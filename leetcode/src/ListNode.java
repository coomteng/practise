/**
 * Created by zhouti8 on 2/3/17.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void output() {
        ListNode cur = this;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public ListNode reverse(){
        if (this.next == null){
            return this; // one element in Linkedlist
        }
        ListNode pre = this;
        ListNode cur = pre.next;
        ListNode after = cur.next;
        pre.next = null;
        while (true){
            cur.next = pre;
            if (after == null) break;
            pre = cur;
            cur = after;
            after = cur.next;
        }
        return cur;
    }

    public static ListNode FromArray(int[] arr1){
        // make a List from int array
        if (arr1.length==0) return null;
        ListNode startNode = new ListNode(arr1[0]);
        ListNode preNode = startNode;
        for (int i=1;i<arr1.length;i++){
            ListNode currNode = new ListNode(arr1[i]);
            preNode.next = currNode;
            preNode = currNode;
        }
        return startNode;
    }
}
