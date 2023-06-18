/*
There are N bags with diamonds in them. The i'th of these bags contains A[i] diamonds. If you drop a bag with A[i] diamonds, 
it changes to A[i]/2 diamonds and you gain A[i] diamonds. Dropping a bag takes 1 minute. Find the maximum number of diamonds 
that you can take if you are given K minutes.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            
            int[] A = new int[N];
            
            String S1[] = read.readLine().split(" ");
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxDiamonds(A,N,K));
        }
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution {
    static long maxDiamonds(int[] A, int N, int K) {
        // code here
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : A) 
        pq.add(x);
        long ans =0;
        for (int i=0; i<K;i++) {
            int curr = pq.remove();
            ans+= curr;
            pq.add(curr/2);
        }
        return ans;
    }
};
