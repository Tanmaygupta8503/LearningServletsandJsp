package com.firstProject;

/**
 * Represents a student with an ID, address, and name.
 */
public class Student {

    private int studentId;
    private String studentAddress;
    private String studentName;

    /**
     * Default constructor.
     */
    public Student() {
        // Default constructor
    }

    /**
     * Parameterized constructor.
     * 
     * @param studentId the student's ID
     * @param studentAddress the student's address
     * @param studentName the student's name
     */
    public Student(int studentId, String studentAddress, String studentName) {
        this.studentId = studentId;
        this.studentAddress = studentAddress;
        this.studentName = studentName;
    }

    /**
     * Returns a string representation of the student.
     * 
     * @return a string containing student details
     */
    @Override
    public String toString() {
        return String.format("Student [studentId=%d, studentAddress=%s, studentName=%s]",
                studentId, studentAddress, studentName);
    }

    // Getters and Setters

    /**
     * Gets the student's ID.
     * 
     * @return the student's ID
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets the student's ID.
     * 
     * @param studentId the new student's ID
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets the student's address.
     * 
     * @return the student's address
     */
    public String getStudentAddress() {
        return studentAddress;
    }

    /**
     * Sets the student's address.
     * 
     * @param studentAddress the new student's address
     */
    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    /**
     * Gets the student's name.
     * 
     * @return the student's name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the student's name.
     * 
     * @param studentName the new student's name
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
