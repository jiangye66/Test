//给你一棵二叉树的根节点
// root ，请你判断这棵树是否是一棵 完全二叉树 。 
//
// 在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含
// 1 到
// 2ʰ 个节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：true
//解释：最后一层前的每一层都是满的（即，节点值为 {1} 和 {2,3} 的两层），且最后一层中的所有节点（{4,5,6}）尽可能靠左。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：false
//解释：值为 7 的节点不满足条件「节点尽可能靠左」。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 100] 内 
// 1 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 287 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.peek();
            if(node != null){
                queue.poll();
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                while(!queue.isEmpty()){
                    if(queue.poll() != null)    return false;
                }
            }
        }
        return true;
    }
}


/*class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                while(!queue.isEmpty()){
                    if(queue.poll() != null)    return false;
                }
            }
        }
        return true;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
