/*
 * Job Sequencing Problem | Practice | GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Greedy > Medium
 * Time complexity: O(N log N)
 * Space complexity: O(maxDeadLine)
 * Solved: 2026-09-15
 * URL: https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * I dont know why this works there is one thing while you are looping back for alloting jobs , loop till 1 only , this pq approach I dont understand correctly
 */

class Solution {
    static class Job {
        int deadline;
        int profit;

        Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }

        // Sort by deadline
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.deadline, b.deadline));

        // Keep the most profitable jobs
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Job job : jobs) {
            pq.add(job.profit);
