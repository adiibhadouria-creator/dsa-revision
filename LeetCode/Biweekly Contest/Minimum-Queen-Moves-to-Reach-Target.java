/*
 * Minimum Queen Moves to Reach Target
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: LeetCode > Biweekly Contest
 * Time complexity: O(1)
 * Space complexity: O(1)
 * Solved: 2026-09-26
 * URL: https://leetcode.com/contest/biweekly-contest-192/problems/minimum-queen-moves-to-reach-target/submissions/2154013555/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * just observe the test cases
 */

class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        //if target is in diagonal positon then 1 move
        //else 2move
        //or source 
        if(source[0]==target[0] && source[1]==target[1]) return 0;
        else if(source[1]==target[1] || source[0]==target[0] || 
          Math.abs(target[0]-source[0])==Math.abs(target[1]-source[1]) || source[0]+source[1]==target[0]+target[1]){
            return 1;
          }
        return 2;
    }
}
