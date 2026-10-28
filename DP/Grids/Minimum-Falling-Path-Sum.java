/*
 * Minimum Falling Path Sum
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Grids
 * Time complexity: O(n^2)
 * Space complexity: O(2n)
 * Solved: 2026-10-28
 * URL: https://leetcode.com/problems/minimum-falling-path-sum/submissions/2183990275/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //recursion -> memoization -> tabulation
        int minSum = Integer.MAX_VALUE;
        int n = matrix.length;
        int[]next = new int[n];

        for(int i=n-1;i>=0;i--){
            int left = Integer.MAX_VALUE/2;
            int right = Integer.MAX_VALUE/2;
            int down = Integer.MAX_VALUE/2;
            int [] curr = new int[n];
            for(int j=n-1;j>=0;j--){
                if(i==n-1) curr[j] = matrix[i][j];
                else{
                    if(j>0) left = matrix[i][j] + next[j-1];
                    if(j<n-1) right = matrix[i][j] + next[j+1];
                    down = matrix[i][j] + next[j];

                    curr[j]= Math.min(left,Math.min(down,right));
                }
                if(i==0) minSum = Math.min(curr[j],minSum);
            }
            next = curr;
        }
        return minSum;
    }
}
