/*
 * Count Square Submatrices with All Ones
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Grids
 * Time complexity: O(n x m)
 * Space complexity: O(n x m)
 * Solved: 2026-11-17
 * URL: https://leetcode.com/problems/count-square-submatrices-with-all-ones/submissions/2198233660/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int f(int i,int j,int[][]matrix,int[][]dp){
        if(i>=matrix.length || j>=matrix[0].length || matrix[i][j]==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int r = f(i,j+1,matrix,dp);
        int d = f(i+1,j,matrix,dp);
        int c = f(i+1,j+1,matrix,dp);
        int side = 1 + Math.min(r,Math.min(d,c));
        return dp[i][j] = side;
    }
    public int countSquares(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        int squares = 0;
        int[][]dp = new int[n][m];
        for(int[]row:dp) Arrays.fill(row,-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1){
                    int curr = f(i,j,matrix,dp);
                    squares += curr;
                }
            }
        }
        return squares;
    }
}
