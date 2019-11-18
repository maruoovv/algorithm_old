class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }    
        
        return mergeSort(head);
    }
    
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }    
        
        ListNode leftHalf = head;
        ListNode prev = null;
        ListNode rightHalf = head;
        
        while (rightHalf != null && rightHalf.next != null) {
            prev = leftHalf;
            leftHalf = leftHalf.next;
            rightHalf = rightHalf.next.next;
            
        }
        
        prev.next = null;
        
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(leftHalf);
        
        return merge(left, right);
    }
    
    public ListNode merge(ListNode left, ListNode right) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        
        while (left != null && right != null) {
            if (left.val > right.val) {
                cur.next = right;
                right = right.next;
            } else {
                cur.next = left;
                left = left.next;
            }
            
            cur = cur.next;
        }
        
        if (left != null) {
            cur.next = left;
        }
        
        if (right != null) {
            cur.next = right;
        }
        
        return res.next;
    }
    
}
