//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2295 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

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
//时间o(n),空间o(n)
class Solution {
    int[] preorder;
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.map = new HashMap<Integer,Integer>();
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode buildTree(int pre_l, int pre_r, int in_l, int in_r){
        if(pre_l > pre_r)   return null;

        int rootVal = preorder[pre_l];
        int mid = map.get(rootVal);
        int leftSize = mid - in_l;
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(pre_l+1,pre_l+leftSize,in_l,mid-1);
        root.right = buildTree(pre_l+leftSize+1,pre_r,mid+1,in_r);
        return root;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
