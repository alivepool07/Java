/*
You are given an array arr of n integers. You must return the minimum number of operations required to make this array 0. For this you can do an operation :

Choose a sub-array of non-zero elements & replace all with 0(0 must be present in arr, if not you can not replace it).
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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.arrayOperations(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int arrayOperations(int n, int[] arr) {
        // code here
        boolean zero = false;
        int counter = 0;
        boolean prev_zero = true;
        for(int i=0;i<n;i++){
            if(arr[i] == 0) {
                zero = true;
                prev_zero = true;
            } else if(prev_zero){
                prev_zero = false;
                counter++;
            }
        }
        
        if(zero) {
            return counter;
        } else {
            return -1;
        }
    }
}
            
