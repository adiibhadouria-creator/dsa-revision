/*
 * Valid Sudoku
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Matrix
 * Time complexity: O(81)
 * Space complexity: O(1)
 * Solved: 2026-09-30
 * URL: https://leetcode.com/problems/valid-sudoku/submissions/2158057758/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * in valid box method , check where are u creating hashset , we have to use same cell for all 9 cells. thus create it outside

 */

class Solution {
    public boolean validBox(char[][]board,int sr,int er,int sc,int ec){
        Set<Character> st = new HashSet<>();
        for(int row=sr;row<=er;row++){
            
            for(int col=sc;col<=ec;col++){
                char c = board[row][col];
                if(c=='.') continue;
                if(st.contains(c)) return false;
                st.add(c);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int row=0;row<9;row++){
           Set<Character> st = new HashSet<>();
            for(int col =0;col<9;col++){
                char c = board[row][col];
                if(c =='.') continue;
                if(st.contains(c)) return false;
                st.add(c);
            }
        }

        //validate column
        for(int col=0;col<9;col++){
            Set<Character> st = new HashSet<>();
            for(int row =0;row<9;row++){
                char c = board[row][col];
                if(c =='.') continue;
                if(st.contains(c)) return false;
                st.add(c);
            }
        }

        //Validate sub - boxes
        for(int sr=0;sr<9;sr+=3){
            int er = sr+2;
            for(int sc =0;sc<9;sc+=3){
                int ec = sc+2;
                if(!validBox(board,sr,er,sc,ec)){
                    return false;
                }
            }
        }
        return true;
   
    }
}
