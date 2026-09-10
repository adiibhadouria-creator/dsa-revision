/*
 * Optimal Approach Explained ! - Java
 * Difficulty: Not specified
 * Topic: Heap > Medium
 * Time complexity: O(n log k)
 * Space complexity: O(k)
 * Solved: 2026-09-10
 * URL: https://www.geeksforgeeks.org/problems/maximum-sum-combination/1
 *
 * Problem statement:
 * You are given two integer arrays a[] and b[] of equal size. A sum combination is formed by adding one element from a[] and one from b[], using each index pair (i, j) at most once. Return the top k maximum sum combinations, sorted in non-increasing order.

Examples:

Input: a[] = [3, 2], b[] = [1, 4], k = 2
Output: [7, 6]
Explanation: Possible sums: 3 + 1 = 4, 3 + 4 = 7, 2 + 1 = 3, 2 + 4 = 6, Top 2 sums are 7 and 6.
Input: a[] = [1, 4, 2, 3], b[] = [2, 5, 1, 6], k = 3
Output: [10, 9, 9]
Explanation: The top 3 maximum possible sums are : 4 + 6 = 10, 3 + 6 = 9, and 4 + 5 = 9
 *
 * Notes:
 * If u sort both the input arrays them choosing first element of both the pairs will give the maximum and thus the next maximum answer can either be with i+1,j or i,j+1
and we can use a pair only once so use a set to store the pairs u have visited and heap for always getting the max sum
 */

PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y)->Integer.compare(y[0],x[0]));
        Set<String> visited = new HashSet<>();
        //Array of sum , i , j
        maxHeap.add(new int[]{a[n-1]+b[n-1],n-1,n-1});
        visited.add((n-1)+","+(n-1));
        ArrayList<Integer> ans = new ArrayList<>();
        while(k>0 && !maxHeap.isEmpty()){
            int[] curr = maxHeap.poll();
            int sum = curr[0];
            int i = curr[1] , j = curr[2];
            ans.add(sum);
            k--;
            
            if(i-1>=0){
                String key = (i-1)+","+j;
                if(!visited.contains(key)){
                    maxHeap.add(new int[]{a[i-1]+b[j],i-1,j});
                    visited.add(key);
                }
            }
            if(j-1>=0){
               String key = (i)+","+(j-1);
                if(!visited.contains(key)){
                    maxHeap.add(new int[]{a[i]+b[j-1],i,j-1});
                    visited.add(key);
                } 
            }
        }
        return ans;
    }
}
