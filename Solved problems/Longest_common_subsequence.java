import java.util.*;
public class Longest_common_subsequence {
    
    public static void main(String[] args) {
        
        System.out.println("Enter the length of first string : ");
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();

        System.out.println("Enter the length of Second string : ");
        Scanner sss = new Scanner(System.in);
        int y=sss.nextInt();

        System.out.println("Enter first string : ");
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();

        
        System.out.println("Enter first string : ");
        Scanner ss = new Scanner(System.in);
        String s2 = ss.nextLine();

       int lcs = Solution.lcs(x , y , s1 , s2);
       System.out.println("The longest common subsequence is " + lcs);
    }


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {   
    int n = s1.length();
    int m = s2.length();
    int prev[] = new int[m + 1];
    int curr[] = new int[m + 1];
    
    for (int idx1 = 1; idx1 <= n; idx1++) {
        for (int idx2 = 1; idx2 <= m; idx2++) {
            if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
                curr[idx2] = 1 + prev[idx2 - 1];
            } else {
                curr[idx2] = Math.max(prev[idx2], curr[idx2 - 1]);
            }
        }
        
        // Swap curr and prev arrays
        int[] temp = prev;
        prev = curr;
        curr = temp;
    }
    
    return prev[m];
    }
    
   
}
}
