//给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10⁹ + 7 取模。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//rabbbit
//rabbbit
//rabbbit 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1219 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String t, String s) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.fill(dp[0],1);
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chart.length; j++) {
                if(chars[i] == chart[j]){
                    dp[i+1][j+1] = dp[i+1][j] + dp[i][j];
                }else{
                    dp[i+1][j+1] = dp[i+1][j];
                }
//                System.out.print(dp[i+1][j+1] + " ");
            }
        }
        return dp[s.length()][t.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
