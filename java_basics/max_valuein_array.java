public class max_valuein_array {
    public static void main(String[] args) {
        int[] arr = {1,56,56,7,63,54};
        System.out.println(maxv(arr));
    }
    static int maxv(int[] arr){
        int max_v = arr[0];
        for (int i = 1 ; i < arr.length ; i++){
            if(arr[i] > max_v){
                max_v = arr[i];
            }
        }
        return max_v;
    }
}
