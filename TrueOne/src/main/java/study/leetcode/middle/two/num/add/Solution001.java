package study.leetcode.middle.two.num.add;

import com.google.gson.Gson;

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

public class Solution001 {
    public static void main(String[] args) {
        Solution001 solution = new Solution001();
        ListNode listNode1 = solution.new ListNode(2);
        ListNode next = listNode1;
        next = next.next = solution.new ListNode(4);
        next = next.next = solution.new ListNode(3);
        ListNode listNode2 = solution.new ListNode(5);
        next = listNode2;
        next = next.next = solution.new ListNode(6);
        next.next = solution.new ListNode(4);

        ListNode listNodeLast = solution.addTwoNumbers(listNode1,listNode2);
        System.out.println(new Gson().toJson(listNodeLast));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head, nodeNext;
        head = new ListNode(l1.getVal() + l2.getVal());
        ListNode listNode1Next = l1.getNext();
        ListNode listNode2Next = l2.getNext();
        nodeNext = head;
        int high = 0;
        int twoNumberAddresult;
        boolean twoNumberAddresultBigThen10;
        while (true) {
            if (listNode1Next == null && listNode2Next == null) {
                return head;
            } else if (listNode1Next == null) {
                buildHeadNode(listNode2Next, nodeNext, high);
                return head;
            } else if (listNode2Next == null) {
                buildHeadNode(listNode1Next, nodeNext, high);
                return head;
            }
            twoNumberAddresult = listNode1Next.getVal() + listNode2Next.getVal() + high;
            twoNumberAddresultBigThen10 = twoNumberAddresult >= 10;
            high = twoNumberAddresultBigThen10 ? 1 : 0;
            nodeNext = (nodeNext.next = new ListNode(twoNumberAddresultBigThen10 ? 0 : twoNumberAddresult));
            listNode1Next = listNode1Next.getNext();
            listNode2Next = listNode2Next.getNext();
        }
    }

    private void buildHeadNode(ListNode listNode, ListNode nodeNext, int high) {
        int val = listNode.getVal();
        while (true) {
            if (high <= 0 || val < 9) {
                nodeNext.next = listNode;
                return;
            } else {
                listNode = listNode.getNext();
                if (listNode == null) {
                    nodeNext.next = new ListNode(1);
                    return;
                }

                nodeNext = (nodeNext.next = new ListNode(0));
                high = 1;
                val = listNode.getVal();
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