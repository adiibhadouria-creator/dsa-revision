/*
 * Simple LIS Approach! - Java
 * Platform: GeeksforGeeks
 * Difficulty: easy
 * Topic: DP > LIS
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 * Solved: 2026-11-07
 * URL: https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

import java.util.*;
import java.util.stream.IntStream;
class Solution {
    public static int longestBitonicSequence(int n, int[] arr) {
        int[] leftLIS = new int[n];
        int[] rightLIS = new int[n];
        Arrays.fill(leftLIS,1);
        Arrays.fill(rightLIS,1);
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if(arr[i]>arr[j]){
                    leftLIS[i] = Math.max(leftLIS[i],leftLIS[j]+1);
                    }
                }
            }
            for(int i=n-2;i>=0;i--){
                for(int j=n-1;j>i;j--){
                    if(arr[i]>arr[j]){
                        rightLIS[i] = Math.max(rightLIS[i],rightLIS[j]+1);
                    }
                }
            }
        int leftMax = Arrays.stream(leftLIS).max().getAsInt();
        int rightMax = Arrays.stream(rightLIS).max().getAsInt();
        int leftSum = Arrays.stream(leftLIS).sum();
        int rightSum = Arrays.stream(rightLIS).sum();
        
        //edge cases: strictly increasing / decreasing or all same
        if(leftLIS[n-1]==leftMax && rightSum == n) return 0;
        else if(rightLIS[0]==rightMax && leftSum == n) return 0;
        else if(leftSum == n && rightSum == n) return 0;
        // System.out.print("Printing LIS from left: ");
        // for(int x:leftLIS) System.out.print(x+" ");
        // System.out.println();
        // System.out.print("Printing LIS from right: ");
        // for(int x:rightLIS) System.out.print(x+" ");
            int ans = 0;
            for(int i=0;i<n;i++){
                int peak = 0;
                if(leftLIS[i]>1 && rightLIS[i]>1){
                    peak = leftLIS[i]+rightLIS[i]-1;
                }
                ans = Math.max(peak,ans);
            }
            return ans;
       
        
       
    }
}
