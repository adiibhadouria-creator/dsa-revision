/*
 * Delete Operation for Two Strings
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Strings
 * Time complexity: O(n x m)
 * Space complexity: O(2N)
 * Solved: 2026-11-04
 * URL: https://leetcode.com/problems/delete-operation-for-two-strings/submissions/2189030091/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This LCCS application is best, man. There are two words, word 1 and word 2. I have to make both of them equal, and I can't delete any character anywhere in any string. Tell me, if I want to make two strings equal and I have to delete elements, then which elements will I tend to delete? Even if I think, which element should I delete? Those elements are not in both. If it is in either of these, which will remain are the characters that are in both, the characters that are common in both of these strings.

I want to do a min operation, so I have to find the longest common subsequence. It should be contiguous, so it's a subsequence. If I can get the longest common subsequence of both the strings, what will remain are the characters that are in either of the two strings. I have to remove those to make both of them equal. Just this much it is. Just use the longest common subsequence code and the total length of the characters, minus the LCS that is present in both words. That is what you will not delete into two. Into two means both the strings I have to add. What are the faulty words I will delete only? 
 */

class Solution {
    public int minDistance(String word1, String word2) {
        //longest common subsequence
        int len = word1.length() + word2.length();
        return len - lcs(word1,word2)*2;
    }
    public int lcs(String s,String t){
        int n = s.length() , m = t.length();
        int[] prev = new int[m+1];
        for(int i=1;i<=n;i++){
            int [] curr = new int[m+1];
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)) curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(curr[j-1],prev[j]); 
            }
            prev = curr;
        }
        return prev[m];
    }
}
