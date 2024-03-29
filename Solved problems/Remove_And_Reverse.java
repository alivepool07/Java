/*
Given a string S which consists of only lowercase English alphabets, you have to perform the below operations:
If the string S contains any repeating character, remove the first repeating character and reverse the string and again perform the above 
operation on the modified string, otherwise, you stop.
You have to find the final string.
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
          
            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeReverse(S); 
            System.out.println(ans);
        }
    } 
} 

// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    String removeReverse(String S) 
    { 
        // code here
        int arr[] = new int[26];
		for (int i = 0; i < S.length(); i++) {
			arr[S.charAt(i) - 97]++;
		}
		char[] s = S.toCharArray();
		boolean r = true;
		boolean l = false;
		int i = 0;
		int j = S.length() - 1;
		while (i < j) {
			if (r) {
				if (arr[s[i] - 97] > 1) {
					arr[s[i] - 97]--;
					s[i] = '#';
					r = false;
					l = true;
				}
				i++;

			} else if (l) {
				if (arr[s[j] - 97] > 1) {
					arr[s[j] - 97]--;
					s[j] = '#';
					r = true;
					l = false;
				}
				j--;
			}
		}
		StringBuilder sb = new StringBuilder();
		if (r) {
			for (int k = 0; k < s.length; k++) {
				if (s[k] != '#')
					sb.append(s[k]);
			}
		} else {
			for (int k = s.length - 1; k >= 0; k--) {
				if (s[k] != '#')
					sb.append(s[k]);
			}
		}
		return sb.toString();
    }
} 

//{ Driver Code Starts.

// } Driver Code Ends
