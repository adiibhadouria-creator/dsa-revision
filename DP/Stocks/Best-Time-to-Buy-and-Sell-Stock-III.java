/*
 * Best Time to Buy and Sell Stock III
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Stocks
 * Time complexity: O(5n)
 * Space complexity: O(1)
 * Solved: 2026-11-05
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int f(int day,int transactions,int[]prices,int[][]dp){
        if(transactions==0) return 0;
        if(day==prices.length) return 0;
        if(dp[day][transactions]!=-1) return dp[day][transactions];
        if(transactions%2==0){
            int buy = f(day+1,transactions-1,prices,dp)-prices[day];
            int notBuy = f(day+1,transactions,prices,dp);
            return dp[day][transactions] = Math.max(buy,notBuy);
        }
        else{
            int sell = f(day+1,transactions-1,prices,dp)+prices[day];
            int notSell = f(day+1,transactions,prices,dp);
            return dp[day][transactions] = Math.max(sell,notSell);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][]dp = new int[n+1][5];     
            for(int[]row:dp){
                Arrays.fill(row,-1);
            }
       return f(0,4,prices,dp);
    }
}
