import java.util.ArrayDeque;
import java.util.Scanner;

public class Calculator {
    /*Evaluate a postfix expression stored in s.
      *Assume valid postfix notation, of ints doubles and operators separated by spaces.
      *Valid operators are + - / * and % (remainder not modulo)
      *All results are doubles even if the operands are both int.
      *@throws IllegalArgumentException when there are too many or too few operands.
      *        Use the string parameter of your exception to indicate what happened.
      *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
      */
    public static double eval(String s){
        ArrayDeque<Double> stack = new ArrayDeque<Double>();
        Scanner scan = new Scanner(s);
        while (scan.hasNext()){
            if (scan.hasNextDouble()){
                stack.addFirst(scan.nextDouble());
            } else {
                char operator = scan.next().charAt(0);
                if (stack.size() < 2){
                    throw new IllegalArgumentException("too few operands for operation " + operator);
                }
                double op2 = stack.removeFirst();
                double op1 = stack.removeFirst();
                /*if (operator == '+') stack.addFirst(op1 + op2);
                if (operator == '-') stack.addFirst(op1 - op2);
                if (operator == '/') stack.addFirst(op1 / op2);
                if (operator == '*') stack.addFirst(op1 * op2);
                if (operator == '%') stack.addFirst(op1 % op2);*/
                switch (operator) {
                    case '+': 
                        stack.addFirst(op1 + op2);
                        break;
                    case '-':
                        stack.addFirst(op1 - op2);
                        break;
                    case '/':
                        stack.addFirst(op1 / op2);
                        break;
                    case '*':
                        stack.addFirst(op1 * op2);
                        break;
                    case '%':
                        stack.addFirst(op1 % op2);

                }
            }
        }
        if (stack.size() > 1){
            throw new IllegalArgumentException("too many operands");
        } else if (stack.size() == 0){
            throw new IllegalArgumentException("too few operands");
        }
        return stack.getLast();
    }
}
