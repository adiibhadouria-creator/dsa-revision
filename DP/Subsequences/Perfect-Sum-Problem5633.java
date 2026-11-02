/*
 * Perfect Sum Problem5633
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: DP > Subsequences
 * Time complexity: O(n*target)
 * Space complexity: O(n)
 * Solved: 2026-11-02
 * URL: https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Just one thing I was curious about: why do we mark `previous[a[0]] = 1`? When I am at index 0, why do I need to mark it as 1?
First of all, why do we even check if `a[0] <= target`? Let me answer the first question. We mark it as 1: if I am at index 0, then what is the possibility that I have some 0? The possibility is 1. I do not choose an even index. 1, then my answer will be 1 subset because if I have nothing in my subset, the answer is 0. Valid.
Now, why is `er[0] <= target`? Because `er[0]` can be 5 or 7 or something, right? We have to check before marking it. If I access `er[0]`, which is 7, but my target allows me to index till 2 or 3, then how can I mark 7? It will give me an auto bound.
 */

class Solution {
    static int perfectSum(int[] arr, int target) {
        int n = arr.length;
        int[]prev = new int[target+1];
        
        if(arr[0] == 0) prev[0] = 2;
        else prev[0] =1;
        if(arr[0] <=target && arr[0]!=0) prev[arr[0]] = 1;
        
        for(int i=1;i<n;i++){
            int[] curr = new int[target+1];
            for(int j=0;j<=target;j++){
                
                int pick = arr[i] <= j ?prev[j-arr[i]] : 0;
                int notPick = prev[j];
        
                curr[j] = pick + notPick;
            }
            prev = curr;
        }
        return prev[target];
    }
}
