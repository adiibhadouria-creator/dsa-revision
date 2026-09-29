/*
 * Rat In A Maze Problem
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Recursion > Combos
 * Time complexity: O(4^n^2)
 * Space complexity: O(n^2)
 * Solved: 2026-09-29
 * URL: https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * mistakes -> base case till n-1 not n
2.   in if conditions there should be bound checking on basis of moving direction
3.  as all are different situations every direction requires their separate markings of visited and backtracking

4.do not end this method if(maze[i][j]==0) return; 
5.one edge case if(starting grid is 0 then there is no chance you can go till end
6. also mark first grid as visited before sending it to method
 */

class Solution {
    
    void findPaths(int[][]maze,ArrayList<String>paths,StringBuilder path,int i,int j,int n){
        if(i==n-1 && j==n-1){
            paths.add(path.toString());
            return;
        }
        

        if(i+1 <n && maze[i+1][j]==1){
            maze[i+1][j]=0;
            path.append("D");
            findPaths(maze,paths,path,i+1,j,n);
            
            path.deleteCharAt(path.length()-1);
            maze[i+1][j]=1;
        }
        if(j-1>=0 && maze[i][j-1]==1){
            maze[i][j-1]=0;
            path.append("L");
            findPaths(maze,paths,path,i,j-1,n);
            
            path.deleteCharAt(path.length()-1);
            maze[i][j-1]=1;
        }
        if(j+1<n && maze[i][j+1]==1){
            maze[i][j+1]=0;
            path.append("R");
            findPaths(maze,paths,path,i,j+1,n);
            
            path.deleteCharAt(path.length()-1);
            maze[i][j+1]=1;
        }
        if(i-1>=0 && maze[i-1][j]==1){
            maze[i-1][j]=0;
            path.append("U");
            findPaths(maze,paths,path,i-1,j,n);
            
            path.deleteCharAt(path.length()-1);
            maze[i-1][j]=1;
        }
        
        
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
       
        ArrayList<String> paths = new ArrayList<>();
        
        if(maze[0][0]==1){
            maze[0][0]=0;
            findPaths(maze,paths,new StringBuilder(),0,0,n);
            maze[0][0]=1;
        }
        return paths;
    }
}
