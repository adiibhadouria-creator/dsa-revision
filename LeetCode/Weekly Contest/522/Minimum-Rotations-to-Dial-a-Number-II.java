
 * Notes:
 * we have to find the point where on rotating we get the maximum benefit , so one thing more we do not need to reverse the array every time , after reversing only thing changes the distance of prev element could either be to curr element if not reversedd or it could be with the last element as after reversal that will be our curr , and between them nothing changes as dist(a,b) = dist(b,a).

So just find the maximum diff upon rotating and minus it with the whole cost
 */

class Solution {
    public int dist(int a ,int b){
        int diff = Math.abs(a-b);
        return Math.min(diff,10-diff);
    }
    public int minRotations(int n, String s) {
        //can this work with only one rotation
        int gain =0 , prev =0;
        int last = s.charAt(n-1)-'0';
        int cost =0;
        for(int i=0;i<n;i++){
            int curr = s.charAt(i)-'0';
            cost += dist(prev,curr);
            gain = Math.max(dist(prev,curr)-dist(prev,last),gain);
            prev = curr;
        }
        return cost - gain;
    }
}
