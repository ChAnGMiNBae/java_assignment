package com.ohgiraffers.level01.basic;

import java.util.Scanner;

public class Application1 {

    public static void main(String[] args) {
        /* ----- 입력 예시 -----
         *
         * 문자열 입력 : I will be a good developer.
         *
         * ----- 출력 예시 -----
         *
         * 변환된 문자열: I Will Be A Good Developer.
         * 총 단어 개수: 6
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();

        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            String upperStr = arr[i].substring(0, 1).toUpperCase()
                    + arr[i].substring(1);
            sb.append(upperStr + " ");
            cnt++;
        }
        System.out.println(sb);
        System.out.println("총 단어 개수: " + cnt);
    }
}