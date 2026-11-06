/*
 * Longest Increasing Subsequence
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > LIS
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 * Solved: 2026-11-06
 * URL: https://leetcode.com/problems/longest-increasing-subsequence/submissions/2190476911/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * just dry run 
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        int max = 1;
        Arrays.fill(dp,1);
        for(int ind = 0;ind<n;ind++){
            for(int prev= 0;prev<ind;prev++){
                if(nums[prev]<nums[ind]){
                    dp[ind] = Math.max(dp[ind],1+dp[prev]);
                }
                max = Math.max(max,dp[ind]);
            }
        }
        return max;
    }
}
