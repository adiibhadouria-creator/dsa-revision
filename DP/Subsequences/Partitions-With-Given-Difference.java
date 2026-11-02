/*
 * Partitions With Given Difference
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: DP > Subsequences
 * Time complexity: O(n*total+diff)
 * Space complexity: O(n)
 * Solved: 2026-11-02
 * URL: https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * The main problem was with 0. What if I get 0 at my 0 index? In base cases for recursion, we go deep down. We do not stop if we get a target as 0, because what if there are 0 values afterwards? Including those will not change my sum, but it will create a new subset and give me a new subset. I have to go deep down.
The second thing is, just try to convert base cases as it looks. It is not so difficult. Just try to understand what it is saying. If `array[0]` is 0, it means there are 2 ways:
- If I choose it, then also my sum will be the same.
- If I do not choose it, then also my sum will be the same.
If it is not 0, then there is only 1 way.
One more case: if `array[0] <= target`, this is for checking that we are not marking something out of bounds. If `array[0] != 0`, then we will do `s1`. Why not equal to 0? Because if it is equal to 0, then it will override the last base case. Everything else is simple, I guess.
 */

class Solution {
    public int countPartitions(int[] arr, int diff) {
        int n =arr.length;
        int total = Arrays.stream(arr).sum();
        int target = total+diff;
        if (target%2==1) return 0;
        target /=2;
        int[][]dp = new int[n][target+1];
        
        if(arr[0]==0) dp[0][0] = 2;
        else dp[0][0] = 1;
        
        if(arr[0]<=target && arr[0]!=0) dp[0][arr[0]] = 1;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                
                int pick = arr[i]<=j ? dp[i-1][j-arr[i]] : 0;
                int notPick = dp[i-1][j];
                
                dp[i][j] = pick + notPick;
            }
        }
        return dp[n-1][target];
    }
}
