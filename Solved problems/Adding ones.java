/*
You start with an array A of size N. Initially all elements of the array A are zero. You will be given K positive integers. 
Let j be one of these integers, you have to add 1 to all A[i], where i ≥ j. Your task is to print the array A after all these K updates are done.

Note: 1-based indexing is followed for updates.
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
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[n];
            int updates[] = new int[k];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < k; i++) {
                updates[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.update(a, n, updates, k);
            
            StringBuilder output = new StringBuilder();
            for(int i = 0; i < n; i++)
            output.append(a[i] + " ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends




//User function Template for Java


class Solution {

    public static void update(int a[], int n, int updates[], int k)
    {
        // Your code goes here
        int i=0;
        while(i<k){
            int temp = updates[i]-1;
            if(temp < n){
                a[temp] += 1;
            }
            i++;
        }
        int j=1;
        while(j<n){
            a[j] += a[j-1];
            j++;
        }
    }
    
}
