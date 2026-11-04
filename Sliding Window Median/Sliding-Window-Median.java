/*
 * Sliding Window Median
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Sliding Window Median
 * Time complexity: O(n log k)
 * Space complexity: O(k)
 * Solved: 2026-11-04
 * URL: https://leetcode.com/problems/sliding-window-median/submissions/2189572909/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    TreeMap<Integer,Integer> smaller =new TreeMap<>();
    TreeMap<Integer,Integer> larger = new TreeMap<>();
    int smallSize = 0, largeSize = 0;

    void add(TreeMap<Integer,Integer> map ,int x){
        map.merge(x,1,Integer::sum);
    }
    void delete(TreeMap<Integer,Integer> map ,int x){
        int count = map.get(x);
        if(count ==1) map.remove(x); 
        else map.put(x,count-1);
    }
    void insert(int x){
        if(smaller.isEmpty() || x<=smaller.lastKey()){
            add(smaller,x); 
            smallSize++;
        }
        else {
            add(larger,x); 
            largeSize++;
        }
        balance();
    }
    void  erase(int x){
        if(smaller.containsKey(x)) {
            delete(smaller,x); 
            smallSize--;
        }
        else {
            delete(larger,x); 
            largeSize--;
        }
        balance();
    }
    void balance(){
        while(smallSize > largeSize + 1){
            int x = smaller.lastKey();
            delete(smaller,x); 
            smallSize--;
            add(larger,x); 
            largeSize++;
            
        }
        while(smallSize < largeSize){
            int x = larger.firstKey();
            delete(larger,x); largeSize--;
            add(smaller,x); smallSize++;
        }
    }
     double median(){
            if(smallSize == largeSize){
                return ((long)smaller.lastKey() + larger.firstKey())/2.0;
            }
            else return smaller.lastKey();
        }
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int subarrays = n-k+1;
        double[] medians = new double[subarrays];
        int idx = 0;
        int i=0 , j=0;
        while(j<n){
            //add it into something 
            //if it equals to window size , take the median
            //remove last one
            insert(nums[j]);
            if(j-i+1==k){
                medians[idx++] = median();
                erase(nums[i]);
                i++;
            } 
            j++;
        }
        return medians;
    }
}
