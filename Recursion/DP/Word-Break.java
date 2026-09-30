/*
 * Word Break
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Recursion > DP
 * Time complexity: O(2^n)
 * Space complexity: O(n)
 * Solved: 2026-09-30
 * URL: https://leetcode.com/problems/word-break/submissions/2157635866/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    boolean check(String s,Set<String> dict , int idx,Boolean[]memo){
        if(idx==s.length()) return true;
        if(memo[idx]!=null){
            return memo[idx];
        }

        for(int len=idx;len<s.length();len++){
            String temp = s.substring(idx,len+1);
            if(dict.contains(temp)){
                //move index to check next word or chunk
                
                if(check(s,dict,len+1,memo)) {
                    memo[idx]=true;
                    return true;
                }
            }
        }
        memo[idx]=false;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        Set<String> dict = new HashSet<>(wordDict);
        return check(s,dict,0,memo);
    }
}
