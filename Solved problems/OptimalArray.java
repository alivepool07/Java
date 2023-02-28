/*  
You are given a sorted array a of length n. For each i(0<=i<=n-1), you have to make all the elements of the array from index 0 till i equal, using minimum 
number of operations. In one operation you either increase or decrease the array element by 1.

You have to return a list which contains the minimum number of operations for each i, to accomplish the above task.

Note:
1. 0-based indexing.
2. For each index, you need to consider the same array which was given to you at the start.
*/



//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long arr[]=ob.optimalArray(n,a);
            for(long i:arr){
                out.print(i+" ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends




class Solution {

    public long[] optimalArray(int n,int a[])

    {

        long[] minNumOfOperations = new long[n];

        minNumOfOperations[0] = 0;
        
        for(int i = 1; i < n; i++) {
          int index = i/2;

            minNumOfOperations[i] = a[i]-a[index] + minNumOfOperations[i-1];

        }
        return minNumOfOperations;

    }

}   
