package com.ohgiraffers.level01.basic;

import java.util.HashSet;
import java.util.Scanner;

public class Application4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> hset = new HashSet<>();
        String str;

        while (true) {
            System.out.print("학생 ID 입력('exit' 입력 시 종료): ");
            str = sc.nextLine();

            if (str.equals("exit")) break;

            if(hset.add(str)) {
                System.out.println("ID가 추가 되었습니다.");
            }
            else {
                System.out.println("이미 등록 된 ID입니다.");
            }
        }

        System.out.println("모든 학생의 ID : " + hset);
    }
}
