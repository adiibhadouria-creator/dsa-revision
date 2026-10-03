/*
 * Longest Valid ParenthesesHard
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: LeetCode > Daily
 * Time complexity: O(2n)
 * Space complexity: O(1)
 * Solved: 2026-10-03
 * URL: https://leetcode.com/problems/longest-valid-parentheses/submissions/2160766541/?envType=daily-question&envId=2026-10-03
 * Language: java
 *
 * Problem statement:
 * whenever you see parentheses think of stack or open close , you can get the answer easily and requires two pass sometimes

condition--> for valid parenthese
from left to right
open == close -->means it is valid store the count
open < close -->means it is invalid reset count
open > close--> keep going forward no problem

from right to left
close < open-->  means it is invalid reset count
close > open -> keep going forward no problem
open == close -->means it is valid store the count


 *
 * Notes:
 * None
 */

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int open =0 , close =0;
        int  maxlen =0;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='(') open++;
            else close++;

            if(open==close) {
                maxlen = Math.max(maxlen,open+close);
            }
            else if(close>open) {
                open = close =0; 
                
            }
        }
        open = close = 0;
        for(int i=n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c=='(') open++;
            else close++;

            if(open==close) {
                maxlen = Math.max(maxlen,open+close);
            }
            else if(open>close){
                 open = close =0;
            }
        }
        return maxlen;
    }
}
