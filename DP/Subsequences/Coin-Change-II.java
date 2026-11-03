/*
 * Coin Change II
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Subsequences
 * Time complexity: O(n*target)
 * Space complexity: O(n)
 * Solved: 2026-11-03
 * URL: https://leetcode.com/problems/coin-change-ii/submissions/2188262503/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int change(int amount, int[] coins) {
        //i have to return all
        //recursion - tle -> memoisation -> tabulation -> space optimisation
        int n = coins.length;
        int[] prev = new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i % coins[0]==0) prev[i] = 1;
        }   
        for(int i=1;i<n;i++){
            int[]curr = new int[amount+1];
            for(int j=0;j<=amount;j++){
                int notPick = prev[j];
                int pick = 0;
                if(coins[i]<=j){
                    pick = curr[j-coins[i]];
                }
                curr[j] = pick + notPick;
            }
            prev = curr;
        }
        return prev[amount];
    }
}
