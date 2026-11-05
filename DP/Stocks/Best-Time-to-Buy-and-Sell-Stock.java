/*
 * Best Time to Buy and Sell Stock
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Stocks
 * Time complexity: O(n )
 * Space complexity: O(1)
 * Solved: 2026-11-05
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/2189810621/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int cheapest = prices[0];
        for(int i=1;i<prices.length;i++){
            int profit= prices[i]-cheapest;
            max = Math.max(max,profit);
            cheapest = Math.min(prices[i],cheapest);
        }
        return max;
    }
}
