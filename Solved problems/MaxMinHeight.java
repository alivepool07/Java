/*

You have a garden with n flowers lined up in a row. The height of ith flower is ai units. You will water them for k days. 
In one day you can water w continuous flowers (you can do this only once in a single day). Whenever you water a flower its height increases by 1 unit. 
You need to maximize the height of the smallest flower all the time.

*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N, K, W;
			String [] str = br.readLine().trim().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			W = Integer.parseInt(str[2]);
			str = br.readLine().trim().split(" ");
			int [] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution obj = new Solution();
			System.out.println(obj.maximizeMinHeight(N, K, W,arr));
		}
	}
}
// } Driver Code Ends



//User function Template for Java



public class Solution {
    public boolean isvalid(int[] a, int n, int k, int w, long mid) {
        long[] ps = new long[n];
        Arrays.fill(ps, 0);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0)
                ps[i] += ps[i - 1];
            if (a[i] + ps[i] < mid) {
                long e = mid - a[i] - ps[i];
                ans += e;
                ps[i] += e;
                if (i + w < n)
                    ps[i + w] -= e;
            }
        }
        return (ans <= k);
    }
    
    public long maximizeMinHeight(int n, int k, int w, int[] a) {
        long ans = 0;
        long l = 0, h = (long)1e14;
        while (l <= h) {
            long mid = (l + h) / 2;
            if (isvalid(a, n, k, w, mid)) {
                l = mid + 1;
                ans = mid;
            }
            else {
                h = mid - 1;
            }
        }
        return ans;
    }
}
