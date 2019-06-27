package com.ldb.medium;

import com.ldb.structure.ListNode;

/**
 * @author ldb
 */
public class Solution002 {

    /**
     * 题目描述
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */

    public static void main(String[] args) {
        Solution002 solution002 = new Solution002();
        ListNode.print(solution002.addTwoNumbers(
                ListNode.createTestData("[2,4,3,2]"),
                ListNode.createTestData("[5,6,4]")
        ));

    }


    /**
     * 设立一个表示进位的变量carried，建立一个新链表，把输入的两个链表从头往后同时处理，每两个相加，将结果加上carried后的值作为一个新节点到新链表后面。
     *
     * @return
     */
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode newListNode = new ListNode(-1);
        ListNode current = newListNode;
        int carried = 0;
        while (list1 != null || list2 != null) {
            int a = list1 != null ? list1.val : 0;
            int b = list2 != null ? list2.val : 0;
            current.next = new ListNode((a + b + carried) % 10);
            carried = (a + b + carried) / 10;
            current = current.next;
            list1 = list1 != null ? list1.next : null;
            list2 = list2 != null ? list2.next : null;
        }
        current.next = carried > 0 ? new ListNode(1) : null;
        return newListNode.next;
    }
}
