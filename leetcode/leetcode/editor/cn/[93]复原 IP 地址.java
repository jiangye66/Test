//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1410 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
//时间复杂度o(3^4*n),空间复杂度o(n)
class Solution {
    private List<String> result = new ArrayList<>();
    private List<Integer> count = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s,0);
        return result;
    }

    private void dfs(String s, int index){
        if(count.size() == 4 && count.get(3) == s.length()){
            StringBuilder sb = new StringBuilder(s);
            for(int i = 2; i >= 0; i--){
                sb.insert(count.get(i),".");
            }
            result.add(sb.toString());
            return;
        }

        for(int i = index+1; i <= s.length() && i <= index + 4 ; i++){
            String path = s.substring(index,i);
            if(isValid(path)){
                count.add(i);
                dfs(s,i);
                count.remove(count.size()-1);
            }else{
                return ;
            }
        }
    }

    private boolean isValid(String s){
        if(s.length() != 1 && s.charAt(0) == '0')   return false;
        return Integer.parseInt(s) <= 255 ? true : false;
    }
}






/*class Solution {

    private List<String> result;
    private List<String> count;

    public List<String> restoreIpAddresses(String s) {
        List<String> count = new ArrayList<>();
        this.result = new ArrayList<>();
        backTracking(s,0,count);
        return result;
    }

    private void backTracking(String s, int begin, List<String> count){
        if(count.size() == 4){
            if(begin == s.length()){
                result.add(String.join(".",count));
            }
            return ;
        }

        for(int i = 0; i < 3 && i < s.length() - begin; i++){
            String ip = s.substring(begin, begin + i + 1);
            if(isValid(ip)){
                count.add(ip);
                backTracking(s,begin + i + 1,count);
                count.remove(count.size() - 1);
            }else{
                return ;
            }
        }
    }

    private Boolean isValid(String s){
        if(s.length() != 1 && s.charAt(0) == '0') return false;
        return Integer.parseInt(s) <= 255 ? true : false;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
