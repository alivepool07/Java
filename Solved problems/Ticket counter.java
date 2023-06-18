/*
N people from 1 to N are standing in the queue at a movie ticket counter. It is a weird counter, as it distributes tickets to the first 
K people and then the last K people and again first K people and so on, once a person gets a ticket moves out of the queue. 
The task is to find the last person to get the ticket.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int distributeTicket(int N,int K)
    {
        int i=1,j=N,ans=0;
        boolean a=false;
        while(i<=j){
            if(a==false){
                i+=K;
                ans=j;
            }
            else{
                j-=K;
                ans=i;
            }
            a=!a;
        }
        return ans;
    }
}
