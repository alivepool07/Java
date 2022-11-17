//changing array data using functions

import java.util.Arrays;

public class arrays {

    public static void main(String[] args) {
        int[] arr = {1,23,4,5,6};
        System.out.println(Arrays.toString(arr));
        change(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void change(int[] arr) {
        arr[2] = 45;
    }
}
