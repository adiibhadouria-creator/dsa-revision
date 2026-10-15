/*
 * Floyd Warshall Algorithm
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > Dijkstra
 * Time complexity: O(n^3)
 * Space complexity: O(n^2)
 * Solved: 2026-10-15
 * URL: https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This is the Floyd Warshall algorithm. Now, why is it used? Why, over Dijkstra, will we use it?  
  
The first thing is, here we want the distance from multiple sources to multiple destinations. I want the shortest distance from any sources to any destination. We can do that using Dijkstra, but if there are negative cycles, not negative edges, then Floyd Warshall can handle it, but Dijkstra cannot. Dijkstra will fall into an infinite loop, but Floyd Warshall will also help in detecting negative weight cycles.  
  
What is the brute force idea of this? Assume there were  negative cycles, and you have to find the distance from every source to every destination in a graph. You can do Dijkstra for every vertex. The time complexity for Dijkstra is E log V, and if we are doing it for every vertex, it will be : V × E log V.  
  
If there are negative weight cycles, then Floyd Warshall will help. What Floyd Warshall does is it checks for every route. It will check for via0, via1, via2, via3, and it will keep updating. This is the basic brute force idea: I will check every path, and I will get the shortest eventually.  
  
Now, how will I detect that here cycles are negative? What I will do is, if at any time  a cycle is negative, the source will get less than zero. I know the distance from any vertex to itself will always be zero. Even for any node, 0 to 0 will be zero, 1 to 1 will be zero, and 2 to 2 will be zero. If there's a negative cycle, then what will happen is any of the sources can go beyond zero because of the negative sum. If any of the source nodes, if any of the 00, 11 diagonal nodes, goes beyond zero, less than zero, that means there is a negative cycle. This is the detection for a cycle.  so we cannot give shortest path
  
Else, I will also check if my via, matlab, from this path I am going to, is not infinity, and the node I am going to is not infinity. Then I will update whichever is the minimum: whether the earlier cost was minimum or the current cost via this path is minimum.
 */

class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        //can i use dijkstra here 
        // directed -> no negative weight cycle -> shortest distance -> dijkstra
        int n = dist.length;
        for(int via = 0; via < n; via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j && dist[i][j]<0){
                        System.out.println("Negative cycle found");
                    }
                    if(dist[i][via]!=1e8 && dist[via][j]!=1e8){
                    dist[i][j] = Math.min(dist[i][j],
                                    dist[i][via]+dist[via][j]);
                    }
                }
            }
        }
    }
}
