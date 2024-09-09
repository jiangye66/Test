//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3567 👎 0


import org.apache.velocity.util.ArrayListWrapper;

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
//时间复杂度不会分析，什么卡特兰数,空间复杂度o(n)
class Solution {

    StringBuilder path = new StringBuilder();
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n,0,0);
        return result;
    }

    private void dfs(int n, int l, int r){
        if(r > l || l > n)   return ;
        if(path.length() == 2 * n){
            result.add(path.toString());
            return ;
        }

        for(int i = 0; i < 2; i++){
            if(i == 0){
                l++;
                path.append('(');
                dfs(n,l,r);
                path.deleteCharAt(path.length()-1);
                l--;
            }else{
                r++;
                path.append(')');
                dfs(n,l,r);
                path.deleteCharAt(path.length()-1);
                r--;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
