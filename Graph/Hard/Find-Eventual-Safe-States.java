/*
 * Find Eventual Safe States
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Hard
 * Time complexity: O(v+e)
 * Space complexity: O(v)
 * Solved: 2026-10-11
 * URL: https://leetcode.com/problems/find-eventual-safe-states/submissions/2169196547/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Main discovery of this was if a node is in cycle or if a node connects to a cycle then I can definitely say it is unsafe.
So this is basic check of Cycle directed graph here we got a graph and we have to find the safe states ,safe states are those nodes those are directly going to terminal. There's no cycling environment so the main problem what I was having in is check method like if I send a node and I say check this first I will mark as visited and then I will mark this as visited. Also, then I will run a loop to check for its neighs. One of its neigh is not visited then I will check if there are Cycle for its neigh if neigh is in Cycle means I am also in Cycle so I will mark myself as unsafe and turn to my path. My neigh is already in my path that means I am already in a cycle so I mark my surface unsafe and if not the both conditions that means I am safe so I will mark myself less safe and I will remove myself from path as I am returning back from the discussion and I will false and then I will loop in (Ansh) and whichever is false means it is safe so I will add into my answer. Time in space complexity is same as DFS.

 */

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //create adjacency list
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        boolean[] unsafe = new boolean[n];     
        for(int i=0;i<n;i++){
            if(!visited[i]) check(graph,i,visited,path,unsafe);
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(unsafe[i]==false) safeNodes.add(i);
        }
        return safeNodes;
    }
    private boolean check(int[][]graph,int V,boolean[]visited,boolean[]path,boolean[]unsafe){
        visited[V] = true;
        path[V] = true;
        //now run a loop and check for neighbours
        for(int neighbour:graph[V]){
            if(!visited[neighbour]){//means neighbour is not visited now check for cycle
            //is there is a cycle or this reach to cycle mark it as unsafe and return true 
                if(check(graph,neighbour,visited,path,unsafe)){
                    unsafe[V] = true;
                    return true;
                } 
            }//if it is visited and also in path means there is a cycle so mark it true
            else if(path[neighbour]){
                    unsafe[V] = true;
                    return true;
                } 
            }
            //if not the above remove from path
            //mark it as safe
            //return false
        path[V] = false;
        unsafe[V] = false;
        return false;
    }
}
