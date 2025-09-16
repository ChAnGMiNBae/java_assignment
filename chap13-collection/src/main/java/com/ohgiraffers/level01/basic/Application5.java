package com.ohgiraffers.level01.basic;

import java.util.*;

public class Application5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> alist = new ArrayList<>();
        String str;

        while (true) {
            System.out.print("단어 입력 ('exit' 입력 시 종료): ");
            str = sc.nextLine();

            if (str.equals("exit")) break;

            alist.add(str);
        }

        Collections.sort(alist);

        System.out.println("정렬 된 단어 : " + alist);
    }
}
