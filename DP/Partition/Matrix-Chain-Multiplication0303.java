/*
 * Matrix Chain Multiplication0303
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: DP > Partition
 * Time complexity: O(n^3) near about
 * Space complexity: O(n^2)
 * Solved: 2026-11-11
 * URL: https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i=1;i<n;i++) dp[i][i] = 0;//wese to this is unnecessary but just for the records to mark base case first
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int minCost = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int cost = arr[i-1] * arr[k] * arr[j] 
                    + dp[i][k] + dp[k+1][j];
                    minCost = Math.min(cost,minCost);
                }
                dp[i][j] = minCost;      
                }
            }
        return dp[1][n-1];
    }
}
