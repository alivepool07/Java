//GFG

/*You are given an array consisting of n integers which denote the position of a stall.
You are also given an integer k which denotes the number of aggressive cows.
You are given the task of assigning stalls to k cows such that the minimum distance
between any two of them is the maximum possible.
The first line of input contains two space-separated integers n and k.
The second line contains n space-separated integers denoting the position of the stalls.
*/

import java.util.Arrays;

public class Aggressive_cows {

    public static void main(String[] args) {

    }
    public static int solve(int n, int k, int[] arr) {

        Arrays.sort(arr);

        int i=1,res=0,j=arr[arr.length-1]-arr[0];

        while(i<=j){

            int mid=(i+j)/2;

            if(isPossible(arr,k,mid)){

                res=mid; i=mid+1; }else j=mid-1;}

        return res;

    }

    static boolean isPossible(int[]arr,int cow ,int mid){

        int start=arr[0],count=1;

        for (int i = 0; i < arr.length; i++) {

            if(arr[i]-start>=mid){

                start=arr[i];count++;}

            if(count==cow)return true;}

        return false;

    }
}
