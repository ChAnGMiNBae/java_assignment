package com.ohgiraffers.level01.basic;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> que = new LinkedList<>();
        String str;

        while (true) {
            System.out.print("방문 URL을 입력하세요 (단, exit를 입력하면 종료) : ");
            str = sc.nextLine();

            if(str.equals("exit")) break;

            if(que.size() < 5) {
                que.offer(str);
            }
            else {
                que.poll();
                que.offer(str);
            }

            ArrayList<String> revList = new ArrayList<>(que);
            Collections.reverse(revList);
            System.out.println("최근 방문 url : " + revList);
        }

    }
}
