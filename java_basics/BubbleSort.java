import java.util.Arrays;

public class BubbleSort{

    public static void main(String[] args) {
        int[] arr = {45,75,-3,47,-500,85,21,30,11};
        bs(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bs(int[] arr){
        int n = arr.length;

        for (int i = 0 ; i < n ; i++){
            for (int j = 1 ; j < (n-i) ; j++){
                if ( arr[j-1] > arr[j]){

                    //swap elements
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
