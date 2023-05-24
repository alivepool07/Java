/*
You are given a tree containing N nodes in the form of an array P where Pi represents the parent of the i-th node and P0 = -1 as the tree is rooted 
at node 0. In one move, you can merge any two adjacent nodes. Calculate the minimum number of moves required to turn the tree into a star tree.

-> Merging adjacent nodes means deleting the edge between them and considering both the nodes as a single one.
-> A Star tree is a tree with a center node, and all other nodes are connected to the center node only.
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
            
            
            int[] p = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.solve(N, p);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends




class Solution {
    public static int solve(int N, int[] p) {
        int[] arr = new int[N];
        Arrays.fill(arr, 0);
        
        for (int i = 1; i < N; i++) {
            arr[p[i]]++;
            arr[i]++;
        }
        
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        
        if (count == N) {
            return 0;
        }
        
        return N - 1 - count;
    }
}
        
