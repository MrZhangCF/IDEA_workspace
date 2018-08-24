package com.zhangcf.code;

import java.util.Stack;

public class N2 {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0){
            return 0;
        }
        if (tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }
        Stack<String> stack = new Stack<>();
        stack.push(tokens[0]);
        stack.push(tokens[1]);
        int res = 0;
        for (int i = 2; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-")|| tokens[i].equals("*")|| tokens[i].equals("/")){
                String b = stack.pop();
                String a = stack.pop();
                Integer temp = oper(b,a,tokens[i]);
                stack.push(temp.toString());
            }else {
                stack.push(tokens[i]);
            }

        }
        res = Integer.parseInt(stack.pop());
        return res;
    }

    private int oper(String b, String a, String flag) {
        switch (flag){
            case "+":
                return Integer.parseInt(a) + Integer.parseInt(b);
            case "-":
                return Integer.parseInt(a) - Integer.parseInt(b);
            case "*":
                return Integer.parseInt(a) * Integer.parseInt(b);
            case "/":
                return Integer.parseInt(a) / Integer.parseInt(b);
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] strings = {"4", "13", "5", "/", "+"};
        System.out.println(new N2().evalRPN(strings));
    }
}
