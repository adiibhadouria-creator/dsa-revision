/*
 * Maximal Square
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Grids
 * Time complexity: O(n x m)
 * Space complexity: O(n x m)
 * Solved: 2026-11-17
 * URL: https://leetcode.com/problems/maximal-square/submissions/2198005052/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        int[][]dp = new int[n][m];
        for(int[]row:dp) Arrays.fill(row,-1);
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    int side = f(i,j,matrix,dp);
                    ans = Math.max(ans,side*side);
                }
            }
        }
        return ans;
    }
    public int f(int i,int j,char[][]matrix,int[][]dp){
        if(i>=matrix.length || j>=matrix[0].length || matrix[i][j]=='0') return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right = 1+f(i,j+1,matrix,dp);
        int down = 1+f(i+1,j,matrix,dp);
        int diagonal = 1+f(i+1,j+1,matrix,dp);
        int side = Math.min(right,Math.min(down,diagonal));
        return dp[i][j] = side;
    }
}
