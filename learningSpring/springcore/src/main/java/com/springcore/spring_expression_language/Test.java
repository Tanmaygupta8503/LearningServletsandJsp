package com.springcore.spring_expression_language;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {
	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/spring_expression_language/config.xml");
		Demo demo = (Demo) context.getBean("demo" , Demo.class);
		System.out.println(demo);
		SpelExpressionParser parser = new SpelExpressionParser();
		Expression expression = (Expression) parser.parseExpression("24 * 23 % 69");
		System.out.println(expression.getValue());
	}
}
