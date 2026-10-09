/*
 * 01 Matrix
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Traversal Problem
 * Time complexity: O(n*m)
 * Space complexity: O(n*m)
 * Solved: 2026-10-09
 * URL: https://leetcode.com/problems/01-matrix/submissions/2167558244/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * -----MULTI SOURCE BFS------

This question is the same as rotten oranges, where multiple oranges are rotten, and after every second, they rot their adjacent ones (left, right, top, bottom). The same is true for this question here. We have to find the distance from 0 or 1, whichever is given in the question. We can think of 0 as rotten and 1 as fresh. How many times will each orange be rotten? This is the question.

The mistakes I made were while traversing the matrix, updating `visited`, and adding elements to the queue. I didn't attend to length constraints carefully, and then `distance` went to increment. That's also the thing: either increment it after the `for` loop, once per level, or start it from -1, because the starting elements in the queue will already have 0 distances. This is also known as multi-source BFS. 
 */

class Solution {
    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;  
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] ans = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    queue.add(new Pair(i,j));
                    visited[i][j]=true;
                }
            }
        }
        int dis = 0;
        int[] delrow = {-1,0,+1,0};
        int[] delcol = {0,+1,0,-1};
        while(!queue.isEmpty()){
            int k = queue.size();
            for(int l=0;l<k;l++){
                Pair top = queue.poll();
                int row = top.row;
                int col = top.col;
                ans[row][col] = dis;
                for(int j=0;j<4;j++){
                    int nrow = row + delrow[j];
                    int ncol = col + delcol[j];
                    if(nrow<0 || nrow>=n || ncol<0 || ncol>=m || mat[nrow][ncol]==0 || visited[nrow][ncol]==true) continue;
                    else{
                        visited[nrow][ncol] = true;
                        queue.add(new Pair(nrow,ncol));
                    }
                }
            }
            dis++;
        }
        return ans;
    }
}
