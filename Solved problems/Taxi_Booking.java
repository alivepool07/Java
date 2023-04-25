/*
You are going to book a taxi. There are infinite number of points 1, 2, 3... on the X axis and your current position is cur. There are N Taxis near you, 
and the position of those taxis is given as an array pos. Where pos[i] denotes the position of the ith taxi. You are also given an array time. 
Where time[i] denotes the time taken by the ith taxi to cover 1 unit of distance. Your task is to find the minimum time to board a taxi.
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
            
            
            int cur;
            cur = Integer.parseInt(br.readLine());
            
            
            int[] pos = IntArray.input(br, N);
            
            
            int[] time = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.minimumTime(N, cur, pos, time);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends





//User function Template for Java

class Solution 
{ 
    static long solve(int X,int Y, String S)
	{    
	    // code here
	    Stack<Character> st = new Stack<>();
        long cnt_pr = 0 , cnt_rp = 0;
        char a = 'p' , b = 'r';
        if(Y > X){
            a = 'r';
            b = 'p';
            int temp = X;
            X = Y;
            Y = temp;
        }
        for(int i=0;i<S.length();i++){
            if(!st.isEmpty() && st.peek() == a && S.charAt(i) == b){
                st.pop();
                cnt_pr++;
            }
            else{
                st.push(S.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        // Now checking count of rp
        for(int i=0;i<sb.length();i++){
            if(!st.isEmpty() && st.peek() == b && sb.charAt(i) == a){
                st.pop();
                cnt_rp++;
            }
            else{
                st.push(sb.charAt(i));
            }
        }
        long ans = (X*cnt_pr)+(Y*cnt_rp);
        return ans;
	}
}
