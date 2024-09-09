//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1332 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//时间o(m(n+m)),空间o(m+n)
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))    return "0";
        String result = new String();
        String tmp = new String();
        for(int i = num1.length()-1; i >= 0; i--){
            int add = 0;
            int n1 = num1.charAt(i) - '0';
            StringBuilder sb = new StringBuilder();
            for(int j = num2.length()-1; j >= 0; j--){
                int n2 = num2.charAt(j) - '0';
                int num = n1 * n2 + add;
                sb.append(num % 10);
                add = num / 10;
            }
            if(add != 0)    sb.append(add);
            sb.reverse();
            int count = num1.length() - 1 - i;
            while(count > 0){
                sb.append(0);
                count--;
            }
            tmp = sb.toString();
            result = addString(result,tmp);
        }
        return result;
    }

    private String addString(String s1, String s2){
        int add = 0;
        int i1 = s1.length()-1, i2 = s2.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i1 >= 0 || i2 >= 0){
            int num1 = i1 >= 0 ? s1.charAt(i1--) - '0' : 0;
            int num2 = i2 >= 0 ? s2.charAt(i2--) - '0' : 0;
            int num = num1 + num2 + add;
            sb.append(num % 10);
            add = num / 10;
        }
        if(add != 0)    sb.append(add);
        return sb.reverse().toString();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
