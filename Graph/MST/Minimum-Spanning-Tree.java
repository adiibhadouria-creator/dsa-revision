/*
 * Minimum Spanning Tree
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > MST
 * Time complexity: O(e log v)
 * Space complexity: o(e)
 * Solved: 2026-10-16
 * URL: https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * greedy approach of always choosing closest path
 */

class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        //1. create adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.weight,b.weight));
        int sum = 0;
        
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int v = top.node;
            int wt = top.weight;
            
            if(visited.contains(v)) continue;
            visited.add(v);
            sum += wt;
            for(Pair p:adj.get(v)){
                int u = p.node;
                int weight = p.weight;
                if(!visited.contains(u)){
                    pq.add(new Pair(u,weight));
                }
            }
        }
        return sum;
    }
}
