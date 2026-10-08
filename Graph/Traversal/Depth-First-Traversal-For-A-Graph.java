/*
 * Depth First Traversal For A Graph
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > Traversal
 * Time complexity: O(n + 2e)
 * Space complexity: O(3n)
 * Solved: 2026-10-08
 * URL: https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This is a simple DFS traversal. We do it in trees, but here it is different, as we keep a `visited` array and call it from the start node.
What happens in that recursion function is:
1. We mark that visited node as true, meaning in the `visited` array we mark that vertex as true.
2. We add it to the traversal.
3. We go to all its neighbors. If it is not visited, we call DFS of the graph from there. If it is visited, we do not care about it.
Now, for the time complexity, it will be going for `n` nodes plus how many neighbors there are. There are `n` neighbors, and there are `2e` edges, as we have discovered before. This is the time complexity.
The space complexity is:
- n for traversal
- n for `visited`
- `O(n)` for the question stack space, because what if it is a skewed graph? Then it will go to `O(n)`. Time complexity is `O(3n)`, and space complexity is `O(3n)`. Time complexity is `O(n + 2e)`.
 */

class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> traversal = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()+1];
        
        dfsOfGraph(0,adj,visited,traversal);
        return traversal;
    }
    public void dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj,boolean[]visited,ArrayList<Integer> traversal){
        visited[V] = true;
        traversal.add(V);
        for(int i=0;i<adj.get(V).size();i++){
            int neighbour = adj.get(V).get(i);
            if(visited[neighbour]==false){
                dfsOfGraph(neighbour,adj,visited,traversal);
            }
        }
        
    }
}
