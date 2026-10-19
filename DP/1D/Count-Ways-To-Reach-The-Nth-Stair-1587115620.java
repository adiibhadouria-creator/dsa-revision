/*
 * Count Ways To Reach The Nth Stair 1587115620
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: DP > 1D
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Solved: 2026-10-19
 * URL: https://www.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int countWays(int n) {
        // code here
        
        if(n<2) return 1;
        int [] dp = new int[n+1];
        dp[1] = 1;//ways to climb 1 stair
        dp[2] = 2;//ways to climb 2 stairs
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
