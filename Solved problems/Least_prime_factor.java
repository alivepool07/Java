/*
Given a number N, find the least prime factors for all numbers from 1 to N.  The least prime factor of an integer X is the smallest prime number that divides it.
Note :

1 needs to be printed for 1.
You need to return an array/vector/list of size N+1 and need to use 1-based indexing to store the answer for each number.

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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.leastPrimeFactor(n);
            for(int i = 1; i <=n; i++)
            {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends




//User function Template for Java
class Solution
{
    public int[] leastPrimeFactor(int n)
    {
        int [] leastPrime = new int[n+1];
        leastPrime[0] = 0;
        leastPrime[1] = 1;
        // leastPrime[2] = 2;
        for(int i=2; i<=n; i++){
            if(leastPrime[i] == 0){
                int ind=1;
                int j=i;
                while(j*ind <= n){
                    j = j*ind;
                    ind++;
                    if(leastPrime[j] == 0) leastPrime[j] = i;
                    j= i;
                }
            }
        }
        return leastPrime;
    }
}
