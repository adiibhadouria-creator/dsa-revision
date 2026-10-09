/*
 * Rotting Oranges
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Traversal Problems
 * Time complexity: O(n*m)
 * Space complexity: O(n*m)
 * Solved: 2026-10-09
 * URL: https://leetcode.com/problems/rotting-oranges/submissions/2167171137/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * How will we first figure out that it will be solved by BFS? In the question, it is given that at every time unit, it will affect only its neighbors, then its neighbors, then its neighbors. I can think of it as: when there is a difference of 1, it means a neighbor, and that level will be affected. After that, those neighbors will be affected.
Here I can get the idea of level order traversal or BFS. Why not DFS? Because DFS will go in depth, whereas BFS goes breadthwise. Whenever we want to find the minimal time, we use BFS, and whenever we want to do flood fill, we use DFS.
Now, how will this question be solved? This could be solved using a visited array or by modifying the input array, depending on the situation. It could also be solved by creating a new static class `orange` or without it. You remember, whenever we run the queue loop while the queue is not empty, we take its size and run a `for` loop for it. What we do is, whenever we run a `for` loop, it means it is a new level, and we will increase the time. That is one idea.
Another idea is that we can also have a `time` variable with it, and whenever we pop a time and we are inserting its next children, we will do `+1`. This is a little bit complex. I hope you will refer to that code where, for a `for` loop while the queue is not empty, we take the size, and then we do `timer++`. Then we run the `for` loop from 0 to `n`, where `n` is the queue size.
A few more conditions are:
- If it is out of bounds, then we will return or continue.
- If it is already rotten, we will continue.
- If it is an empty cell (0), we will continue.
- Otherwise, we will mark it as rotten and add it to the queue.
This will be the whole approach. At the end, we will also have a fresh counter, and we will keep decrementing it every time we add a fruit to the queue. If the fresh counter at the end reaches 0, then we will return the time. If it doesn't reach 0, it means all oranges are not rotten, so we will return -1.
 */

class Solution {
    static class Orange{
        int row;
        int col;
        int time;
        Orange(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Orange> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) {
                    vis[i][j]=1;
                    fresh++;
                }
                else if(grid[i][j]==2){
                    vis[i][j]=2;
                    queue.add(new Orange(i,j,0));
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int[] delrow = {0,-1,1,0};
        int[] delcol = {-1,0,0,1};
        int time = 0;
        while(!queue.isEmpty()){
            Orange top = queue.poll();
            int r = top.row;
            int c = top.col;
            int t = top.time;
            time = Math.max(t,time);
            //find its neighbours and do business
            for(int i=0;i<4;i++){
                    int nrow = r+delrow[i];
                    int ncol = c+delcol[i];
                    if(nrow<0||ncol<0 || nrow>=grid.length||ncol>=grid[0].length||vis[nrow][ncol]==0||vis[nrow][ncol]==2) continue;
                    else{
                        if(grid[nrow][ncol]==1){//means it is fresh-> make it rotten add into queue and decrease fresh count
                            vis[nrow][ncol]=2;
                            queue.add(new Orange(nrow,ncol,t+1));
                            fresh--;
                        }
                    }
                }
            }
        if(fresh!=0) return -1;
        return time;
    }
}

--SImpler code
    class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[]{i, j});
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            time++;

            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();

                for (int d = 0; d < 4; d++) {
                    int r = curr[0] + dr[d];
                    int c = curr[1] + dc[d];

                    if (r >= 0 && r < n && c >= 0 && c < m
                        && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        fresh--;
                        q.add(new int[]{r, c});
                    }
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}
