/*
Given an undirected graph with V vertices(numbered from 1 to V) and E edges. Find the number of good components in the graph.
A component of the graph is good if and only if the component is a fully connected component.
Note: A fully connected component is a subgraph of a given graph such that there's an edge between every pair of vertices in a component, the given graph can be a 
disconnected graph. Consider the adjacency 
list from index 1.
*/


//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]=new boolean[V+1];
        int cntcomp=0;
        for(int i=1;i<=V;i++){
            if(!vis[i]){
                int cnt[]=new int[1];
                int cntedge[]=new int[1];
                dfs(i,vis,adj,cnt,cntedge);
                if(cntedge[0]/2==(cnt[0]*(cnt[0]-1))/2){
                    cntcomp++;
                }
            }
        }

        return cntcomp;
    }
    public void dfs(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj,int[] cnt,int[] cntedge){
        vis[node]=true;
        cnt[0]++;

        for(int adjnode:adj.get(node)){
            cntedge[0]++;
 
            if(!vis[adjnode]){
                dfs(adjnode,vis,adj,cnt,cntedge);

            }
        }
    }
}
 
