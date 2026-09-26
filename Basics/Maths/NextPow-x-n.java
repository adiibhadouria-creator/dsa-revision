/*
 * NextPow(x, n)
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Basics > Maths
 * Time complexity: O(log N)
 * Space complexity: O(log N)
 * Solved: 2026-09-26
 * URL: https://leetcode.com/problems/powx-n/submissions/2153455466/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * just remember of conversion of int to long as int can not have max value = - min value so convert it into long and why it can have because 31st bit is used for sign flag and if that number is positive that bit will be 0 thus a number less will be there
 */

class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        long power =n;
        if(power<0){
            power = -power;
            x = 1/x;
        }
        double ans =1;
        while(power>0){
            if((power&1)==1) ans *= x;
            x *= x;
            power >>= 1;
        }
        return ans;
    }
}
