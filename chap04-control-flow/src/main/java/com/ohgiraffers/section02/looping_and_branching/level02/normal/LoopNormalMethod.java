package com.ohgiraffers.section02.looping_and_branching.level02.normal;

import java.util.Scanner;

public class LoopNormalMethod {
    public void loopNormalApplication1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력하세요 : ");
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            System.out.print(i + " : ");
            System.out.println(s.charAt(i));
        }
    }

    public void loopNormalApplication2() {
        for(int i = 'a'; i <= 'z'; i++) {
            System.out.print( (char)i );
        }
    }

    public void loopNormalApplication3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if(i % 2 == 0) {
                sb.append("박");
            }
            else {
                sb.append("수");
            }
        }

        System.out.println(sb);
    }
}
