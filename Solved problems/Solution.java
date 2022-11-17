// Leetcode problem to find out numbers with even number of digits

/* Input: nums = [12,345,2,6,7896]
        Output: 2
        Explanation:
        12 contains 2 digits (even number of digits).
        345 contains 3 digits (odd number of digits).
        2 contains 1 digit (odd number of digits).
        6 contains 1 digit (odd number of digits).
        7896 contains 4 digits (even number of digits).
        Therefore, only 12 and 7896 contain an even number of digits.  */

public class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;                  
        for(int num : nums){                    // Loop initialisation
            if(even(num)){                      // calling even function to check every digit of nums .
                count++;
            }
        }
        return count;
    }
    boolean even(int num){              
        int get_num = digit(num);               // Calling digit function 

        return get_num % 2 ==0;                 // Returns true for every num that has even nbumber of digits
    }
    int digit(int num){
        if (num == 0){                          // boundary condition : as loop won;t execute for num = 0 ,still it will have 1 digit .
            return 1;
        }
        if (num < 0){                           // Boundary condition : When given a negative interger value , this line will convert it into +ve for counting digits
            num= num * -1;                      // Otherwiase , it'll return -1
        }
        int count = 0;

        while(num > 0){                        // checking the total number of digits in a given interger by dividing it by 10 
            count++;
            num = num/10;
        }
        return count;
    }

}
