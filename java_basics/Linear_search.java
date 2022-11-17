public class Linear_search {
    public static void main(String[] args) {
        int[] arr = {1,34,56,67,876,3,4};
        int target = 876;
        int ans = linear_search(arr , target);
        System.out.print("Target is present at ");
        System.out.println(ans);
    }
    static int linear_search(int[] arr,int target){         
        if (arr.length == 0){                               //Checking if the list is empty by any chance.
            System.out.println("Empty list");
        }

        for (int i = 0 ; i < arr.length ; i++){            //Initialising a loop for traversing over the whole list.
            int temp = arr[i];                             //Creating a temp var to store the index value so that it could be passed if value at that index equals target value.
            if (temp == target ){
                return i;                                 //Returning the index value. **HERE RETURNING TEMP VALUE WOULD HAVE GIVEN VALUE AT THAT INDEX
            }
        }
        return -1;                                        //INDICATES TARGET IS PRESENT NO WHERE IN THE LIST.
    }
}
