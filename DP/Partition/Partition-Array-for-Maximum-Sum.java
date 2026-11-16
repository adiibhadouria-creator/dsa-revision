/*
 * Partition Array for Maximum Sum
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Partition
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 * Solved: 2026-11-16
 * URL: https://leetcode.com/problems/partition-array-for-maximum-sum/submissions/2197359707/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int f(int idx,int[]arr , int k,int[]dp){
        if(idx==arr.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int best = 0 , max = Integer.MIN_VALUE;
        for(int i = idx;i<Math.min(idx+k,arr.length);i++){
            max = Math.max(arr[i],max);
            int curr = max *(i-idx+1) + f(i+1,arr,k,dp);
            best = Math.max(curr,best);
        }
        return dp[idx] = best;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[]dp = new int[n];
        Arrays.fill(dp,-1);
        return f(0,arr,k,dp);
    }
}
