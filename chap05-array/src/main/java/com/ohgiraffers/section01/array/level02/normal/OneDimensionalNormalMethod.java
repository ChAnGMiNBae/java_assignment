package com.ohgiraffers.section01.array.level02.normal;

import java.util.Scanner;

public class OneDimensionalNormalMethod {
    public void oneDimensionalNormalApplication1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 하나 입력하세요 : ");
        String str = sc.nextLine();
        char[] carr = str.toCharArray();
        System.out.print("검색할 문자를 입력하세요 : ");
        char ch = sc.next().charAt(0);
        int count = 0;

        for(char c :  carr) {
            if(c == ch) {
                count++;
            }
        }

        System.out.println("입력하신 문자열 " + str + "에서 찾으시는 문자 " + ch + "은 " + count + "개 입니다.");
    }

    public void oneDimensionalNormalApplication2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("주민등록번호를 입력하세요 : ");
        String str = sc.nextLine();
        char[] carr = str.toCharArray();
        for(int i = 8; i < carr.length; i++) {
            carr[i] = '*';
        }

        System.out.println(carr);
    }
}
