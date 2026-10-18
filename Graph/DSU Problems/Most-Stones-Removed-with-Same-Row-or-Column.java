/*
 * Most Stones Removed with Same Row or Column
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > DSU Problems
 * Time complexity: O(n+m)
 * Space complexity: O(N)
 * Solved: 2026-10-18
 * URL: https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/submissions/2175753586/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Here, instead of thinking about how we will connect stones in the same row and the same column, we can consider every row and every column as a single node.

For that, first we need to find the number of rows and columns. We will do a loop for that. Then we will declare a disjoint set of max row + max column + 2. In Java, we go from 0 to n - 1, so +2. I know this sounds strange.

Whenever we go into a stone, we get its row and its column, and we do the union of its row and column. At the end, we will get the number of components, and the answer is n - components.size.

Now, why does doing the union of row and column work? Because of that, all stones in one row go to one node, and all stones in one column go to one node. 
 */

//total stones - no.of connected components
//traverse first row wise and then column wise

class Solution {
    int[] parent;
    int[] size;
    public int removeStones(int[][] stones) {
        //stone present or visited kind of 
        //create stone matrix
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(int[] stone:stones){
            maxRow = Math.max(maxRow,stone[0]);
            maxCol = Math.max(maxCol,stone[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow+maxCol+2);
        Set<Integer> components = new HashSet<>();
        for(int[] stone : stones){
            int row = stone[0];
            int col = stone[1]+maxRow+1;
            ds.union(row,col); 
  
        }
        for(int[] stone : stones){
            int row = stone[0];
            int col = stone[1]+maxRow+1;
            components.add(ds.root(row));      
        }

        return n - components.size();
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
