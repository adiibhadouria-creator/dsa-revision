/*
 * Minimum Sum Partition3317
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: DP > Subsequences
 * Time complexity: O(n*sum)
 * Space complexity: O(n)
 * Solved: 2026-11-02
 * URL: https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * The fun about this approach is that the question is all-subsets sum = target. If I look at the DP table, or tabulation table, of it, at the last index I know whether this sum is possible, whether 2 is possible, whether 3 is possible, whether 4 is possible. I have used that in this question. If I could have figured it out on my own, this would be mind-blowing. 
 */

class Solution {
    public int minDifference(int arr[]) {
        // code here
        //count subsets with sum k
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        boolean[] prev = new boolean[sum+1];
        prev[0] = true;
        if(arr[0]<=sum) prev[arr[0]] = true;
        
        for(int i=1;i<n;i++){
            boolean[] curr = new boolean[sum+1];
            curr[0] = true;
            for(int j=1;j<=sum;j++){
                boolean notPick = prev[j];
                boolean pick = arr[i]<=j ? prev[j-arr[i]] : false;
                
                curr[j] = pick || notPick;
            }
            prev = curr;
        }
        int min = (int)1e8;
        for(int i=0;i<=sum;i++){
            if(prev[i]==true){
                int s1 = i;
                int s2 = sum - i;
                min = Math.min(min,Math.abs(s1-s2));
            }
        }
        return min;
    }
    
}
