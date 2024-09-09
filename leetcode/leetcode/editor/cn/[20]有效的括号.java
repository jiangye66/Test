//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4440 👎 0


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
//时间复杂度o(n),空间复杂度o(n)
class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && map.containsKey(stack.peek())){
                if(map.get(stack.peek()) == s.charAt(i)){
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}

//先右括号再左括号会快一点
/*class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                if(stack.isEmpty() || stack.getFirst() != map.get(cur)) return false;
                stack.removeFirst();
            }else{
                stack.addFirst(cur);
            }

        }
        return stack.isEmpty();
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
