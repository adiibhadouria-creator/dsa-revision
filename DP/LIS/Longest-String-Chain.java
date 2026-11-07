/*
 * Longest String Chain
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > LIS
 * Time complexity: O(n.L^2)
 * Space complexity: O(n)
 * Solved: 2026-11-07
 * URL: https://leetcode.com/problems/longest-string-chain/submissions/2191054137/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
        int longest =1 , n = words.length;
        Map<String,Integer> dp = new HashMap<>();
        for(String s:words){
        //generate all predecessors for this word
            int best = 1;
            for(int i=0;i<s.length();i++){
                String prev = s.substring(0,i)+s.substring(i+1);
                int v = dp.getOrDefault(prev,0)+1;
                best = Math.max(best,v);
            }
            dp.put(s,best);
            longest = Math.max(longest,best);
        }
        return longest;
        } 
    }
