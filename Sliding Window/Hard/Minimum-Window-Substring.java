/*
 * Minimum Window Substring
 * Platform: LeetCode
 * Difficulty: Hard
 * Topic: Sliding Window > Hard
 * Time complexity: O(2N) +O(M)
 * Space complexity: O(128)
 * Solved: 2026-09-24
 * URL: https://leetcode.com/problems/minimum-window-substring/submissions/2152175856/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * jusst think of required count and when inserting what to do with vallue and when removing what to do
 */

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(m>n) return "";
        int[]hash = new int[128];
        for(int i=0;i<m;i++){
            char c = t.charAt(i);
            hash[c]++;
        }
        int cnt =0,minLen = Integer.MAX_VALUE , start = -1;
        int left =0 , right =0;
        while(right<n){
            char r = s.charAt(right);
            if(hash[r]>0){
                cnt++;
            }
            hash[r]--;
            while(cnt == m){
                char l = s.charAt(left);
                if(minLen > right-left+1){
                    minLen = right-left +1;
                    start = left;
                }
                hash[l]++;
                if(hash[l]>0) cnt--;
                left++;
            }
            right++;
        }
        return start == -1 ? "":s.substring(start,start+minLen);
    }
}
