/*

You are given an array A of N integers and an integer K, and your task is to find the total number of cuts that you can make such that for each 
cut these two conditions are satisfied
1. A cut divides an array into two parts equal or unequal length (non-zero).
2. Sum of the largest element in the left part and the smallest element in the right part is greater than or equal to K.

*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int K;
            K = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.totalCuts(N, K, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int totalCuts(int N, int K, int[] A) {
        // code here
        int[] mini=new int[N];
        int[] maxi=new int[N];
        maxi[0]=A[0];
        mini[N-1]=A[N-1];
        for(int i=1;i<N-1;i++){
            mini[N-i-1]=Math.min(mini[N-i],A[N-i-1]);
            maxi[i]=Math.max(maxi[i-1],A[i]);
        }
        int ans=0;
        for(int i=0;i<N-1;i++){
            if(mini[i+1]+maxi[i] >=K)ans++;
        }
        return ans;
    }
}
