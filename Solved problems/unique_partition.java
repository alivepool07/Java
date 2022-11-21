//Leetcode Unique partition problem

/* Given a positive integer n, generate all possible unique ways
  to represent n as sum of positive integers.
Note: The generated output is printed without partitions.
Each partition must be in decreasing order.
Printing of all the partitions is done in reverse sorted order.
  */


public class unique_partition {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
        {
            partition(n,n);
            return ans;
        }
        public void partition(int n, int target)
        {
            if(n<=0)
                return;

            if(target<0)
                return;

            if(target==0)
            {
                ans.add(new ArrayList<>(tempList));
                return;
            }

            tempList.add(n);
            partition(n,target-n);
            tempList.remove(tempList.size()-1);

            partition(n-1, target);
        }
    }

