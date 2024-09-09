//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
// 
// 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 636 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
//时间O(n),空间O(n)
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queueNode = new LinkedList<>();
        Deque<Integer> queueIndex = new LinkedList<>();
        queueNode.offer(root);
        queueIndex.addLast(1);
        int max = 1;
        while(!queueNode.isEmpty()){
            int size = queueNode.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queueNode.poll();
                int index = queueIndex.pollFirst();
                if(node.left != null){
                    queueNode.offer(node.left);
                    queueIndex.addLast(index * 2);
                }
                if(node.right != null){
                    queueNode.offer(node.right);
                    queueIndex.addLast(index * 2 + 1);
                }
            }
            if (queueIndex.size() > 1) {
                max = Math.max(max,queueIndex.getLast() - queueIndex.getFirst() + 1);
            }
        }
        return max;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
