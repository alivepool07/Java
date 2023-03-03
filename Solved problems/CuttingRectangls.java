/*
Given a rectangle of dimensions L x B find the minimum number (N) of identical squares of maximum side that can be cut out from that rectangle so that no 
residue remains in the rectangle. Also find the dimension K of that square.
*/


//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            long L = Long.parseLong(input_line[0]);
            long B = Long.parseLong(input_line[1]);

            Solution ob = new Solution();
            List<Long> ans = new ArrayList<Long>();
            ans = ob.minimumSquares(L, B);
            System.out.print(ans.get(0)+" ");
            System.out.println(ans.get(1));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    static List<Long> minimumSquares(long L, long B)
    {
        // code here
          
        long l = L;
        long b = B;
        
        while(L>0){
            long val = L;
            L = B%L;
            B = val;
        }
        
        List<Long> ans = new ArrayList<>();
        ans.add((l/B) * (b/B));
        
        
        ans.add(B);
        return ans;
        
    }
}
