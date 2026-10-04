/*
 * Maximum Alternating Subarray Sum With One Deletion
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: LeetCode  > Weekly Contest
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Solved: 2026-10-04
 * URL: https://leetcode.com/problems/maximum-alternating-subarray-sum-with-one-deletion/submissions/2161912282/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * 4 states dp
 */

class Solution {
    public long maxAlternatingSum(int[] nums) {
        final long infinity = Long.MIN_VALUE/2;
        long plusDel = infinity;
        long minusDel = infinity;
        long plus = infinity;
        long minus = infinity;
        long ans = infinity;
        for(long x:nums){
            //Either take it or start fresh
            long p = Math.max(minus+x,x);

            //take it and cant start fresh as then it will be converted to +ve
            long m = plus-x;

            //Either delete it or go ahead with past
            long pd =Math.max(minusDel+x,plus);

            //same with reverse sign
            long md = Math.max(plusDel-x,minus);
            plus =p ; 
            minus =m ;
            plusDel = pd;
            minusDel = md;
            ans = Math.max(ans,Math.max(Math.max(plus,minus),Math.max(plusDel,minusDel)));
        }
        return ans;

    }
}
