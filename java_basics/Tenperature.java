// Temperature conversion

import java.util.Scanner;

public class Tenperature {
    public static void main(String[] args) {
        System.out.println("Temperature Conversion");
        System.out.println("Enter the temperature in Celsius");
        Scanner input = new Scanner (System.in);
        double inp = input.nextInt();
        double cnv = inp * 1.8 + 32;
        System.out.println("The temperature in fah. is " + cnv);
    }

}

