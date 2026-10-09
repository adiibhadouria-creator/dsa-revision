/*
 * Surrounded Regions
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Traversal Problem
 * Time complexity: O(n*m)
 * Space complexity: O(N)
 * Solved: 2026-10-09
 * URL: https://leetcode.com/problems/surrounded-regions/submissions/2167625587/
 * Language: java
 *
 * Problem statement:
 * Same as the number of islands problem, but there was no condition such as it should be connected to the boundary or something. It was just the numbers which cannot form an island: remove them, and return the number of islands.
Here, we have conditioned it: if 0 is at the boundary, then it cannot be surrounded, and all the 0s connected to that boundary 0 in either direction will also not be surrounded.
1. We will find out the boundary 0s.
2. We will do the DFS to get all the 0s which are connected to the boundary and mark them as some special character.
3. We will again traverse it, and whatever remains can be surrounded.
4. We will again traverse it, and if any character is that special symbol, we mark it as 0 because those cannot be surrounded.
We marked it as * to differentiate between 0s which can be surrounded and 0s which cannot be surrounded.
Now, what I was doing wrong in DFS was I was not checking whether it was visited or not. If it was visited, it must be marked with *, meaning some special symbol which I am using. Also, IJ constraints at the start for boundary checks and those validity checks
 *
 * Notes:
 * None
 */

class Solution {
    public void solve(char[][] board) {
       
        int n = board.length , m= board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0||i==n-1||j==0||j==m-1)&&board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O') board[i][j]='X';
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='*') board[i][j] = 'O';
            }
        }
    }
    public void dfs(char[][]board,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='X'||board[i][j]=='*') {
            return;
        }
        board[i][j]='*';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
        return;
    }
}
