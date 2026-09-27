/*
 * Longest Subarray With Restricted Pair Sums
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: LeetCode > Weekly Contest
 * Time complexity: O(n)
 * Space complexity: O(501)
 * Solved: 2026-09-27
 * URL: https://leetcode.com/problems/longest-subarray-with-restricted-pair-sums/submissions/2154786645/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int maxSubarray(int[] nums) {
        int n = nums.length;
        int maxlen = 0;
        int i=0 , j=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(j<n){
            int x = nums[j];
            while(i<j){
                boolean valid = true;
                for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                    int y = entry.getKey();
                    if((map.containsKey(x-y)&& (x-y!=y || entry.getValue()>1)) || map.containsKey(x+y)){
                        valid = false;
                        break;
                    }
                }
                if(valid){
                    break;
                }
                //Shrinking part
                int value = nums[i];
                map.put(value,map.get(value)-1);
                if(map.get(value)==0){
                    map.remove(value);
                }
                i++;
            }
            map.put(x,map.getOrDefault(x,0)+1);
            maxlen = Math.max(maxlen,j-i+1);
            j++;

        }
        return maxlen;
    }
}
