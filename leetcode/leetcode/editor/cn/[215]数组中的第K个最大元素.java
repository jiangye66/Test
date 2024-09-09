//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2438 👎 0


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int result = fastFind(0,nums.length-1,k);
        return result;
    }

    private int fastFind(int l, int r, int k){
        int index = partition(l,r);
        if(index > nums.length - k){
            return fastFind(l,index-1,k);
        }else if(index < nums.length - k){
            return fastFind(index+1,r,k);
        }
        return nums[index];
    }

    private int partition(int l, int r){
        int mid = l + (r - l) / 2;
        swap(l,mid);
        int start = l,base = nums[l];
        while(l < r){
            while(l < r && nums[r] >= base) r--;
            while(l < r && nums[l] <= base) l++;
            swap(l,r);
        }
        swap(l,start);
        return l;
    }

    private void swap(int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/*class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}*/

//快排
//class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        int result = fastSelect(nums,0,nums.length-1,k);
//        return result;
//    }
//
//    public int fastSelect(int[] nums, int l, int r, int k){
//        int pos = partition(nums, l, r);
//        if(pos == k-1)  return nums[pos];
//        else if(pos > k-1) return fastSelect(nums, l, pos-1, k);
//        return fastSelect(nums, pos + 1, r, k);
//    }
//
//    public int partition(int[] nums, int l, int r){
//        int pivot = new Random().nextInt(r - l + 1) + l;
//        int i = l;
//        swap(nums,pivot,r);
//        for(int j = l; j < r; j++){
//            if(nums[j] > nums[r]){
//                swap(nums,j,i);
//                i++;
//            }
//        }
//        swap(nums,i,r);
//        return i;
//    }
//
//    public void swap(int[] nums,int i, int j){
//        if(i == j)  return;
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//}


//leetcode submit region end(Prohibit modification and deletion)
