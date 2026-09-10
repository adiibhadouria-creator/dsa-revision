/*
 * Daily Temperatures
 * Difficulty: Medium
 * Topic: Stack > Monotonic
 * Time complexity: O(N)
 * Space complexity: O(1)
 * URL: https://leetcode.com/problems/daily-temperatures/submissions/2137408332/
 *
 * Problem statement:
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead. Example 1: Input: temperatures = [73,74,75,71,69,72,76,73] Output: [1,1,4,2,1,1,0,0] Example 2: Input: temperatures = [30,40,50,60] Output: [1,1,1,0] Example 3: Input: temperatures = [30,60,90] Output: [1,1,0] Constraints: 1 <= temperatures.length <= 105 30 <= temperatures[i] <= 100
 *
 * Notes: works on next greater approach
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //I will maintain a monotonic stack in which it will store next greater element but with a twist that is gap of days between them
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&& temperatures[st.peek()]<=temperatures[i] ){
                st.pop();
            }
            ans[i] = st.isEmpty() ? 0 : st.peek()-i;
            st.push(i);
        }
        return ans;
    }
}
