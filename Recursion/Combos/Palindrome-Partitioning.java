/*
 * Palindrome Partitioning
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Recursion > Combos
 * Time complexity: O(2^n * n)
 * Space complexity: O(n)
 * Solved: 2026-09-28
 * URL: https://leetcode.com/problems/palindrome-partitioning/submissions/2156459430/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * just focus on what you are passing to for loop
 */

class Solution {
    void helper(int start , String s,  List<String> list,List<List<String>> ans){
        if(start == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(start,i,s)){
                
                list.add(s.substring(start,i+1));
                helper(i+1,s,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        helper(0,s, list,ans);
        return ans;
    }
    public boolean isPalindrome(int start,int end , String s){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
