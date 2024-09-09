//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2294 👎 0


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
//归并，时间复杂度o(nlogn),空间复杂度o(logn)
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)  return head;

        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(mid);
        return merge(l1,l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null)   cur.next = l1;
        if(l2 != null)   cur.next = l2;
        return dummyHead.next;
    }
}

//自底向上
/*class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null)    return head;
        int len = 0;
        ListNode dummyHead = new ListNode(0,head);
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        for (int step = 1; step < len; step *= 2){
            ListNode tail = dummyHead;
            cur = tail.next;
            while(cur != null){
                ListNode l = cur;
                ListNode r = cut(cur,step);
                cur = cut(r,step);
                tail.next = merge(l,r);
                while(tail.next != null){
                    tail = tail.next;
                }
            }
        }
        return dummyHead.next;
    }

    private ListNode cut(ListNode begin, int step){
        for (int i = 1; i < step; i++) {
            if(begin == null)    return null;
            begin = begin.next;
        }
        if(begin == null)    return null;
        ListNode tail = begin.next;
        begin.next = null;
        return tail;
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null)  cur.next = l1;
        if(l2 != null)  cur.next = l2;
        return dummyHead.next;
    }
}*/

//自顶向下
/*class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)  return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(mid);

        return merge(l,r);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null)  cur.next = l1;
        if(l2 != null)  cur.next = l2;
        return dummyHead.next;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
