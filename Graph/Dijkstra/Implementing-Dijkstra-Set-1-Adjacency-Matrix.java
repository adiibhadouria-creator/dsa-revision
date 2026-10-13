/*
 * Implementing Dijkstra Set 1 Adjacency Matrix
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > Dijkstra
 * Time complexity: e log V
 * Space complexity: e+v
 * Solved: 2026-10-13
 * URL: https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * A graph with negative cycles cannot use the Dijkstra algorithm. It will fall into an infinite loop because, to find the shortest path, whenever we go from one node to another node, we have to pay a cost. We have to give something, but if there is a negative weight, that means it is giving us back something, so it will fall into an infinite loop. 

The question is like this: we have also done this earlier, where we have to find a distance array of an undirected graph. Here also, I followed the same approach as I used earlier, which was with a queue, but it was getting repeated again and again. It was giving TLE before just the last three test cases, so I have to use a queue. What does a queue help with? It always gives me the edge which is nearer to me, so I can explore the nearer edge. Otherwise, everything is the same.

My mistake was that I was not implementing the algorithm properly, like not implementing the comparator. Another mistake was that I was not pruning early. If the weight is greater than some distance, it means that from this node, wherever I will go, I will get a higher weight, so stop before it. The rest is safe. 
 */

class Solution {
    static class Pair{
        int v;
        int wt;
        Pair(int v , int wt){
            this.v = v;
            this.wt = wt;
        }
    }
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // Use priority queue and store in form of pairs min heap , it will be sorted on vlause of weights
        List<List<Pair>> adj = new ArrayList<>();
                for(int i=0;i<V;i++){
                    adj.add(new ArrayList<>());
                }
                for(int []edge: edges){
                    int u = edge[0];
                    int v = edge[1];
                    int wt = edge[2];
                    adj.get(u).add(new Pair(v,wt));
                    adj.get(v).add(new Pair(u,wt));
                }
                int[] distance = new int[V];
                Arrays.fill(distance,Integer.MAX_VALUE);
                //mistake 1 not implementing comparator as pair was stored so it did not know on what basis to sort
                Queue<Pair> queue = new PriorityQueue<>((a,b)->Integer.compare(a.wt,b.wt));
    
                queue.add(new Pair(src,0));
                distance[src] = 0;
                while(!queue.isEmpty()){
                    Pair top = queue.poll();
                    int node = top.v;
                    int weight = top.wt;
                    //early pruning for avoiding tle , as if weight is greater then there is no need to explore more path from this node it will be costlier
                    if(weight > distance[node]) continue;
                    for(Pair neighbour:adj.get(node)){
                        
                        int v = neighbour.v;
                        int wtt = neighbour.wt;
                        if(wtt + weight < distance[v]){
                            distance[v] = weight + wtt;
                            queue.add(new Pair(v,distance[v]));
                        }
                    }
                }
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i:distance){
                ans.add(i);
            }
            return ans;
            
        }
        
    }
