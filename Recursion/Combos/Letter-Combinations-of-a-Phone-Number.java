/*
 * Letter Combinations of a Phone Number
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Recursion > Combos
 * Time complexity: O(4^n)*n
 * Space complexity: O(1)
 * Solved: 2026-09-28
 * URL: https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/2156433398/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * in for loop we are iterating over curr digit string then after choosing a char from that string we will move to char of another digit string that is why passing index+1 to helper instead of i+1 , i is just for iterating over curr string
 */

class Solution {
    void helper (int index,StringBuilder curr,String digits,String[]map,List<String> ans){
        if(index>=digits.length()){
            ans.add(curr.toString());
            return;
        }
        char c = digits.charAt(index);
        int key = c-'0';
        String str = map[key];
        for(int i=0;i<str.length();i++){
            curr.append(str.charAt(i));
            helper(index+1,curr,digits,map,ans);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String [] map = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        List<String> ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        helper(0,curr,digits,map,ans);
        return ans;
    }
}
