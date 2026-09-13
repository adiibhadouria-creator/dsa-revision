/*
 * Cyclically Shift Rows and Columns
 * Difficulty: Easy
 * Topic: LeetCode > Weekly Contest 519/1
 * Time complexity: O(N^2)
 * Space complexity: O(N^2)
 * Solved: 2026-09-13
 * URL: https://leetcode.com/contest/weekly-contest-519/problems/cyclically-shift-rows-and-columns/
 *
 * Problem statement:
 * You are given an integer n, a 2D integer array grid of size n x n, and two integer arrays rowShift and colShift, each of length n where: rowShift[i] represents the number of positions to cyclically left shift the ith row of grid. colShift[j] represents the number of positions to cyclically upward shift the jth column of grid. First, cyclically shift each row according to rowShift, then cyclically shift each column according to colShift. Return the resulting grid after performing all the shifts. A cyclic left shift of the ith row by k positions shifts only that row. The element at column j moves to column (j - k + n) % n, while all other rows remain unchanged. A cyclic upward shift of the jth column by k positions shifts only that column. The element at row i moves to row (i - k + n) % n, while all other columns remain unchanged. Example 1: Input: n = 2, grid = [[1,2],[3,4]], rowShift = [1,0], colShift = [0,1] Output: [[2,4],[3,1]] Explanation: The grid changes as follows: Example 2: Input: n = 3, grid = [[1,2,3],[4,5,6],[7,8,9]], rowShift = [1,2,0], colShift = [2,2,1] Output: [[7,8,5],[2,3,9],[6,4,1]] Explanation: The grid changes as follows: Constraints: 1 <= n == grid.length == grid[i].length <= 10 1 <= grid[i][j] <= 100 rowShift.length == colShift.length == n 0 <= rowShift[i], colShift[i] < n
 *
 * Notes:
 * None
 */

class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {

        int[][] temp = new int[n][n];
        for(int i=0;i<n;i++){
            int k = rowShift[i]%n;
            for(int j=0;j<n;j++){
                temp[i][j] = grid[i][(j+k)%n];
            }
        }

        int[][]result = new int[n][n];
        for(int j=0;j<n;j++){
            int k = colShift[j];
            for(int i=0;i<n;i++){
                result[i][j] = temp[(i+k)%n][j];
            }
        }
        return result;
    }
}
2
[[1,2],[3,4]]
[1,0]
[0,1]
3
[[1,2,3],[4,5,6],[7,8,9]]
[1,2,0]
[2,2,1]
[[2,4],[3,1]]
[[7,8,5],[2,3,9],[6,4,1]]
