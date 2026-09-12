/*
 * Fractional Knapsack | Practice | GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Greedy  > Easy
 * Time complexity: O(N log N) + O(2N)
 * Space complexity: O(N)
 * Solved: 2026-09-12
 * URL: https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Custom operator , creating array of custom operator Item which is also a class
 */

// code here
        
        int n = val.length;
        Item[] items = new Item[n];
        for(int i=0;i<n;i++){
            items[i] = new Item(val[i],wt[i]);
        }
        Arrays.sort(items,(a,b)->{
            double r1 = (double)a.value/a.weight;
            double r2 = (double)b.value/b.weight;
            return Double.compare(r2,r1);
        });
        double ans = 0.0;
        
            for(Item item:items){
                if(item.weight>capacity){
                    ans +=((double)item.value/item.weight) * capacity;
                    break;
                }
                else{
                    ans +=item.value;
                    capacity -= item.weight;
                }
            }
         return ans;
    }
}
