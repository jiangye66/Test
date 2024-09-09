//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2497 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
//时间o(n),空间o(n)
class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '(')  dp[i] = 0;
            else{
                if(s.charAt(i-1) == '(')    dp[i] = i > 1 ? dp[i-2] + 2 : 2;
                else if(s.charAt(i-1) == ')'){
                    if(i - dp[i-1] - 1 >= 0 && s.charAt(i-dp[i-1]-1) == '('){
                        dp[i] = i-dp[i-1]-1 >= 1 ? dp[i-1] + 2 + dp[i-dp[i-1]-2] : dp[i-1] + 2;
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
