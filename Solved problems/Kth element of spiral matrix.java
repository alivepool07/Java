/*
Given a matrix with n rows and m columns. Your task is to find the kth element which is obtained while traversing the matrix spirally. 
You need to complete the method findK which takes four arguments the first argument is the matrix A and the next two arguments will be 
n and m denoting the size of the matrix A and then the forth argument is an integer k. 
The function will return the kth element obtained while traversing the matrix spirally.
*/

//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends



class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
        int l = 0;
 		int r = m-1;
 		int t = 0;
 		int b = n-1;
 		int count = 1;
 	    while(count>=0){
 	        // left to right
 	        for(int i= l ; i<=r; i++){
 	            if(count==k)
 	                return A[t][i];
 	            count++;
 	        }
 	        // top to bottom
 	        for(int j=t+1; j<=b; j++){
 	            if(count==k)
 	                return A[j][r];
 	            count++;
 	        }
 	        // right to left
 	        for(int i=r-1; i>=l; i--){
 	            if(count==k)
 	                return A[b][i];
 	            count++;
 	        }
 	        // bottom to top
 	        for(int j=b-1; j>=t+1; j--){
 	            if(count==k)
 	                return A[j][l];
 	            count++;
 	        }
 	        l++;
 	        t++;
 	        r--;
 	        b--;
 	        if(l>r|| t>b)
 	            break;
 	    }
 	    return 0;
	  
    }
}
