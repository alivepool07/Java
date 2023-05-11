/*
Given a string, S.The string can contain small case English letters or '?'. You can replace '?' with any small English letter. Now if it is possible 
to make the string S a palindrome after replacing all '?' then find the palindromic string with a minimum ascii sum of differences of adjacent characters. 
Otherwise, return -1.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int minimumSum(String s) {
        // code here
        int n=s.length();
        
        char arr[] = s.toCharArray();
        int i=0; int j=n-1;
        
        while(i<=j){
            if(arr[i]!=arr[j]){
                if(arr[i]=='?'){
                    arr[i]=arr[j];
                }else if(arr[j]=='?'){
                    arr[j]=arr[i];
                }else return -1;
            } 
            i++; j--;
        }
        
        i=0; j=n-1;
        int ans=0; char prev='?';
        
        while(i<=j){
            char cur=arr[i];
            if(cur!='?'){
                if(prev!='?') ans+=Math.abs(cur-prev);
                prev=cur;
            }
            
            i++; j--;
        }
        
        return 2*ans;
    }
}
