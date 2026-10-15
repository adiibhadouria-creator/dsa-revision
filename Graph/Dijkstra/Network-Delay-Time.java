/*
 * Network Delay Time
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Dijkstra
 * Time complexity: O(e log v)
 * Space complexity: O(2e+v)
 * Solved: 2026-10-15
 * URL: https://leetcode.com/problems/network-delay-time/submissions/2173381544/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * simple dijkstra just dont think if w at max can be 100 thenfill time with 101, the sum can still go more than 100 but it can t go int max so fill it with int max
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
    public int networkDelayTime(int[][] times, int n, int k) {
        //if i do bfs and at which level all the nodes are visited that will be my answer
        //dijkstra and iterate in distance array and if there is inf then return -1 else return max value of distance
        int inf = Integer.MAX_VALUE;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];
            adj.get(u).add(new Pair(v,t));
        }
        int[] time = new int[n+1];
        Arrays.fill(time,inf);
        time[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.weight,b.weight));
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int src = top.node;
            int timeTaken = top.weight;
            if(timeTaken > time[src]) continue;
            for(Pair neighbour:adj.get(src)){
                int dest = neighbour.node;
                int timeNeeded = neighbour.weight; 

                if(timeNeeded + timeTaken < time[dest]){
                    time[dest] = timeNeeded + timeTaken;
                    pq.add(new Pair(dest,time[dest]));
                }
            }
        }
        
        int max = 0;
        for(int i=1;i<=n;i++){
            //System.out.print(time[i]+" ");
            max = Math.max(max,time[i]);
        }
        return max == inf ? -1 : max;
    }
}
