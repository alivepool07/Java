/*
Chhota Bheem wants to eat the maximum number of ladoos in Dholakpur on Independence Day. The houses in Dholakpur are arranged in the form of a binary tree 
and have ladoos the same as their house number. Chhota Bheem is standing at his home initially. 
Find the maximum ladoos he can eat if he can go to houses within a maximum distance k from his house. 
The number of ladoos at his home should also be included in the sum.

Note: Every house has distinct ladoos in it. 
*/


//{ Driver Code Starts
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
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int home = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            Solution x = new Solution();
            System.out.println( x.ladoos(root, home, k) );
            t--;
        }
    }
}


// } Driver Code Ends




/*
// node structure:

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

*/

class Solution{
    static int ladoos(Node root, int home, int k){
        // Your code goes here
        HashMap<Node,Node> parent=new HashMap<>();
        markparents(root,parent);
        Node target=shome(home,root);
        Queue<Node> q=new LinkedList<>();
        q.add(target);
        HashMap<Node,Boolean> visited=new HashMap<>();
        
        visited.put(target,true);
        int sum=0;
        sum+=home;
        int curlevel=0;
        
        while(!q.isEmpty()){
            int n=q.size();
            if(curlevel++==k) break;
            
            for(int i=0;i<n;i++){
                Node f=q.poll();
                if(f.left!=null && !visited.containsKey(f.left)){
                    q.add(f.left);
                    sum+=f.left.data;
                    visited.put(f.left,true);
                }
                if(f.right!=null && !visited.containsKey(f.right)){
                    q.add(f.right);
                    sum+=f.right.data;
                    visited.put(f.right,true);
                }
                if(parent.containsKey(f) && !visited.containsKey(parent.get(f))){
                    q.add(parent.get(f));
                    sum+=parent.get(f).data;
                    visited.put(parent.get(f),true);
                }
            }
        }
        return sum;
        
    }
    
    static void markparents(Node root,HashMap<Node,Node> parent){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            Node p=q.poll();
            if(p!=null){
              if(p.left!=null){
                  q.add(p.left);
                  parent.put(p.left,p);
              }
              if(p.right!=null){
                  q.add(p.right);
                  parent.put(p.right,p);
              }
            }
            else{
                if(!q.isEmpty()) q.add(null);
            }
        }
    }
    
    static Node shome(int home,Node root){
        if(root==null) return null;
        
        if(root.data==home) return root;
        
        Node left=shome(home,root.left);
        
        if(left!=null) return left;
        
        return shome(home,root.right);
    }
}
