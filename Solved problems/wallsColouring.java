/*
There is a row of N walls in Geeksland. The king of Geeksland ordered Alexa to color all the walls on the occasion of New Year. Alexa can color each wall 
with one of the K colors. The cost associated with coloring each wall with a particular color is represented by a 2D costs array of size N * K. For example, 
costs[0][0] is the cost of coloring wall 0 with color 0; costs[1][2] is the cost of coloring wall 1 with color 2, and so on... Find the minimum cost to color all 
the walls such that no two adjacent walls have the same color.

Note: If you are not able to paint all the walls, then you should return -1.
*/



//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends




//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		int n=costs.length;
		int k=costs[0].length;
		if(k==1 && n>1){
		    return -1;
		}
		
		int dp[][]=new int[n][k];
		
		int m1=Integer.MAX_VALUE;
		int m2=Integer.MAX_VALUE;
		
		for(int i=0;i<k;i++){
		    dp[0][i]=costs[0][i];
		    
		    if(costs[0][i]<m1){
		        m2=m1;
		        m1=costs[0][i];
		    }else if(costs[0][i]<m2){
		        m2=costs[0][i];
		    }
		}
		for(int i=1;i<n;i++){
		      int nm1=Integer.MAX_VALUE;
		      int nm2=Integer.MAX_VALUE;
		      
		    for(int j=0;j<k;j++){
		        
		        if(dp[i-1][j]==m1)
		        dp[i][j]=costs[i][j]+m2;
		        
		        else
		        dp[i][j]=costs[i][j]+m1;
		        
		        if(dp[i][j]<nm1){
		            nm2=nm1;
		            nm1=dp[i][j];
		         }else if(dp[i][j]<nm2){
		            nm2=dp[i][j];
		        }
		        
		    }
		    m1=nm1;
		    m2=nm2;
		}
		return m1;
	}
}
