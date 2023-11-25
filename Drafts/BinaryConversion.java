package Drafts;
import queueAndStack.MyStack;
import java.util.Scanner;
/**
 * @author Krish Porwal
 * @version 1.0.0
 * @since 15-09-2023
 */
/**
 * Class to convert a user-given decimal number to binary number using stack implementation.
 */
public class BinaryConversion {
    /**
     * @param number
     * @return binaryNumber String value of converted binary number
     */
    public static String toBinary(int number) {
        MyStack<Integer> stack = new MyStack<>(64);
        if(number == 0) {
            return "0";
        }
        while(number > 0) {
            stack.push(number % 2);
            number /= 2;
        }
        StringBuilder binaryNumber = new StringBuilder();
        while(!stack.isEmpty()) {
            binaryNumber.append(stack.pop());
        }
        return binaryNumber.toString();
    }
    /**
     * Main method to call the `toBinary` method and print the value
     * @param args
     */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a decimal number: ");
        int number = scan.nextInt();
        System.out.println(number + " in binary is " + toBinary(number));
        scan.close();
    }
}
