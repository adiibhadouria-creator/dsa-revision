/*
 * Valid Parenthesis String
 * Difficulty: Medium
 * Topic: Greedy  > Medium
 * Time complexity: O(N)
 * Space complexity: O(1)
 * Solved: 2026-09-12
 * URL: https://leetcode.com/problems/valid-parenthesis-string/
 *
 * Problem statement:
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid. The following rules define a valid string: Any left parenthesis '(' must have a corresponding right parenthesis ')'. Any right parenthesis ')' must have a corresponding left parenthesis '('. Left parenthesis '(' must go before the corresponding right parenthesis ')'. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "". Example 1: Input: s = "()" Output: true Example 2: Input: s = "(*)" Output: true Example 3: Input: s = "(*))" Output: true Example 4: Input: s = "(" Output: false Constraints: 1 <= s.length <= 100 s[i] is '(', ')' or '*'.
 *
 * Notes:
 * Instead of exploring all options we keep the range of the open brackets that using two variables and minOpen cant go beyond 0 cause that will be an invalid string then and if maxopen goes beyond 0 that means there is no possible answer

 */

class Solution {
    public boolean checkValidString(String s) {
        // minOpen = "best case for closing brackets"
        // maxOpen = "best case for opening brackets"
        int minOpen = 0 , maxOpen = 0;
        for(char c:s.toCharArray()){
            if(c=='('){
                minOpen++;
                maxOpen++;
            }
            else if(c==')'){
                minOpen--;
                maxOpen--;
            }
            else{//means *-> 
                minOpen--; //if consider at as a close bracket then one open braket will pop out
                maxOpen++;//if consider this also as a open bracket then the count increases
            }
            if(minOpen<0) minOpen = 0; //openbracket minimum have to be 1 other wise it will be invalid to add a close bracket
            if(maxOpen<0) return false;
        }
        return minOpen ==0;


    }
}
