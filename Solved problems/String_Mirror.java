/*
You are given a string str of length n. You want to choose a non-zero integer k (k<=n), such that you can perform the following operation:
Take the prefix of the string of length k and append the reverse of it to itself.
Your task is to find the lexicographically smallest string you can get.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String stringMirror(String str) {
        int i =0;
        while(i<str.length()-1 && str.charAt(i)>=str.charAt(i+1) && str.charAt(0)!=str.charAt(1)){
            i++;
        }
        StringBuilder sb = new StringBuilder(str.substring(0,i+1));
        for(int j =sb.length()-1;j>=0;j--){
            sb.append(sb.charAt(j));
        }
        return sb.toString();
       
    }
}
        
