/*
You are given a tree rooted at node 1. The tree is given in form of an array P where Pi denotes the parent of node i, Also P1 = -1, as 1 is the root node. 
Every node i has a value Ai associated with it. At first, you have to choose any node to start with, after that from a node you can go to any of its child nodes. 
You've to keep moving to a child node until you reach a leaf node. Every time you get to a new node, you write its value. Let us assume that the integer sequence in 
your path is B.
Let us define a function f over B, which is defined as follows:
f(B) = B1 - B2 + B3 - B4 + B5.... + (-1)(k-1)Bk.
You have to find the maximum possible value of f(B).
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
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.bestNode(N, A, P);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long bestNode(int N, int[] A, int[] P) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int k: P) set.add(k);
        ArrayList<Integer> leafNode = new ArrayList<>();
        for(int i = 1; i <= P.length; i++) if(!set.contains(i)) leafNode.add(i);
        int answer = Integer.MIN_VALUE;
        for(int leaf : leafNode){
            int node = leaf;
            int ans = 0;
            while(node != -1){
                ans *= -1;
                ans += (A[node - 1]);
                answer = Math.max(answer, ans);
                node = P[node - 1];
            }
        }
        return answer;
    }
}
        
