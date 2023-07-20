/*
Given a number and its reverse. Find that number raised to the power of its own reverse.
Note: As answers can be very large, print the result modulo 10^9 + 7.
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
    
    // compute reverse of a number
    public static long rev(long n)
    {
        long rev_num = 0;
         while(n > 0) 
          { 
            rev_num = rev_num*10 + n%10; 
            n = n/10; 
          } 
          return rev_num;
    }
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
        //testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int N;
		    
		    
            //input N
		    N=sc.nextInt();
		    int R=0;
		    
		    	    
            // reverse the given number n
		    R=(int)rev(N);
	
            //power of the number to it's reverse
		    long ans=(long)obj.power(N,R);
		    System.out.println(ans);
		    
		    
		}
		
	}
}


// } Driver Code Ends



//User function Template for Java

class Solution
{
        
    long power(int N,int R)
    {
        //Your code here
        int mod = 1000000007;
        if(R == 1)  return N;
        else if(R % 2 == 1) return (N * power(N , R-1))%mod;
        else
        {
            long temp = power(N , R/2);
            return (temp*temp)%mod;
        }
    }

}
