/*
 * Coin Change
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Subsequences
 * Time complexity: O(n*amount)
 * Space complexity: O(n)
 * Solved: 2026-11-03
 * URL: https://leetcode.com/problems/coin-change/submissions/2188173737/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int f(int i,int a,int []c,int[][]dp){
        if(i==0){
            if(a%c[i]==0) return a/c[i];
            else return Integer.MAX_VALUE/2;
        }
        if(dp[i][a]!=Integer.MAX_VALUE) return dp[i][a];
        int notPick = f(i-1,a,c,dp);
        int pick = Integer.MAX_VALUE/2;
        if(c[i]<=a){
            pick = 1 + f(i,a-c[i],c,dp);
        }
        return dp[i][a] = Math.min(pick,notPick);
    }
    public int coinChange(int[] coins, int amount) {
        //keep the count of coins but not amount 
        if(amount==0) return 0;
        int n = coins.length;
        int[][]dp = new int[n][amount+1];
        for(int[]row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        int ans = f(n-1,amount,coins,dp);
        return ans==Integer.MAX_VALUE/2 ? -1 : ans;

    }
}
