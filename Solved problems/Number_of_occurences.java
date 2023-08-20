import java.util.*;

public class Number_of_occurences {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        System.out.println("Enter no. of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Taking input for array

        for (int i = 0 ; i < n ; i++){

            System.out.print("Enter Element " + i +" : ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the value to be found : ");
        int x=sc.nextInt();

        Solution solution = new Solution();
        int cnt = solution.count(arr,n,x);
        System.out.println("The no of times "+x+ " has occured is " + cnt + " .");

    }

    
}
class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int i=0;
        int j=n-1;
        int count=0;
        while(i<=j){
            if(arr[i]==x){
                count++;
            }
            if(i<j){
            if(arr[j]==x){
                count++;
            }
            }
            i++;
            j--;
        }

        return count;
    }
    }

