/*
 * Rod Cutting0840
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: DP > Subsequences
 * Time complexity: O(n*n)
 * Space complexity: O(n)
 * Solved: 2026-11-03
 * URL: https://www.geeksforgeeks.org/problems/rod-cutting0840/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int cutRod(int[] price) {
        // code here
        ///just think it is 1-based indexing but you can access elements using normal behaviour only
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int i=0;i<=n;i++){
            dp[0][i] = i*price[0];
        }
        
        for(int i=1;i<n;i++){
            for(int len = 0;len<=n;len++){
                int notPick = dp[i-1][len];
                int pick = 0;
                if(len >= i+1) pick = price[i] + dp[i][len-(i+1)];
                
                dp[i][len] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][n];
    }
}
