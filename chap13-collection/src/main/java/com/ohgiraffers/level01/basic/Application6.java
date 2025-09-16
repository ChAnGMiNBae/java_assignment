package com.ohgiraffers.level01.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Application6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = new String[2];
        String str;
        Map<String,String> tmap = new TreeMap<>();
        while (true) {
            System.out.print("이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): ");
            str = sc.nextLine();
            if (str.equals("search")) {
                System.out.print("검색 할 이름 : ");
                str = sc.nextLine();

                if(tmap.containsKey(str)){
                    System.out.println(str + "씨의 전화번호 : " + tmap.get(str));
                } else {
                    System.out.println(str + "씨의 번호는 등록 되어 있지 않습니다.");
                }
            }
            else if (str.equals("exit")) {
                break;
            }
            else {
                input = str.split("\\s+");

                if(input.length != 2) {
                    System.out.println("입력이 잘못 되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호>");
                    continue;
                }

                tmap.put(input[0], input[1]);
                System.out.println("추가 완료 : " + input[0] + " " + input[1]);
            }
        }

    }
}
