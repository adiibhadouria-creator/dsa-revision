/*
 * Number of Islands
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: Graph > Traversal Problem
 * Time complexity: O(n * m)
 * Space complexity: O(n * m)
 * Solved: 2026-10-08
 * URL: https://leetcode.com/problems/number-of-islands/submissions/2166391292/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This problem can either be solved by DFS or BFS. The first thing is: how can you observe that this is a graph problem? It is a simple matrix, but if we can carefully see the problem, it shows that whenever we are at one land, all of that land will also be affected. That means we have to search from that node. That gives us an idea of any traversal using BFS or DFS.

BFS will be complex using a queue data structure, but it can also be solved. We will use a queue data structure and write all the neighbors. In the GFG version, neighbors can be in eight directions, but in LeetCode, there are only four directions, so the neighbors will be the simple four directions. We will mark the neighbors as visited and then move forward. Anytime we are doing BFS, the count of islands increases. 
 */

class Solution {
    public int numIslands(char[][] grid) {
        int islands =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    void dfs(int row,int col,char[][]grid){
        if(row<0 || col<0 || row>=grid.length||col>=grid[0].length||grid[row][col]=='0') return;

        grid[row][col] = '0';
        dfs(row+1,col,grid);
        dfs(row-1,col,grid);
        dfs(row,col+1,grid);
        dfs(row,col-1,grid);
        return;
    }
}
