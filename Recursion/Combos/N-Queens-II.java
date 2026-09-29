/*
 * N-Queens II
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: Recursion > Combos
 * Time complexity: O(n! * n)
 * Space complexity: O(n^2)
 * Solved: 2026-09-29
 * URL: https://leetcode.com/problems/n-queens-ii/submissions/2157012594/
 * Language: java
 *
 * Problem statement:
 * 

 *
 * Notes:
 * traverese column wise so that everytime you move give row +1 so for row I am sure that it will never be  same but for column and left right diagonal have a check method focus on its syntax also .

then base case will be if all queens are safely placd then row will reach till n thus increase the number of counts. and use a void method and use global variable ans update on base case


space complexity for board will be n ^2 and recursion stack space will be n level and for time it will be n chances for firrst col , n-1 for sec col thus n! and another n for canweplace method check
 */

class Solution {
    int ans;
    //method for checking whether it is safe to place here or not
    boolean canWePlace(char[][]board,int row,int column,int n){
        //check for column
        for(int i=row-1;i>=0;i--){
            if(board[i][column]=='Q') return false;
        }
        //check for left diagonal
        for(int i=row-1,j=column-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        //check for right diagonal
        for(int i=row-1,j=column+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q') return false;
        }
            return true;

    }
    void placeQueens(char[][] board,int row){
        if(row == board.length) {
            ans ++;
            return;
        }
        //little optimization using pruning condition
        
        //traverse column wise
        for(int col=0;col<board.length;col++){
            if(canWePlace(board,row,col,board.length)){
                    //pick
                    board[row][col]='Q';
                    //explore
                    placeQueens(board,row+1);
                    //backtrack
                    board[row][col]='*';
                }
        }
        return ;
    }
    public int totalNQueens(int n) {
        ans =0;
        char[][]board = new char[n][n];
        for(char[]row:board){
            Arrays.fill(row,'*');
        }
        placeQueens(board,0);
        return ans;
    }
}
