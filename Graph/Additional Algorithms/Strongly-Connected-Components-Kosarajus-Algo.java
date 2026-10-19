/*
 * Strongly Connected Components Kosarajus Algo
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > Additional Algorithms
 * Time complexity: O(v+e)
 * Space complexity: O(v+e)
 * Solved: 2026-10-19
 * URL: https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This is Kosaraju's algorithm, which is used for counting the number of strongly connected components or printing the strongly connected components in one pass.
Strongly connected components are those components. Suppose there's an edge 1 to 2, so you can go from 1 to 2 and from 2 to 2. Not using undirected edges, if there is a cycle, whatever elements are in a cycle are strongly connected components. We find it using Kosaraju's algorithm.
What we do is:
1. Sort all the edges according to finish time. Finish time is whichever gets finished first will get to the bottom of the stack. How will we do this? We will use a DFS traversal, and whenever the DFS is over, it will be over when there is no neighbor. That will be the last node, so we will store that node in our stack. Then we will backtrack. Simple backtrack: just `stack.push(node)` at last.
2. We will reverse the graph. How can we reverse the graph? We will create a new edge list of, say, `reverse` name, and we will traverse in the adjacent list and get the neighbor and node. What we will do is, initially, `node` points to `neighbor`. We will do `neighbor` points to `node`. This is how we will reverse the graph.
3. We will do a DFS again. Now, how many times are we doing DFS? Those will be our strongly connected components. Why? Because even if there is a cycle, even if I reverse all the edges, I can go from any node in that cycle to any other node, even after reversing the edges. Those are isolated, which cannot be reached after reversing. That will be my other strongly connected component. That's why we used to reverse the edge. It was to reverse all the edges, and then only the strongly connected ones will still be connected, with the other side unreachable. That's why we reverse the graph.
 */

class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj,boolean [] visited, Stack<Integer> st){
            visited[node] = true;
            for(int neighbour:adj.get(node)){
                if(!visited[neighbour]){
                    dfs(neighbour,adj,visited,st);
                }
            }
            st.push(node);
        }
        public void dfsR(int node, ArrayList<ArrayList<Integer>> reversed,boolean[] visitedR ){
            visitedR[node] = true;
            for(int neighbour:reversed.get(node)){
                if(!visitedR[neighbour]){
                    dfsR(neighbour,reversed,visitedR);
                }
            }
        }
    public int countSCC(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,adj,visited,st);
            }
        }

        ArrayList<ArrayList<Integer>> reversed = new ArrayList<>();
        for(int i=0;i<V;i++){
            reversed.add(new ArrayList<>());
        }

        boolean[] visitedR = new boolean[V];
        for(int i=0;i<V;i++){
            for(int neighbour:adj.get(i)){
                reversed.get(neighbour).add(i);
            }
        }

        int cnt = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(!visitedR[node]){
                cnt++;
                dfsR(node,reversed,visitedR);
            }
        }
        return cnt;
    }
}
