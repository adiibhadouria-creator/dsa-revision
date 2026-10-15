/*
 * Distance From The Source Bellman Ford Algorithm
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > Bellman Ford
 * Time complexity: O(ev)
 * Space complexity: O(v)
 * Solved: 2026-10-15
 * URL: https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * The thing is, Dijkstra can work for any graph which is a directed acyclic graph and does not have negative edge weights. For negative edge weights, we use the Bellman-Ford algorithm.

Now, one more thing: Dijkstra can work with negative edge weights if the path sum of cycle is greater than zero. If  sum of that path is greater than zero, then Dijkstra can also work. If the path sum is less than zero, then we have to use the Bellman-Ford algorithm.

Now, in the Bellman-Ford algorithm, we use n - 1 iterations. By n - 1 iterations, I mean that, in the worst-case scenario, from reaching the source to the destination, there will be n - 1 edges. In the best-case scenario, it can be 1 from source to destination. It can be 2, it can be 3, but at worst, it will be the number of n(no.of vertices)- 1. It will be the maximum edges that will be required in the worst-case scenario for going from source to destination. That's why we have to do n - 1 iterations.


Now, one more thing: how will we know that there is a cycle? If there is no cycle, then only till n - 1 distance array will get updated. After n - 1, nothing in the distance array should be updated. What I can do is, after I have done it n - 1 times, I will do it again in one single loop. I will check if the distance is updating, that simple check to the next edges. If it is updating, that means it is the n iteration and it is changing. This means there is a negative cycle, so I will return whatever is required by the question.

No mistake: what I was doing is I was not checking that the starting distance is infinity. If the starting distance is infinity, I will not update it. It will cause integer overflow.
 */

class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        // code here
        int inf = Integer.MAX_VALUE;
        int[] distance = new int[V];
        Arrays.fill(distance,inf);
        distance[src] = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<V-1;i++){
            for(int[] edge:edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                
                if(distance[u]!=inf && distance[u] + wt < distance[v]){
                    distance[v] = distance[u] + wt;
                }
            }
        }
        //this is for the nth iteration , if something gets updated return -1
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
                
            if(distance[u]!=inf && distance[u] + wt < distance[v]){
                distance[v] = distance[u] + wt;
                return new ArrayList<>(Arrays.asList(-1));
            }
        }
        for(int a:distance){   
            if(a==inf) ans.add((int)1e8);
            else ans.add(a);
        }
        return ans;
    }
}
