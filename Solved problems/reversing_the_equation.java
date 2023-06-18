/*
Given a mathematical equation that contains only numbers and +, -, *, /. Print the equation in reverse, such that the equation is reversed, 
but the numbers remain the same.
It is guaranteed that the given equation is valid, and there are no leading zeros.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution{
    String reverseEqn(String S)
    {
       StringBuilder s = new StringBuilder();
        for(int i = S.length() - 1; i >= 0 ; i--){
            if( i != 0 && (S.charAt(i) >= '0' && S.charAt(i) <= '9') && (S.charAt(i-1) >= '0' && S.charAt(i-1) <= '9') ){
                continue;
            }
            else{
                if(S.charAt(i) == '+' || S.charAt(i) == '-' || S.charAt(i) == '*' || S.charAt(i) == '/')
                s.append(S.charAt(i));
                else{
                int j = i;
                while(j < S.length() && S.charAt(j) >= '0' && S.charAt(j) <= '9')
                {
                   s.append(S.charAt(j));
                   j++;
                }
            }
            }
        }
        return s.toString();
    }
}
