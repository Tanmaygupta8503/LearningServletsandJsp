package gitlogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Logger;

class GitLogService {

    private int totalCommits = 0;
    private final Map<LocalDate, Map<String, Integer>> commitsMap = new HashMap<>();

    public void parseFile(String filePath, LocalDate date) throws FileNotFoundException, InvalidFileFormatException, IncompleteInformationException {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new FileNotFoundException("The file was not found: " + filePath);
        }

        StringBuilder logEntry = new StringBuilder();
        boolean isParsingLogEntry = false;
        for (String line : lines) {
            if (line.startsWith("commit ")) {
                if (isParsingLogEntry) {
                    parseLogEntry(logEntry.toString(), date);
                    logEntry.setLength(0);
                }
                isParsingLogEntry = true;
            }
            if (isParsingLogEntry) {
                logEntry.append(line).append(System.lineSeparator());
            }
        }

        // Parse the last log entry
        if (logEntry.length() > 0) {
            parseLogEntry(logEntry.toString(), date);
        }

        // Handle exception for an empty file or improperly formatted file
        if (!isParsingLogEntry) {
            throw new InvalidFileFormatException("The file format is invalid or the file is empty.");
        }
    }

    public void writeOutputToFile(String filePath, LocalDate date) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Total Commits: " + getTotalCommits() + System.lineSeparator());

            writer.write("Total commits by each developer since date " + date + ":" + System.lineSeparator());
            Map<String, Integer> commitsByDeveloper = getTotalCommitsByDeveloperSinceDate(date);
            for (Map.Entry<String, Integer> entry : commitsByDeveloper.entrySet()) {
                writer.write("Developer: " + entry.getKey() + ", Commits: " + entry.getValue() + System.lineSeparator());
            }

            writer.write("Count of commits by each developer since date " + date + ", for each day:" + System.lineSeparator());
            Map<LocalDate, Map<String, Integer>> commitsByDay = getCommitsByDeveloperPerDaySinceDate(date);
            for (Map.Entry<LocalDate, Map<String, Integer>> entry : commitsByDay.entrySet()) {
                writer.write("Date: " + entry.getKey() + System.lineSeparator());
                for (Map.Entry<String, Integer> authorEntry : entry.getValue().entrySet()) {
                    writer.write("  Developer: " + authorEntry.getKey() + ", Commits: " + authorEntry.getValue() + System.lineSeparator());
                }
            }

            writer.write("List of developers who did not commit anything successively in 2 days:" + System.lineSeparator());
            for (String developer : noCommitsTwoDays()) {
                writer.write("Developer: " + developer + System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private void parseLogEntry(String logEntry, LocalDate sinceDate) throws InvalidFileFormatException, IncompleteInformationException {
        String[] lines = logEntry.split(System.lineSeparator());
        if (lines.length < 4) {
            throw new IncompleteInformationException("The log entry is incomplete.");
        }

        String commitLine = lines[0];
        String authorLine = lines[1];
        String dateLine = lines[2];
        String messageLine = lines[4];
        if (!commitLine.startsWith("commit ") || !authorLine.startsWith("Author: ") || !dateLine.startsWith("Date: ")) {
            throw new InvalidFileFormatException("The log entry format is invalid.");
        }

        String author = authorLine.substring(8).split("<")[0].trim();
        String dateString = dateLine.substring(6).trim();
        LocalDate commitDate = convertToDate(dateString);

        if (commitDate == null || author.isEmpty() || messageLine.trim().isEmpty()) {
            throw new IncompleteInformationException("The log entry is missing necessary information.");
        }

        totalCommits++;
        if (commitDate.isAfter(sinceDate) || commitDate.isEqual(sinceDate)) {
            commitsMap.putIfAbsent(commitDate, new HashMap<>());
            Map<String, Integer> authorCommits = commitsMap.get(commitDate);
            authorCommits.put(author, authorCommits.getOrDefault(author, 0) + 1);
        }
    }

    private LocalDate convertToDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss yyyy Z", Locale.ENGLISH);
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString, formatter);
            return zonedDateTime.toLocalDate();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getTotalCommits() {
        return totalCommits;
    }

    public Map<String, Integer> getTotalCommitsByDeveloperSinceDate(LocalDate sinceDate) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<LocalDate, Map<String, Integer>> entry : commitsMap.entrySet()) {
            LocalDate commitDate = entry.getKey();
            Map<String, Integer> authorCommits = entry.getValue();

            if (commitDate.isEqual(sinceDate) || commitDate.isAfter(sinceDate)) {
                for (Map.Entry<String, Integer> authorEntry : authorCommits.entrySet()) {
                    String author = authorEntry.getKey();
                    int commits = authorEntry.getValue();
                    result.put(author, result.getOrDefault(author, 0) + commits);
                }
            }
        }
        return result;
    }

    public Map<LocalDate, Map<String, Integer>> getCommitsByDeveloperPerDaySinceDate(LocalDate sinceDate) {
        Map<LocalDate, Map<String, Integer>> result = new HashMap<>();
        for (Map.Entry<LocalDate, Map<String, Integer>> entry : commitsMap.entrySet()) {
            LocalDate commitDate = entry.getKey();
            Map<String, Integer> authorCommits = entry.getValue();

            if (commitDate.isEqual(sinceDate) || commitDate.isAfter(sinceDate)) {
                // Create a new map for this date in the result if it doesn't exist
                result.putIfAbsent(commitDate, new HashMap<>());

                // Update the counts for each developer
                for (Map.Entry<String, Integer> authorEntry : authorCommits.entrySet()) {
                    String author = authorEntry.getKey();
                    int commits = authorEntry.getValue();
                    result.get(commitDate).put(author, result.get(commitDate).getOrDefault(author, 0) + commits);
                }
            }
        }
        return result;
    }

    public List<String> noCommitsTwoDays() {
        Set<String> result = new HashSet<>();
        Map<String, LocalDate> lastCommitDate = new HashMap<>();

        // Get all dates in sorted order
        List<LocalDate> dates = new ArrayList<>(commitsMap.keySet());
        Collections.sort(dates);

        for (LocalDate currentDate : dates) {
            for (String author : commitsMap.get(currentDate).keySet()) {
                if (lastCommitDate.containsKey(author)) {
                    LocalDate previousDate = lastCommitDate.get(author);
                    if (!previousDate.plusDays(1).isEqual(currentDate) && !previousDate.plusDays(1).plusDays(1).isEqual(currentDate)) {
                        result.add(author);
                    }
                }
                lastCommitDate.put(author, currentDate);
            }
        }
        return new ArrayList<>(result);
    }
}

