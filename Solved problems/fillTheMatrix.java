/* Given a matrix with dimensions N x M, entirely filled with zeroes except 
for one position at co-ordinates X and Y containing '1'. 
Find the minimum number of iterations in which the whole matrix can be 
filled with ones.
Note: In one iteration, '1' can be filled in the 4 neighbouring elements of a 
cell containing '1'. */



//User function Template for Java

class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		int top = x-1, down = N-x;
	    int left = y-1, right = M-y;
	    return Math.max(top+left, Math.max(top+right, Math.max(down+left, down+right)));
		
	}
}
