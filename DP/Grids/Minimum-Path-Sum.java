/*
 * Minimum Path Sum
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Grids
 * Time complexity: O(m x n)
 * Space complexity: O(m x n)
 * Solved: 2026-10-26
 * URL: https://leetcode.com/problems/minimum-path-sum/submissions/2182569255/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int minPathSum(int[][] grid) {
        //recursion -> memoization -> tabulation
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
       
        for(int i=0;i<m;i++){
            int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else{
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];

                    dp[i][j] = grid[i][j] + Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
