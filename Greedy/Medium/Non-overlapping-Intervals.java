/*
 * Non-overlapping Intervals
 * Difficulty: Not specified
 * Topic: Greedy > Medium
 * Time complexity: O(N log N) +O(N)
 * Space complexity: O(1)
 * Solved: 2026-09-18
 * URL: https://leetcode.com/problems/non-overlapping-intervals/
 *
 * Problem statement:
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping. Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping. Example 1: Input: intervals = [[1,2],[2,3],[3,4],[1,3]] Output: 1 Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping. Example 2: Input: intervals = [[1,2],[1,2],[1,2]] Output: 2 Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping. Example 3: Input: intervals = [[1,2],[2,3]] Output: 0 Explanation: You don't need to remove any of the intervals since they're already non-overlapping. Constraints: 1 <= intervals.length <= 105 intervals[i].length == 2 -5 * 104 <= starti < endi <= 5 * 104
 *
 * Notes:
 * Inverse version of n meetings in one room intuition->the ending time is contributing to overlapping 
the more end time is the more is the chances of overlapping so
 try to remove the interval with larger end time

sort according to the time end
 */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count = 1;
        int n = intervals.length;
        // List<int[]> ans = new ArrayList<>();
        // for(int[] interval:intervals){
        //     if(ans.isEmpty() || ans.get(ans.size()-1)[1]<=interval[0]){
        //         ans.add(interval);
        //     }
        //     else{
        //         if(ans.get(ans.size()-1)[1]>interval[1]){
        //             ans.remove(ans.get(ans.size()-1));
        //             ans.add(interval);
        //         } 
        //         count++;

        //         //ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],interval[1]);
        //     }
        // } 
        // return count;

        //It is same as N meetings in one room just reverse of it
        int freeTime = intervals[0][1];
        for(int[] interval:intervals){
            if(interval[0]>=freeTime){
                count++;
                freeTime = interval[1];
            }
        }
        return n-count;
        //tc-O(1)
    }
}
