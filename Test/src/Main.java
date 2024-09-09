public class Main {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(){};
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;

        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        TreeNode root = createTree(nums,0);
        dfs(root);
    }

    private static TreeNode createTree(int[] nums, int i){
        if(i >= nums.length) return null;
        TreeNode node = new TreeNode(nums[i]);
        if(i * 2 + 1< nums.length) node.left = createTree(nums,i * 2 + 1);
        if(i * 2 + 2< nums.length) node.right = createTree(nums,i * 2 + 2);
        return node;
    }

    private static void dfs(TreeNode root){
        if(root == null)    return ;
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}