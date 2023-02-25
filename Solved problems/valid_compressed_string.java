/* 
A special compression mechanism can arbitrarily delete 0 or more characters and replace them with the deleted character count.
Given two strings, S and T where S is a normal string and T is a compressed string, determine if the compressed string  T is valid for the plaintext string S
*/


//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static boolean checkIfNumber(String T, int ptr2){
        if(T.charAt(ptr2)=='0' || T.charAt(ptr2)=='1' || T.charAt(ptr2)=='2' || T.charAt(ptr2)=='3' || 
            T.charAt(ptr2)=='4' || T.charAt(ptr2)=='5' || T.charAt(ptr2)=='6' || T.charAt(ptr2)=='7' ||
            T.charAt(ptr2)=='8' || T.charAt(ptr2)=='9'){
                return true;
            }
            
        return false;
    }
    
    static int checkCompressed(String S, String T) {
        int ptr1=0;
        int ptr2=0;
        int n1=S.length();
        int n2=T.length();
        
        while(ptr1<n1 && ptr2<n2){
            if(S.charAt(ptr1) == T.charAt(ptr2)){
                ptr1++;
                ptr2++;
            }
            else if(checkIfNumber(T, ptr2)==true){
                StringBuffer sb=new StringBuffer();
                
                //count numbers
                while(ptr2+1 < n2 && checkIfNumber(T, ptr2+1) == true){
                    sb.append(T.charAt(ptr2));
                    ptr2++;
                }
                sb.append(T.charAt(ptr2));
                
                //convert into int
                int n=Integer.parseInt(sb.toString());
                
                //skip the characters and check
                if(ptr1+n > n1){
                    return 0;
                }
                int temp=ptr1;
                ptr1=temp+n;
                
                //increment ptr2
                ptr2++;
            }
            else if(S.charAt(ptr1)!=T.charAt(ptr2)){
                //not a valid string
                return 0;
            }
        }
        
        //last check
        if(ptr1==n1 && ptr2==n2){
            return 1;
        }
        
        return 0;
    }
}
