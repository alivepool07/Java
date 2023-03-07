/*
Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.
*/

//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends




class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        
        HashMap<Integer , Integer> mp = new HashMap<>();
        
        mp.put(0,-1);
        int sum =0;
        int ml=0;
        
        for(int i=0;i<n;i++){
            sum += arr[i];
            
            if(mp.containsKey(sum)){
                int tl = i-mp.get(sum);
                
                ml = Math.max(ml , tl);
                
            }
            
            else{
                mp.put(sum, i);
            }
        }
        return ml;
    }
}
