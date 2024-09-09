//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 828 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//时间复杂度o(n),空间复杂度o(n)
class Solution {
    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while(i1 >= 0 || i2 >= 0){
            int num11 = i1 >= 0 ? num1.charAt(i1--) - '0' : 0;
            int num22 = i2 >= 0 ? num2.charAt(i2--) - '0' : 0;
            int num = num11 + num22 + add;
            sb.append(num % 10);
            add = num / 10;
        }
        if(add == 1)    sb.append(add);
        return sb.reverse().toString();
    }
}

/*class Solution {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length()-1;
        int l2 = num2.length()-1;
        StringBuilder result = new StringBuilder();
        int add = 0, i1 = 0, i2 = 0;
        while(l1 >= 0 || l2 >= 0){
            i1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            i2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            result.append((i1+i2+add) % 10);
            add = (i1+i2+add)/10;
            l1--;
            l2--;
        }
        if(add == 1)    result.append(1);
        return result.reverse().toString();
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
