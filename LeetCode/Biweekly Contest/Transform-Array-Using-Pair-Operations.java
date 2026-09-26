/*
 * Transform Array Using Pair Operations
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: LeetCode > Biweekly Contest
 * Time complexity: O(N)
 * Space complexity: O(1)
 * Solved: 2026-09-26
 * URL: https://leetcode.com/contest/biweekly-contest-192/problems/transform-array-using-pair-operations/submissions/2154038486/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Look at what one operation does to the two chosen numbers:

before: source[i] + source[j]
after: (source[i] + source[j] - delta) + delta = source[i] + source[j]
Their sum never changes. The other numbers are not touched, so the total sum of the array never changes.

So if sum(source) != sum(target), the answer is false.
 */

class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0;i<source.length;i++){
            sum1+=source[i];
            sum2+=target[i];
        }
        return sum1==sum2;
    }
}
