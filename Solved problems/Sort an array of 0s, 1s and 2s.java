/*
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
*/

//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int arr[], int n){
        int s = 0,mid = 0,high = n-1;
        while(s<n && arr[s]==0) s++;
        mid = s;
        while(mid<n && arr[mid]==1) mid++;
        while(high>=0 && arr[high]==2) high--;
        while(mid<=high){
            if(arr[mid]==0){
                arr[mid] = arr[s];
                arr[s] = 0;
                s++;mid++;
            }
            else if(arr[mid]==1) mid++;
            else{ //2
                arr[mid] = arr[high];
                arr[high] = 2;
                high--;
            }
        }
    }
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends
