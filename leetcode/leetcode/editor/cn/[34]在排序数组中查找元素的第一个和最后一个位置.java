//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2699 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//时间O(logn),空间(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int low = -1, high = -1;
        //最左
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                low = mid;
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        l = 0;
        r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                high = mid;
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{low,high};
    }
}







/*class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int hight = -1, low = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(target > nums[mid]){
                l = mid + 1;
            }else if(target < nums[mid]){
                r = mid - 1;
            }else{
                hight = mid;
                l = mid + 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(target > nums[mid]){
                l = mid + 1;
            }else if(target < nums[mid]){
                r = mid - 1;
            }else{
                low = mid;
                r = mid - 1;
            }
        }
        int[] result = {low,hight};
        return result;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
