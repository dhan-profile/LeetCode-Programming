/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head.next;
        ListNode prev = head;
        int indx = 1;
        int min = -1;
        int count = 0;
        int minDistance = Integer.MAX_VALUE;
        int max = -1;
        int maxDistance = 0;
        while(temp.next != null){
            if(prev.val < temp.val && temp.val > temp.next.val){
                count++;
                if(min == -1){
                    min = indx;
                    max = indx;
                }else{
                    minDistance = Math.min(indx-min, minDistance);
                    min = indx;
                    maxDistance = indx-max;
                }
            }else if(prev.val > temp.val && temp.val < temp.next.val){
                count++;
                if(min == -1){
                    min = indx;
                    max = indx;
                }else{
                    minDistance = Math.min(indx-min, minDistance);
                    min = indx;
                    maxDistance = indx-max;
                }
            }
            indx++;
            prev = temp;
            temp = temp.next;
        }
        if(count <2){
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};

    }
}