/*
 * Reverse Substrings Between Each Pair of ParenthesesMed.
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: LeetCode > Daily
 * Time complexity: O(N)
 * Space complexity: O(N)
 * Solved: 2026-09-27
 * URL: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/submissions/2155382064/?envType=daily-question&envId=2026-09-27
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * wormhole teleportation technique ->
first store all the pairs of door(open and close brackets) using a staack because that only allows or u can use a map

then, again traverse into string and whenever a door comes reach to its other end , and traverse in diff direction from current thus there will be no need to reverse any string
 */

class Solution {
    public String reverseParentheses(String s) {
        //worm hole teleportation technique
        int n = s.length();
        int[] portal  = new int[n];
        Stack<Integer> st = new Stack<>();
        //first pass for checking all links 
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else if(s.charAt(i)==')'){
                int j = st.pop();
                portal[i] = j;
                portal[j] = i;
            }
        }
        StringBuilder res = new StringBuilder();
        int flag = 1;
        //second pass for teleporting if a gate comes
        for(int i=0;i<n;i+=flag){
            char c = s.charAt(i);
            if(c=='(' || c==')'){
                i = portal[i];
                flag = -flag;
            }
            else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
