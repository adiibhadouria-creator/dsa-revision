/*
 * Knapsack With Duplicate Items4201
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: DP > Knapsack
 * Time complexity: O(n*capacity)
 * Space complexity: O(n)
 * Solved: 2026-11-03
 * URL: https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[] prev = new int[capacity+1];
        for(int i=0;i<=capacity;i++){
            prev[i] = (i/wt[0]) * val[0];
        }
        for(int i=1;i<n;i++){
            int[] curr = new int[capacity+1];
            for(int j=0;j<=capacity;j++){
                int notPick = prev[j];
                int pick = wt[i]<=j ? val[i] + curr[j-wt[i]] : 0;
                curr[j] = Math.max(pick,notPick);
            }
            prev = curr;
        }
        return prev[capacity];
    }
}
