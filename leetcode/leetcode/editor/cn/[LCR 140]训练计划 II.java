//给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [2,4,7,8], cnt = 1
//输出：8 
//
// 
//
// 提示： 
//
// 
// 1 <= head.length <= 100 
// 0 <= head[i] <= 100 
// 1 <= cnt <= head.length 
// 
//
// 
//
// Related Topics 链表 双指针 👍 513 👎 0


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
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode dummyHead = new ListNode(0,head);
        while(cnt > 0){
            dummyHead = dummyHead.next;
            cnt--;
        }
        while(dummyHead.next != null){
            dummyHead = dummyHead.next;
            head = head.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
