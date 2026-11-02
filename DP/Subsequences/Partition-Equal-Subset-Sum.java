/*
 * Partition Equal Subset Sum
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Subsequences
 * Time complexity: O(n*target)
 * Space complexity: O(n)
 * Solved: 2026-11-02
 * URL: https://leetcode.com/problems/partition-equal-subset-sum/submissions/2187392476/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int target = sum/2;
        if(sum%2==1 || n==1) return false;
        boolean[][]dp = new boolean[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if(nums[0]<=target){
            dp[0][nums[0]] = true;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean pick = nums[i] <= j? dp[i-1][j-nums[i]]:false;
                boolean notPick = dp[i-1][j];

                dp[i][j] = pick || notPick;
            }
        }
    return dp[n-1][target]; 
    }
}
