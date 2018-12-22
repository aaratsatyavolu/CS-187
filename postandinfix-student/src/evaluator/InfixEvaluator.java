package evaluator;

import parser.ArithParser;
import stack.LinkedStack;

public class InfixEvaluator extends Evaluator {

	private LinkedStack<String> operators = new LinkedStack<String>();
	private LinkedStack<Integer> operands = new LinkedStack<Integer>();

	/** return stack object (for testing purpose) */
	public LinkedStack<String> getOperatorStack() {
		return operators;
	}

	public LinkedStack<Integer> getOperandStack() {
		return operands;
	}

	/**
	 * This method performs one step of evaluation of a infix expression. The input
	 * is a token. Follow the infix evaluation algorithm to implement this method.
	 * If the expression is invalid, throw an exception with the corresponding
	 * exception message.
	 * 
	 * @throws Exception
	 */

	public void process_operator() throws Exception {

		String op = operators.pop();
		switch (op) {
		case "!":
			if (operands.size < 1)
				throw new Exception("too few operands");
			operands.push(-1 * operands.pop());
			break;
		case "+":
			if (operands.size < 2)
				throw new Exception("too few operands");
			operands.push(operands.pop() + operands.pop());
			break;
		case "-":
			if (operands.size < 2)
				throw new Exception("too few operands");
			operands.push(-1 * operands.pop() + operands.pop());
			// test for length 2
			break;
		case "*":
			if (operands.size < 2)
				throw new Exception("too few operands");
			operands.push(operands.pop() * operands.pop());
			break;
		case "/":
			if (operands.size < 2)
				throw new Exception("too few operands");
			int second = operands.pop();
			int first = operands.pop();
			if (second == 0)
				throw new Exception("division by zero");
			operands.push(first / second);
			break;
		default:
			throw new Exception("invalid operator");
		}
	}

	public void evaluate_step(String token) throws Exception {
		if (isOperand(token)) {
			operands.push(Integer.parseInt(token));
		} else {
			/*
			 * TODO: What do we do if the token is an operator? If the expression is
			 * invalid, make sure you throw an exception with the correct message.
			 * 
			 * You can call precedence(token) to get the precedence value of an operator.
			 * It's already defined in the Evaluator class.
			 */

			boolean foundleft = false;

			switch (token) {
			case "(":
				operators.push(token);
				break;
			case ")":
				if (!operators.isEmpty() && operators.top().equals("("))
					foundleft = true;
				while (!operators.isEmpty() && !operators.top().equals("(")) {
					process_operator();
					if (!operators.isEmpty() && operators.top().equals("("))
						foundleft = true;
				}
				if (foundleft == false) {
					throw new Exception("missing (");
				}
				operators.pop(); // only gets here if left found
				break;
			case "+":
				if (operators.isEmpty() || precedence(token) > precedence(operators.top()))
					operators.push(token);
				else {
					while (!operators.isEmpty() && precedence(token) <= precedence(operators.top())) {
						process_operator();
					}
					operators.push(token);
				}
				break;
			case "-":
				if (operators.isEmpty() || precedence(token) > precedence(operators.top()))
					operators.push(token);
				else {
					while (!operators.isEmpty() && precedence(token) <= precedence(operators.top())) {
						process_operator();
					}
					operators.push(token);
				}
				break;
			case "*":
				if (operators.isEmpty() || precedence(token) > precedence(operators.top()))
					operators.push(token);
				else {
					while (!operators.isEmpty() && precedence(token) <= precedence(operators.top())) {
						process_operator();
					}
					operators.push(token);
				}
				break;
			case "/":
				if (operators.isEmpty() || precedence(token) > precedence(operators.top()))
					operators.push(token);
				else {
					while (!operators.isEmpty() && precedence(token) <= precedence(operators.top())) {
						process_operator();
					}
					operators.push(token);
				}
				break;
			case "!":
				if (operators.isEmpty() || precedence(token) > precedence(operators.top()))
					operators.push(token);
				else {
					while (!operators.isEmpty() && precedence(token) <= precedence(operators.top())) {
						process_operator();
					}
					operators.push(token);
				}
				break;
			default:
				throw new Exception("invalid operator");
			}
		}
	}

	/**
	 * This method evaluates an infix expression (defined by expr) and returns the
	 * evaluation result. It throws an Exception object if the infix expression is
	 * invalid.
	 */
	public Integer evaluate(String expr) throws Exception {

		for (String token : ArithParser.parse(expr)) {
			evaluate_step(token);
		}

		/* TODO: what do we do after all tokens have been processed? */
		while (!operators.isEmpty()) {
			process_operator();
		}

		// The operand stack should have exactly one operand after the evaluation is
		// done
		if (operands.size() > 1)
			throw new Exception("too many operands");
		else if (operands.size() < 1)
			throw new Exception("too few operands");

		return operands.pop();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(new InfixEvaluator().evaluate("10/5/2"));

	}
}
