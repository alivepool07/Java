//GFG POTD

/*  
Given a binary tree, connect the nodes that are at the same level. The structure of the tree Node contains an addition nextRight pointer for this purpose.

Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.

*/


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node nextRight;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
        nextRight = null;
    }
} */
class Solution {
   public void connect(Node root) {
       Queue<Node> queue = new LinkedList();
       
	   if(root != null)
	   queue.add(root);
	   
	   while(!queue.isEmpty()){
	     int size = queue.size();
		 for(int i=1;i<=size;i++){
		 
		   Node n = queue.poll();
		   Node nex = queue.peek();
		   if(i==size)
		    nex = null;
		   n.nextRight = nex;
           if(n.left !=null)
            queue.add(n.left);
           if(n.right !=null)
            queue.add(n.right);				
		   	
		 }
	   }
        
    }
}
