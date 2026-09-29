/*
 * Word Search
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Recursion > Combos
 * Time complexity: O(M∗N∗3 ^L )
 * Space complexity: O(L)
 * Solved: 2026-09-29
 * URL: https://leetcode.com/problems/word-search/submissions/2156945631/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * mistakes , thinking of when to move right left up down instead just try for all of them and have a check condition if at any time i goes beyond 0 or more than n and same for j return false and 
for marking anything visited first store that character somewhere then replace it with a symbol to show it is visited, so when we call recursion and use this symbol as a check that if this symbol comes that means i have visited this cell i cant visit it again thus return false


and passing wrong index in for loop just pass the starting index

L->length of words
 */

class Solution {
    boolean check(char[][]board,int i,int j,int index,String word){
        if(index==word.length()){
            return true;
        }
        if(i<0 || j<0 || i==board.length|| j==board[0].length||board[i][j]=='*'||board[i][j]!=word.charAt(index)){
            return false;
        }


        //pick this 
        char c = board[i][j];
        board[i][j]='*';
        //explore all cells
        if(check(board,i+1,j,index+1,word)||
            check(board,i-1,j,index+1,word)||
            check(board,i,j+1,index+1,word)||
            check(board,i,j-1,index+1,word)){
                return true;
            }
        //backtrack
        board[i][j] = c;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(check(board,i,j,0,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
