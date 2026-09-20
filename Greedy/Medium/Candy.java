/*
 * Intuition
 * Difficulty: Easy
 * Topic: Greedy > Medium
 * Time complexity: O(N)
 * Space complexity: O(1)
 * Solved: 2026-09-18
 * URL: https://leetcode.com/problems/candy/
 *
 * Problem statement:
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings. You are giving candies to these children subjected to the following requirements: Each child must have at least one candy. Children with a higher rating get more candies than their neighbors. Return the minimum number of candies you need to have to distribute the candies to the children. Example 1: Input: ratings = [1,0,2] Output: 5 Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively. Example 2: Input: ratings = [1,2,2] Output: 4 Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively. The third child gets 1 candy because it satisfies the above two conditions. Constraints: 1 <= n == ratings.length <= 5 * 104 0 <= ratings[i] <= 5 * 104
 *
 * Notes:
 * Non intuitive but remember concept of slope and increasing decreasing and plateau and you do not care how much bigger the previous one it you just care is it bigger or not
 */

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        //Assigning 1 candy to each one at starting
        int candies = n , i = 1;
        while(i<n){
            //Either it is plateau
            while(i<n && ratings[i-1]==ratings[i]){
                i++;
                continue;
            }
            //Increasing slope
            int peak = 0;
            while(i<n && ratings[i]>ratings[i-1]){
                peak++; 
                candies += peak; 
                i++;
            }
            //Or it is down slope
            int dip =0;
            while(i<n && ratings[i]<ratings[i-1]){
                dip++;
                candies += dip; 
                i++;
            }
            //Remove overlapping candies
            candies -= Math.min(dip,peak);
            
        }
        return candies;
    }
}
