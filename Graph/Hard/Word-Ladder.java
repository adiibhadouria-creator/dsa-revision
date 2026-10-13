/*
 * Word Ladder
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Graph > Hard
 * Time complexity: O(n*L*26)
 * Space complexity: O(n*L)
 * Solved: 2026-10-13
 * URL: https://leetcode.com/problems/word-ladder/submissions/2171219056/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Now, how will I think that this question is about a graph? Actually, it is not about a graph. It is about BFS, breadth-first search. How will I think that it is about breadth-first search? There is at most one change in two adjacent words. This is the first condition to go to the next word. To get to the next word, I have to change one thing, which means I can go to the next level. That gives me an idea for such level-order traversal.  
  
Now, I can either create an adjacency list, but that will be complicated, as there are only 26 lowercase letters given, so I will type it, replacing all 26 characters. What is my basic algorithm for this question? First of all, I will use a set for bigger lookup, otherwise it will take end time. I will check if my end word is not in the set, meaning my destination is not in the set, then I will return 0, meaning I cannot reach the end word.  
  
Else, I will add my begin word to the queue, and I will remove it from the set. Why am I removing it from the set? So that I don't get back to it while I convert any string to another string to check whether it is hashed or not. If it comes again, then it will again go back to itself, but that is not what the question asks for.  
  
I will add the begin word to the queue, remove it from the set, and mark my distance as 0 or steps as 0. Now I will do this until my queue is not empty. Whenever I move to one level, I will increase my distance. For one level, I will pop out all the top elements from it and check whether this equates to my destination or end word. If yes, then I will return the current distance. If not, then I will traverse through each character of the word. For each character, I will try to replace it with A to Z. If any character fits and is also found in the set, that means that is my next word. That means, by changing only one word, I can get the next element.  
  
Another follow-up: going from A to Z. One more thing: we have to store the original here. That was my mistake. After trying all 26 combinations, I have to get back to my original string. Otherwise, it will never be the same. Also, we cannot compare strings using the \`==\` operator. We have to use the \`.equals\` method. Then we will check for every index and every character. If at any time my set contains that string, then I will add it to my queue and remove it from my set. After doing all this, I will set it back to the original string. If it is found, then I would have returned earlier. If it is not found, then I will return 0, meaning I cannot reach
 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(new StringBuilder(beginWord));
        dict.remove(beginWord);
        int distance = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            distance++;
            for(int i=0;i<n;i++){//this loop is for all elements in queue
                StringBuilder next = queue.poll();
               
                if(next.toString().equals(endWord)) return distance;
                for(int j=0;j<next.length();j++){//this loop is for replacing all indexes to check for word
                    char original = next.charAt(j);
                    for(int k=0;k<26;k++){//this loop for trying all characters
                        next.setCharAt(j,(char)('a'+k));
                        if(dict.contains(next.toString())){
                            queue.add(new StringBuilder(next));
                            dict.remove(next.toString());
                        }
                    }
                    next.setCharAt(j,original);
                }
            }
        }
        return 0;
    }
}
