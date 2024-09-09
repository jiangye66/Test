//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2705 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
/*class Solution {
    public boolean isSymmetric(TreeNode root) {
        return cheak(root,root);
    }

    private boolean cheak(TreeNode p, TreeNode q){
        if(p == null && q == null)    return true;
        if(p == null || q == null)    return false;
        if(p.val != q.val)  return false;

        boolean left = cheak(p.left,q.right);
        boolean right = cheak(p.right,q.left);

        return left && right;
    }
}*/

//迭代
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return cheak(root.left,root.right);
    }

    private boolean cheak(TreeNode p, TreeNode q){
        Queue<TreeNode> queue = new LinkedList<>();
        if(p == null && q == null)  return true;
        if(p == null || q == null)  return false;
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                p = queue.poll();
                q = queue.poll();
                if(p == null && q == null)  continue;
                if(p == null || q == null)  return false;
                if(p.val != q.val)  return false;
                queue.offer(p.left);
                queue.offer(q.right);
                queue.offer(p.right);
                queue.offer(q.left);
            }
        }
        return true;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
