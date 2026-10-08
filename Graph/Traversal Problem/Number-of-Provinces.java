/*
 * Number of Provinces
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Traversal Problem
 * Time complexity: O(n+v+2e) 
 * Space complexity: O(n)
 * Solved: 2026-10-08
 * URL: https://leetcode.com/problems/number-of-provinces/submissions/2166278948/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 *  If you can come to that node again, that means it is a single province, so we have to count the number of provinces.

Striver helped in converting this matrix into an adjacency list, which I learned how to convert. Otherwise, it could also be solved without converting it into an adjacency list. What we did was a traversal, which may be DFS or BFS.

The main point of this problem is the main approach: we will run a loop from 0 to the number of vertices. Whenever we have not visited that vertex, we will increase our province count and do a traversal. While doing the traversal, all of its neighbors will be marked. What will be left are those that are not neighbors, meaning they are new provinces.

This loop will always check: if it is marked, I will not do anything. If it is not marked, this is a new province, so I will increase the province count and again traverse from this city. 
 */

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        //now convert this into adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int provinces =0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                traverse(i,adj,visited);
                provinces++;
            } 
        }
        return provinces;
    }
    void traverse(int V,List<List<Integer>> adj , boolean[]visited){
        visited[V] = true;
        for(int i=0;i<adj.get(V).size();i++){
            int neighbour = adj.get(V).get(i);
            if(!visited[neighbour]) traverse(neighbour,adj,visited);
    }
}
}
