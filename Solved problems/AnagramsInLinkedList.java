/*

Given a linked list of characters and a string S.Return all the anagrams of the string present in the given linked list.In case of overlapping anagrams 
choose the first anagram from left.

*/

//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends



// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        int[] a = new int[26];
        for(char c : s.toCharArray()){
            a[c-'a']++;
        }
        
        int n = s.length();
        
        int k=0;
        Node t1 = head, t2 = head;
        
        ArrayList<Node> list = new ArrayList<>();
        
        while(t2!=null){
            a[t2.data-'a']--;
            k++;
            while(a[t2.data-'a']<0){
                a[t1.data-'a']++;
                k--;
                t1 = t1.next;
            }
            
            if(k == n){
                list.add(t1);
                while(t1!=t2.next){
                    a[t1.data-'a']++;
                    t1 = t1.next;
                }
                t1 = t2.next;
                t2.next = null;
                t2 = t1;
                k = 0;
            }
            else t2 = t2.next;
        }
        
        return list;
    }
}
