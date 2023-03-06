/*
Given an non-negative integer n. You are only allowed to make set bit unset. You have to find the maximum possible value of query so that after 
performing the given operations, no three consecutive bits of the integer query are set-bits. 
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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int noConseBits(int n) {
        // code here
        int c = 0;
        for(int i=31;i>=0;i--){
            if((n & (1<<i))!=0)
            c++;
            else c = 0;
            
            if(c==3){
                n = n & ~(1<<i);
                c = 0;
            }
        }
        return n;
        
    }
}
        
