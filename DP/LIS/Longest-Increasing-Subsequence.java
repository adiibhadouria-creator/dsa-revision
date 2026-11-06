/*
 * Longest Increasing Subsequence
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > LIS
 * Time complexity: O(n log n)
 * Space complexity: O(n)
 * Solved: 2026-11-06
 * URL: https://leetcode.com/problems/longest-increasing-subsequence/submissions/2190986053/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * It is also known as it is also patience sorting. What we do here is, for future reference, if you come here and use normal DP, it will take around O(N^2) to reconstruct the array as well as to get the answer.  
There is a thing known as patience sorting, in which I think we do many of the things I have. I was doing it for around 2 to 2.5 hours, and I figured it out.  
What is the longest increasing subsequence? It is simple by name, and I can understand what it is. How can I get the longest increasing subsequence? If I just add elements one by one that are greater, then why does this greedy fail? This greedy fails because if I am adding just after a greater element, then there might come an element that is smaller than the current greater element, like the last index. There are some elements that I have chosen earlier, so this could have been part of my subsequence.  
What is the blocking window for this? The current greater element. Do you have any way to replace this current greater element? Yes, replace it with something. With what should I replace it? I want to increase my chances of getting the longest. I think I need to make the larger element shorter. What are the larger elements? If I make the largest element that element, then my subsequences will be disrupted because that element is the base for building the subsequence.  
Which element should I replace? Should I simply replace some smaller element? If I replace some smaller element, then this greater element will again disrupt my chances. You can try another case to examine it. I think if I replace just the greater element, then I am increasing chances and I am not disrupting the subsequence. Here, we replace it with the lower bound.  
Here, I have also coded it for printing LIS using backtracking by storing the parent pointer. It is in O(n log n), and I am doing binary search using indexes. This is the new thing I have done.  
Good. The things I have understood are:  
\- How to keep the parent pointer  
\- How we can do binary search using indexes  
That is also pretty cool. Light. Just these two things and alias in O and log n. Pretty good.
 */

class Solution {
    public int lowerBound(int[]nums,int i,List<Integer> list){
        int low = 0 , high = list.size()-1 , ans = high;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[list.get(mid)]>=nums[i]){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] parent = new int[n];
        Arrays.fill(parent,-1);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(list.isEmpty() || nums[list.get(list.size()-1)]<nums[i]){
                
                if(!list.isEmpty()) parent[i] = list.get(list.size()-1);
                list.add(i);
                //if i am creating a new pile means i came because of last elements so just create a backtrace array

            }
            else{
                int idx = lowerBound(nums,i,list);
                if(idx>0) parent[i] = list.get(idx-1);
                list.set(idx,i);
            }
        }
        int curr = list.get(list.size()-1);
        List<Integer> LIS = new ArrayList<>();
        while(curr!=-1){
            LIS.add(nums[curr]);
            curr = parent[curr];
        }
        Collections.reverse(LIS);
        System.out.print("Printing Longest Increasing Subsequence in O(n log n) :");
        for(int x:LIS){
            System.out.print(x+" ");
        }

        return list.size();
    }
}
