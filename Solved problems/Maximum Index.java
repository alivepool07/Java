/*
Given an array arr[] of n positive integers. The task is to find the maximum of j - i subjected to the constraint of arr[i] <= arr[j].
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
     static int maxIndexDiff(int A[], int N) { 
        int i,j,dif=0;
        for(i=0;i<N;i++){
            int res=0;
            for(j=N-1;j>i;j--){
                if(A[j]>=A[i]){
                    res=j-i;
                    break;
                }
            }
                if(res>dif){
                    dif=res;
            }
        }
        return dif;
        
    }
}
