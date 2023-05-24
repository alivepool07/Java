/*
There are N bowls containing cookies. In one operation, you can take one cookie from any of the non-empty bowls and put it into another bowl. 
If the bowl becomes empty you discard it. You can perform the above operation any number of times. You want to know the maximum number of bowls you can have 
with an identical number of cookies.

Note: All the non-discarded bowls should contain the identical number of cookies.


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
            
            
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.getMaximum(N, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int getMaximum(int n, int[] arr) {
        // code here
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        while(sum%n!=0){
            n--;
        }
        return n;
    }
}
        
