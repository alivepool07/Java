/*
Given an array of strings arr[] of size n, a string str and an integer k. The task is to find the count of strings in arr[] whose prefix of length 
k matches with the k-length prefix of str.Given an array of strings arr[] of size n, a string str and an integer k. The task is to find the count of strings in arr[] whose 
prefix of length k matches with the k-length prefix of str.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.next();
            }
            
            int k = Integer.parseInt(sc.next());
            
            String str = sc.next();
            
            Solution obj = new Solution();
            int ans = obj.klengthpref(arr,n,k,str);
            System.out.println(ans);
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int klengthpref(String[] arr, int n, int k, String str)
    {
        // code here
         if(k>str.length()) return 0;
        
        String s=str.substring(0,k);
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            String temp=arr[i];
            
              if(arr[i].length()<k){continue;}
            
                 if(temp.substring(0,k).equals(s))
                {
                     count++;
                }
        } 
        
        return count;
    }
}
