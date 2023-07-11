/*
Write a program to find the transpose of a square matrix of size N*N. Transpose of a matrix is obtained by changing rows to columns and columns to rows.
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
        int t=Integer.parseInt(in.readLine().trim());
        while(t-->0)
        {
            int n=Integer.parseInt(in.readLine().trim());
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                for(int j=0;j<n;j++){
                    a[i][j]=Integer.parseInt(s[j]);
                }
            }
            Solution ob=new Solution();
            ob.transpose(n,a);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    out.print(a[i][j]+" ");
                }out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution
{
    public void transpose(int n,int ar[][])
    {
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int t = ar[i][j];
                ar[i][j] = ar[j][i];
                ar[j][i] = t;
            }
        }
    }
}
