/*
 * Fair Distribution of Cookies
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Recursion > Backtracking
 * Time complexity: O(k^n)
 * Space complexity: O(n)
 * Solved: 2026-09-28
 * URL: https://leetcode.com/problems/fair-distribution-of-cookies/submissions/2156503022/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * for every cookie there is a choice ,whether to give it to this particular children or not , then for keeping children candies create a different array to keep track.
then easy peasy
 */

class Solution {
    int ans = Integer.MAX_VALUE;
    void backtrack(int idx,int k,int[]cookies,int []children){
        if(idx>=cookies.length){
           int unfairness =0;
           for(int i=0;i<k;i++){
            unfairness = Math.max(unfairness,children[i]);
           }
            ans = Math.min(ans,unfairness);
            return;
        }
        int cookie = cookies[idx];
        for(int i =0;i<k;i++){
            children[i] += cookie;
            backtrack(idx+1,k,cookies,children);
            children[i] -= cookie;
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        int [] children = new int[k];
        
        backtrack(0,k,cookies,children);
        return ans; 
    }
}
