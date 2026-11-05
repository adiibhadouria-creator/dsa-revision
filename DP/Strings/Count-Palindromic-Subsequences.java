/*
 * Count Palindromic Subsequences
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Strings
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Solved: 2026-11-05
 * URL: https://leetcode.com/problems/count-palindromic-subsequences/submissions/2189788406/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    static int mod = (int)1e9+7;
    public int solve(String s,String t,int i,int j,int[][]dp){
        if(j<0) return 1;//i got whole palindrome
        if(i<0) return 0;//i did not got palindrome
        if(dp[i][j]!=-1) return dp[i][j];
        int take = 0; 
        if(s.charAt(i)==t.charAt(j) || t.charAt(j)=='?'){
            take = solve(s,t,i-1,j-1,dp);//either char matches or it is a placeholder i will search for shorter string
        }
        int notTake = solve(s,t,i-1,j,dp);//i will not take this char for my current subsequence

        return dp[i][j] = (take + notTake)%mod;
    }
    public int countPalindromes(String s) {
        int n = s.length();
        int m = 5;
        if(n<5) return 0;
        int count = 0;
        for(int a=0;a<=9;a++){
            for(int b=0;b<=9;b++){
                String t = ""+a + b + "?" + b + a;
                int[][]dp = new int[n][5];
                for(int[]row:dp){
                    Arrays.fill(row,-1);
                }
                count = (count+solve(s,t,n-1,m-1,dp))%mod;
            }
        }
        return count;
    }
}
