package week2;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;

        int cnt = 0;
        while(cnt < n) {
            end = end.next;
            cnt++;
        }

        if (end == null) {
            head = head.next;
            return head;
        }

        ListNode cur = head;


        while(true) {
            if (end.next == null) {
                cur.next = cur.next.next;
                break;
            }

            cur = cur.next;
            end = end.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}