/*
 * Longest Common Subsequence
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Strings
 * Time complexity: O(n x m)
 * Space complexity: O(2n)
 * Solved: 2026-11-03
 * URL: https://leetcode.com/problems/longest-common-subsequence/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Two of the things which I learned from this are:  
1\. If your base case is beyond zero, like here, my base case was: if \`i < 0\` and \`j < 0\`, then 0. In an array, while tabulating, you cannot have a negative index, so what I can do is shift the index. By shifting the index, I can say that if it was -1, I can assume it as 0. That's basically shifting the index, and it will help me in the tabulation version of it.  
2\. Why greedy doesn't work, I also understood it because it might leave something important, because there is no uniformity.
 */

class Solution {
    public int longestCommonSubsequence(String s, String t) {
        //recursion -> memoisation -> tabulation -> 2 array space optimisation
        int n = s.length(),m = t.length();
        int[] prev = new int[m+1];
        for(int i=0;i<=n;i++){
            int [] curr = new int[m+1];
            for(int j=0;j<=m;j++){
                if(i==0 || j==0) curr[j] =0;
                else if(s.charAt(i-1)==t.charAt(j-1)) curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(curr[j-1],prev[j]);
            }
            prev = curr;
        }
        return prev[m];
    }
}
