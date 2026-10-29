/*
 * Cherry Pickup II
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Grids
 * Time complexity: O(rows x col^2)
 * Space complexity: O(col^2)
 * Solved: 2026-10-29
 * URL: https://leetcode.com/problems/cherry-pickup-ii/submissions/2184328681/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * too much learnign from this quesiton
 */

class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];

        //Base case:Both robots are on the last column
        for(int robot1Col = 0; robot1Col < cols ; robot1Col++){
            for(int robot2Col = 0; robot2Col < cols ; robot2Col++){
                dp[rows-1][robot1Col][robot2Col] = getCherries(grid,rows-1,robot1Col,robot2Col);
            }
        }
        //Fill DP from bottom to top
        for(int row = rows-2;row>=0; row--){
            for(int robot1Col = 0; robot1Col < cols ; robot1Col++){
                for(int robot2Col = 0; robot2Col < cols ; robot2Col++){

                    int maxCherries = Integer.MIN_VALUE/2;

                    for(int robot1Move = -1; robot1Move<=1; robot1Move++){
                        for(int robot2Move = -1; robot2Move<=1; robot2Move++){

                            int nextRobot1Col = robot1Col + robot1Move;
                            int nextRobot2Col = robot2Col + robot2Move;

                            if(nextRobot1Col < 0 || nextRobot2Col <0 || nextRobot1Col>=cols || nextRobot2Col >= cols) continue;

                            int cherries = getCherries(grid,row,robot1Col,robot2Col);

                            cherries += dp[row+1][nextRobot1Col][nextRobot2Col];

                            maxCherries = Math.max(cherries,maxCherries);
                        }
                    }
                    dp[row][robot1Col][robot2Col] = maxCherries;
                }
            }
        }
        return dp[0][0][cols-1];
    }
    private int getCherries(int[][]grid,int row,int col1 ,int col2){
        if(col1==col2) return grid[row][col1];
        return grid[row][col1] + grid[row][col2];
    }
}
