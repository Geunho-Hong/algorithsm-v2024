package programmers.level2;

// stack , 2024.02.08
// https://school.programmers.co.kr/learn/courses/30/lessons/12909

// 1.여는 괄호로 시작하는것은 상관이 없다.
// 2.괄호의 종류는 한개이다.
// 3.닫는 괄호를 만나면 끝이난다.-> 닫는 괄호를 만나면 끝을 내버린다.

import java.util.Stack;

public class ProperBracket {

    public static void main(String[] args) {
        String s = "()()";
        boolean answer = solution(s);
        System.out.println(answer);
    }

    private static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);

            if(stack.isEmpty() && word == ')') {
                return false;
            }

            if(word == '(') {
                stack.push(word);
            } else if (word == ')') {
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}

// stack
