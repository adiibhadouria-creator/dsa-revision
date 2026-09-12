/*
 * Count Values With Equally Spaced Occurrences I
 * Difficulty: Easy
 * Topic: Leetcode > Biweekly Contest 191
 * Time complexity: O(2N)
 * Space complexity: O(N)
 * Solved: 2026-09-12
 * URL: https://leetcode.com/contest/biweekly-contest-191/problems/count-values-with-equally-spaced-occurrences-i/
 *
 * Problem statement:
 * You are given an integer array nums. An integer x is called special if: x appears exactly three times in nums. All three occurrences of x are equally spaced in nums. In other words, if all occurrences of x are at indices i1 < i2 < i3, then i2 - i1 = i3 - i2. Return the number of distinct special integers in nums. Example 1: Input: nums = [1,8,1,5,1,5,8,5] Output: 2 Explanation: 1 is special because it occurs exactly three times at equally spaced indices 0, 2, and 4. 5 is special because it occurs exactly three times at equally spaced indices 3, 5, and 7. 8 is not special because it occurs only twice. Therefore, the answer is 2. Example 2: Input: nums = [8,8,8,8] Output: 0 Explanation: 8 is not special because it does not occur exactly three times. Therefore, the answer is 0. Example 3: Input: nums = [8,6,6,8,8] Output: 0 Explanation: 8 occurs at indices 0, 3, and 4, which are not equally spaced. 6 occurs only twice. Therefore, no integer is special. Constraints: 3 <= nums.length <= 100 1 <= nums[i] <= 100
 *
 * Notes:
 * None
 */

class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            List<Integer> list = map.getOrDefault(nums[i],new ArrayList<>());
            list.add(i);
            map.put(nums[i],list);
        }
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            int num = entry.getKey();
            List<Integer> list = entry.getValue();
            if(list.size()==3){
                //This means it has 3 elements only now check the differences
                if(list.get(1)-list.get(0)==list.get(2)-list.get(1)) count++;
            }
        }
        return count;
    }
}

[1,8,1,5,1,5,8,5]
[8,8,8,8]
[8,6,6,8,8]
2
0
0
