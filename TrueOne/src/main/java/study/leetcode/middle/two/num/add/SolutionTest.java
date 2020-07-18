package study.leetcode.middle.two.num.add;

import com.google.gson.Gson;

/**
 * @Auther Micky
 * @Date 2020-07-18 9:15
 */
public class SolutionTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.ListNode listNode1 = solution.new ListNode(1);
        Solution.ListNode next = listNode1;
        next = next.next = solution.new ListNode(9);
        // next = next.next = solution.new ListNode(9);
        Solution.ListNode listNode2 = solution.new ListNode(8);
        next = listNode2;
       /* next = next.next = solution.new ListNode(6);
        next.next = solution.new ListNode(4);*/

        Solution.ListNode listNodeLast = solution.addTwoNumbers(listNode1,listNode2);
        System.out.println(new Gson().toJson(listNodeLast));
    }

    buil
}
