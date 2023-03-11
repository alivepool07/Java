/*

You are given an array of N elements and num queries, In each query you are given three numbers L,R and K and you have to tell, how many indexes are 
there in between L and R(L<=i<=R) such that the frequency of a[i] from index i to n-1 is k.

Note: 0-based indexing

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


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
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
            
            
            int num;
            num = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[][] Q = IntMatrix.input(br, num, 3);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.solveQueries(N, num, A, Q);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<Integer> solveQueries(int N, int num, int[] arr, int[][] Q) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,HashMap<Integer,Integer>> hm = new HashMap<>();
        for(int i=0;i<N;i++){
            HashMap<Integer,Integer> temp = new HashMap<>();
            for(int j=i;j<N;j++){
                temp.put(arr[j],temp.getOrDefault(arr[j],0)+1);
            }
            hm.put(i,temp);
        }
        for(int i=0;i<Q.length;i++){
            int L = Q[i][0];
            int R = Q[i][1];
            int K = Q[i][2];
            int count = 0;
            for(int j=L;j<=R;j++){
                if(hm.get(j).get(arr[j]) == K){
                    count++;
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
