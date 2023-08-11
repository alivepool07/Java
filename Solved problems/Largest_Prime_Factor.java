
import java.util.*;

class Largest_Prime_Factor
{
    public static void main(String args[])
    {
        System.out.println("Write the value of N :");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        long largestPrimeFactor = Solution.largestPrimeFactor(N);
        System.out.println("The largest prime factor of " + N + " is: " + largestPrimeFactor);
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution{
    static long largestPrimeFactor(int N) {
        // code here
        if(isPrime(N))
            return N;
        int maxFactor = 1;
        for(int i=2; i*i<=N; i++){
            if(N%(N/i)==0 && isPrime(N/i))
                maxFactor = Math.max(maxFactor, N/i);
            else if(N%i==0 && isPrime(i)){
                maxFactor = Math.max(maxFactor, i);
            }
        }
        return maxFactor;
    }
    
    static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
} 

