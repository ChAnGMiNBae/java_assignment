package com.ohgiraffers.level01.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> alist = new ArrayList<>();
        char cnt;
        int grade;
        double sum = 0;

        while (true) {
            System.out.print("학생 성적 : ");
            grade = sc.nextInt();
            alist.add(grade);
            System.out.print("추가 입력하려면 y : ");
            cnt = sc.next().charAt(0);

            if (cnt != 'y' && cnt != 'Y') {
                break;
            }
        }

        for (Integer i : alist) {
            sum += i;
        }

        System.out.println("학생 인원 : " + alist.size());
        System.out.println("평균 점수 : " + sum / alist.size());
    }
}
