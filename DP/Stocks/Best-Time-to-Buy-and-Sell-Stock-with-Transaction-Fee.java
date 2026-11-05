/*
 * Best Time to Buy and Sell Stock with Transaction Fee
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Stocks
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Solved: 2026-11-05
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/submissions/2190351035/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int f(int i,int j,int []prices,int fee,int[][]dp){
        if(i==prices.length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(j==1){
            int buy = f(i+1,0,prices,fee,dp)-prices[i];
            int notBuy = f(i+1,1,prices,fee,dp);
            return dp[i][j] = Math.max(buy,notBuy);
        }
        else{
            int sell = f(i+1,1,prices,fee,dp)+(prices[i]-fee);
            int notSell = f(i+1,0,prices,fee,dp);
            return dp[i][j] = Math.max(sell,notSell);
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp= new int[n][2];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return f(0,1,prices,fee,dp);
    }
}
