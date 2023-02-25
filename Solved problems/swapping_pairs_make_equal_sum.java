/*

Given two arrays of integers A[] and B[] of size N and M, the task is to check if a pair of values (one value from each array) exists such that 
swapping the elements of the pair will make the sum of two arrays equal.
 
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    long findSwapValues(long A[], int n, long  B[], int m){
       HashSet<Long> set = new HashSet<>();
       long sum1 =0 ,  sum2 =0;
       for(long a : A){
           sum1+=a;
       }
       
       for(long b : B){
           sum2 += b;
        }
        
        long sum =sum2 - sum1;
        
        if((sum2 + sum1)%2 ==1){
            return -1;
        }
        
        for(long b:B){
            set.add(b);
        }
        
        for(int i =0; i<n; i++){
            if(set.contains(A[i] + sum/2))
            return 1;
        }
       return-1; 
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int m =Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a,n,b,m);
            System.out.println(ans);
        }
    }
}





// } Driver Code Ends
