/*
Finding A Job Is Now Easier Than Today's Problem! Explore Job Fair 2023 

You are given an array of strings arr of size n. You have to find out if it is possible to make a palindromic string by concatenating the strings in any order. 
Provided that all the strings given in the array are of equal length.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.makePalindrome(n, arr);
            
            String _result_val = (res) ? "YES" : "NO";
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends




class Solution {
    public static boolean makePalindrome(int n, String[] arr) {
        // code here
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            StringBuffer sb=new StringBuffer(arr[i]);
            String s=sb.toString();
            String rev=sb.reverse().toString();
            
            if(map.containsKey(s))
            map.remove(s);
            
            else if(map.containsKey(rev))
            map.remove(rev);
            
            else 
            map.put(s,1);
            
            
        }
        
        if(map.size()==0)
        return true;
        
        else if(map.size()==1)
        {
            for(String val:map.keySet())
            {
                StringBuffer sb=new StringBuffer(val);
                if(val.equals(sb.reverse().toString()))
                return true;
            }
        }
        return false;
    }
}
        
