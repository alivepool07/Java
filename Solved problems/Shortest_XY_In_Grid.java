/*
Given a N*M grid of characters 'O', 'X', and 'Y'. Find the minimum Manhattan distance between a X and a Y.

Manhattan Distance :
| row_index_x - row_index_y | + | column_index_x - column_index_y |
*/

//{ Driver Code Starts
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
            int M = Integer.parseInt(S[1]);

            ArrayList<ArrayList<Character>> grid = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Character> col = new ArrayList<>();
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    col.add(S1[j].charAt(0));
                }
                grid.add(col);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestXYDist(grid, N, M));
        }
    }
}
// } Driver Code Ends




// User function Template for Java



// User function Template for Java

class Solution {
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N,
                              int M) {
        //code here
        List<int[]> x = new ArrayList<>(); // store all X with their co-ordinates
        List<int[]> y = new ArrayList<>(); // store all Y with their co-ordinates
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(grid.get(i).get(j) == 'X') x.add(new int[]{i, j});
                else if(grid.get(i).get(j) == 'Y') y.add(new int[]{i, j});
            }
        }
       
        for(int[] xi : x) {
            for(int[] yi : y) {
                distance = Math.min(distance, Math.abs(xi[0]-yi[0]) + Math.abs(xi[1]-yi[1]));
            }
        }
        return distance;
    }
};
    
