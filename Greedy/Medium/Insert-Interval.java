/*
 * Insert Interval
 * Difficulty: Not specified
 * Topic: Greedy > Medium
 * Time complexity: O(N)
 * Space complexity: O(N)
 * Solved: 2026-09-18
 * URL: https://leetcode.com/problems/insert-interval/submissions/2145383102/
 *
 * Problem statement:
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval. Two intervals are considered overlapping if they share at least one point. Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary). Return intervals after the insertion. Note that you don't need to modify intervals in-place. You can make a new array and return it. Example 1: Input: intervals = [[1,3],[6,9]], newInterval = [2,5] Output: [[1,5],[6,9]] Example 2: Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8] Output: [[1,2],[3,10],[12,16]] Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10]. Constraints: 0 <= intervals.length <= 104 intervals[i].length == 2 0 <= starti <= endi <= 105 intervals is sorted by starti in ascending order. newInterval.length == 2 0 <= start <= end <= 105
 *
 * Notes:
 * Sometimes better is optimal solution
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //either the part is before overlapping or it is the overlapped part or the part is after the overlapping
        List<int[]> ans = new ArrayList<>();
        int i=0;
        int n = intervals.length;
        //Left part means end of this is smaller than start of new
        while(i<n && intervals[i][1]<newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }

        //middle means the overlapped part
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1] , intervals[i][1]);
            i++;
        }
        ans.add(newInterval);

        //right part 
        while(i<n ){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
