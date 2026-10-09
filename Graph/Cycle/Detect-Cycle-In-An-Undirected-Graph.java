/*
 * Detect Cycle In An Undirected Graph
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > Cycle
 * Time complexity: O(n+2e)
 * Space complexity: O(2n)
 * Solved: 2026-10-09
 * URL: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * if a node is already visited and its not the neighbour means it already came in path so return true
 */

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean [] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i] && dfs(i,-1,adj,visited)) return true;
        }
        return false;
    }
    public boolean dfs(int node,int parent , List<List<Integer>> adj,boolean[] visited){
        visited[node]=true;
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour,node,adj,visited)==true) return true;
            }
            else{
                if(parent!=neighbour) return true;
            }
        }
        return false;
    }
}
