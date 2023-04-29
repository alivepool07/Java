/*

Given an integer N, You need to find the Nth smallest number which only contains odd digits i.e. 1,3,5,7,9 means no even digits are allowed on that number 
(12 will not consider). For example, the starting numbers which only contain odd digits are 1,3,5,7,9,11,13,15,17,19,31,33,35 and so on.

*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            long n=Long.parseLong(in.readLine());
            Solution ob=new Solution();
            out.println(ob.findNumber(n));
        }
        out.close();
    }
}

// } Driver Code Ends



//User function Template for Java
class Solution
{
    public long findNumber(long N)
    {
        int lst[]={ 9,1,3,5,7};
        long num=0;
        long p=1;
        while(N!=0){
            int rem=(int)(N % (long)5);
            num=num+lst[rem]*p;
            if(rem==0){
                N--;
            }
            p*=10;
            N/=5;
        }
        return num;
    }
}
