/*

Given two arrays A[] and B[] of same length N. There are N types of sticks of lengths specified. Each stick of length A[i] is present in B[i] units (i=1 to N). 
You have to construct the squares and rectangles using these sticks. Each unit of a stick can be used as length or breadth of a rectangle or as a side of square. 
A single unit of a stick can be used only once.

Let S be the sum of lengths of all sticks that are used in constructing squares and rectangles. The task is to calulate the maximum possible value of S.

Note: The element in array A[] is always unique.

*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            input_line = read.readLine().trim().split("\\s+");
            int B[]= new int[N];
            for(int i = 0; i < N; i++)
                B[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.maxPossibleValue(N, A, B); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long maxPossibleValue(int N, int A[] ,int B[]) { 
        // code here
         int count=0;
        int mini=Integer.MAX_VALUE;
        long sum=0;
        for(int i=0;i<N;i++){
            int n=B[i]/2;
            if(n>0){
                mini=Math.min(mini,A[i]);
                sum+=A[i]*n*2;
                count+=n;
            }
        }
        if(count%2!=0) sum-=mini*2;
        return sum;
        
    }
} 
