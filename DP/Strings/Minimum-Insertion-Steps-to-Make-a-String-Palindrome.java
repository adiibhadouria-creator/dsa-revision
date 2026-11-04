/*
 * Minimum Insertion Steps to Make a String Palindrome
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > Strings
 * Time complexity: O(n x n)
 * Space complexity: O(n)
 * Solved: 2026-11-04
 * URL: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/submissions/2189014965/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This is a pretty tricky approach. If I want to make a string a palindrome, what will I do? Root force, if I think. No minimum, no maximum, just to convert it. I will just attach the reverse of it at the last, right? Then it will definitely be a palindrome.

Now I want to do minimum insertions. How can I do minimum insertions? If I can think of it, there may be a palindrome already in it, so why disturb it? Let's keep it intact. Don't change it. The remaining elements which are not in the palindromic subsequence are creating a problem for me. I will just make a copy of it.

The question boils down to how many elements are not in my palindromic subsequence. As I want the minimum insertion, I want my palindromic sequence to be maximum, so I will find the longest palindromic sequence. Those are the elements which are already in place and don't need anything. Whichever are not, those need to be. I will just subtract the length of the string from the length of this longest palindromic subsequence string. Literally, my answer 
 */

class Solution {
    public int minInsertions(String s) {
        //if it itself is palindrome then answer is 0
        return s.length()-lps(s);
    }
    public int lps(String s) {
        int n = s.length();
        int[] prev = new int[n+1];
        for(int i=1;i<=n;i++){
            int[] curr = new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s.charAt(n-j)){
                    curr[j] = 1+ prev[j-1];
                }
                else curr[j] = Math.max(prev[j],curr[j-1]);
            }
            prev = curr;
        }
        return prev[n];
    }
}
