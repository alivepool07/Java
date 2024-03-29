/*
Given a sorted array arr[] of size N. Find the element that appears only once in the array. All other elements appear exactly twice. 
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int a[], int n)
    {
        // Complete this function
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = ans ^ a[i];
        }
        return ans;
        
    }
}
