/*
 * Number of Ways to Arrive at Destination
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Dijkstra
 * Time complexity: O(v+e (log v))
 * Space complexity: O(v+e)
 * Solved: 2026-10-15
 * URL: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/submissions/2172586859/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Half of the approach is written in the solution itself. My first intuition was to do DFS and all, but then level-order traversal. Both approaches will not give us any result. We will use Dijkstra, but with the count of ways.

Now think of one thing: you can reach from city A to B in two ways. Are there only two ways to reach city B? No, right? If you can reach city A in three ways, then what are the ways you can reach city B? From any number of cities, you can reach A in three ways, and this way to city B is five. That's the concept we are using here.

We are using a distance city for getting the shorter distance. If we get the shorter distance, we want the shorter distance. If it is shorter, then I will update my shorter distance. Also, this is the new way, which is shorter, so I will update this as the path it is coming from. If it is equal, then I will add the ways of the previous city, do the modulus, and take the time as long. This was the mistake I was making. 
 */

class Solution {
    static class Journey{
        int city;
        long time;
        Journey(int city,long time){
            this.city = city;
            this.time = time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
       /*In this problem, I cannot use Dijkstra directly. I cannot use a distance array and keep updating it. That would give me the shortest distance, but not the ways.
        Another thought which will come to my mind is: let me count the ways. Count the nodes which are coming to the destination node. Then it will give me the answer. No, that will also not be my answer. I have to count the previous nodes before the destination: how many nodes are coming into the dead node, plus this node? That will be my answer. I am writing that code. Let's see. 
*/
        List<List<Journey>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road:roads){
            int st = road[0];
            int dt = road[1];
            int t = road[2];
            adj.get(st).add(new Journey(dt,t));
            adj.get(dt).add(new Journey(st,t));
        }

        long[] time = new long[n];
        Arrays.fill(time,Long.MAX_VALUE);
        time[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        Queue<Journey> pq = new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
        pq.add(new Journey(0,0));

        while(!pq.isEmpty()){
            Journey nearest = pq.poll();
            int start = nearest.city;
            long timeTravelled = nearest.time;

            for(Journey j:adj.get(start)){
                int destination = j.city;
                long timeTaken = j.time;

                if(timeTravelled + timeTaken < time[destination]){
                    time[destination] = timeTravelled + timeTaken;
                    ways[destination] = ways[start];
                    pq.add(new Journey(destination,time[destination]));
                }
                else if(timeTravelled + timeTaken == time[destination]){
                    ways[destination] = (ways[destination] + ways[start])% mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}
