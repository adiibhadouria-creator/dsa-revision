/*
 * Course Schedule
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Cycle
 * Time complexity: O(v+e)
 * Space complexity: O(2v)
 * Solved: 2026-10-10
 * URL: https://leetcode.com/problems/course-schedule/submissions/2167733303/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This question can be framed as: Can we detect a cycle in a directed graph? We know how to detect a cycle in an undirected graph, but can we do it in a directed graph?
Now , direct DFS approach fails because when we choose a different path and come to the same node, if we use normal DFS (what we use in an undirected graph), it will return `true`. The thing is, we may have come to this node from another path. That doesn't mean this is a cycle.
Here, we use two things:
- whether it is in the current path or not
- whether it has come again
If it is in the current path and has come again, it is a cycle. We keep two arrays: one for visited and one for the current path. Here, I named it `study` for the question reference.
Whenever I visit a node, I call DFS for same node. I will mark it as studied and mark it as in the current path. Now I will perform the simple DFS and check for the cycle. If it is not visited, then I will visit it. If it is visited and not in the current path, it means nothing: there's no cycle. If it is visited and also in the current path, it means it is a cycle. According to that, we will return the boolean value.
The mistake I was making was that it is a directed graph, so I was creating an adjacency list like it is an undirected graph. That's it.
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //if cycle then not possible 
        //else possible
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int []prerequisite:prerequisites){
            int u = prerequisite[0];
            int v = prerequisite[1];
            adj.get(u).add(v);
        }
        int[] studied = new int[numCourses];
        int[] studying = new int[numCourses];
        Arrays.fill(studied,0);
        Arrays.fill(studying,0);
        for(int i=0;i<numCourses;i++){
            if(studied[i]==0){
                //if there is a cycle that means all pre cannot be done so return false
                if(finish(i,adj,studied,studying)==true) return false;
            }
        }
        //if there is no cycle , means all prerequisites can be completed
        return true;
    }
    //returns whether directed graph has cycle or not
    public boolean finish(int subject ,List<List<Integer>> adj , int[]studied, int[]studying){
        //mark this current subject as studied and also in studying
        studied[subject] = 1;
        studying[subject] = 1;
        for(int pre:adj.get(subject)){
            if(studied[pre]==0){
                //means i have not studied it
                if(finish(pre,adj,studied,studying)==true) return true;
            }
            else{
                //means i have already studied it now just check if i am doing it again
                if(studying[pre]==1) return true;
            }
        }
        studying[subject]= 0;
        return false;
    }
}
