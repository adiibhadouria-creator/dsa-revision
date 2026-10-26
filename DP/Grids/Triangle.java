/*
 * Triangle
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Grids
 * Time complexity: O(n x n)
 * Space complexity: O(n)
 * Solved: 2026-10-26
 * URL: https://leetcode.com/problems/triangle/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * A few things I learned today are:
- If I ever see these notes, they can be fixed starting points from start to end. Rather, they can be a variable starting point and a variable ending point. If they are both fixed starting and ending, then we have to call only one recurrence: start to end or end to start. I can choose either of them.
- If I have multiple starts and a single end, then I will call the question from end.
- If I have a single start and multiple ends, like in this question, I have a single start at 0 through. I have only one value, and it will be my start. All the numbers, all the values in the last row, are my base case and my end. It is a variable endpoint. I can end at any point, so I will choose this as my base case. What if the row number is n - 1? I will return it. I will not choose 0 as my base case. Then I have to call recurrence from every value in the last row, which will be a loop. That's why I have to call recurrence from the fixed starting point.
Just remember this. My implementation was much more difficult to understand, not cleaner. This is very clean. I was just impressed by this. Why couldn't I think of this? Now I know: we should start. Adiketen swama, fix a starting point. If there are both variable starting and ending points, then start from anywhere. We do not care.
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] next = new int[n];
        for(int col=0;col<n;col++){
            next[col] = triangle.get(n-1).get(col);
        }
        //i have already filled last row cause it was base case and I am doing opposite of recursion here
        for(int i=n-2;i>=0;i--){
            int[] curr = new int[n];
            for(int j=i;j>=0;j--){
                int x = triangle.get(i).get(j);
                int down = x + next[j];
                int diag = x + next[j+1];
                curr[j] = Math.min(down,diag);
            }
            next = curr;
        }
        return next[0];
    }
}
