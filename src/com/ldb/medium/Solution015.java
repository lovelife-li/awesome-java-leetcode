package com.ldb.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ldb
 * @date 2019-06-27 16:42
 */
public class Solution015 {

    /**
     * 题目来源于 LeetCode 上第 15 号问题：三数之和。
     * <p>
     * 题目描述
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 *a，b，c ，*使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution015 solution015 = new Solution015();
        System.out.println(solution015.threeSum(new int[]{5, -1, 0, 1, 2, -1, -4}));
    }

    /**
     * 题目需要我们找出三个数且和为 0 ，那么除了三个数全是 0 的情况之外，肯定会有负数和正数，所以一开始可以先选择一个数，然后再去找另外两个数，
     * 这样只要找到两个数且和为第一个选择的数的相反数就行了。也就是说需要枚举 a 和 b ，将 c 的存入 map 即可。
     * <p>
     * 需要注意的是返回的结果中，不能有有重复的结果。这样的代码时间复杂度是 O(n^2)。在这里可以先将原数组进行排序，然后再遍历排序后的数组，
     * 这样就可以使用双指针以线性时间复杂度来遍历所有满足题意的两个数组合。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null && nums.length < 3) return list;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; ++k) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int target = 0 - nums[k];
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i + 1]) ++i;
                    while (i < j && nums[j] == nums[j - 1]) --j;
                    ++i;
                    --j;
                } else if (nums[i] + nums[j] < target) {
                    ++i;
                } else {
                    --j;
                }
            }
        }

        return list;
    }
}
