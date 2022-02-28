package leetcode.editor.cn.huawei.simple;

import java.util.*;

/**
 * 栈、字符串
 *
 * 有效的括号
 */
public class P20 {

    public static void main(String[] args) {
        P20 p20 = new P20();
        System.out.println(p20.isValid2("{}[]{[]}"));
    }

    public boolean isValid2(String s){
        Map<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        Stack<Character> stack = new Stack<>();


        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            //如果是左括号，就进栈

            //如果是右括号，就尝试匹配
            if (map.containsKey(chs[i])){
                if (stack.peek().equals(chs[i])){

                }
            }else {
                stack.push(chs[i]);
            }
        }

        return false;
    }
}
