/*
 * Simple Greedy Approach! - Java
 * Difficulty: Not specified
 * Topic: Greedy > Medium
 * Time complexity: O(N log N)
 * Space complexity: O(1)
 * Solved: 2026-09-18
 * URL: https://www.geeksforgeeks.org/problems/shortest-job-first/1
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Shortest job first - simple logic
 */

class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int n = bt.length;
        int waitingTime = 0;
        int currTime = 0;
        for(int time:bt){
            waitingTime += currTime;
            currTime += time;
        }
        return waitingTime/n;
    }
}
