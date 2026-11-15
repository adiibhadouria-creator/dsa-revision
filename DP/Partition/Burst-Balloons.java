/*
 * Burst Balloons
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Partition
 * Time complexity: O(n^3)
 * Space complexity: O(n^2)
 * Solved: 2026-11-15
 * URL: https://leetcode.com/problems/burst-balloons/submissions/2196754626/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * think in reverse
 */

class Solution {
    public int f(int i,int j,List<Integer> list,int[][]dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int best = -(int)1e9;
        for(int ind=i;ind<=j;ind++){
           int score = list.get(i-1) * list.get(ind) * list.get(j+1)+
           f(i,ind-1,list,dp) + f(ind+1,j,list,dp);
           best = Math.max(best,score);
        }
        return dp[i][j] = best;
    }
    public int maxCoins(int[] nums) {
        //i can reconstruct
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int x:nums) list.add(x);
        list.add(0,1);
        list.add(list.size(),1);
        int[][] dp = new int[n+1][n+1];
        for(int[]row:dp) Arrays.fill(row,-1);
        return f(1,n,list,dp);
    }
}
