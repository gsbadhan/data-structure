package com.infixToPostfix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfixExpression {
	private static char OPEN_BRACKET='(';
	private static char CLOSE_BRACKET=')';
	private static Stack<Character> stack = new Stack<>();
	private static Map<Character, Integer> operatorPriority = new HashMap<>();
	private static String postFixExp = "";

	static {
		operatorPriority.put('^', 3);
		operatorPriority.put('*', 2);
		operatorPriority.put('/', 2);
		operatorPriority.put('+', 1);
		operatorPriority.put('-', 1);
	}

	

	private static String infixToPostfix(String exp) {
		stack.push(OPEN_BRACKET);
		char tokens[] = exp.toCharArray();
		for (char c : tokens) {
			if (isOperator(c)) {
				popHigherOperator(c);
				stack.push(c);
			} else if (c == OPEN_BRACKET) {
				stack.push(c);
			} else if (c == CLOSE_BRACKET) {
				popUptoOpenBracket();
			} else {
				postFixExp += c;
			}
		}
		stack.add(CLOSE_BRACKET);
		//

		//Empty all Stack
		while (!stack.isEmpty()) {
			char c = stack.pop();
			if (c != OPEN_BRACKET && c != CLOSE_BRACKET) {
				postFixExp += c;
			}
		}
		return postFixExp;
	}

	private static void popUptoOpenBracket() {
		while (stack.peek() != OPEN_BRACKET) {
			char c = stack.pop();
			if (c != OPEN_BRACKET && c != CLOSE_BRACKET) {
				postFixExp += c;
			}
		}
		stack.pop();
	}

	private static void popHigherOperator(char c) {
		if (isOperator(stack.peek()) && isHigherOrSame(stack.peek(), c)) {
			postFixExp += stack.pop();
			popHigherOperator(c);
		}
	}

	private static boolean isHigherOrSame(char oldc, char newc) {
		int oldcc = operatorPriority.get(oldc);
		int newcc = operatorPriority.get(newc);
		return (newcc <= oldcc ? true : false);
	}

	private static boolean isOperator(char c) {
		return operatorPriority.containsKey(c);
	}
	
	
	
	public static void main(String[] args) {
		String exp = "2+(3*4-(5/6^2)*3)*4)";
		String postexp=infixToPostfix(exp);
		System.out.println("postexp:" + postexp);
	}

}
