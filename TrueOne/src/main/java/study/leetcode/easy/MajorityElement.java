package study.leetcode.easy;

import java.util.Arrays;
/**
 *
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *  
 *
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 *  
 *
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 *
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int length = 0;
        if (null == nums ||  (length = nums.length) == 0 ){
            return -1;
        }
        if (length == 1 || (length == 2 && nums[0]==nums[1])){
            return nums[0];
        }
        Arrays.sort(nums);
        int num = (length - 1)/2 ;// 向下取整
        for(int i = 0;i <= num;i++){
            if(nums[i] == nums[num+i]){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3,2,3}));
        System.out.println(new MajorityElement().majorityElement(new int[]{1,2,2,4,2}));
        System.out.println(new MajorityElement().majorityElement(new int[]{1,2,3,4,5}));
        System.out.println(new MajorityElement().majorityElement(new int[]{1,3,3,4,5}));
    }
}
