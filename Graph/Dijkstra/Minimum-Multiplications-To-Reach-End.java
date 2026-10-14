/*
 * Minimum Multiplications To Reach End
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Graph > Dijkstra
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Solved: 2026-10-14
 * URL: https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This can also be solved using directs, but the main thing is we are moving here level-wise. In this form, levels are known as steps. We have to multiply a number, so it is not in some sense. Simple: just multiply the current value by every element of the other, right? Check.

It is inside time. The aim is to get into a loop. It is not. We will edit into you, and we will also edit into set. Any time while popping out, if I use it, it goes to the end, and then I can determine the number of steps.

One mistake whatever is doing is if not set contains, I was also using it. This created a new constraint, which was not beneficial because some numbers which are created then can also lead me to the end because by month 2003 
 */

class Solution {
    static class Pair{
        int value;
        int steps;
        Pair(int value,int steps){
            this.value = value;
            this.steps = steps;
        }
    }
    public int minSteps(int[] arr, int start, int end) {
        
        if(start == end) return 0;
        Set<Integer> set = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start,0));
        set.add(start);
        while(!queue.isEmpty()){
            Pair top = queue.poll();
            int v = top.value;
            int s = top.steps;
            if(v==end) return s;
            for(int i=0;i<arr.length;i++){
                int currValue = (v*arr[i])%1000;
                if(!set.contains(currValue)){
                    queue.add(new Pair(currValue,s+1));
                    set.add(currValue);
                }
            }
        }
        return -1; 
    }
}
