/*
 * Number of Operations to Make Network Connected
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > DSU Problems
 * Time complexity: O(n+m)
 * Space complexity: O(n)
 * Solved: 2026-10-17
 * URL: https://leetcode.com/problems/number-of-operations-to-make-network-connected/submissions/2174883211/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * The main idea of this problem was that one thing we can do is DFS and count the number of connected components.  
  
How will we do it? Every time, we will run a loop from 0 to n. Every time a node is unvisited, we will call DFS for it, visit all its adjacent neighbors, and mark it visited. Every time I call DFS, it means a new component that is not connected to any other component is going for DFS, so I will do \`component++\`. That means this is a new component. At the end, I can return \`component - 1\`.  
  
Now, why \`component - 1\`, and what are the edge cases? The first edge case is if there are less than n - 1 edges, then it is not possible to connect all computer networks. If there are 5 computers and there are only 2 edges, then there is no possible chance I can connect to all the computers. Even if there are 5 computers and there are 3 cables, I still can't connect them all. If there are 5 computers and 4 cables, then I can connect them all. The first edge case is this. Keep this in mind.  
  
Now, the main idea was: how many components are there? If the extra cables we have are greater than or equal to \`components - 1\`, then we can return the answer. The answer will be \`number of components - 1\`.  
  
Now, why \`components - 1\`? There's one component containing 4 computers, another component containing 3 computers, and another component containing 2 computers. I do not need to think much about this. I just need to think: if I pick one cable from component 1 and use that cable to connect it to component 2, then I can go to all the computers in component 2. I just need to count the extra cables that can help me connect all components. If the extra cables are more than \`count of components - 1\`, then I can return \`count of components - 1\`. If there are not extra cables in it, then I will return \`n - 1\`.  
  
Sweet and simple. The code I have written is a little bit misleading: instead of \`cables++\`, it should be \`components++\`. Like \`parent\`, I will store the number of components. You understand what I mean to say? At the end, I will write \`components - 1\`. Now, why am I not checking here? Because I have checked above only. Simple
 */

class Solution {
    int[] parent;
    int[] size;
    public int makeConnected(int n, int[][] connections) {
        int cables = connections.length;
        if(cables < n-1) return -1;//this means there are not enough cables to connect all computers
        //run a loop from 0 to n check if it is connected or it has same parent then ok else union them and counter ++
        DS d = new DS(n);
        int cablesChanged  = 0;
        for(int [] connection:connections){
            int u = connection[0];
            int v = connection[1];
            if(d.connected(u,v)) continue;
            else{
                d.union(u,v);
            }
        }
        for(int i=0;i<n;i++){
            if(parent[i]==i) cablesChanged++;
        }
        return cablesChanged-1;

    }
    class DS{
        public DS(int n){
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
        public boolean connected(int u, int v){
            int uP = root(u);
            int vP = root(v);
            return uP == vP;
        }
        public void union(int u, int v){
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
