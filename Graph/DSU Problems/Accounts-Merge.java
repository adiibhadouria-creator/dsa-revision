/*
 * Accounts Merge
 * Platform: LeetCode
 * Difficulty: Medium
 * Topic: Graph > DSU Problems
 * Time complexity: O(n+u)
 * Space complexity: O(n+u)
 * Solved: 2026-10-17
 * URL: https://leetcode.com/problems/accounts-merge/submissions/2174931946/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * The important insight is that accounts 0 and 1 are connected even if they don't share every email. Account 0 shares b@gmail.com with account 1, so the emails of both accounts belong to the same component.
This is exactly a connected-components problem.
You could solve it using DFS/BFS on an account graph, but DSU is a natural fit because you only need to merge groups when a shared email is found.
Why DSU works here
For each email, remember which account encountered it first.
- If the email is new, record its account index.
- If the email has been seen before, union the current account with the recorded account.
- After processing every account, all connected accounts have the same DSU representative.
You don't need to construct an explicit adjacency list.
 */

class Solution {
    int[] parent;
    int[] size;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<Integer,String> nameMap = new HashMap<>();
        Map<String,Integer> mailMap = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);

        for(int i=0;i<n;i++){
            String name = accounts.get(i).get(0);
            nameMap.put(i,name);
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!mailMap.containsKey(mail)){
                    mailMap.put(mail,i);
                }
                else{
                    ds.union(mailMap.get(mail),i);
                    mailMap.put(mail,i);
                }
            }
        }
        
        List<List<String>> mergedList = new ArrayList<>();
        for(int i=0;i<n;i++){
            mergedList.add(new ArrayList<>());
        }
       
        for(Map.Entry<String,Integer> entry : mailMap.entrySet()){
            String mail = entry.getKey();
            int idx = ds.root(entry.getValue());
            mergedList.get(idx).add(mail);
        } 

        for(int i=0;i<mergedList.size();i++){
            Collections.sort(mergedList.get(i));
        }
        // System.out.println("Printing after sorting without name mergedList");
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<mergedList.get(i).size();j++){
        //         System.out.print(mergedList.get(i).get(j)+",");
        //     }
        //     System.out.println();
        // }
        //ans list
        //merged mail list --. empty to do nothing else add it in ans list

        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<mergedList.size();i++){
            String name = nameMap.get(i);
            if(mergedList.get(i).size()==0) continue;
            mergedList.get(i).add(0,name);
            ans.add(new ArrayList<>(mergedList.get(i)));
        }
        return ans;
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
