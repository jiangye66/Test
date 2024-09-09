//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2802 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.PriorityQueue;

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
//单调队列
/*class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        for(ListNode list : lists){
            if (list != null) {
                queue.offer(list);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            if(node.next != null)   queue.offer(node.next);
            cur.next = node;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}*/
//归并
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)   return null;
        return mergeKList(lists,0,lists.length-1);
    }

    private ListNode mergeKList(ListNode[] lists, int l, int r){
        if(l >= r)  return lists[l];

        int mid = l + (r - l) / 2;
        ListNode left = mergeKList(lists,l,mid);
        ListNode right = mergeKList(lists,mid+1,r);

        return mergeTwoList(left,right);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1 != null)  cur.next = l1;
        if(l2 != null)  cur.next = l2;
        return dummyNode.next;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
