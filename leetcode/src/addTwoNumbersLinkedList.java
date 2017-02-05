/**
 * Created by zhouti8 on 2/3/17.
 */

/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/

//public class addTwoNumbersLinkedList {
//
//
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//        ListNode carryNode, resultNode, preResultNode=null, preCarryNode=null, startResultNode, startCarryNode, leftNode;
//        ListNode l1curr = l1;
//        ListNode l2curr = l2;
//
//        while (l1curr != null || l2curr != null) {
//            int l1currVal = l1curr!=null ? l1curr.val:0;
//            int l2currVal = l2curr!=null ? l2curr.val:0;
//            int resultAllVal = l1currVal + l2currVal;
//            int resultRes = resultAllVal % 10;
//            int resultCarry = resultAllVal / 10;
//            resultNode = new ListNode(resultRes);
//            carryNode = new ListNode(resultCarry);
//            if (preResultNode != null) {
//                preResultNode.next = resultNode;
//            } else {
//                startResultNode = resultNode;
//            }
//            preResultNode = resultNode;
//
//            if (preCarryNode != null) {
//                preCarryNode.next = carryNode;
//            } else {
//                startCarryNode = carryNode;
//            }
//            preCarryNode = carryNode;
//
//            l1curr = l1curr!=null? l1curr.next:null;
//            l2curr = l2curr!=null? l2curr.next:null;
//
//        }
//        carryNode = startCarryNode;
//        boolean hasCarry = false;
//        while (carryNode != null)
//        {
//            if (carryNode.val != 0){
//                hasCarry = true;
//                break;
//            }
//            carryNode = carryNode.next;
//        }
//        if (hasCarry){
//            // add 0 in front of startCarry Node
//            ListNode zeroNode = new ListNode(0);
//            zeroNode.next = startCarryNode;
//            startCarryNode = zeroNode;
//            return addTwoNumbers(startResultNode, startCarryNode);
//        }
//        else{
//            return startResultNode;
//        }
//
//    }
//
//
//}

