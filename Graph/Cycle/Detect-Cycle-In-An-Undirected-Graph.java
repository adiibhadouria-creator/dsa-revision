/*
 * Detect Cycle In An Undirected Graph
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > Cycle
 * Time complexity: O(n+2e)
 * Space complexity: O(n)
 * Solved: 2026-10-09
 * URL: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Key insight: If you visit a vertex that's already visited AND it's not your parent → cycle!
 */

class Solution {
    boolean detect(int start,List<List<Integer>> adj,boolean[]visited){
       
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start,-1});
        visited[start]=true;
        while(!queue.isEmpty()){
           int[] curr = queue.poll();
            int node = curr[0];
            int parent = curr[1];
            //visit all neighbours using edges list
          
            for(int neighbour:adj.get(node)){
                
                    if(!visited[neighbour]){
                        visited[neighbour]=true;
                        queue.add(new int[]{neighbour,node});
                    }
                    else if(parent!=neighbour) {
                        return true;
                    }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i] && detect(i,adj,visited)){
                return true;
            } 
        }
        return false;
    }
}
