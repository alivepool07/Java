/*
You are given an array of size N. Rearrange the given array in-place such that all the negative numbers occur before all non-nagative numbers.
(Maintain the order of all -ve and non-negative numbers as given in the original array).
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.Rearrange(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void Rearrange(int a[], int n)
    {
        // Your code goes here
        List<Integer> posList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();
        for(int i = 0;i<a.length;i++){
            if(a[i]<0){
                negList.add(a[i]);
            }else{
                posList.add(a[i]);
            }
        }
        int index = 0;
        for(Integer k:negList){
            a[index++] = k;
        }
        for(Integer k:posList){
            a[index++] = k;
        }
    }
}
