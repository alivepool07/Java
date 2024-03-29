/*
Today! 

Imagine an imaginary array of length N containing balls. Given 2 arrays color and radius of length N each, where color[i] represents the color of the ith ball 
while radius[i] represents the radius of ith ball. 
If two consecutive balls have the same color and size, both are removed from the array. Geek wants to know the length of the final imaginary array.
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
            
            
            int[] color = IntArray.input(br, N);
            
            
            int[] radius = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.finLength(N, color, radius);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int finLength(int N, int[] color, int[] radius) {
        // code here
        Deque<Pair> dq = new LinkedList<>();
        for(int i=0 ; i<N ; i++){
            if(dq.isEmpty()){
                dq.addLast(new Pair(color[i], radius[i]));
            }
            else if(dq.peekLast().color == color[i] && dq.peekLast().radius == radius[i]){
                dq.removeLast();
            }
            else{
                dq.addLast(new Pair(color[i], radius[i]));
            }
        }
        return dq.size();
    }
    static class Pair{
        int color, radius;
        Pair(int color, int radius){
            this.color = color;
            this.radius = radius;
        }
    }
}
