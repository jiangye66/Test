//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2305 👎 0


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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0,head);
        ListNode cur = head;
        int n = 0;
        while(cur != null){
            n++;
            cur = cur.next;
        }
        ListNode pre = dummyHead;
        cur = head;
        ListNode tail = cur;
        while(n >= k){
            for(int i = 0; i < k; i++){
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            tail.next.next = pre;
            tail.next = cur;
            pre = tail;
            tail = cur;
            n -= k;
        }
        return dummyHead.next;
    }
}


/*class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0, head);
        int n = 0;
        for(ListNode cur = head; cur != null; cur = cur.next){
            n++;
        }
        ListNode preHead = dummyHead;
        ListNode pre = null, cur = head;
        while(n >= k){
            //'2->1->3->4->5->6' ==> '2->1<-3<-4 5->6' pre是4，cur是5
            for(int i = 0; i < k; i++){
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }

            ListNode tail = preHead.next;   //preHead之前记录了头节点，反转后就是尾结点了
            tail.next = cur;    //把尾结点和下一组相连
            preHead.next = pre; //把上一组的尾巴和反转后的头节点相连
            preHead = tail;     //更新preHead
            n -= k;
        }
        return dummyHead.next;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
