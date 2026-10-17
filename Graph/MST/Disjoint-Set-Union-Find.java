/*
 * Disjoint Set Union Find
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > MST
 * Time complexity: O(4 alpha)
 * Space complexity: O(1)
 * Solved: 2026-10-17
 * URL: https://www.geeksforgeeks.org/problems/disjoint-set-union-find/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public ArrayList<Integer> DSU(int n, int[][] queries) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        DisjointSet ds = new DisjointSet(n);
        for(int[] query:queries){
            int type = query[0];
            if(type==1){
                ds.union(query[1],query[2]);
            }
            else{
                ans.add(ds.root(query[1]));
            }
        }
        return ans;
    }
    class DisjointSet{
        int[] parent;
        
        public DisjointSet(int n){
            parent = new int[n+1];
            for(int i=1;i<=n;i++){
                parent[i] = i;
            }
        }
        public int root(int node){
            if(node == parent[node]){
                return node;
            }
            return parent[node] = root(parent[node]);
        }
        public void union(int x , int z){
            int xU = root(x);
            int zU = root(z);
            
            if(xU == zU) return;
            
            parent[xU] = parent[zU];
        }
    }
}
