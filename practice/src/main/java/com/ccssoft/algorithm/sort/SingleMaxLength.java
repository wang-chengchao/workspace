package com.ccssoft.algorithm.sort;

import java.util.Stack;

public class SingleMaxLength {
    public static void main(String[] args) {
        Stack<Character> stack=new Stack<>();
        String str="aaaacdddee";
        int ret=0;
        char[] chars = str.toCharArray();
        for (int i=0;i<chars.length;i++){
            char c=chars[i];
            if (stack.isEmpty()||c==stack.peek()){
                stack.push(c);
            }else {
                int size = stack.size();
                stack.clear();
                stack.push(c);
               ret=Math.max(ret,size);
            }
        }
         ret=Math.max(stack.size(),ret);

        System.out.printf("最长单一字符串长度==>%d",ret);
    }
}
