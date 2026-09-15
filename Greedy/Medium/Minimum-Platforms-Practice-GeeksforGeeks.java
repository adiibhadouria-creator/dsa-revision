/*
 * Minimum Platforms | Practice | GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Greedy > Medium
 * Time complexity: O(2*nlogn)
 * Space complexity: O(1)
 * Solved: 2026-09-15
 * URL: https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Either merge both the arrays and sort them and on arrival increase the platform count but this will also consume space complexity , so sort both arrays individually and traverse and check if arrival Time is greater then increase the platform else decrease the platform


Brute force - There will be only 4 conditions , use a nested loop and use that 4 conditions
 */

class Solution {
    
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0;
        int platforms = 0;
        int maxPlatforms = 0;
        while(i<arr.length && j<dep.length){
           if(arr[i]<=dep[j]){
                platforms++;
                maxPlatforms = Math.max(maxPlatforms,platforms); 
                i++;
            }
            else{
                platforms--;
                j++;
            }
        }
        return maxPlatforms;
       
    }
}
