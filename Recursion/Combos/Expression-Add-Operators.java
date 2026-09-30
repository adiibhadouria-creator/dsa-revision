/*
 * Expression Add Operators
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: Recursion > Combos
 * Time complexity: O(3^n)
 * Space complexity: O(n)
 * Solved: 2026-09-30
 * URL: https://leetcode.com/problems/expression-add-operators/submissions/2158622878/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    List<String> ans = new ArrayList<>();

    void helper(String s,int target ,int i,String path,long total,long last){
        if(i==s.length()){
            if(total==target){
                ans.add(path);
            }
            return;
        }
        long num=0;
        for(int j=i;j<s.length();j++){
            if(j>i && s.charAt(i)=='0') return;
            num = num*10 + (s.charAt(j)-'0');
            String curr = s.substring(i,j+1);
            if(i==0){
                helper(s,target,j+1,path+curr,num,num);
            }
            else{
                helper(s,target,j+1,path+"+"+curr,total+num,num);
                helper(s,target,j+1,path+"-"+curr,total-num,-num);
                helper(s,target,j+1,path+"*"+curr,total-last+last*num,last*num);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        helper(num,target,0,"",0,0);
        return ans;
    }
}
