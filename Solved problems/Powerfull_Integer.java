/*
You are given a 2D integer array of intervals whose length is n where intervals[i]=[start, end] I.e. all integers from start to end inclusive of start and 
end are also present and also we are given an integer k. We have to return the Powerfull Integer. A powerful Integer is an integer that occurs at least k times. 
If multiple integers have at least k occurrences, we have to return the maximum integer out of all those elements. 

Note: If no integer occurs at least k times return -1.
*/


//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine().trim());
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                a[i][0]=Integer.parseInt(s[0]);
                a[i][1]=Integer.parseInt(s[1]);
            }
            int k=Integer.parseInt(in.readLine().trim());
            Solution ob=new Solution();
            out.println(ob.powerfullInteger(n,a,k));
        }
        out.close();
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution{
    public static int powerfullInteger(int n,int interval[][],int k) {
        int max = Integer.MIN_VALUE;
        
        for (int i=0; i < interval.length; i++) {
            max = Math.max(max, interval[i][1]);
        }
        
        int[] prefix = new int[max + 2];
        
        for (int i=0; i < interval.length; i++) {
            prefix[interval[i][0]]++;
            prefix[interval[i][1] + 1]--;
        }
        
        int ans = -1;
        
        for (int i=1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + prefix[i];
            
            if (prefix[i] >= k) {
                ans = i;
            }
        }
        
        return ans;
    }
}
