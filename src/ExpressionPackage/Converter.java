package ExpressionPackage;

import java.util.ArrayList;
import java.util.Stack;

public class Converter 
{
    public static String convertInfixToPostfix(String expression) 
    {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operators = new Stack<>();

        for (char c : expression.toCharArray()) 
        {
            if (isOperator(c)) {
                while (!operators.isEmpty() && hasHigherPrecedence(operators.peek(), c)) {
                    postfix.append(operators.pop());
                }
                operators.push(c);
            } else {
                postfix.append(c);
            }
        }
        
        while (!operators.isEmpty()) {
            postfix.append(operators.pop());
        }

        return postfix.toString();
    }

    public static boolean isOperator(char c) 
    {
        return c == '~' || c == '+' || c == '.';
    }

    private static boolean hasHigherPrecedence(char op1, char op2) 
    {
        return getOperatorPrecedence(op1) >= getOperatorPrecedence(op2);
    }

    private static int getOperatorPrecedence(char op) 
    {
        switch (op) {
            case '~':
                return 4;
            case '.':
                return 3;
            case '+':
                return 2;
            default:
                return -1;
        }
    }
  
}
