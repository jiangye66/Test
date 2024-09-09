//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1173 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if(root == null) return result;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node != null){
                stack.pop();
                stack.push(node);
                stack.push(null);
                if(node.right != null)  stack.push(node.right);
                if(node.left != null)  stack.push(node.left);
            }else{
                stack.pop();
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
//递归
/*class Solution {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root){
        if(root == null)    return;
        dfs(root.left);
        dfs(root.right);
        result.add(root.val);
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
