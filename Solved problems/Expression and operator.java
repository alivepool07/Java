/*
Given a string S that contains only digits (0-9) and an integer target, return all possible strings to insert the 
binary operator ' + ', ' - ', or ' * ' between the digits of S so that the resultant expression evaluates to the target value.

Note:

Operands in the returned expressions should not contain leading zeros. For example, 2 + 03 is not allowed whereas 20 + 3 is fine. It is allowed 
to not insert any of the operators.

If no solution is found, return an empty string array.
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

            String S;
            S = br.readLine();

            int target;
            target = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<String> res = obj.addOperators(S, target);
            Collections.sort(res);
            for (String s : res) System.out.print(s + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<String> addOperators(String S, int target) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        String newString = "";
        help(S,target,0,ans,0,0,newString);
        return ans;
    }
    
    static void help(String s,int target,int index,ArrayList<String> ans,int value,int pichla,String newString){
        if(index==s.length()){
            if(value==target){
                ans.add(newString);
            }
            return;
        }
        String temp= "";
        int n = 0;
        for(int i=index;i<s.length();i++){
            temp+=s.charAt(i);
            n=n*10+(s.charAt(i)-'0');
            if(index==0){
                help(s,target,i+1,ans,n,n,temp);
            }
            else{
                help(s,target,i+1,ans,value+n,n,newString+"+"+temp);
                help(s,target,i+1,ans,value-n,-n,newString+"-"+temp);
                help(s,target,i+1,ans,value-pichla+pichla*n,pichla*n,newString+"*"+temp);
            }
            if(s.charAt(index)=='0')break;
        }
    }
    
}
