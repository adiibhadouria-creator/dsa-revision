/*
 * Pow(x, n)
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Basics > Maths
 * Time complexity: O(log N)
 * Space complexity: O(log N)
 * Solved: 2026-09-26
 * URL: https://leetcode.com/problems/powx-n/submissions/2153452564/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public double helper(double x, long N){
        //base case
        if(N==0) return 1;
        //check if n is odd or even
        if(N<0) return helper(1/x,-N);
        if(N%2==1) {
            return x*helper(x,N-1);
        }
        else{
            return helper(x*x,N/2);
        }
    }
    public double myPow(double x, int n) {
        return helper(x,(long)n);
    }
}
