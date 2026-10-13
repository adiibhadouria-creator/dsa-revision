/*
 * Shortest Path In Undirected Graph Having Unit Distance
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > Hard
 * Time complexity: O(v+e)
 * Space complexity: O(v+e)
 * Solved: 2026-10-13
 * URL: https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This is the question of finding the shortest path between source and destination. As given, every edge has a unit weight of 1. There is no variable weight, so I can do a BFS here.

Keep one thing always in mind: whenever we need to find the shortest path or least time, use BFS, and whenever we want to flood fill the algorithm of Completed, we use DFS. Here we will use BFS.

Now why BFS? At one level, it will go to the nodes which have a distance of 1. At two levels, it will go to the nodes of distance 2. Whenever I reach any place, wherever I find my destination, I will also have my level. That level will be my distance: how far it is from the source.

Just explain BFS and time and space complexity. Time complexity: every vertex is processed once and every edge is processed twice. 
 */

class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        //we use queue , adjacency list , visited[] array
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        queue.add(src);
        visited[src] = true;
        int distance = 0;
        boolean found = false;
        while(!queue.isEmpty()){
            
            int n = queue.size();
            for(int i=0;i<n;i++){
                int node = queue.poll();
                if(node==dest) {
                    return distance;
                }
                for(int neighbour:adj.get(node)){
                    if(!visited[neighbour]){
                        queue.add(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }
            distance++;
            //if(queue.isEmpty() && found==false) return -1;
            
        }
    return -1;
    }
}
