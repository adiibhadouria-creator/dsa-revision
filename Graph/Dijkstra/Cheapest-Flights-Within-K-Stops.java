/*
 * Cheapest Flights Within K Stops
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Dijkstra
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Solved: 2026-10-14
 * URL: https://leetcode.com/problems/cheapest-flights-within-k-stops/submissions/2172538990/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * I first tried to apply normal DFS here by using a distance array and a priority queue, and sorting the priority queue on the basis of cost so that I can get the cheapest. The thing is, I can get a path where I can get the cheapest for now, but the optimal path is another way where it is not cheaper.
I can go from 1 to 4 to 5. 1 to 4 is 7, and 4 to 5 is 1. Total cost is 8. Another distance is 1 to 2 to 5. 1 to 2 is 2, and 2 to 5 is 10. As I will update the distance and distance array, I will not choose that path according to my Dijkstra algorithm. I am avoiding some paths because of cost, but cost is not my first criterion.
If I see the question, my criteria are:
1. if I can reach the destination
2. if I can reach within K stops
3. cheapest
Cheapest should not be my only verification. Within K stops should be my verification. Instead of storing it by sorting by cost, I will store it in the form of stops.
Now, while doing BFS traversal, I will also not need the edge queue because I am doing level-order traversal. First, I will get all the cities with 1 stop, then 2 stops, then 3 stops. There is no need for the edge queue.
At the starting city, in the queue, I will set distance and cost to 0, and also set the marketing price distance price array to 0. Then, in this loop, I will pop out the top node and check if the stops for this flight are greater than K. If so, it is invalid, and I will not go. Why not equal to K? Because I can allow the destination as a stop. I do not count the destination as a stop. If stops equal K and it is the destination, then it may be my answer, but I have to check.
Now I will get all the end cities updated, and I will check if the cost is less. I will update it in the price array. At the end, when I am at the end, I will check if the destination price is still `Integer.MAX`. It means it is unreachable, but otherwise, I will return the price of that destination.
The main problem was to think whether to sort on the basis of cost or stops. It was stops, because the main criteria were stops, cheapest was the third criteria, and first was shortest destination. Time and space complexity of general Dijkstra is O(E log V), but here we are not using a priority queue, so it is only O(E). E means edges, and edges mean the number of flights. Flight size, basically
 */

class Solution {
    class Flight{
        int stops;
        int source;
        int cost;
        Flight(int stops,int source, int cost){
            this.stops = stops;
            this.source = source;
            this.cost = cost;
        }
    }
        static class Pair {
            int destination;
            int fare;

            Pair(int destination, int fare) {
                this.destination = destination;
                this.fare = fare;
            }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //pq will use comparator comparing min cost if same cost then compare k
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            adj.get(flight[0]).add(new Pair(flight[1],flight[2]));
        }
        int[] price = new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        Queue<Flight> q = new LinkedList<>();

        q.add(new Flight(0,src,0));
        price[src] = 0;

        while(!q.isEmpty()){
            Flight cheapest = q.poll();
            int source = cheapest.source;
            int cost = cheapest.cost;
            int stops = cheapest.stops;
            if(stops>k) continue;
            for(Pair p:adj.get(source)){
                int s = p.destination;
                int c = p.fare;
                if(c + cost < price[s]){
                    price[s] = c + cost;
                    q.add(new Flight(stops+1,s,price[s]));
                }
            }
        }
        return price[dst] == Integer.MAX_VALUE ? -1:price[dst];
    }
}
