package com.ohgiraffers.level01.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        Queue<String> que = new LinkedList<>();

        while (true) {
            System.out.print(" 대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): ");
            str = sc.nextLine();

            if (str.equals("next")) {
                if(que.isEmpty()) {
                    System.out.println("대기 고객이 없습니다.");
                }
                else {
                    System.out.println(que.poll() + " 고객님 차례입니다.");
                }
            }
            else if (str.equals("exit")) {
                break;
            }
            else {
                que.offer(str);
                System.out.println(str + " 고객님 대기 등록 되었습니다.");
            }
        }
    }
}
