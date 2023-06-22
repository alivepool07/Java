/*

You will be given an integer n, your task is to return the sum of all natural number less than or equal to n.

As the answer could be very large, return answer modulo 10^9 + 7.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);

            Solution ob = new Solution();
            System.out.println(ob.sumOfNaturals(n));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static int sumOfNaturals(int n) {
        // code here
        int mod = 1000000007;
        long sum = (long)n*(long)(n+1);
        sum/=2;
        return (int)(sum%mod);
    }
};
