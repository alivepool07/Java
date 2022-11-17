// Bonus salary using if - else

import java.util.Scanner;

public class if_else {
    public static void main(String[] args) {
        System.out.println("Enter the amount of salary");
        Scanner input = new Scanner(System.in);
        int salary =  input.nextInt();

        // conditionals
        if(salary<= 30000){
            double news = salary + (0.3 * salary);
            System.out.println("You are eligible for getting bonus");
            System.out.println("Your total salary is " + news);

        }
        else {
            System.out.println("You are already above the bonus line. Thank YOU !!!");
        }
    }

}
