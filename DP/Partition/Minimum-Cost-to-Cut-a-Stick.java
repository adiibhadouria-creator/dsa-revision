/*
 * Minimum Cost to Cut a Stick
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Partition
 * Time complexity: O(n^3)
 * Space complexity: O(n^2)
 * Solved: 2026-11-15
 * URL: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/submissions/2196637311/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int minCost(int n, int[] cuts) {
        //1. Why need sorting here? -> to solve subproblems independently
        int c = cuts.length;
        List<Integer> list =new ArrayList<>();
        for(int a:cuts){
            list.add(a);
        }
        list.add(0,0);
        list.add(list.size(),n);
        Collections.sort(list);
        int[][]dp = new int[c+2][c+2];
        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;
                else{
                    int mini = (int)1e9;
                    for(int k=i;k<=j;k++){
                        int cost =  list.get(j+1)-list.get(i-1) + dp[i][k-1]+ dp[k+1][j];
                        mini = Math.min(cost,mini);
                    }
                    dp[i][j] = mini;
                }
            }
        }
        return dp[1][c];
    }
}
