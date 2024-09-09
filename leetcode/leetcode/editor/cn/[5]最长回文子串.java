//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 7156 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int l = 0, r = 0;
        for(int i = len - 2; i >= 0; i--){
            for(int j = i + 1; j < len; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i == 1 || dp[i+1][j-1] == true)){
                    dp[i][j] = true;
                    if(j - i > r - l){
                        l = i;
                        r = j;
                    }
                }

            }
        }
        return s.substring(l,r+1);
    }
}

/*class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int l = 0, r = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j] && (j - i <= 1 || dp[i + 1][j - 1] == true)) {
                    dp[i][j] = true;
                    if (j - i > r - l) {
                        l = i;
                        r = j;
                    }
                }
            }
        }

        return s.substring(l, r + 1);
    }
}*/
//    中心扩散法
//    public String longestPalindrome(String s) {
//        int start = 0, end = 0;
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            int len1 = palindromeLen(chars, i, i ,1);
//            int len2 = palindromeLen(chars, i, i+1 ,2);
//            int len = Math.max(len1,len2);
//            if(len > end - start){
//                end = i + len / 2;
//                start = i - (len-1)/2;
//            }
//        }
//        String result = s.substring(start,end+1);
//        return result;
//    }
//
//    public int palindromeLen(char[] chars, int begin, int end, int len){
//        while(begin >= 0 && end < chars.length && chars[begin] == chars[end]){
//            len += 2;
//            begin--;
//            end++;
//        }
//        return len-2;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
