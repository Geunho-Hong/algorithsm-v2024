package programmers.level2;

//https://school.programmers.co.kr/learn/courses/30/lessons/12914
// 1. 뽑는 경우의 수가 아니라 합을 구해야 함
// 2. 활용해야 하는 숫자만 나오고 정해진 배열이 없음.
// 순열로 BaseCase 정해놓고 푼다고 하더라도 체크할 수 있는 방법이 있나?
    // -> 다이나믹 프로그래밍 문제이다!

public class LongJump {
    public static void main(String[] args) {
        long answer = answer(10);
        System.out.println(answer);
    }

    private static long answer(int n){
        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < 2001; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return dp[n];
    }

}

