/*
 * Critical Connections in a Network
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Additional Algorithms
 * Time complexity: o(v+2e)
 * Space complexity: O(v+2e + 3n)
 * Solved: 2026-10-19
 * URL: https://leetcode.com/problems/critical-connections-in-a-network/submissions/2176176438/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This is Tarjan's algorithm, in which we can find the critical nodes.

The main idea behind this is that I will traverse using DFS, and I will also know about the parent's lowest insertion time and the parent's insertion time. Whenever I am at a particular node, I see its lowest insertion time, and then I see its parent's insertion time. If this node's lowest insertion time is less than the parent's insertion time, that means I can reach this node through any other way. Otherwise, I can't reach it.

The main idea is that if I know someone who comes before you, then this edge is not a bridge. Else, this edge is a bridge.

In this code also, we just have two variables: lowest insertion time and insertion time array, and a visited array for DFS. We also have bridges for storing the critical edges and an adjacency list.

First, we create the adjacency list, then we call DFS. In DFS, we mark the current node as visited and set its lowest insertion time and insertion time to be the current timer or the current variable. Then we will go to its neighbor and skip the parent because we want to check for the parent only now: whether this edge is critical or not, and whether this edge is a bridge or not.

For everything else, we will skip the parent and then get to the unvisited neighbors. We will again call DFS for this neighbor. When this DFS call returns, we will update the lowest insertion time of this node to be the minimum of the lowest insertion time of this node and the lowest insertion time of all the neighbors.

After that, if the lowest insertion time of this neighbor is greater than the insertion time of the node, that means this is a bridge. How can I explain this? At this time, the node was inserted. If the lowest insertion time of a neighbor is greater than this, then there is no way I can reach the neighbor without this node. We have to just check whether I can get to this neighbor without using this node.

How will I check it? If I know someone before you, before you means my lowest insertion time is less than my parent's insertion time. Simple. If it is this, else I will update the lowest insertion time. 
 */

class Solution {
    int timer = 1;
    int[] lowestInsertionTime;
    int[] insertionTime;
    boolean[] visited;
    List<List<Integer>> bridges;
    List<List<Integer>> adj;
    public void findBridges(int node, int parent){
        visited[node] = true;
        lowestInsertionTime[node] = insertionTime[node] = timer;
        timer++;
        for(int neighbour:adj.get(node)){
            if(neighbour == parent) continue;
            if(!visited[neighbour]){
                findBridges(neighbour,node);
                lowestInsertionTime[node]= Math.min(lowestInsertionTime[node],lowestInsertionTime[neighbour]);
                if(lowestInsertionTime[neighbour] > insertionTime[node]){//this means it is a bridge
                bridges.add(Arrays.asList(node,neighbour));
                }
            }
            
            else{
                lowestInsertionTime[node] = Math.min( lowestInsertionTime[node],lowestInsertionTime[neighbour]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //if i know someone before you , than that means i can also reach you means it is not a bridge
        lowestInsertionTime = new int[n];
        insertionTime = new int[n];
        visited = new boolean[n];

        adj = new ArrayList<>();
        bridges = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> connection : connections){
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        findBridges(0,-1);
        return bridges;
    }
}
