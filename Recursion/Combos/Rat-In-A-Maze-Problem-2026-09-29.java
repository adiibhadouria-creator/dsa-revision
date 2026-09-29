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
 * block out of bound index and if a maze cell is 0 return


 */

class Solution {

    void findPaths(int[][] maze, ArrayList<String> paths,
                   StringBuilder path, int i, int j, int n) {

        // Invalid / blocked cell
        if (i < 0 || i >= n || j < 0 || j >= n ||
            maze[i][j] == 0) {
            return;
        }

        // Destination
        if (i == n - 1 && j == n - 1) {
            paths.add(path.toString());
            return;
        }

        // Mark CURRENT cell as visited
        maze[i][j] = 0;

        // Down
        path.append("D");
        findPaths(maze, paths, path, i + 1, j, n);
        path.deleteCharAt(path.length() - 1);

        // Left
        path.append("L");
        findPaths(maze, paths, path, i, j - 1, n);
        path.deleteCharAt(path.length() - 1);

        // Right
        path.append("R");
        findPaths(maze, paths, path, i, j + 1, n);
        path.deleteCharAt(path.length() - 1);

        // Up
        path.append("U");
        findPaths(maze, paths, path, i - 1, j, n);
        path.deleteCharAt(path.length() - 1);

        // Unmark CURRENT cell
        maze[i][j] = 1;
    }

    public ArrayList<String> ratInMaze(int[][] maze) {

        int n = maze.length;
        ArrayList<String> paths = new ArrayList<>();

        if (maze[0][0] == 0) {
            return paths;
        }

        findPaths(maze, paths, new StringBuilder(), 0, 0, n);

        return paths;
    }
}
