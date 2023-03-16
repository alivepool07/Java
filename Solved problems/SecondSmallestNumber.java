/*

The task is to find the second smallest number with a given sum of digits as S and the number of digits as D.

*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        }
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution{
    static String secondSmallest(int S, int D){
        // code here
        int[] num = new int[D];
        for(int i=D-1;i>0;i--)  {
            int d = Math.min(S-1,9);
            num[i] = d;
            S-=d;
        }
        if(S>9)  {
            return  "-1";
        }
        num[0] = S;
        for(int i = D-1;i>0;i--)  {
            if(num[i] != 0 && num[i -1] !=9)  {
                num[i] -=1;
                num[i-1] += 1;
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<D;j++)  {
                    sb.append(num[j]);
                }
                return sb.toString();
            }
        }
        return  "-1";
    }
}
