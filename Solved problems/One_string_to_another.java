//Check if it is possible to convert one string into another with given constraints
// GFG
/* Given two strings S and T, which contains three characters i.e 'A', 'B' and '#' only.
Check whether it is possible to convert the first string into another string by performing following operations on string first.

1- A can move towards Left only
2- B can move towards Right only
3- Neither A nor B should cross each other
Note: Moving i'th character towards Left one-step means swap i'th with (i-1)'th
character [ i-1>=0 ]. Moving i'th character towards Right one-step means swap i'th
with (i+1)'th character [ i+1< string's length ].
 */

public class One_string_to_another {
    public static void main(String[] args) {

    }
    int isItPossible(String S, String T, int M, int N) {
        // code here
        if(M!=N)
            return 0;

        int i=0; int j=0;
        while(i<M)
        {
            while(i<M && S.charAt(i)=='#') i++;
            while(j<N && T.charAt(j)=='#') j++;

            if(i>=M && j<N) return 0;
            if(j>=N && i<M) return 0;

            if(i<M && j<N && (S.charAt(i) == T.charAt(j)))
            {
                if(S.charAt(i)=='A' && j>i) return 0;
                if(S.charAt(i)=='B' && j<i) return 0;
            }
            if(i<M && j<N && (S.charAt(i) != T.charAt(j)))
                return 0;

            i++; j++;
        }
        return 1;
    }
};


