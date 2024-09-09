//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2787 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
//时间o(n),空间o(k)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        for(int i = 0; i < k; i++){
            while(!deque.isEmpty() && nums[i] > nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        result[0] = nums[deque.getFirst()];
        for(int i = k; i < nums.length; i++){
            while(!deque.isEmpty() && nums[i] > nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
            while(deque.getFirst() < i - k + 1){
                deque.removeFirst();
            }
            result[i-k+1] = nums[deque.getFirst()];
        }
        return result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
