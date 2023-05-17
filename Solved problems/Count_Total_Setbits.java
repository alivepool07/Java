/*
You are given a number N. Find the total number of setbits in the numbers from 1 to N. 
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long N;
            N = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.countBits(N);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long countBits(long N) {
       long count=0;
        for(long i=1;i<=N;i++)
        {
            count += Long.bitCount(i);
        }
        return count;
    }
}
        