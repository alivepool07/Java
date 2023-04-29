/*
Given an array of N integers arr[] where each element represents the maximum length of the jump that can be made forward from that element. This means if arr[i] = x, then we can jump any distance y such that y ≤ x.
Find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then you cannot move through that element.

Note: Return -1 if you can't reach the end of the array.
*/


//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends




class Solution{
    static int minJumps(int[] arr){
           if(arr[0]==0)
        return -1;
        int n=arr.length;
        int curr=arr[0],max=arr[0],ct=0;
        for(int i=1;i<n-1;i++)
        {
            max=Math.max(max,i+arr[i]);
            if(i==curr)
            {
                ct++;
                if(max==curr)
                return -1;
                curr=max;
            }
        }
        return ct+1;
    }
}
