package com.ohgiraffers.section02.looping_and_branching.level04.advanced;

import java.util.Scanner;

public class LoopAdvancedMethod {
    public void loopAdvancedApplication1(){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.print("문자열을 입력하세요 : ");
        String str = sc.nextLine();
        System.out.print("숫자를 입력하세요 : ");
        int num = sc.nextInt();

        for(char ch : str.toCharArray()){
            if(ch >= 'a' && ch <= 'z') {
                ch = (char)( ((ch -'a' + (num % 26) ) % 26) + 'a' );
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char)( ((ch -'A' + (num % 26) ) % 26) + 'A' );
            }
            sb.append(ch);
        }

        System.out.println(sb);
    }
}
