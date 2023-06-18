/*
Santa is still not married. He approaches a marriage bureau and asks them to hurry the process. The bureau checks the list of eligible girls of size N and hands 
it over to Santa. 
Santa being conscious about his marriage is determined to find a girl with maximum connections so that he can gather more information about her. Accordingly, 
he looks to figure out the maximum number of girls (from the list) who know each other to achieve the above purpose.

In order to finalize the girl, he needs to find the Kth prime. Where k = largest group of girls who know each other. Considering Santa's poor knowledge of Maths, 
he seeks Banta's help for the answer. Now you, a fan of Santa Banta Jokes, take this prestigious opportunity to solve the problem.

In case no of connections is zero, print "-1". Here the connection between girls is represented by a 2-D array g of dimension M*2, where M is the number of 
connections.

Note :
1. Suppose girl "a" knows girl "b" and girl "b" knows girl "c", then girl "a" also knows girl "c". Transitivity holds here.
2. Consider 1 as a composite number.
3. For precompute function given in the template you just have to complete it and use it wherever required, do not call it again and again, it is already being 
called by driver function before executing test cases. 
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		obj.precompute();    	
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [][] = new int[M][2];
		    for(int i = 0;i<M;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.helpSanta(N, M, arr);
            System.out.println(ans);
    	    
		}
	}
}




// } Driver Code Ends




//User function Template for Java


class Complete{
    
    static boolean[] store=new boolean[1299723];
    static ArrayList<Integer> primes=new ArrayList<>();
    public static void precompute () {
        
        for(int i=2;i<1299723;i++)
        {
            for(int j=i+i;j<1299723;j+=i)
            {
                store[j]=true;
            }
        }
        
        for(int i=2;i<1299723;i++)
        {
            if(store[i]==false)
            {
                primes.add(i);
            }
        }
    }
    
    public static void dfs(int i,ArrayList<ArrayList<Integer>> adj,int[] curCount,boolean[] visited)
    {
        if(visited[i]==true) return;
        
        visited[i]=true;
        
        curCount[0]+=1;
        
        for(int x: adj.get(i))
        {
            if(visited[x]==false) 
                dfs(x,adj,curCount,visited);
        }
    }
    public static int helpSanta (int n, int m, int g[][]) {
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
            
        for(int i=0;i<g.length;i++)
        {
            int u=g[i][0],v=g[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        
        
        int maxGroupSize=0;
        
        boolean[] visited=new boolean[n+1];
        
        for(int i=0;i<=n;i++)
        {
            if(visited[i]==false){
                int[] curCount={0};
                dfs(i,adj,curCount,visited);
                maxGroupSize=Math.max(maxGroupSize,curCount[0]);
            }
        }
        
        if(maxGroupSize==1) return -1;
        
        return primes.get(maxGroupSize-1);
        
    }
    
    
}
