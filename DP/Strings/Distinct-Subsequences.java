/*
 * Distinct Subsequences
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Strings
 * Time complexity: O(n x m)
 * Space complexity: O(m)
 * Solved: 2026-11-04
 * URL: https://leetcode.com/problems/distinct-subsequences/submissions/2189641589/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * I could not think of this question's approach. I don't know what I was thinking, but if I want to find the number of subsequences of string T in S, then what will be my first thought process? Generate all subsequences of S and check which of them equal T, but this will give exponential time complexity.

What we can do is use the question: in the question, we have to think in terms of indexes i and j. I will be nesting S, and j will be at string T. Then we will figure out what is the thing in the sequence: either I can choose this or not. Either it matches or does not match. There may be multiple subsequences, which we definitely know.

How can we make another subsequence even if we get a subsequence earlier? I got a subsequence at the end of 3 characters in S, and yes, it is equal to T. Then how would I check another substrings of it or another subsequence? Things of it: I have to not take this letter, right? That means we have to play with indexes. How will we play?

If I do not want this character to come in my sequence, I will say, "Go and search before the character 5 - 1." If I want that I should take it, then there will be 2 possibilities: if it does not match, if character S[i] and T[j] are not equal, then what is the need? It will be 0. At this point, there is no subsequence with this ending index at i.

If those are equal, then go and search before J, because I got it. I got 2 characters the same, so I will search for the previous character now in the previous string of S. Just this was the crux: what to skip, what to take. At the end, this could be space-optimized to a 1D array also.

Here, we have also done a shift of indexing for managing the base case. We also optimized from 2D to 1D space. How? For calculating this guy, I need the guy just above and the guy just previous. If I start from 0 to M, then I will be overwriting values. If I start from M to 0, then I just need the previous one and the above one. I need the above one and the previous one, so I am not using that guy anymore. Only once, so that I can convert it to one array 
 */

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m>n) return 0;
        //recusrion -> memoisation -> tabulation -> 2 array space optimisation -> 1 array space optimisation
        int[]dp = new int[m+1];
        for(int i=0;i<=n;i++){
            int [] cur = new int[m+1];
            for(int j=m;j>=0;j--){
                if(i==0 && j!=0) cur[j] = 0;
                else if(j==0) dp[j] = 1;
                else{
                    int match = s.charAt(i-1)==t.charAt(j-1) ? dp[j-1] : 0;
                    int notMatch = dp[j];
                    dp[j]= match + notMatch;
                }
            }
        }
        return dp[m];
    }
}
