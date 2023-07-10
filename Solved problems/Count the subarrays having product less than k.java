/*
Given an array of positive numbers, the task is to find the number of possible contiguous subarrays having product less than a given number k.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSubArrayProductLessThanK(a, n, k));
            
        }
	}
}


// } Driver Code Ends




class Solution {
    
    public int countSubArrayProductLessThanK(long a[], int n, long k)
    {
        int i,j,c=0;
        //long p=1;
        n=a.length;
        
        for(i=0;i<n;i++){
            long p=1;
            for(j=i;j<n;j++){
                p=p*a[j];
                if(p<k){
                    c++;
                }
                else{
                    break;
                }
            }
        }
        return c;
    }
}
