/*
Given a set of N jobs where each jobi has a deadline and profit associated with it. Each job takes 1 unit of time to 
complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find 
the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.
*/

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        //sort 
        Arrays.sort(arr, (a, b) -> Integer.compare(b.profit, a.profit));
        
        //store deadlines
        Map<Integer, Integer> map=new HashMap<>();
        int totalProfits=0;
        int totalJobs=0;
        
        for(int i=0; i<n; i++){
            int profit=arr[i].profit;
            int deadline=arr[i].deadline;
            
            for(int j=deadline; j>=1; j--){
                //check if deadline is stored
                if(map.containsKey(j)==false){
                    totalProfits=totalProfits+profit;
                    totalJobs=totalJobs+1;
                    
                    map.put(j, 1);
                    break;
                }
            }
        }
        
        //make res
        int[] res=new int[2];
        res[0]=totalJobs;
        res[1]=totalProfits;
        
        return res;
        
    }
}
