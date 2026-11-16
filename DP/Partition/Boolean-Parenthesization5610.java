/*
 * Boolean Parenthesization5610
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: DP > Partition
 * Time complexity: O(n^3)
 * Space complexity: O(n^2)
 * Solved: 2026-11-16
 * URL: https://www.geeksforgeeks.org/problems/boolean-parenthesization5610/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * kind of ways it can make true depends on both side true false so we have to track true and false both
 */

class Solution {
    static int f(int i,int j,String c,int isTrue,int[][][]dp){
        
        if(j==i){
            if(isTrue==1) return c.charAt(i)=='T' ? 1:0;
            else return  c.charAt(i)=='F'?1:0;
        }
        if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];
        int ways = 0;
        for(int ind=i+1;ind<j;ind+=2){
            int lt = f(i,ind-1,c,1,dp);
            int rt = f(ind+1,j,c,1,dp);
            int lf = f(i,ind-1,c,0,dp);
            int rf = f(ind+1,j,c,0,dp);
            
            char op = c.charAt(ind);
            if(op=='&'){
                if(isTrue==1) ways += lt * rt;
                else ways += lt * rf + lf * rt + lf * rf;
            }
            else if(op=='|'){
                if(isTrue==1) ways += lt * rf + lf * rt + lt*rt;
                else ways += lf * rf;
            }
            else{
                if(isTrue==1) ways += lt * rf + rt * lf;
                else ways += lt * rt + lf * rf;
            }
        }
        return dp[i][j][isTrue] = ways;
        
    }
    static int countWays(String s) {
        int n = s.length();
        int[][][]dp = new int[n][n][2];
        for(int[][]mat:dp){
            for(int[]row:mat) Arrays.fill(row,-1);
        }
        return f(0,s.length()-1,s,1,dp);
    }
}
