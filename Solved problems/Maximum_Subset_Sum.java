/*
Given an array A of size N. Find the maximum subset-sum of elements that you can make from the given array such that for every two consecutive 
elements in the array, at least one of the elements is present in our subset. 


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
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.findMaxSubsetSum(N, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {

    public static long findMaxSubsetSum(int N, int[] A) {
        // code here
         long sum = 0;
        long max = A[0];
        for(int i = 1;i<N;i++){
            long cur = A[i] + Math.max(sum,max);
            sum = max;
            max = cur;
        }
        return Math.max(sum,max);
    }
}
        
