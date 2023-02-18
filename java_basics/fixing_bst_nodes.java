// GFG POTD
/* Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
Note: It is guaranteed than the given input will form BST, except for 2 nodes that will be wrong. 
*/





class Solution {
    Node w1 = null, w2 = null;
    public Node correctBST(Node root) {
        inorder(root);
        // System.out.println(w1.data+" "+w2.data);
        int temp = w1.data;
        w1.data = w2.data;
        w2.data = temp;
        return root;
    }
    Node prev = null;
    public void inorder(Node root) {
        if(root == null) return;
        // last = root;
        inorder(root.left);
        if(prev!=null){
            if(prev.data > root.data){
                if(w1 == null) w1 = prev;
                 w2 = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
