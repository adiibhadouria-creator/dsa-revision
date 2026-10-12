-----Approach----
  So this is the question to find the shortest path in directed a graph. We can also do this using dijkstra, but we can also do this using Topo sort now why topo works here because we had the order of nodes in which has these order, I will get the first node which has no node coming to it , second node with the first node go to third node with the second node go to it so by this,  I am making sure that it's before nodes are used perfectly. This is the idea of using to certain shortest path in order, Topo cannot used in other finding shortest, but like an indirect   be used time and space complexity is number of vertices plus, I am using DFS approach.
  I will use topo sort using DFS then I will store pairs in form of list and list and make the graph from edges. Then I will run a loop for all components. After that I will make a distance array, initially I will mark all the distance to the integer mix value and I will mark the source as zero distance because the distance from the source to it's a.
  Then I will loop in my stack. It's not empty. I will take out the edge and I will check if edge is unbeatable means it makes value is distance and I will continue but if it is possible, then I will check if it's distance is less lesser than current no distance if it's neigh distance is less than current distance plus weight then I will update it and move on
  Mistakes I was doing worse in prayer class, then not marking source known as the distance then not checking if it's distance is integer max value than to skip and then check if distance is integer or max then assign it minus one as occurred by question
  Time Complexity: O(V+E), where V and E are the numbers of vertices and directed edges; topological DFS and relaxation process each vertex and edge once.

Space Complexity: O(V+E), where the adjacency list stores V vertices and E edges, while the visited, stack, recursion, and distance storage require O(V) space.
class Solution {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    private void topoSort(int V, List<List<Pair>>adj,boolean[]visited,Stack<Integer> st){
        visited[V] = true;
        for(int i=0;i<adj.get(V).size();i++){
            int neighbour = adj.get(V).get(i).first;
            if(!visited[neighbour]){
                topoSort(neighbour,adj,visited,st);
            }
        }
        st.push(V);
    }
    public int[] shortestPath(int N, int M, int[][] edges) {
        //make graph from edges annd with weights
        //do topo sort
        //pop out from stack , get neighbors and update distance array
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v,wt));
        }
        boolean[] visited = new boolean[N];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<N;i++){
            if(!visited[i]) topoSort(i,adj,visited,st);
        }
        int[] distance = new int[N];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            if (distance[node] == Integer.MAX_VALUE) {
                continue;
            }
            
            for(int i=0;i<adj.get(node).size();i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                if(distance[node]+wt < distance[v]){
                    distance[v] = distance[node]+wt;
                }
            }
        }
        for(int i=0;i<N;i++){
            if(distance[i]==Integer.MAX_VALUE) distance[i]=-1;
        }
        return distance;
    }
}
