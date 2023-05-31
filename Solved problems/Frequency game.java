/*
Given an array A of size N. The elements of the array consist of positive integers. You have to find the largest element with minimum frequency.
*/
//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

// Position this line where user code will be pasted.

// Driver class with main function
class GFG {
    // Main function
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        // Iterating over testcases
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int arr[] = new int[n];

            String s[]=in.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            System.out.println(obj.LargButMinFreq(arr, n));
        }
    }
}
// } Driver Code Ends



// User function Template for Java

// Helper class to find largest number with minimum frequency
class Solution {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        // Your code here
        HashMap<Integer,Integer> mm = new HashMap<>();
        for(int i=0;i<n;i++){
            mm.putIfAbsent(arr[i],0);
            mm.put(arr[i],mm.get(arr[i])+1);
        }
        int ans=0,f=Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> x:mm.entrySet()){
            if(x.getValue()<f){
                f=x.getValue();
                ans=x.getKey();
            }
            else if(x.getValue()==f){
                ans=Math.max(ans,x.getKey());
            }
        }
        return ans;
    }
}
