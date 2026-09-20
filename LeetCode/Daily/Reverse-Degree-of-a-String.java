/*
 * Reverse Degree of a String
 * Difficulty: Easy
 * Topic: LeetCode > Daily
 * Time complexity: O(N)
 * Space complexity: O(1)
 * Solved: 2026-09-20
 * URL: https://leetcode.com/problems/reverse-degree-of-a-string/submissions/2147114157/?envType=daily-question&envId=2026-09-20
 *
 * Problem statement:
 * Given a string s, calculate its reverse degree. The reverse degree is calculated as follows: For each character, multiply its position in the reversed alphabet ('a' = 26, 'b' = 25, ..., 'z' = 1) with its position in the string (1-indexed). Sum these products for all characters in the string. Return the reverse degree of s. Example 1: Input: s = "abc" Output: 148 Explanation: LetterIndex in Reversed AlphabetIndex in StringProduct'a'26126'b'25250'c'24372 The reversed degree is 26 + 50 + 72 = 148. Example 2: Input: s = "zaza" Output: 160 Explanation: LetterIndex in Reversed AlphabetIndex in StringProduct'z'111'a'26252'z'133'a'264104 The reverse degree is 1 + 52 + 3 + 104 = 160. Constraints: 1 <= s.length <= 1000 s contains only lowercase English letters.
 *
 * Notes:
 * simulated as asked.
 */

class Solution {
    public int reverseDegree(String s) {
        /*                  sum
           a-> 1   26       27
           b-> 2   25       27
        */
        int sum =0;
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            int reversed = 26 - (c-'a');
            sum += (i+1)*reversed;
            // System.out.println("normal:"+normal);
            // System.out.println("reversed:"+reversed);
            // System.out.println("sum:"+sum);
            // System.out.println("-----------");
        }
        return sum;
    }
}
