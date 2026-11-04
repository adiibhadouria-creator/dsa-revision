/*
 * Shortest Common Supersequence
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Strings
 * Time complexity: O(n x m) + O(n+m)
 * Space complexity: O(n x m)
 * Solved: 2026-11-04
 * URL: https://leetcode.com/problems/shortest-common-supersequence/submissions/2189125116/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Finding the shortest common supersequence: find the longest common subsequence. By finding the LCS, we can get the max number of characters which are common in both. If we just want the length of the shortest common supersequence, then my brain will say: those elements which are repeating, add them only once, and write every other letter.  
  
What will be the length of the shortest common supersequence? Length of string 1 + length of string 2 - length of common subsequence. This will give me the shortest common.  
  
Now, how will you calculate it? If you remember the tabulation table of the longest common subsequence, what does it represent? DPNM stores the answer, but it also stores where it is coming from. If both characters at strings s and t are equal, then it is coming from the diagonal. If it is not, then it is coming either from the left or from up.  
  
Can I use this? Whenever the character will be the same, I will add it only once. Whenever those are not the same, wherever I am moving, I will let it get like it is going behind it. If I am getting --, then before doing --, I will add caret i into my answers. Pretty simple.
 */

class Solution {
    public String shortestCommonSupersequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp =new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        int i=n , j =m;
        StringBuilder lcs =new StringBuilder();
        while(i>0 && j>0){
            if(s.charAt(i-1)==t.charAt(j-1)){
                lcs.append(s.charAt(i-1));
                i--; j--;
            }
            else if(dp[i][j]==dp[i-1][j]){
                lcs.append(s.charAt(i-1));
                i--;
            } 
            else{
                lcs.append(t.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            lcs.append(s.charAt(i-1));
            i--;
        }
        while(j>0){
            lcs.append(t.charAt(j-1));
            j--;
        }
        return lcs.reverse().toString();

    }
}
