/*
Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. 
Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: Consider 1-based indexing.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends



class Solution{
    int dp[]=new int[1001];
    int recursion(int price[],int n,int count){
        if(count>n){
            return Integer.MIN_VALUE;
        }
        
        if(dp[count]!=-1){
            return dp[count];
        }
        int ans = 0;
        for(int i =0;i<n;i++){
            ans = Math.max(ans,price[i]+recursion(price,n,count+i+1));
        }
        return dp[count]=ans;
    }
    int cutRod(int price[], int n) {
        //code here
        for(int i =0;i<1001;i++){
            dp[i]=-1;
        }
        return recursion(price,n,0);
    }
}
