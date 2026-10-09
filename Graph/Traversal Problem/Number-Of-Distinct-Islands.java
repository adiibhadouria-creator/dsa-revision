/*
 * Number Of Distinct Islands
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > Traversal Problem
 * Time complexity: O(n*m*(log(n*m) +(n*m*4)
 * Space complexity: O(n)
 * Solved: 2026-10-09
 * URL: https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * What I learned from this question is how we can store shapes of a grid in a set or in any data structure. What we can do is have a  start row, and start column, and from there we will calculate wherever I want land or wherever i have required index according to problem. Wherever land is present, I will subtract that row index from the start row and same for column and store that in a set.

What will happen if there are identical shapes? Then those will have the same difference for every row and column and so on, and only one unique one will be stored.

Another thing I learned here is that if I use a pair here and store this row and column as a pair, the pair's `equals` and `hashCode` methods are not overridden. The `String` class overrides the `hashCode` and `equals` methods. If I store it as a pair, even though the pairs are the same, their addresses won't be saved. If I store it as a string, then it will be saved.

Now, come to the question: number of distinct islands, similar to number of islands, but here we want distinct, so we have to store it in the form of a shape. The rest is the main difference, and for shape, we have to do all this process. 
 */

class Solution {
    public int countDistinctIslands(char[][] grid) {
        // code here
        //we can store row diff , col diff and size of shapes/islands in set
       // and return the set size later
       int n = grid.length;
       int m = grid[0].length;
       Set<List<String>> st = new HashSet<>();
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j]=='L'){
                   List<String> list = new ArrayList<>();
                   dfs(grid,i,j,list,i,j);
                   st.add(new ArrayList<>(list));
               }
           }
       }
       return st.size();
    }
    public void dfs(char[][]grid,int row , int col,List<String> list , int sr , int sc){
        if(row<0 || col<0 || row>=grid.length || col >=grid[0].length || grid[row][col]=='W'|| grid[row][col]=='V') return;
        
        int nr = row-sr;
        int nc = col-sc;
        
        list.add(nr+","+nc);
        grid[row][col]='V';
        dfs(grid,row+1,col,list,sr,sc);
        dfs(grid,row-1,col,list,sr,sc);
        dfs(grid,row,col-1,list,sr,sc);
        dfs(grid,row,col+1,list,sr,sc);
        return;
    }
}
