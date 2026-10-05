/*
 * Score of ParenthesesMed.
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: LeetCode > Daily
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Solved: 2026-10-05
 * URL: https://leetcode.com/problems/score-of-parentheses/submissions/2162741667/?envType=daily-question&envId=2026-10-05
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * if we can find the depth , power of depth will be the answer for it
 */

class Solution {
    public int scoreOfParentheses(String s) {
        int score =0;
        int depth =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                depth++;
            }
            else{
                depth--;
                if(s.charAt(i-1)=='(') score += 1<<depth;
            }
        }
        return score;
    }
}
