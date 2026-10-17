/*
 * Minimum Spanning Tree Kruskals Algorithm
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > MST
 * Time complexity: O(m log m) + O(M x 4 x alpha)
 * Space complexity: O(1)
 * Solved: 2026-10-17
 * URL: https://www.geeksforgeeks.org/problems/minimum-spanning-tree-kruskals-algorithm/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        Arrays.sort(edges,(a,b)->Integer.compare(a[2],b[2]));
        //now i have sorted edges just need to implement disjoint set 
        //check if these belong to same or not
        int ans = 0;
        DisjointSet ds =new DisjointSet(V);
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            if(ds.connected(u,v)) continue;
            else{
                ans += wt;
                ds.union(u,v);
            }
        }
        return ans;
        
    }
    static class DisjointSet{
        int[] parent;
        
        public DisjointSet(int V){
            parent = new int[V];
            for(int i=0;i<V;i++){
                parent[i] = i;
            }
        }
        public int root(int node){
            if(node == parent[node]){
                return node;
            }
            return parent[node] = root(parent[node]);
        }
        public boolean connected(int u,int v){
            int uP = root(u);
            int vP = root(v);
            return uP == vP;
        }
        public void union(int u,int v){
            int uP = root(u);
            int vP = root(v);
            
            //if(uP==vP) continue;
            parent[uP] = parent[vP];
    }
}
}
