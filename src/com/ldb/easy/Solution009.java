package com.ldb.easy;

/**
 * @author ldb
 */
public class Solution009 {

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     *
     * 进阶:
     * 你能不将整数转为字符串来解决这个问题吗？
     * @param args
     */
    public static void main(String[] args) {
        Solution009 solution = new Solution009();

        System.out.println(solution.isPalindrome1(1221));
    }

    /**
     * 解法一：普通解法
     * 最好理解的一种解法就是先将 整数转为字符串 ，然后将字符串分割为数组，只需要循环数组的一半长度进行判断对应元素是否相等即可。
     * @param x
     * @return
     */
    ///简单粗暴，看看就行
    public boolean isPalindrome1(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

    /**
     * 解法二：进阶解法---数学解法
     * 通过取整和取余操作获取整数中对应的数字进行比较。
     *
     * 举个例子：1221 这个数字。
     *
     * 通过计算 1221 / 1000， 得首位1
     * 通过计算 1221 % 10， 可得末位 1
     * 进行比较
     * 再将 22 取出来继续比较
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }


    public boolean isPalindrome3(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
