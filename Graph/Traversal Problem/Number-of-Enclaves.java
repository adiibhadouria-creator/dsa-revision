/*
 * Number of Enclaves
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Traversal Problem
 * Time complexity: O(n*m)
 * Space complexity: O(n)
 * Solved: 2026-10-09
 * URL: https://leetcode.com/problems/number-of-enclaves/submissions/2167640023/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int numEnclaves(int[][] grid) {
        //we have to return the number of land cells which are not connected to boundary
        //cannot walk off the boundary-> it should not be connected to boundary 
        //so how to differentiate boundary connecting land cells and not connecting land cells
        //traverse on boundary and if it is land then do dfs and which ever land is connected to it , mark it as * means cannot be walked
        //now only land cells which cannot be walked off boundary will remain so count them and return
        int n = grid.length , m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //check if its boundary
                if((i==0 || i==n-1 || j==0 || j==m-1)&&grid[i][j]==1){
                    dfs(grid,i,j);
                }
            }
        }
        int land = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) land++;
            }
        }
        return land;
    }
    void dfs(int[][]grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || grid[i][j]==-1){
            return;
        }
        grid[i][j]=-1;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
