/*
2. 两数相加


给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807


*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode temp = fakeHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int current = carry;
            if (l1 != null) {
                current += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                current += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(current % 10);
            temp = temp.next;
            carry = current / 10;
        }
        if (carry != 0) {
            temp.next = new ListNode(carry);
        }
        return fakeHead.next;
    }
}
