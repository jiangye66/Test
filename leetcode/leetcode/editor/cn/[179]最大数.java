//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 字符串 排序 👍 1271 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(ss,(a,b)->{
           String x = a+b,y = b+a;
           return y.compareTo(x);
        });
        StringBuilder sb = new StringBuilder();
        for(String s : ss) {
            sb.append(s);
        }
        int start = 0;
        while(sb.charAt(start) == '0' && start < sb.length()-1) start++;
        return sb.substring(start);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
