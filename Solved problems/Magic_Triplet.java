

// Magic triplet

/* Given an array of size n, a triplet (a[i], a[j], a[k]) is called a Magic Triplet
   if a[i] < a[j] < a[k] and i < j < k.
   Count the number of magic triplets in a given array.
*/

public class Magic_Triplet {
    public static void main(String[] args) {

        int[] nums = {3,2,1};
        int ans = countTriplets(nums);

        System.out.println(ans);
    }
    public static int countTriplets(int[] nums){
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int s = 0;
            int l = 0;

            for(int j = 0 ; j < i ; j++) {
                if (nums[j] < nums[i]) s++;
            }
            for(int k = i+1 ; k < nums.length ; k++){
                if(nums[k] > nums[i] ) l++;
            }
            count += s*l;
        }
        return count;
    }
}
