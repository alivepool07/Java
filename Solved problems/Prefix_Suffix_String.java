/*
Given two Lists of strings s1 and s2, you have to count the number of strings in s2 which is either a suffix or prefix of at least one string of s1.
*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution
{
    public int prefixSuffixString(String s1[],String s2[])
    { int count=0;
        for(String s: s2)
        {
            for(String word: s1)
            {
                if(word.startsWith(s) || word.endsWith(s))
                {
                count++;
                break;
            }
            }
        }
        return count;
    }
}
