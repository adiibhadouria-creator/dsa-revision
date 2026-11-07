/*
 * Longest String Chain
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > LIS
 * Time complexity: O(nL)^2
 * Space complexity: O(n)
 * Solved: 2026-11-07
 * URL: https://leetcode.com/problems/longest-string-chain/submissions/2191034584/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int longestStrChain(String[] words) {
        //I think sorting can help me
        //Tc-> n log n + n^2(16 x 16)
        //Sc-> n
        Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
        //for(String s:words) System.out.print(s+" ");
        int longest =1 , n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=0; i <n;i++){
            for(int j = 0;j<i;j++){//checking all previous words if they are precedessors or not
                String a = words[i] , b=  words[j];
                if(a.length()-b.length()==1){//must condition
                    for(int x=0;x<a.length();x++){//trying by removing every char
                        StringBuilder sbA = new StringBuilder(a);
                        char removed = sbA.charAt(x);
                        sbA.deleteCharAt(x);
                        if(sbA.indexOf(b)!=-1){
                            dp[i]= Math.max(dp[i],dp[j]+1);
                        }
                        sbA.insert(x,removed);
                    }
                }
            }
            longest = Math.max(longest,dp[i]);
        }
        //System.out.println();
        //for(int x:dp) System.out.print(x+" ");
        return longest;
    }
}
