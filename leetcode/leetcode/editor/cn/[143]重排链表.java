//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics 栈 递归 链表 双指针 👍 1465 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode nextHead = reverse(mid.next);
        mid.next = null;
        merge(head,nextHead);
    }

    private ListNode findMid(ListNode head){
        ListNode slow = head,fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null, cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    private void merge(ListNode l1, ListNode l2){
        ListNode tmp1,tmp2;
        while (l2 != null){
            tmp1 = l1.next;
            tmp2 = l2.next;
            l1.next = l2;
            l2.next = tmp1;
            l1 = tmp1;
            l2 = tmp2;
        }
    }
}

/*class Solution {

    private int len;

    public void reorderList(ListNode head) {
        ListNode midNode = findMidNode(head);
        ListNode tailNode = reverseList(midNode.next);
        midNode.next = null;
        mergeList(head,tailNode);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    private ListNode reverseList(ListNode head){
        ListNode pre = null,cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            this.len++;
        }
        return pre;
    }

    private ListNode findMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private void mergeList(ListNode l1, ListNode l2){
        ListNode l1_tmp;
        ListNode l2_tmp;
        while(l1 != null && l2 != null){
            l1_tmp = l1.next;
            l2_tmp = l2.next;
            l1.next = l2;
            l2.next = l1_tmp;
            l1 = l1_tmp;
            l2 = l2_tmp;
        }
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
