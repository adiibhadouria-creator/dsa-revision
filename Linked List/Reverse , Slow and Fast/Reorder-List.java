/*
 * Reorder List
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Linked List > Reverse , Slow and Fast
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Solved: 2026-10-01
 * URL: https://leetcode.com/problems/reorder-list/submissions/2159188375/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    ListNode reverse(ListNode node){
        if(node==null || node.next==null){
            return node;
        }
        ListNode curr = node;
        ListNode prev = null;
        while(curr!=null){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head.next==null || head.next.next ==null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = reverse(slow.next);
        slow.next=null;
        ListNode first = head;
        while(second!=null){
            ListNode front1 = first.next;
            ListNode front2 = second.next;

            first.next = second;
            second.next = front1;
            
            first = front1;
            second = front2;
        }
       
    }
}
