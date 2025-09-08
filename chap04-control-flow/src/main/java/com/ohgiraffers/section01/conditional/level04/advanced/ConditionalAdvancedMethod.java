package com.ohgiraffers.section01.conditional.level04.advanced;

import java.util.Scanner;

public class ConditionalAdvancedMethod {
    public void conditionalAdvancedApplication1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("국어 점수를 입력하세요 : ");
        int korean = sc.nextInt();
        System.out.print("영어 점수를 입력하세요 : ");
        int english = sc.nextInt();
        System.out.print("수학 점수를 입력하세요 : ");
        int math = sc.nextInt();

        int gradeAvg = (korean + english + math) / 3;

        if(gradeAvg >= 60 && korean >= 40 && english >= 40 && math >= 40) {
            System.out.println("합격입니다!");
        }
        else {
            if(gradeAvg <60) {
                System.out.println("평균 점수 미달로 불합격입니다.");
            }

            if(korean< 40) {
                System.out.println("국어 점수 미달로 불합격입니다.");
            }

            if(english< 40) {
                System.out.println("영어 점수 미달로 불합격입니다.");
            }

            if(math< 40) {
                System.out.println("수학 점수 미달로 불합격입니다.");
            }
        }
    }

    public void conditionalAdvancedApplication2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("월 급여 입력 : ");
        int salary = sc.nextInt();
        System.out.print("매출액 입력 : ");
        int sales = sc.nextInt();
        double bonusRate = 0;

        if(sales >= 50000000) {
            bonusRate = 0.05;
        }
        else if(sales > 30000000) {
            bonusRate = 0.03;
        }
        else if(sales > 10000000) {
            bonusRate = 0.01;
        }

        double bonus = sales * bonusRate;
        int totalSalary = salary + (int)bonus;

        System.out.println("======================");
        System.out.println("매출액 : " + sales);
        System.out.println("보너스율 : " + (int)(bonusRate * 100) + "%");
        System.out.println("월 급여 : " + salary);
        System.out.println("보너스 금액 : " + (int)bonus);
        System.out.println("======================");
        System.out.println("총 급여 : " + totalSalary);
    }
}
