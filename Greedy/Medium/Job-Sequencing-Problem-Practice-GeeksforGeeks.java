/*
 * Job Sequencing Problem | Practice | GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Greedy > Medium
 * Time complexity: O(N log N)
 * Space complexity: O(N)
 * Solved: 2026-09-15
 * URL: https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#expected-approach-using-priority-queue-on-logn-time-and-on-space
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * We sort deadlines , and choose the job to be done on the basis of profit like if at that slot only one job can be done then no problem but if there can be two or more jobs done then we have to find which job gives the maximum profit which is assisted my min heap we remove the job which give the lowest profit 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.PriorityQueue;
​
public class GfG {
    
    static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(0, 0));
        List<int[]> jobs = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{deadline[i], profit[i]});
        }
​
        // sort jobs by deadline in ascending order
        jobs.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < jobs.size(); i++) {
            int[] job = jobs.get(i);
            
            // if job can be scheduled within its deadline
            if (job[0] > pq.size()) {
                pq.add(job[1]);
            } 
            
            // replace the job with the lowest profit
            else if (!pq.isEmpty() && pq.peek() < job[1]) {
                pq.poll();
                pq.add(job[1]);
            }
        }
       
        while (!pq.isEmpty()) {
            ans.set(1, ans.get(1) + pq.poll());
            ans.set(0, ans.get(0) + 1);
        }
​
        return ans;
    }
​
    public static void main(String[] args) {
        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};
        ArrayList<Integer> result = jobSequencing(deadline, profit);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}
        }
    }
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        Job[] jobs = new Job[n];
        for(int i=0;i<n;i++){
            jobs[i] = new Job(deadline[i],profit[i]);
        }
        Arrays.sort(jobs,(a,b)->Integer.compare(a.deadline,b.deadline));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(Job job:jobs){
            pq.add(job.profit);
            if(pq.size()>job.deadline){
                pq.poll();
            }
        }
        int totalProfit = 0;
        int count = pq.size();
        while(!pq.isEmpty()){
            totalProfit += pq.poll();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(totalProfit);
        return ans;
    }
}
