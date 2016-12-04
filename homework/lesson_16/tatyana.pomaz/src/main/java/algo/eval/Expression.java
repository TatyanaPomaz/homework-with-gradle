package algo.eval;

import algo.stack.LinkedListStack;
import algo.stack.Stack;

public class Expression {
  private Stack<Character> operators = new LinkedListStack<>();
  private Stack<Double> operands = new LinkedListStack<>();
  private String bufferOperand = "";

  public double evaluate(String exprStr) {
    for (int i = 0; i < exprStr.length(); i++) {
      char ch = exprStr.charAt(i);
      if ("*/+-".indexOf(ch) != -1) {
        operators.push(ch);
        addNumberToBufferOperand();
      } else if (Character.isDigit(ch)) {
        bufferOperand += ch;
      } else if (ch == ')') {
        addNumberToBufferOperand();
        double operand = operands.pop();
        double result = operands.pop();
        char operation = operators.pop();
        switch (operation) {
          case '+': result += operand; 
            break;
          case '-': result -= operand; 
            break;
          case '*': result *= operand; 
            break;
          case '/': result /= operand; 
            break;
          default: 
            break;
        }
        operands.push(result);
      }
    }
    return operands.pop();
  }

  private void addNumberToBufferOperand() {
    if (bufferOperand != "") {
      operands.push(Double.parseDouble(bufferOperand));
      bufferOperand = "";
    }
  }
}
