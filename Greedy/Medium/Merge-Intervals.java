/*
 * Merge Intervals
 * Difficulty: Not specified
 * Topic: Greedy > Medium
 * Time complexity: O(N log N)+O(N)
 * Space complexity: O(N)
 * Solved: 2026-09-18
 * URL: https://leetcode.com/problems/merge-intervals/
 *
 * Problem statement:
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input. Example 1: Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6]. Example 2: Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5] are considered overlapping. Example 3: Input: intervals = [[4,7],[1,4]] Output: [[1,7]] Explanation: Intervals [1,4] and [4,7] are considered overlapping. Constraints: 1 <= intervals.length <= 104 intervals[i].length == 2 0 <= starti <= endi <= 104
 *
 * Notes:
 * Proper greediness
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare((a)[0],(b)[0]));
        List<int[]> ans = new ArrayList<>();
        for(int[] interval:intervals){
            int start = interval[0];
            int end = interval[1];
            //It is not overlapping
            if(ans.isEmpty() ||  ans.get(ans.size()-1)[1]<start){
                ans.add(interval);
            }
            else {
                ans.get(ans.size()-1)[1]= Math.max(interval[1],ans.get(ans.size()-1)[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
