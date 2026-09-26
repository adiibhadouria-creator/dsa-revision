/*
 * Generate Parentheses
 * Platform: LeetCode
 * Difficulty: Medium
 * Topic: Recursion > Subsequences
 * Time complexity: O(N)* Catalan(N)
 * Space complexity: O(N)* Catalan(N)
 * Solved: 2026-09-26
 * URL: https://leetcode.com/problems/generate-parentheses/submissions/2153478675/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    void generate(int left,int right,String curr,List<String> res){
        if(left==0 && right==0){
            res.add(curr);
            return;
        }
        if(left>0){
            generate(left-1,right,curr+'(',res);
        }
        if(right>left){
            generate(left,right-1,curr+')',res);
        }
        return;
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n,n,"",res);
        return res;
    }
}
