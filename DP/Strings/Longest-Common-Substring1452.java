/*
 * Longest Common Substring1452
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: DP > Strings
 * Time complexity: O(n^2)
 * Space complexity: O(2n)
 * Solved: 2026-11-04
 * URL: https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This question lasted around 1.5 hours or 2 hours of mine, but I understood one thing: if I want to return a string, the string is continuous, whereas a subsequence is not continuous. In a subsequence, I can either skip this and find further words, but in a string, if it doesn't match, then I have to reset the count to zero. What we can do is build a tabular table and observe what is happening. According to that, you can directly write it. 
 */

class Solution {
    public int longCommSubstr(String s, String t) {
        // code here
        //build tabulated table
        //i will also print it
        int n = s.length() , m = t.length() , max = 0;
        int endIdx = -1;
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(dp[i][j],max);
                    // if(dp[i][j]>max){
                    //     max = dp[i][j];
                    //     endIdx = i;
                    // }
                }
            }
        }
        //System.out.println("Printing longest common substring->"+s.substring(endIdx-max,endIdx));
        return max;
    }
}
