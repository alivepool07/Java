/*
There is a rectangular path for a Train to travel consisting of n rows and m columns. The train will start from one of the grid's cells and it 
will be given a command in the form of string s consisting of characters L, R, D, U. Find if it is possible to travel the train inside the grid only.

Note:
If the train is at position (i,j)
on taking 'L' it goes to (i,j-1),
on taking 'R' it goes to (i,j+1),
on taking 'D' it goes to (i-1,j),
on taking 'U' it goes to (i+1,j).
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String srgs[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s1[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(n, m, s));
        }
    }
}
// } Driver Code Ends




// User function Template for 

class Solution{
    static int isPossible(int n, int m, String s){
       int a=0, b=0, c=0, d=0;
       for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='L'){
               a++;
               if(b!=0)
               b--;
           }
           else if(s.charAt(i)=='R'){
               b++;
               if(a!=0)
               a--;
           }
           else if(s.charAt(i)=='D'){
               c++;
               if(d!=0)
               d--;
           }
           else if(s.charAt(i)=='U'){
               d++;
               if(c!=0)
               c--;
           }
           if(a>=m || b>=m || c>=n || d>=n)
           return 0;
       }
       return 1;
    }
}
