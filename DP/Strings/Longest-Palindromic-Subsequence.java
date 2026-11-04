/*
 * Longest Palindromic Subsequence
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Strings
 * Time complexity: O(n^2)
 * Space complexity: O(2n)
 * Solved: 2026-11-04
 * URL: https://leetcode.com/problems/longest-palindromic-subsequence/submissions/2189007269/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * The main idea of this was to think of the longest common subsequence. First of all, what is a palindrome? If a string is the same when reversed and as normal, then it is a palindrome, right? Now, if I reverse this string, then I find the longest common substring between the normal string and the reversed string. What will I get? I will get a string which is equal from both sides, even if it's starting normally or starting from the reverse, and it is a palindrome. 
 */

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] prev = new int[n+1];
        for(int i=1;i<=n;i++){
            int[] curr = new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s.charAt(n-j)){
                    curr[j] = 1+ prev[j-1];
                }
                else curr[j] = Math.max(prev[j],curr[j-1]);
            }
            prev = curr;
        }
        return prev[n];
    }
}
