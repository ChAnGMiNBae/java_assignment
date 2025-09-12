package com.ohgiraffers.level01.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application2 {

    public static void main(String[] args) {

        /* ----- 입력 예시 -----
         *
         * 문자열 입력 : hello world Hello everyone! 안녕하세요 반갑습니다
         *
         * ----- 출력 예시 -----
         *
         * ===== 단어 빈도 =====
         * hello: 2
         * world: 1
         * everyone: 1
         * 가장 빈도 높은 단어 : hello (2 번)
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();

        String[] arr = str.split("[,!?. ]");
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        int max = 1;

        for (String s : arr) {
            if (!map.containsKey(s.toLowerCase()) && !map.containsKey(s.toUpperCase())) {
                map.put(s.toLowerCase(), 1);
            } else {
                map.put(s.toLowerCase(), map.get(s.toLowerCase()) + 1);
                if (max < map.get(s.toLowerCase())) {
                    max = map.get(s.toLowerCase());
                }
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max){
                sb.append(entry.getKey()).append(" ");
            }
        }

        System.out.println("가장 빈도 높은 단어 : " + sb + " (" +  max + " 번)");
    }
}