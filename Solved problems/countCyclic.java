

/* 

Given a triangular pyramid with its vertices marked as O, A, B and C and a number N, 
the task is to find the number of ways such that a person starting from the origin O initially, reaches back to the origin in N steps. 
In a single step, a person can go to any of its adjacent vertices.

 */




class Solution{
	public static int countPaths(int N){
		//code here
		 int m = 1000000007;
		 long ans = 0;
		 for(int i=2;i<=N;i++){
            if(i%2==0){
                ans=(ans%m*3%m)%m+3;

     }else{
         ans=(ans%m*3%m)%m-3;
         }
    }
     return (int)ans%m;
	}
}
