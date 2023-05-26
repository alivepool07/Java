/*
Given two numbers n and x, find out the total number of ways n can be expressed as the sum of the Xth power 
of unique natural numbers. As the total number of ways can be very large, so return the number of ways modulo 10^9 + 7. 
*/
//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}

// } Driver Code Ends



//User function Template for Java
class Solution
{
    static int mod=1000000007;
    static int help(int n, int x, int num, int dp[][]){
    if(n==0) return 1;
    if(num>n || n<0)   return 0;
    if(dp[n][num]!=-1) return dp[n][num];
    int temp=(int) Math.pow(num, x);
    return dp[n][num]=(help(n-temp, x, num+1, dp) + help(n,x,num+1, dp))%mod;
    }
    static int numOfWays(int n, int x)
    {
        int dp[][]=new int[n+1][n+1];
        for(int temp[]:dp) Arrays.fill(temp, -1);
        return help(n, x, 1, dp);
    }
}
