/*
 * Edit Distance
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Strings
 * Time complexity: O(n x m)
 * Space complexity: O(2 n)
 * Solved: 2026-11-04
 * URL: https://leetcode.com/problems/edit-distance/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Just do as it says. I have three options: replacing, deleting, or inserting. If the character is the same at both pointers, then I will not need to do any operation, and thus the cost added will be zero. I will search for the previous indexes. If it is not matching, then I will try all three combinations: replacing, deleting, and inserting.
Each will have a cost when I update. What will happen in the places is:
- If I replace it, that means I am bringing an element which is the same as that element, so I need to search for someone lesser in T.
- If I am deleting it, that means I have searched for someone lesser in I, and I have deleted.
- If I insert it, that means it will be close to this element, so search for the previous element of G.
And to remain simple
 */

class Solution {
    public int minDistance(String s, String t) {
        int n = s.length() , m = t.length();
        int[]prev = new int[m+1];
        for(int i=0;i<=n;i++){
            int[]curr = new int[m+1];
            for(int j=0;j<=m;j++){
                if(i==0) curr[j] = j;
                else if(j==0) curr[j] = i;
                else{
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        curr[j] = prev[j-1];
                    }
                    else{
                        int replace = 1 + prev[j-1];
                        int delete = 1 + prev[j];
                        int insert = 1 + curr[j-1];
                        curr[j] = Math.min(replace,Math.min(delete,insert));
                    }
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
