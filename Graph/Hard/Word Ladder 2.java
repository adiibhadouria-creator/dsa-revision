class Solution {
    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
        
        int len = beginWord.length();
        //this is for constant time lookup for checking words in list
        Set<String> dictionary = new HashSet<>(wordList);
        List<List<String>> sequences = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();

        //addding level 0 in queue for further exploring
        queue.add(new ArrayList<>(Arrays.asList(beginWord)));
        //removing it from dictionary so that i do not come here again which will increase sequences length
        dictionary.remove(beginWord);

        while(!queue.isEmpty()){

            //adding all strings which are used in this particular level , for deleting later so that i dont come there back
            Set<String> usedOnLevel = new HashSet<>();

            int n = queue.size();
            for(int i=0;i<n;i++){
                List<String> currPath = queue.poll();
                String lastWord = currPath.get(currPath.size()-1);
                if(lastWord.equals(endWord)) {
                    sequences.add(new ArrayList<>(currPath));
                    continue;
                }
                //if not then try to create all new words and find it
                char[] chars = lastWord.toCharArray();
                for(int j=0;j<len;j++){
                    //storing original for later restoration
                    char original = chars[j];
                    //trying all indices and all characters
                    for(char c = 'a';c<='z';c++){
                        chars[j] = c;
                        String next = new String(chars);
                        if(dictionary.contains(next)){
                            //creatign new path
                            List<String> newPath = new ArrayList<>(currPath);
                            newPath.add(next);
                            //storing in used for deleting after traversing for whole level
                            usedOnLevel.add(next);
                            queue.add(newPath);
                        }
                    }
                    chars[j] = original;
                }
            }
            dictionary.removeAll(usedOnLevel);
            //means i got an level which has answer so i must break , no need to find further
            if(!sequences.isEmpty()) break;
        }
        return sequences;
    }
}
