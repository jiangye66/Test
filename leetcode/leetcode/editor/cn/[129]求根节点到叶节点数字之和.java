//给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
//
// 
// 
// 每条从根节点到叶节点的路径都代表一个数字： 
// 
// 
//
// 
// 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 
// 
//
// 计算从根节点到叶节点生成的 所有数字之和 。 
//
// 叶节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：25
//解释：
//从根到叶子节点路径 1->2 代表数字 12
//从根到叶子节点路径 1->3 代表数字 13
//因此，数字总和 = 12 + 13 = 25 
//
// 示例 2： 
// 
// 
//输入：root = [4,9,0,5,1]
//输出：1026
//解释：
//从根到叶子节点路径 4->9->5 代表数字 495
//从根到叶子节点路径 4->9->1 代表数字 491
//从根到叶子节点路径 4->0 代表数字 40
//因此，数字总和 = 495 + 491 + 40 = 1026
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 1000] 内 
// 0 <= Node.val <= 9 
// 树的深度不超过 10 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 738 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
//递归,时间O(n),空间O(n)
/*class Solution {
    private int result = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return result;
    }

    private void dfs(TreeNode root, int sum){
        if(root.left == null && root.right == null){
            result += sum*10 + root.val;
            return;
        }

        if(root.left != null)   dfs(root.left,sum*10+root.val);
        if(root.right != null)  dfs(root.right,sum*10+root.val);
    }
}*/

//迭代,时间O(n),空间O(n)
class Solution {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    sum += node.val;
                    continue;
                }
                if(node.left != null){
                    node.left.val += node.val * 10;
                    queue.offer(node.left);
                }
                if(node.right != null){
                    node.right.val += node.val * 10;
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }
}








//dfs
/*class Solution {
    public int sumNumbers(TreeNode root) {

        return dfs(root,0);
    }

    private int dfs(TreeNode root,int preSum){
        if(root == null)    return 0;
        int sum = preSum * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }else{
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}*/
//DFS
/*class Solution {
    public int sumNumbers(TreeNode root) {
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueNum = new LinkedList<>();
        queueNode.offer(root);
        queueNum.offer(root.val);
        int sum = 0;
        while(!queueNode.isEmpty()){
            TreeNode node = queueNode.poll();
            int num = queueNum.poll();
            TreeNode left = node.left, right = node.right;
            if(left == null && right == null){
                sum += num;
            }else{
                if(left != null){
                    queueNode.offer(left);
                    queueNum.offer(num*10 + left.val);
                }
                if(right != null){
                    queueNode.offer(right);
                    queueNum.offer(num*10 + right.val);
                }
            }
        }
        return sum;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
