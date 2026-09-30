/*
 * M Coloring Problem 1587115620
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Recursion > Combos
 * Time complexity: O(N^M)
 * Space complexity: O(N+N)
 * Solved: 2026-09-30
 * URL: https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * mistakes-> implementing ispossible inside recursion method only not safe 
 */

class Solution {
    static boolean isPossible(int n,int[][]edges,int[]color,int curr){
        //check if any of adjacent vertix have same color then return
        for(int[]edge:edges){
            if(edge[0]==n && color[edge[1]]==curr){
                return false;
            }
            if(edge[1]==n && color[edge[0]]==curr){
                return false;
            }
        }
        return true;
    }
    static boolean check(int n,int[][]edges,int m ,int[]color,int v){
        if(n==v){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(isPossible(n,edges,color,i)){
                color[n]=i;
                if(check(n+1,edges,m,color,v)){
                    return true;
                }
                color[n]=-1;
            }
        }
        return false;
    }
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int[]color = new int[v];
        Arrays.fill(color,-1);
        return check(0,edges,m,color,v);
    }
}
