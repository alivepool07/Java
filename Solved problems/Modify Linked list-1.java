/*
Given a singly linked list containing N nodes. Modify the Linked list as follows:

1. Modify the value of the first half nodes such that 1st node's new value is equal to the value of the last node minus the first node's current value,
2nd node's new value is equal to the second last nodes value minus 2nd nodes current value, likewise for first half nodes.
2. Replace the second half of nodes with the initial values of the first half nodes(values before modifying the nodes).
3. If N is odd then the value of the middle node remains unchanged.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution
{
    public static Node reverse(Node h){
        Node prev=h;
        Node curr=h.next;
        while(curr!=null){
            Node nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        h.next=null;
        return prev;
    }
    public static Node findMiddle(Node head) {
        Node r=head;
        Node h=head;
        while(r.next!=null&&r.next.next!=null){
            r=r.next.next;
            h=h.next;
        }
        Node mid=h;
        return mid;
    }
    public static Node modifyTheList(Node head)
    {
        if(head.next==null){
            return head;
        }
        
        Node middle=findMiddle(head);
        Node sec=reverse(middle.next);
        Node cur=head;
        Node c2=sec;
        while(cur!=middle.next){
            if(c2==null){
                break;
            }
            int d1=cur.data;
            int d2=c2.data;
            cur.data=d2-d1;
            c2.data=d1;
            cur=cur.next;
            c2=c2.next;
            
        }
        reverse(sec);
        return head;
    }
}
