/* There is a string of size n containing only 'A' and 'O'. 'A' stands for Apple, and 'O' stands for Orange. We have m number of spells, each spell allows us to convert an orange into an apple.

Find the longest sequence of apples you can make, given a string and the value of m.

 */


class Solution{
    public static int appleSequence(int n, int m, String arr){
        //code here
        int i=0;
        int cntO=0;
        int ans=0;
        for(int j=0;j<n;j++)
        {
            if(arr.charAt(j)=='O') cntO++;
            
            while(i<j && cntO>m)
            {
                if(arr.charAt(i)=='O') cntO--;
                i++;
            }
            
            ans=Math.max(ans,(j-i+1));
        }
        
            return ans;
    }
}
