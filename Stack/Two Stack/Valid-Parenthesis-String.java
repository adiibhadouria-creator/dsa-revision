/*
 * Valid Parenthesis String
 * Difficulty: Not specified
 * Topic: Stack > Two Stack
 * Time complexity: O(N) 
 * Space complexity: O(N)
 * Solved: 2026-09-12
 * URL: https://leetcode.com/problems/valid-parenthesis-string/
 *
 * Problem statement:
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid. The following rules define a valid string: Any left parenthesis '(' must have a corresponding right parenthesis ')'. Any right parenthesis ')' must have a corresponding left parenthesis '('. Left parenthesis '(' must go before the corresponding right parenthesis ')'. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "". Example 1: Input: s = "()" Output: true Example 2: Input: s = "(*)" Output: true Example 3: Input: s = "(*))" Output: true Example 4: Input: s = "(" Output: false Constraints: 1 <= s.length <= 100 s[i] is '(', ')' or '*'.
 *
 * Notes:
 * Maintain two stack one for popping of closing and opening and one for maintainig stacks . And in stack store index rather than integers
 */

class Solution {
    //Recusrion approach
    // public boolean helper(String s , int index , int open ){
    //     if(open<0) return false;
    //     if(index == s.length()) return open == 0;
    //     char c = s.charAt(index);
    //     if(c=='('){
    //         return helper(s,index+1,open+1);
    //     }
    //     else if(c==')'){
    //         return helper(s,index+1,open-1);
    //     }
    //     else{
    //         return helper(s,index+1,open+1) || 
    //                 helper(s,index+1,open-1) ||
    //                 helper(s,index+1,open);
    //     }
    // }
    public boolean checkValidString(String s) {
        //return helper(s,0,0);
        

        //Stack approach
        Stack<Integer> openSt = new Stack<>();
        Stack<Integer> starSt = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') openSt.push(i);
            else if(c=='*') starSt.push(i);
            else{
                if(!openSt.isEmpty()) openSt.pop();
                else if(!starSt.isEmpty()) starSt.pop();
                else return false;
            }
        }
        while(!openSt.isEmpty()&& !starSt.isEmpty()){
            if(openSt.peek()>starSt.peek()) return false;
            openSt.pop();
            starSt.pop();
        }
        return openSt.isEmpty();

    }
}
