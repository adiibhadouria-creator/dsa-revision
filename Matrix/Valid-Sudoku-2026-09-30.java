/*
 * Valid Sudoku
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Matrix
 * Time complexity: O(81)
 * Space complexity: O(81)
 * Solved: 2026-09-30
 * URL: https://leetcode.com/problems/valid-sudoku/submissions/2158071272/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen=new HashSet();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if(c!='.'){
                    String row = c+"number in row"+i;
                    String col = c+"number in col"+j;
                    String block =c+ "number in block"+i/3+","+j/3;
                    if(seen.contains(row)||seen.contains(col)||seen.contains(block)){
                        return false;
                    }
                    seen.add(row);
                    seen.add(col);
                    seen.add(block);
                }
            }
        }
        return true;
    }
}
