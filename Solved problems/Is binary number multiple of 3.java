/*
Given a number in its binary form find if the given binary number is a multiple of 3. 
It is recommended to finish the task using one traversal of input binary number.
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine().trim());
            while(t-->0)
                {
                    String s = in.readLine().trim();
                    Solution ob = new Solution();
                    out.println(ob.isDivisible(s));
                }
                out.close();
        }
}    
// } Driver Code Ends



//User function Template for Java

class Solution {
    int isDivisible(String s) {
   int e=0,o=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)!='0')
            {
                if(i%2==0)
                   o++;
                   else e++;
                   
                   
            }
        }
        int k=e-o;
        
        if(k%3==0) return 1;
        else return 0;    }
}
