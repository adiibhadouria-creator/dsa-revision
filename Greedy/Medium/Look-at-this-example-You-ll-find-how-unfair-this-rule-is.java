/*
 * Look at this example. You'll find how unfair this rule is.
 * Difficulty: Easy
 * Topic: Greedy > Medium
 * Time complexity: O(3N)
 * Space complexity: O(2N)
 * Solved: 2026-09-15
 * URL: https://leetcode.com/problems/candy/
 *
 * Problem statement:
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings. You are giving candies to these children subjected to the following requirements: Each child must have at least one candy. Children with a higher rating get more candies than their neighbors. Return the minimum number of candies you need to have to distribute the candies to the children. Example 1: Input: ratings = [1,0,2] Output: 5 Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively. Example 2: Input: ratings = [1,2,2] Output: 4 Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively. The third child gets 1 candy because it satisfies the above two conditions. Constraints: 1 <= n == ratings.length <= 5 * 104 0 <= ratings[i] <= 5 * 104
 *
 * Notes:
 * Just simulation of the problem statement , brute force
 */

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] left = new int[n];
        left[0] = 1;

        int[] right = new int[n];
        right[n-1] = 1;

        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                left[i] = left[i-1]+1;
            }
            else{
                left[i]=1;
            }
        }

        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                right[i] = right[i+1]+1;
            }
            else{
                right[i] = 1;
            }
        }
        int candies = 0;
        for(int i=0;i<n;i++){
            candies += Math.max(right[i],left[i]);
        }
        return candies;
    }
}