class InvalidFileFormatException extends Exception {
    private static final Logger logger = Logger.getLogger(InvalidFileFormatException.class.getName());

    public InvalidFileFormatException(String message) {
        super(message);
        logger.severe(message);
    }
}

class IncompleteInformationException extends Exception {
    private static final Logger logger = Logger.getLogger(IncompleteInformationException.class.getName());

    public IncompleteInformationException(String message) {
        super(message);
        logger.severe(message);
    }
}

class FileNotFoundException extends Exception {
    public FileNotFoundException(String message) {
        super(message);
    }
}

class GitLogController {

    private final GitLogService gitLogService = new GitLogService();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        System.out.println("Enter the date (YYYY-MM-DD):");
        String dateInput = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateInput);

        try {
            gitLogService.parseFile(filePath, date);
            while (true) {
                System.out.println("1. Total Count of commits by each developer since date " + date);
                System.out.println("2. Count of commits by each developer since date " + date + ", for each day");
                System.out.println("3. List of developers who did not commit anything successively in 2 days");
                System.out.println("4. Write output to file");
                System.out.println("5. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                switch (choice) {
                    case 1:
                        countCommits();
                        break;
                    case 2:
                        commitDevelopers(date);
                        break;
                    case 3:
                        noCommits();
                        break;
                    case 4:
                        System.out.println("Enter output file path:");
                        String outputPath = scanner.nextLine();
                        gitLogService.writeOutputToFile(outputPath, date);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void countCommits() {
        try {
            System.out.println("Total Commits: " + gitLogService.getTotalCommits());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void commitDevelopers(LocalDate date) {
        try {
            System.out.println("Count of commits by each developer since date " + date + ", for each day:");
            Map<LocalDate, Map<String, Integer>> commitsByDay = gitLogService.getCommitsByDeveloperPerDaySinceDate(date);
            for (Map.Entry<LocalDate, Map<String, Integer>> entry : commitsByDay.entrySet()) {
                System.out.println("Date: " + entry.getKey());
                for (Map.Entry<String, Integer> authorEntry : entry.getValue().entrySet()) {
                    System.out.println("  Developer: " + authorEntry.getKey() + ", Commits: " + authorEntry.getValue());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void noCommits() {
        try {
            System.out.println("List of developers who did not commit anything successively in 2 days:");
            for (String developer : gitLogService.noCommitsTwoDays()) {
                System.out.println("Developer: " + developer);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        GitLogController controller = new GitLogController();
        controller.start();
    }
}
