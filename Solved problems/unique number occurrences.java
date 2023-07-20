/*
Given an array arr of N integers, the task is to check whether the frequency of the elements in the array is unique or not. 
Or in other words, there are no two distinct numbers in array with equal frequency. 
If all the frequency is unique then return true, else return false.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
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
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.isFrequencyUnique(n, arr);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends





class Solution {
    public static boolean isFrequencyUnique(int n, int[] arr) {
      HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int it : arr) {
            if(hm.containsKey(it)) {
                hm.put(it, hm.get(it)+1);
            }
            else {
                hm.put(it, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if(hs.contains(entry.getValue())) return false;
            hs.add(entry.getValue());
        }
        return true;
    }
    
}
        
