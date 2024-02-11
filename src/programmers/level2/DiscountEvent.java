package programmers.level2;

import java.util.*;

// 모든 아이템이 할인 받을 수 있어야 한다. 10일동안 회원 자격을 부여한다.
// 사용자 map 만들기.
// 날짜를 기준으로 처리해야하는 map 만들기.

public class DiscountEvent {

    public static void main(String[] args) {

        int answer = 0;

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] numbers = {3,2,2,2,1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        Map<String,Integer> itemMap = new HashMap<>();

        // 1.사용자의 입력 값을 파라미터로 받기.
        for(int i=0; i< want.length; i++) {
            String item = want[i];
            Integer qnt = numbers[i];
            itemMap.put(item,qnt);
        }

        // 2. discount 배열을 활용해서 만들 수 있는 배열 만들기
        // day 날짜만큼 돌면서 loop를 수행한다.
        int days = 10;
        for (int i = 0; i < discount.length - days + 1; i++) {
            Map<String,Integer> dMap = new HashMap<>();

            // i만큼(날짜)를 더해주기 때문에 더한 날짜가 계산된다.
            for (int j = 0; j < days; j++) {
                dMap.put(discount[i +j],dMap.getOrDefault(discount[i+j],0) +1);
            }

            boolean isIdentical = true;

            // 만든 day map을 사용자의 map과 비교한다.
            for(String key : itemMap.keySet()) {
                int wantCnt = itemMap.get(key);
                int disCountCnt = dMap.getOrDefault(key,0);
                if(wantCnt > disCountCnt) {
                    isIdentical = false;
                    break;
                }
            }
            answer += isIdentical ? 1 : 0;
        }

        System.out.println("answer = " + answer);
    }
}
