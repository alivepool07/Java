/*
Given a binary matrix mat[][] of dimensions NxM such that 1 denotes land and 0 denotes water. Find the number of closed islands in the given matrix.

Note: A closed island is a group of 1s surrounded by only 0s on all the boundaries (except diagonals). In simple words, a closed island is an island whose none 
of the 1s lie on the edges of
the matrix.
*/

//{ Driver Code Starts
//Initial Template for Java

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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution
{
    public int closedIslands(int[][] grid, int n, int m)
    {
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i*j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        dfs(i,j,n,m,grid);
                    }
                }
            }
        }
        //call DFS in whole grid and count surrounded land
        int count=0;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            if(grid[i][j]==1){
                count++;
                        dfs(i,j,n,m,grid);
                    }
                 }
            }
            return count;
    }
    public void dfs(int i,int j,int n,int m,int arr[][]){
        arr[i][j]=0;
        int ax[]={1,-1,0,0};
        int ay[]={0,0,1,-1}; 
        for(int k=0;k<4;k++){
            int nx=i+ax[k];
            int ny=j+ay[k];

            if(isValid(nx,ny,n,m,arr)){
                dfs(nx,ny,n,m,arr);
            }
        }
    }
    boolean isValid(int i,int j,int n,int m,int arr[][]){
        if(i>=0 && i<n && j>=0 && j<m && arr[i][j]==1) 
        return true;

        return false;
    }
}
