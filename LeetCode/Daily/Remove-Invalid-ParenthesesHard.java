/*
 * Remove Invalid ParenthesesHard
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: LeetCode > Daily
 * Time complexity: O(2^n*n)
 * Space complexity: O(n)
 * Solved: 2026-10-07
 * URL: https://leetcode.com/problems/remove-invalid-parentheses/submissions/2165784180/?envType=daily-question&envId=2026-10-07
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * While reading this question, only remove invalid parentheses. I thought of generating all parentheses and checking if those are valid, and then I will add them to my answer list. There was one condition also: it should be minimal removal.
What I thought I will do is find the maximum size, then iterate over the answer list. I will check which string has the highest size, and I will add it to my answer.
This can be improved in further ways:
- For validating whether it is a proper parenthesis string or not, what I did was use a `for` loop with a counter variable. If it is an open bracket, I increased the counter, and if it is a close bracket, I decreased the counter. What I can do here is, whenever I choose an open bracket, I will increase the counter, and whenever I choose a close bracket, I will decrease the counter. This will be done in the recursion call only.
- If the counter goes below 0, that means it cannot be valid further, so I will return.
- How I will handle alpha weights, because they are also alpha weights: if they are alpha weights, I will append them to my string, generate from the next index, and then delete them. I should not escape them because I cannot escape an index. Other than that, it is a proper backtracking template like pick, so I will append them to the string builder, then generate, then delete the last character, and after that, generate using it.
- The main concept of this is that, instead of two data structures, like a set and a list, I am using a set so that no duplicates are there, and a list for giving out answers. Whenever my index reaches the base case (the complete length of the string) and the count is 0, it is valid also. I will check if this current length is greater than the maximum length. If it is, it means all the strings already stored in that data structure are invalid because I got one with the maximum length, and the maximum length means minimal removal, obviously. I'll remove all the elements from the set. Now I will set `max length` to `current length`, and then I will check if `current length` and `max length` are equal. If they are, I will add this string to my set. At the end, I can return this set as an array list. This will be our approach.
 */

class Solution {
    int maxLen =0;
    public List<String> removeInvalidParentheses(String s) {
        //generate all the substring , then sort them according to their size , and keep the ones with highest size among them
        Set<String> set = new HashSet<>();
        
        generate(new StringBuilder(),s,set,0,0);
        
        return new ArrayList<>(set);
    }
    public void generate(StringBuilder sb ,String s, Set<String> set , int idx,int count){
        if(count < 0) return;
        if(idx==s.length()) {
            if(count==0){
                if(sb.length()>maxLen){
                    set.clear();
                    maxLen = sb.length();
                }
                if(sb.length()==maxLen){
                    set.add(sb.toString()); 
                }
            }
        return;
    }
        //how will you handle alphabets
        if(s.charAt(idx)!='(' && s.charAt(idx)!=')'){
            sb.append(s.charAt(idx));
            generate(sb,s,set,idx+1,count);
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        //pick
        sb.append(s.charAt(idx));
        //explore
        generate(sb,s,set,idx+1,count + (s.charAt(idx)=='(' ? 1:-1));
        //undo
        sb.deleteCharAt(sb.length()-1);
        generate(sb,s,set,idx+1,count);
    }

    //backtracking is the optioon i see here
}
