/*
 * Evaluate the Bracket Pairs of a StringMed.
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: LeetCode > Daily
 * Time complexity: O(n+m)
 * Space complexity: O(n+m)
 * Solved: 2026-09-26
 * URL: https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/submissions/2153440811/?envType=daily-question&envId=2026-09-26
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * simulation just remember index and methods of string builder
 */

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        //for every key in s which is closed in brackets have a value which is stored in knowledge and maybe it is sequential wise
        //and if that key is not there replace it with ?
        

        //find key in string and have a count which key is this
        // then search in knowledge if keys are same according to count then replace it with this value else ?
        Map<String,String> map = new HashMap<>();
        for(List<String> list:knowledge){
            map.put(list.get(0),list.get(1));
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                int j = s.indexOf(')',i);
                String key = s.substring(i+1,j);
                ans.append(map.getOrDefault(key,"?"));
                i=j;
            }
            else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
