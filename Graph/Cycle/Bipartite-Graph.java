/*
 * Bipartite Graph
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > Cycle
 * Time complexity: O(v+e)
 * Space complexity: O(v)
 * Solved: 2026-10-09
 * URL: https://www.geeksforgeeks.org/problems/bipartite-graph/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * using dfs
 */

class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){adj.add(new ArrayList<>());}
        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] color = new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(check(i,0,adj,color)==false) return false;
            }
        }
        return true;
    }
    public boolean check(int V , int col ,List<List<Integer>> adj, int[]color){
        color[V] = col;
        for(int neighbour:adj.get(V)){
            if(color[neighbour]==-1){
                if(check(neighbour,1-col,adj,color)==false) return false;
            }
            else{
                if(color[neighbour]==col) return false;
            }
        }
        return true;
    }
}
