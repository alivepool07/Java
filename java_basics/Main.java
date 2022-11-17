// Basic input output

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("Enter your age");
        Scanner input = new Scanner(System.in);
        int age = input.nextInt();
        System.out.println("your age is " + age );
    }
}