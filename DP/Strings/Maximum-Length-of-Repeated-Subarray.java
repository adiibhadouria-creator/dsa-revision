/*
 * Maximum Length of Repeated Subarray
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Strings
 * Time complexity: O(n x m)
 * Space complexity: O(2n)
 * Solved: 2026-11-04
 * URL: https://leetcode.com/problems/maximum-length-of-repeated-subarray/submissions/2188985350/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int findLength(int[] s ,int[] t) {
        int n = s.length , m = t.length;
        int[]prev = new int[m+1];
        int max = 0;
        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            for(int j=1;j<=m;j++){
                if(s[i-1]==t[j-1]){
                    curr[j] = prev[j-1]+1;
                    max = Math.max(curr[j],max);
                }
            }
            prev = curr;
        }
        return max;
    }
}
