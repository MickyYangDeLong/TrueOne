package study.leetcode.middle.two.num.add;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Auther Micky
 * @Date 2020-07-18 9:15
 */
public class SolutionTest {
    static Solution solution = new Solution();

    @Test
    public  void test1() {
        handler(new int[]{1,8},
                new int[]{0},
                new int[]{1,8});

        handler(new int[]{9,8},
                new int[]{1},
                new int[]{0,9});

        handler(new int[]{1,9},
                new int[]{8},
                new int[]{9,9});

        handler(new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{5,7,9});

        handler(new int[]{1,8,9},
                new int[]{9,9,9},
                new int[]{0,8,9,1});

        handler(new int[]{9,9},
                new int[]{1},
                new int[]{0,0,1});

        handler(new int[]{9,9,9,9},
                new int[]{1},
                new int[]{0,0,0,0,1});
    }


    public  void handler(int[] firstNum,int[] secondNum,int[] preResult) {
        Solution.ListNode listNodeLast = solution.addTwoNumbers(buildListNode(firstNum), buildListNode(secondNum));
        Solution.ListNode next = listNodeLast;
        for (int i : preResult) {
            Assert.assertEquals(next.val,i);
            next = next.next;
        }
        System.out.println(new Gson().toJson(listNodeLast));
        System.out.println("=====================");
    }

    Solution.ListNode buildListNode(int[] args){
        if (null == args){
            return null;
        }
        Solution.ListNode head = solution.new ListNode(args[0]);
        Solution.ListNode next = head;
        for (int i = 1; i<args.length; i++) {
            next = (next.next = solution.new ListNode(args[i]));
        }
        return head;
    }
}
