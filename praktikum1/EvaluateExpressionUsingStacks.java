package ad.praktikum1;

import java.util.*;

public class EvaluateExpressionUsingStacks {
	
	public static int applyOp(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0) {
				throw new UnsupportedOperationException("Cannot divide by zero");
			}
			return a / b;
		}
		
		return 0;
	}
	
	public static int evaluate(String expr) {
		// seperate expression into tokens
		char[] tokens = expr.toCharArray();
		
        // Create stacks for operators and operands (values) 
        Stack<Character> ops  = new Stack<Character>();
        Stack<Integer> val = new Stack<Integer>();
       
        for (int i = 0; i < tokens.length; i++) {
        		// current tokens is a whitespace -> skip it
        		if (tokens [i] == ' ') {
        			continue;
        		}
        		
        		// current token is a number -> push it to val
        		boolean checkNum = tokens[i] >= '0' && tokens[i] <= '9';
        		if (checkNum) {
        			// just in case the number has multiple digits
        			StringBuffer sbuf = new StringBuffer();
        			while (i < tokens.length && checkNum) {
        				sbuf.append(tokens[i]);
        				i++;
        			}
        			
        			// push the number to val
        			val.push(Integer.parseInt(sbuf.toString()));
        		}
        		
        		// current token is an opening bracket -> push it to ops
        		if (tokens[i] == '(') {
        			ops.push(tokens[i]);
        		}
        		
        		
        		// current token is a closing bracket -> solve the entire brace
        		if (tokens[i] == ')') {
        			while (ops.top() != '(') {
        				// pop 1 operator + 2 operands, solve and then push back to val
        				val.push(applyOp(ops.pop(), val.pop(), val.pop()));
        			}
        			
        			// pop and discard the opening bracket after finishing with the brace
        			ops.pop();
        		}
        		
        		// current token is an operator
        		boolean checkOp = tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/';	
        		if (checkOp) {
        			// apply the operator if possible
        			while (!ops.isEmpty() && ops.top() != '(' && ops.top() != ')') {
        				val.push(applyOp(ops.pop(), val.pop(), val.pop()));
        			}
        			
        			ops.push(tokens[i]);
        		}
        }
        
        // all tokens have been parsed
        while (!ops.isEmpty()) {
        	// apply the remaining operator to the remaining values
        	val.push(applyOp(ops.pop(), val.pop(), val.pop()));
        }
        
        // top of val is the result
        return val.pop();
	}
}
