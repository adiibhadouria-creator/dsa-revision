/*
 * Swim in Rising Water
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Dijkstra
 * Time complexity: O(e log v)
 * Space complexity: O(v+e)
 * Solved: 2026-10-15
 * URL: https://leetcode.com/problems/swim-in-rising-water/submissions/2173410212/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * My general approach was: I first thought of something like a priority queue and Dijkstra, but I didn't understand that. In traditional Dijkstra, we add the node distance till now, we add the edge weight, and we compare it with the next node distance. Here, we do not want to update the distance on the basis of whether it is shorter or larger. We want to check the time, which is the minimum time.

Instead of comparing the addition of distance and edge weight, we will compare the current time, which you may also consider the edge weight, and we will consider the previous current reaching time. Out of this, we take the maximum. In a path, whatever is the maximum value is my max time. I want to get the minimum of this time in all the paths. I hope you understood the question. If you see it again, you will get to know.

I will compare whichever is greater: this time, which I got from this, or the time I have already written in my answer. Whichever is greater will be my new time. I will get the new time, add it to my answer value, and attend to my queue.

Now, once again, if you didn't understand this time concept, in traditional Dijkstra, we use the addition of edge weight and distance to that node and compare it with the distance of the neighbor node. Here, we do not want to compare distance or addition. We want to compare which has the max time. What we will do is compare the time of this and the time of the enabled node. Whichever is greater, I will consider as the new time, assign it, and add it back into the queue. 
 */

class Solution {
    class Tuple{
        int time;
        int row;
        int col;
        Tuple(int time,int row,int col){
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }
    public int swimInWater(int[][] grid) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int n = grid.length;
        int[][] mat = new int[n][n];
        for(int[] row: mat){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        mat[0][0] = grid[0][0];
        Queue<Tuple> pq = new PriorityQueue<>((a,b)->Integer.compare(a.time,b.time));
        pq.add(new Tuple(mat[0][0],0,0));
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int time = t.time;
            int r = t.row;
            int c = t.col;
            if(r==n-1 && c==n-1) return time;
            if(time > mat[r][c]) continue;

            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr<0 || nc<0 || nr>=n || nc>=n) continue;
                int newTime = Math.max(time,grid[nr][nc]);
                if(newTime < mat[nr][nc]){
                    mat[nr][nc] = newTime;
                    pq.add(new Tuple(newTime,nr,nc));
                }
            }
        }
        return -1;
    }
}
