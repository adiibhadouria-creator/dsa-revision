----APPROACH-------
Basically this question is alien dictionary dictionary is different from standard dictionary like in standard dictionary. a comes before b , b comes before and c, e comes before F, but an alien dictionary there can be any order.
I have to detect it and return it and if there is no order I have to return empty thing what I'm given is dictionary of words from there. 
I have to find out the order now I have to compare various words to get the order so I need to find what comes before something before something whenever I listen something before something I think of topological sort it gives me ordering so I will apply topological sort here 
but how first of all I will if I am given how many different characters I am given and easy otherwise I will make a present every of 26 alphabets in English then I will find how many of them are present and then I will make a adjacency list of graph of 26 letters and
I will iterate  in the Dictionary comparing adjacent words, and if their characters are equal, then move the pointer, and if characters are not equal means char of string 1  comes before characterof string two, so I will use that for marking it at the adjacency list.
L-> count of all characters across dictionary
TC-> O(L+N)
SC->O(N)
class Solution {
    public String foreignDictionary(String[] words) {
      //find no. of unique elements
        boolean [] present = new boolean[26];
        int count = 0;
        for(String w:words){
            for(char c : w.toCharArray()){
                if(!present[c-'a']) {
                    present[c-'a'] = true; 
                    count++;
                }
            }
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            if(s1.startsWith(s2) && s1.length()> s2.length()) return "";
            int min = Math.min(s1.length(),s2.length());
            for(int ptr = 0;ptr<min;ptr++){
                if(s1.charAt(ptr)!=s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(26,adj,present);
        if(topo.size()!=count) return "";
        StringBuilder order = new StringBuilder();
        for(int i:topo){
            char c = ((char)(i+'a'));
            order.append(c);
        }
        return order.toString();
    }
    private List<Integer> topoSort(int V,List<List<Integer>> adj,boolean[] present){
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(present[i] && indegree[i]==0) queue.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) queue.add(it); 
            }
        }
        return topo;
    }
}
