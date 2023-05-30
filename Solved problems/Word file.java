/*
Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed 
from letters of adjacent cells only. ie - horizontal or vertical neighbors. The same letter cell can not be used more than once.
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends




class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
         int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        int dRow[] = {-1,0,1,0};
        int dCol[] = {0,1,0,-1};
        int k = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dfs(board,word,i,j,n,m,k,dRow,dCol,vis)){
                    return true;
                }
            }
        }
        return false;
    }
     public boolean dfs(char board[][], String word, int row, int col,int n, int m, int k, int dRow[], int dCol[], boolean vis[][]){
        //base condition
        if(word.length()==k){
            return true;
        }
        //validate
        if(row<0 || row>=n || col<0 || col>=m || vis[row][col] || board[row][col]!=word.charAt(k)){
            return false;
        }
        vis[row][col] = true;
        for(int i=0; i<4; i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if(dfs(board,word,nRow,nCol,n,m,k+1,dRow,dCol,vis)){
                return true;
            }
        }
        vis[row][col] = false;
        return false;
    }
}
