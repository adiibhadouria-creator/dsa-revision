/*
 * Path With Minimum Effort
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Dijkstra
 * Time complexity: O(nm log nm)
 * Space complexity: O(nm)
 * Solved: 2026-10-14
 * URL: https://leetcode.com/problems/path-with-minimum-effort/submissions/2172448607/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * My first approach was that I would start from the destination cell, which is the rightmost bottom, and go till the source cell greedily. Whichever is nearer, I would choose that value, but it is not optimal. Greedily, I can choose a closer one now, but after that node, it can give me around 100 effort, which is not optimal. That is not the choice here.
Now, what I can do: here we have source and destination, and we have to find the shortest or minimum effort. I can think of something like Dijkstra's algorithm. Whenever a situation comes like this, we think of Dijkstra's algorithm.
What I will store in the priority queue is the difference. Rather than storing the value and then the previous value to find the difference, I can just store the difference. Every time, I will store the difference.
Now, how will the algorithm look?
1. I will declare the class, which will have effort, row, and column.
2. I will store or sort the nodes on the basis of difference. The least difference is on top.
3. I will add the source node (0, 0) with difference 0 in the queue.
4. I will run this loop till the queue is not empty.
5. I will also use a visited array, you can say, or a distance array where I will store the nearest distance of it from the source.
6. I will add the source into the queue.
7. I will run this loop till the queue is not empty.
8. I will pop out the topmost node.
9. I will get the effort, get the row, and get the column.
10. I will check: if this row and column are my destination, then I will return the effort.
Now, one more thing: what people can do or think is that whenever we are inserting, we cannot decide that it is the one with the minimum effort. I can find someone better, so I have to wait. While popping out, I will get the min because it is min. Here, it is 2. I know after 2, I will get 2 or more, but not less than 2, because this is many.
I will run a loop and check in all four directions. If any of the directions is invalid, I will continue. Then I will check the difference between whatever is stored in the distance matrix and whatever effort is required in going from the previous index to the current new index. If it is smaller, then I will change it. Now I will mark the new distance as either the earlier effort, if it is greater, or the current distance, which I stored in the matrix, if it is greater.
Suppose one time the effort is 2, and next time I travel, my effort is 1. I cannot do `mat.min` because, at the start, I got the effort 2, and the effort is the max of all the nodes. It will always be 2. I will store `my.max`, and I will get the difference: either the earlier effort is maximum, or the difference which I got now while going to this new direction is maximum. Whichever is maximum, I will store it in the `d` variable. Then I will add a new pair in the queue where I will store this `d` variable, which is the new max effort, new row, and new column.

The time complexity of Dijkstra's algorithm is O(E log V). E stands for H, and V stands for vertices.

Now, how many vertices are there? n * m vertices. How many edges are there? (n * m) × 4. Every vertex has 4 directional edges, so I can say it is O(4nm log nm).

For space complexity, I am using something like a visited array and also a queue, so my at-most space complexity will be O(nm). 
 */

class Solution {
    class Pair{
        int effort;
        int row;
        int col;
        Pair(int effort,int row,int col){
            this.effort = effort;
            this.row = row;
            this.col = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length , m = heights[0].length;
        int [] delrow = {0,-1,0,1};
        int [] delcol = {-1,0,1,0};
        int[][] mat = new int[n][m];
        for(int[] row:mat){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        mat[0][0] = 0;
        Queue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.effort,b.effort));
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int effort = top.effort;
            int r = top.row;
            int c = top.col;
            if(r==n-1 && c==m-1) return effort;
            for(int i=0;i<4;i++){
                int nr = r + delrow[i];
                int nc = c + delcol[i];
                if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
                if(mat[nr][nc] > Math.abs(heights[r][c]-heights[nr][nc])){
                    mat[nr][nc] = Math.abs(heights[r][c]-heights[nr][nc]);
                    int d = Math.max(effort,mat[nr][nc]);
                    pq.add(new Pair(d,nr,nc));
                }
            }
        }
        return 0;
    }
}
