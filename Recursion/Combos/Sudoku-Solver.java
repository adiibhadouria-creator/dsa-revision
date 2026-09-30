/*
 * Sudoku Solver
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Recursion > Combos
 * Time complexity: O(9^81)
 * Space complexity: O(1)
 * Solved: 2026-09-30
 * URL: https://leetcode.com/problems/sudoku-solver/submissions/2158095552/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * typecasting to char is '0'+digit not (char)digit

 */

class Solution {
    boolean isValid(char[][]board,int row,int col,char digit){
        //validate row
        //validate col
        for(int i=0;i<9;i++){
            if(board[row][i]==digit) return false;
            if(board[i][col]==digit) return false;
        }
        //validate sub-box
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if(board[sr+k][sc+l]==digit) return false;
            }
        }
        return true;
    }
    public boolean solve(char[][]board){
        for(int i=0;i<9;i++){

            for(int j=0;j<9;j++){

                if(board[i][j]=='.'){
                    for(char digit='1';digit<='9';digit++){
                        if(isValid(board,i,j,digit)){
                            board[i][j]=digit;
                            if(solve(board)==true){

                                return true;
                            }
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
