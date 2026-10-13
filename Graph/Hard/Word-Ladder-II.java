/*
 * Word Ladder II
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Hard
 * Time complexity: o(nL^2 + pnL)
 * Space complexity: O(pnL)
 * Solved: 2026-10-13
 * URL: https://leetcode.com/problems/word-ladder-ii/submissions/2171555772/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This is a bit of a competitive programming approach. Here, we are using BFS plus DFS. This is a bit more intuitive than the last solution.  
What we do here is I can find levels that I know, so I will store levels in a map, like a string and at what level it occurred, using BFS. Now I will do DFS using a map or backtracking using a map. I know I have this end word, so I will backtrack. I will go from where this word might have come from by simply converting every character at every index and checking if it is in the map.  
What will happen is, if I have the end word and its level is 6, then whatever the word will be will be one character different, and its level will also be one less. I will check if that new letter, new word, is in the map and its level is also one less. If that is the case, this is my word, so I will add this to my sequence and call DFS using this, going lower. While coming back, I will remove this and also restore the character to its original state.  
The mistake I was making during this word was comparing two strings using the \`==\` operator. Also, we have to do \`Collections.reverse\`. While backtracking, we are starting from the end word and going to the second last and third last, so that thing is in reverse. We have to reverse it, store it in \`answer\`, and then reverse it. As we are backtracking, we are removing the last element, so after reversing, the last element will be the first element. This will interrupt our backtracking method, so we will reverse it back, thus sending the same sequence that we got.  
The algorithm is simple:  
1\. Do BFS.  
2\. Use a map to store values with their levels.  
3\. Call DFS using the end node.
 */

class Solution {
    Map<String,Integer> map;
    List<List<String>> ans;
    String b;
    List<String> seq;
    public void dfs(String word,List<String> seq){
        //mistake 3
        if(word.equals(b)){
            Collections.reverse(seq);
            ans.add(new ArrayList<>(seq));
            Collections.reverse(seq);
            return;
        }
        for(int i=0;i<word.length();i++){
            char [] chars = word.toCharArray();
            char original = chars[i];
                for(char c = 'a';c<='z';c++){
                    chars[i] = c;
                    String next = new String(chars);
                    if(map.containsKey(next) && map.get(word)-1==map.get(next)){
                        seq.add(next);
                        dfs(next,seq);
                        seq.remove(seq.size()-1);
                    }
                }
                chars[i] = original;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //store words in map with its level
        //backtrack using map
        map = new HashMap<>();
        ans = new ArrayList<>();
        b = new String(beginWord);
        seq = new ArrayList<>();
        Set<String> dictionary = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        dictionary.remove(beginWord);

        int level = 0;

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                String word = queue.poll();
                map.put(word,level);
                if(word.equals(endWord)) break;
                for(int j=0;j<word.length();j++){
                char [] chars = word.toCharArray();
                char original = chars[j];
                for(char c = 'a';c<='z';c++){
                    chars[j] = c;
                    String next = new String(chars);
                    if(dictionary.contains(next)){
                        queue.add(next);
                        dictionary.remove(next);
                    }
                }
                chars[j] = original;
                }  
            }
            //mistake 2
            level++;
        }
        if(map.containsKey(endWord)){
            //mistake  1 
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;
    }
}
