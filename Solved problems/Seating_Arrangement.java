/*
You are given an integer n, denoting the number of people who needs to be seated, and a list of m integers seats, 
where 0 represents a vacant seat and 1 represents an already occupied seat.

Find whether all n people can find a seat, provided that no two people can sit next to each other.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int test = Integer.parseInt(in.readLine().trim());
        while(test-- > 0){
            int n = Integer.parseInt(in.readLine().trim());
            int m = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int [] seats = new int[m];
            for(int i = 0; i < m; i++){
                seats[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            boolean res = obj.is_possible_to_get_seats(n, m, seats);
            
            String _result_val = (res) ? "Yes" : "No";
            out.println(_result_val);
        }
        out.close();
    }
}

// } Driver Code Ends



class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] arr) {
        for (int i = 0; i < m && n > 0; i++) {
            if (arr[i] == 0) {
                if ((i == 0 || arr[i-1] == 0) && (i == m-1 || arr[i+1] == 0)) {
                    n--;
                    arr[i] = 1;
                }
            }
        }
        return n == 0;
    }
}
