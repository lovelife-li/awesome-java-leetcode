package com.ldb.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ldb
 */
public class Solution001 {

    /**
     * LeetCode 第 1 号问题：两数之和
     * 题目描述
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        int[] nums = new int[]{2, 1, 11, 15, 7};
        int target = 9;
        int[] sum1 = solution001.twoSum1(nums, target);
        int[] sum2 = solution001.twoSum1(nums, target);
        System.out.println(Arrays.toString(sum1));
        System.out.println(Arrays.toString(sum2));

    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 设置一个 map 容器 record 用来记录元素的值与索引，然后遍历数组 nums。
     *
     * 每次遍历时使用临时变量 complement 用来保存目标值与当前值的差值
     * 在此次遍历中查找 record ，查看是否有与 complement 一致的值，如果查找成功则返回查找值的索引值与当前变量的值 i
     * 如果未找到，则在 record 保存该元素与索引值 i
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        map.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.get(temp)!=null){
                return new int[]{i,map.get(temp)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
