/*
 * Shortest Path in Binary Matrix
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Dijkstra
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 * Solved: 2026-10-13
 * URL: https://leetcode.com/problems/shortest-path-in-binary-matrix/submissions/2171645898/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[n-1][n-1]==1 || grid[0][0]==1) return -1;
        int []delrow = {-1,-1,-1,0,0,1,1,1};
        int []delcol = {-1,0,1,-1,1,-1,0,1};
        //do level order traversal and in which ever level you reach n-1 n-1 that is the answer
        //or do level order traversal by creating adjacency list
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0));
        int length = 1;
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int m = queue.size();
            
            for(int i=0;i<m;i++){
                Pair top = queue.poll();
                int r = top.row;
                int c = top.col;
                if(r==n-1 && c ==n-1) return length;
                for(int k=0;k<8;k++){
                    int nr = r + delrow[k];
                    int nc = c + delcol[k];
                    if(nr<0 || nc<0 || nr>=n || nc>=n || grid[nr][nc]==1 || visited[nr][nc]==true) continue;
                    else{
                        queue.add(new Pair(nr,nc));
                        visited[nr][nc] = true;
                    } 
                }
            }
            length++;
        }
        return -1;
    }
}
