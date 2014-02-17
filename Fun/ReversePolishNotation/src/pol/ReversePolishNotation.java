package pol;

import java.util.*;

/**
 * @author Joey Bloom
 * 3/9/13
 */
public class ReversePolishNotation
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Expression in Reverse Polish Notation: ");
        String s = in.nextLine();
        System.out.println(reversePolishNotation(s));
    }

    private static double reversePolishNotation(String str) throws NumberFormatException
    {
        StringTokenizer tokens = new StringTokenizer(str);
        Stack<Double> stack = new Stack<>();
        while(true)
        {
            try
            {
                String t = tokens.nextToken();
                switch(t)
                {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        double subtrahend = stack.pop();
                        double minuend = stack.pop();
                        stack.push(minuend - subtrahend);
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        double divisor = stack.pop();
                        double dividend = stack.pop();
                        stack.push(dividend / divisor);
                        break;
                    case "^":
                        double exp = stack.pop();
                        double base = stack.pop();
                        stack.push(Math.pow(base, exp));
                        break;
                    default:
                        stack.push(Double.valueOf(t));
                }
            }
            catch(NoSuchElementException | EmptyStackException e)
            {
                if(stack.size() == 1)
                {
                    return stack.pop();
                }
                else
                {
                    throw new NumberFormatException("Incorrect Reverse Polish Notation Syntax.");
                }
            }
        }
    }

}