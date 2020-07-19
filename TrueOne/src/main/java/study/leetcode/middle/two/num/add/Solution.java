package study.leetcode.middle.two.num.add;

import java.io.Serializable;

/**
 * @Auther Micky
 * @Date 2020-07-17 22:58
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head, nodeNext;
        int high = 0;
        int twoNumberAddresult = l1.val + l2.val;
        boolean twoNumberAddresultBigThen10;
        twoNumberAddresultBigThen10 = twoNumberAddresult >= 10;
        high = twoNumberAddresultBigThen10 ? 1 : 0;
        head = new ListNode(twoNumberAddresult % 10);
        ListNode listNode1Next = l1.next;
        ListNode listNode2Next = l2.next;
        nodeNext = head;
        while (true) {
            if (listNode1Next != null && listNode2Next != null) {
                twoNumberAddresult = listNode1Next.val + listNode2Next.val + high;
                twoNumberAddresultBigThen10 = twoNumberAddresult >= 10;
                high = twoNumberAddresultBigThen10 ? 1 : 0;
                nodeNext = (nodeNext.next = new ListNode(twoNumberAddresult % 10));
                listNode1Next = listNode1Next.next;
                listNode2Next = listNode2Next.next;
                continue;
            }  if (listNode1Next == null && listNode2Next == null) {
                if (high >0){
                    nodeNext.next = new ListNode(1);
                }
                return head;
            } else if (listNode1Next == null) {
                buildHeadNode(listNode2Next, nodeNext, high);
                return head;
            } else {
                buildHeadNode(listNode1Next, nodeNext, high);
                return head;
            }
        }
    }

    private void buildHeadNode(ListNode listNode, ListNode nodeNext, int high) {
        int val = listNode.val;
        while (true) {
            if (high <= 0 || val < 9) {
                listNode.val = val + high;
                nodeNext.next = listNode;
                return;
            } else {
                listNode = listNode.next;
                nodeNext = (nodeNext.next = new ListNode(0));
                if (listNode == null) {
                    nodeNext.next = new ListNode(1);
                    return;
                }
                high = 1;
                val = listNode.val;
            }
        }
    }

    /**
     * Definition for singly-linked list.
     */
    class ListNode implements Serializable {
        static final long serialVersionUID = 4353456346346342L;

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }
    }
}