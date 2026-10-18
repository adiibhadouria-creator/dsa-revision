/*
 * Number Of Islands
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > DSU Problems
 * Time complexity: O(n x m)
 * Space complexity: O(n x m)
 * Solved: 2026-10-18
 * URL: https://www.geeksforgeeks.org/problems/number-of-islands/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public ArrayList<Integer> numOfIslands(int n, int m, int[][] operators) {
        // Your code here
        //brute force change the operatioon and do dfs traversal and count the islands
        // tc -> 2^n * operators.length
        
        
        //can i reduce it definitely it is dynamically changing graph 
        //after each operation tell the number of components
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        DisjointSet ds = new DisjointSet(n*m);
        ArrayList<Integer> ans = new ArrayList<>();
        boolean [][] visited = new boolean[n][m];
        int count = 0;
        for(int [] operator : operators){
            int r = operator[0];
            int c = operator[1];
            if(visited[r][c]){
                ans.add(count);
                continue;
            }
            visited[r][c] = true;
            count++;
            //now check for adjacent cells
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
                if(visited[nr][nc]){
                    int node = r * m + c;
                    int adjNode = nr * m + nc;
                  
                    if(ds.root(node)!=ds.root(adjNode)){
                       
                        count--;
                        ds.union(node,adjNode);
                    }
                }
            }
            ans.add(count);
        }
        
        return ans;
        
    }
    class DisjointSet{
        int[]parent;
        int[] size;
            public DisjointSet(int n){
                parent = new int[n];
                size = new int[n];

                for(int i=0;i<n;i++){
                    parent[i] = i;
                    size[i] = 1;
                }
            }
            public int root(int node){
                if(parent[node]==node) return node;
                return parent[node] = root(parent[node]);
            }
            public void union(int u,int v){
                int uP = root(u);
                int vP = root(v);

                if(uP == vP) return;

                if(size[uP] < size[vP]){
                    parent[uP] = vP;
                    size[vP] += size[uP];
                }
                else{
                    parent[vP] = uP;
                    size[uP] += size[vP];
                }
            }
        }
}
