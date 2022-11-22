// Given a number N. Find if it can be expressed as sum of two prime numbers.

/* Logic : Any +ve interger less than 4  can't be expressed as a sum of 2 prime numbers , in that case  return "NO"
           
           Any EVEN number greater than 4 can be expressed as sum of two prime numbers , return Yes in that case.
           
           For any ODD value of N , if N-2 is prime , return Yes 
*/

public class sumOfprime {
    public static void main(String[] args) {

        int N = 34;
        String ans = isSumOfTwo(N);
        System.out.println(ans);

    }
    static String isSumOfTwo(int N){
        if(possible(N))return "Yes";
        else return "No";
    }
    static boolean possible(int N) {
        if(N<4)return false;
        if (N%2 == 0)
            return true;
        return isPrime(N - 2);
    }
    static boolean isPrime(int x) {
        for (int i=2; i*i<=x; i++)
            if (x%i == 0)
                return false;
        return true;
    }
}
