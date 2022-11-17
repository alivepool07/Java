public class Linear_search {
    public static void main(String[] args) {
        int[] arr = {1,34,56,67,876,3,4};
        int target = 876;
        int ans = linear_search(arr , target);
        System.out.print("Target is present at ");
        System.out.println(ans);
    }
    static int linear_search(int[] arr,int target){
        if (arr.length == 0){
            System.out.println("Empty list");
        }

        for (int i = 0 ; i < arr.length ; i++){
            int temp = arr[i];
            if (temp == target ){
                return i;
            }
        }
        return -1;
    }
}
