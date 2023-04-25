/*
There are N rooms in a straight line in Geekland State University's hostel, you are given a binary string S of length N where S[i] = '1' represents 
that there is a wifi in ith room or S[i] = '0' represents no wifi. Each wifi has range X i.e. if there is a wifi 
in ith room then its range will go upto X more rooms on its left as well as right. You have to find whether students in all rooms can use wifi.
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends




//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int N, String S, int X) 
    { 
        int range = X, currentRange = 0, currentDistance = 0;
        for(int i = 0; i < N; i++) {
            char c = S.charAt(i);
            if(c == '0') {
                if(currentRange > 0) {
                    currentRange--;
                } else {
                    currentDistance++;
                }
            } else {
                if(currentDistance > range) return false;
                currentRange = range;
                currentDistance = 0;
            }
        }
        return currentDistance <= 0;
    }
} 
