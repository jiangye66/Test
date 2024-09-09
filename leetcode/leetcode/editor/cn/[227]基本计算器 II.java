//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 
//
// 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
//
// Related Topics 栈 数学 字符串 👍 766 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
//时间O(n),空间O(n)
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        s = s.replaceAll(" ", "");
        int num = 0;
        char preSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - '0' >= 0 && c - '0' <= 9) {
                num = num * 10 + c - '0';
            }
            if(c - '0' < 0 || c - '0' > 9 || i == s.length()-1){
                if (preSign == '+') {
                    stack.push(num);
                } else if (preSign == '-') {
                    stack.push(-num);
                } else if (preSign == '*') {
                    int num1 = stack.poll();
                    stack.push(num1 * num);
                } else if (preSign == '/') {
                    int num1 = stack.poll();
                    stack.push(num1 / num);
                }
                num = 0;
                preSign = c;
            }
        }

        int result = 0;
        while(!stack.isEmpty()){
            result += stack.poll();
        }
        return result;
    }
}








/*class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0,sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - '0' >= 0 && c - '0' <= 9) {
                num = num * 10 + c - '0';
            }
            if(c - '0' < 0 || c - '0' > 9 || i == s.length()-1){
                if(preSign == '+'){
                    stack.push(num);
                }
                if(preSign == '-'){
                    stack.push(-1 * num);
                }
                if(preSign == '*'){
                    int top = stack.pop();
                    stack.push(num * top);
                }
                if(preSign == '/'){
                    int top = stack.pop();
                    stack.push(top / num);
                }
                preSign = c;
                num = 0;
            }
        }
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
