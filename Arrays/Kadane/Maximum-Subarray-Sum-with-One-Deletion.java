/*
 * Maximum Subarray Sum with One Deletion
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: Arrays > Kadane
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Solved: 2026-10-04
 * URL: https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/submissions/2161883170/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int maximumSum(int[] arr) {
        int notDeleted = arr[0];
        int alreadyDeleted = arr[0];
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {

            // Save previous state BEFORE updating notDeleted.
            // Needed if we delete arr[i].
            int prevNoDeleted = notDeleted;

            // No deletion:
            // either start fresh at arr[i],
            // or extend previous subarray.
            notDeleted = Math.max(arr[i], notDeleted + arr[i]);

            // One deletion:
            // 1. deletion was already used -> take arr[i]
            // 2. delete arr[i] -> use sum ending at i-1
            alreadyDeleted = Math.max(alreadyDeleted + arr[i],prevNoDeleted);

            // Global maximum seen so far
            res = Math.max(res, Math.max(notDeleted, alreadyDeleted));
        }

        return res;
    }
}
