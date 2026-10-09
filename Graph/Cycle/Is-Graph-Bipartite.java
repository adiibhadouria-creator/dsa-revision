/*
 * Is Graph Bipartite?
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Cycle
 * Time complexity: O(v+e)
 * Space complexity: O(v)
 * Solved: 2026-10-09
 * URL: https://leetcode.com/problems/is-graph-bipartite/submissions/2167710872/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This is a basic graph coloring problem, a bipartite graph. Here, we have to check whether we can color this graph using only two colors such that no two adjacent nodes have the same color.

How can I do this? I can do this using BFS. I will keep checking adjacent nodes. I have to go level by level, and if any adjacent node has the same color, I will return false.

The mistake in this code that I was making is that, before checking all the components, if any component was returning true, I was returning false, which is not likely. If any of them returns false, I have to return false at the end of the template. None of them return false as true. Keep this in mind.

Other than that, I put it all in one go, which is also nice. The time and space complexity is O(V + E). V is the number of vertices, which is visited once. Each edge is checked at most twice in an undirected graph, so O(E). The space complexity using a color array is O(V), and Q is also O(Q). 
 */

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(check(i,graph,color)==false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(int V,int[][]graph,int[]color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        color[V] = 0;
        while(!queue.isEmpty()){
            int top = queue.poll();
            int currColor = color[top];
            for(int i=0;i<graph[top].length;i++){
                int neighbour = graph[top][i];
                if(color[neighbour]==-1){
                    color[neighbour] = 1-currColor;
                    queue.add(neighbour);
                }
                else{
                    if(currColor==color[neighbour]) return false;
                }
            }
        }
        return true;
    }
}
