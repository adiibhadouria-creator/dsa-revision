/*
 * Making A Large Island
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > DSU Problems
 * Time complexity: O(n^2)
 * Space complexity: O(N^2)
 * Solved: 2026-10-18
 * URL: https://leetcode.com/problems/making-a-large-island/submissions/2175718235/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * 1. Connect all the components together so that you will get the size which you were getting with DFS using map.
2. When you connect the component size, they will be updated, and also the parent will be updated.
3. Again, traverse in the array and find the 0th element, which you need to flip.
4. Find the nearby land cells and check their root. If their root is already added, then don't do anything. If it is not added, then add its root size, meaning it is the parent of the ultimate parent of all the nodes.
Yeah, very simple.
 */

class Solution {
    int[] parent;
    int[] size;

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        DisjointSet ds = new DisjointSet(n*n);
        int maxSize = 0;
        Set<Integer> usedIsland = new HashSet<>();
        //make all components together first
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //check all neighbours and union them
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if(nr<0 || nc<0 || nr>=n || nc>=n || grid[nr][nc]==0 ) continue;
                        
                        int x = i * n +j;
                        int y = nr * n + nc;
                        if(ds.root(x)!=ds.root(y)){
                            ds.union(x,y);
                        }
                    }
                } 
            } 
        }
        boolean allOne = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    allOne = false;
                    usedIsland.clear();
                    int currSize = 1;
                    //check neighbours and increase size
                    for(int k = 0;k<4;k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                       
                        if(nr<0 || nc<0 || nr>=n || nc>=n || grid[nr][nc]==0 ) continue;

                        //get neighbours parent and its size
                        int neighbour = nr*n + nc;
                        int par = ds.root(neighbour);
                        if(!usedIsland.contains(par)){
                        usedIsland.add(par);
                        currSize += size[par];
                        }
                    }
                    maxSize = Math.max(currSize,maxSize);
                }  
            }
        }
        //traverse again and check neighbours and then size
        if(allOne) return n*n;
        return maxSize;
    }
    class DisjointSet{
        public DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int root(int node){
            if(parent[node] == node) return node;
            return parent[node] = root(parent[node]);
        }
        public void union(int u,int v){
            int up = root(u);
            int vp = root(v);

            if(up == vp) return;
            if(size[up] < size[vp]){
                parent[up] = vp;
                size[vp] += size[up];
            }
            else{
                parent[vp] = up;
                size[up] += size[vp];
            }
        }
    }
}
