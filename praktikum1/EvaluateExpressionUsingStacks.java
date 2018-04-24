package ad.praktikum1;

public class EvaluateExpressionUsingStacks {

	/**
	 * utility method to apply a operator op on 2 operand a and b
	 * @param op
	 * @param b
	 * @param a
	 * @return result of a op b
	 */
	public static int applyOp(char op, int b, int a) {
		int res = 0;
		switch (op) {
		case '+':
			res =a + b;
			break;
		case '-':
			res = a - b;
			break;
		case '*':
			res = a * b;
			break;
		case '/':
			if (b == 0) {
				throw new UnsupportedOperationException("Cannot divide by zero");
			}
			res = a / b;
		}

		return res;
	}

	/**
	 * method to evaluate an mathematical expression using stack
	 * @param expr
	 * @return result of the expression
	 */
	public static int evaluate(String expr) {
		// stop watch for calculating the runtime
		long startTime = System.nanoTime();
		
		// seperate expression into tokens
		char[] tokens = expr.toCharArray();

		// Create stacks for operators and operands (values)
		Stack<Character> ops = new Stack<Character>();
		Stack<Integer> val = new Stack<Integer>();

		for (int i = 0; i < tokens.length; i++) {			
			// current tokens is a whitespace -> skip it
			if (tokens[i] == ' ') {
				continue;
			}

			// current token is a number -> push it to val
			else if (tokens[i] >= '0' && tokens[i] <= '9') {
				// the number can have multiple digits
				StringBuffer sbuf = new StringBuffer();
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
					sbuf.append(tokens[i]);
					i++;
				}

				// push the number to val
				val.push(Integer.parseInt(sbuf.toString()));
			}

			// current token is an opening bracket -> push it to ops
			else if (tokens[i] == '(') {
				ops.push(tokens[i]);
			}

			// current token is a closing bracket -> solve the entire brace
			else if (tokens[i] == ')') {
				while (ops.top() != '(') {
					// pop 1 operator + 2 operands, solve and then push back to val
					val.push(applyOp(ops.pop(), val.pop(), val.pop()));
				}

				// pop and discard the opening bracket after finishing with the brace
				ops.pop();
			}

			// current token is an operator
			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				// apply the operator on top of ops if it isn't '(' or ')'
				while (!ops.isEmpty() && ops.top() != '(' && ops.top() != ')') {
					val.push(applyOp(ops.pop(), val.pop(), val.pop()));
				}

				// then push the new operator to ops
				ops.push(tokens[i]);
			}
		}

		// all tokens have been parsed
		while (!ops.isEmpty()) {
			// apply the remaining operator(s) to the remaining values
			val.push(applyOp(ops.pop(), val.pop(), val.pop()));
		}
		
		// end the stop watch
		long endTime = System.nanoTime();
        long output = endTime - startTime;
        System.out.println("elapsed time = " + output + "ns");

		// top of val is the result
		return val.pop();
	}
}
