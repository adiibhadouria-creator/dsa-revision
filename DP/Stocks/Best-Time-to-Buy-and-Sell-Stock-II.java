/*
 * Best Time to Buy and Sell Stock II
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Stocks
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Solved: 2026-11-05
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/2190239856/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int f(int day,int allowedToBuy,int[]prices,int[][]dp){
        if(day==prices.length) return 0;
        //if i can buy
        if(dp[day][allowedToBuy]!=-1) return dp[day][allowedToBuy];
        if(allowedToBuy==1){//2 cases : either buy today or do not buy today
            int buy = f(day+1,0,prices,dp)-prices[day];
            int notBuy = f(day+1,1,prices,dp);
            return dp[day][allowedToBuy] = Math.max(buy,notBuy);
        }
        //that means i cannot buy
        else{//2 cases: sell it today or do not
            int sell = f(day+1,1,prices,dp)+prices[day];
            int notSell = f(day+1,0,prices,dp);
            return dp[day][allowedToBuy] =Math.max(sell,notSell);
        }
    }
    public int maxProfit(int[] prices) {
        //recursion -> memoisation
        int n = prices.length;
        int[][]dp = new int[n+1][2];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return f(0,1,prices,dp);
    }
}
