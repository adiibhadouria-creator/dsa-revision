/*
 * Wildcard Matching
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Strings
 * Time complexity: O(n x m)
 * Space complexity: O(2n)
 * Solved: 2026-11-05
 * URL: https://leetcode.com/problems/wildcard-matching/submissions/2189709758/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public boolean isMatch(String s, String t) {
        int n = s.length() , m = t.length();
        //if s is empty , then check if t contains only * then tru
        boolean[][]dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        //for row 0 //k will go from 1 to m and mark true or false
        for(int j=1;j<=m;j++){
            if(t.charAt(j-1)=='*') dp[0][j]=dp[0][j-1];
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                char a = s.charAt(i-1) , b = t.charAt(j-1);
                if(a==b || b=='?') dp[i][j]= dp[i-1][j-1];
                else if(b=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}
