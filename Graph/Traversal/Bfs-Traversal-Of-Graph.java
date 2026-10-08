/*
 * Bfs Traversal Of Graph
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > Traversal
 * Time complexity: O(n + 2e) e-> total edges which twice is number of total degrees in a graph
 * Space complexity: O(3n)
 * Solved: 2026-10-08
 * URL: https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This is a simple BFS traversal in a graph. It is the same as a tree, but in a tree, we do not have something as `visited`. In a graph, our number can be a neighbor of two or more nodes, so we have to keep `visited`. Initially, we keep every number as `false`, and we add the starting node and mark it as `true`.

Now we run this loop till the queue is not empty. We'll pop out the top and check its neighbors. First, we'll add the top into traversal, then we'll check its neighbors using an adjacency list. If its neighbor is not visited, then we will add it into the queue. If it is visited, we do not do anything. We'll just check if it is not visited, then add it into the queue and move further. 
 */

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> traversal = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int size = adj.size();
        boolean[] visited = new boolean[size];
        Arrays.fill(visited,false);
        
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty()){
            int top = queue.poll();
            traversal.add(top);
            for(int i=0;i<adj.get(top).size();i++){
                int current = adj.get(top).get(i);
                if(visited[current]==false){
                    visited[current] = true;
                    queue.add(current);
                }
            }
        }
        return traversal;
    }
}
