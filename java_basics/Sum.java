// sum of two numbers
import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        System.out.println("Enter num1 ");
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        System.out.println("Enter num2");
        Scanner input1 = new Scanner(System.in);
        int num2 = input1.nextInt();
        System.out.println( num1 + num2);
    }
}
