import java.util.Arrays;

public class swap {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,54,45,5678};
        System.out.println(Arrays.toString(arr));
        swap(arr , 2 , 5);

        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr ,int index2,int index5){
        int temp = arr[index2];
        arr[index2] = arr[index5];
        arr[index5] = temp;
    }
}
