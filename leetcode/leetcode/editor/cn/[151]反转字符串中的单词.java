//给你一个字符串 s ，请你反转字符串中 单词 的顺序。 
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 
//
// 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。 
//
// 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 
//输入：s = "  hello world  "
//输出："world hello"
//解释：反转后的字符串中不能存在前导空格和尾随空格。
// 
//
// 示例 3： 
//
// 
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。 
//
// Related Topics 双指针 字符串 👍 1152 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//时间o(n),空间o(n)
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trim(s);
        reverseWord(sb,0,sb.length()-1);
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder trim(String s){
        int l = 0, r = s.length()-1;
        while(s.charAt(l) == ' ')   l++;
        while(s.charAt(r) == ' ')   r--;
        StringBuilder sb = new StringBuilder();
        for(int i = l; i <= r; i++){
            if(s.charAt(i) == ' '){
                if(s.charAt(i-1) != ' '){
                    sb.append(s.charAt(i));
                }
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb;
    }

    private void reverseWord(StringBuilder sb, int l, int r){
        while(l < r){
            char tmp = sb.charAt(l);
            sb.setCharAt(l,sb.charAt(r));
            sb.setCharAt(r,tmp);
            l++;
            r--;
        }
    }

    private void reverseEachWord(StringBuilder sb){
        int l = 0, r = 0;
        while(r <= sb.length()){
            while(r < sb.length() && sb.charAt(r) != ' '){
                r++;
            }
            reverseWord(sb,l,r-1);
            r++;
            l = r;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
