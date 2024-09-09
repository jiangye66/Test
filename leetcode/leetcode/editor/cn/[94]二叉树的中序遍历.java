//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2054 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root,result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result){
        if(root == null)    return;

        dfs(root.left,result);
        result.add(root.val);
        dfs(root.right, result);
    }
}



//迭代,时间o(n),空间O(n)
/*class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null)    return result;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node != null){
                stack.pop();
                if(node.right != null)  stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if(node.left != null)   stack.push(node.left);
            }else{
                stack.pop();
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}*/
//递归,时间o(n),空间O(n)
/*class Solution {

    List<Integer> path = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return path;
    }

    private void dfs(TreeNode root){
        if(root == null)    return ;
        dfs(root.left);
        path.add(root.val);
        dfs(root.right);
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
