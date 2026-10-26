/*
 * Unique Paths II
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Grids
 * Time complexity: O(n*m)
 * Space complexity: O(n)
 * Solved: 2026-10-26
 * URL: https://leetcode.com/problems/unique-paths-ii/submissions/2181804863/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //recursion->memoization -> tabulation -> space optimization
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];
        
        //ignoring that start and end can also be stone
        if(obstacleGrid[m-1][n-1]==1 || obstacleGrid[0][0]==1) return 0;
        for(int i=0;i<m;i++){
            int up = 0 , left = 0;
            int[] curr = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) curr[j]=1;
                else if(obstacleGrid[i][j]==1) curr[j] = 0;
                else{
                    if(i>0) up = prev[j];
                    if(j>0) left = curr[j-1];
                    curr[j] = up + left;  
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }
}
