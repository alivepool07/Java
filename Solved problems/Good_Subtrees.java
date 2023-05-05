/*
You are given a root node of a binary Tree and each node of the binary tree is assigned a value and you are also given an integer k and you have to 
return the count of Good subtrees of this binary Tree . Good subtree is a subtree such that the number of distinct values in this subtree is less than or equal to k.

Note: Subtree of a node consists of that node and all nodes of the subtrees of left and right child  of that node  if they exist .
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
	            int k=Integer.parseInt(br.readLine());
    	    	Node root = buildTree(s);
        	    Solution ob=new Solution();
                int ans=ob.goodSubtrees(root,k);
                out.println(ans);
                    t--;
            
            }
            out.close();
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution
{
    public static int goodSubtrees(Node root,int k)
    {
        int[] count={0};
        HashSet<Integer> set=fun(root,k,count);
        return count[0];
    }
    public static HashSet<Integer> fun(Node root, int k,int[] count){
        if (root==null)
            return null;
        HashSet<Integer> left=fun(root.left,k,count);
        HashSet<Integer> right=fun(root.right,k,count);
        HashSet<Integer> mains=new HashSet<>();
        mains.add(root.data);

        if (left!=null){
            for (int j: left){
                mains.add(j);
            }
        }
        if (right!=null){
            for (int j: right){
                mains.add(j);
            }
        }
        if (mains.size()<=k)
            count[0]++;
        return mains;
    }
}
