package com.ohgiraffers.section01.conditional.level03.hard;

import java.util.Scanner;

public class ConditionalHardMethod {
    public void conditionalHardApplication1() {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 정수 : ");
        int first = sc.nextInt();
        System.out.print("두 번째 정수 : ");
        int second = sc.nextInt();
        System.out.print("연산 기호를 입력하세요 : ");
        String operator = sc.next();

        switch (operator) {
            case "+":
                System.out.println(first + " + " + second + " = " + (first + second));
                break;
            case "-":
                System.out.println(first + " - " + second + " = " + (first - second));
                break;
            case "*":
                System.out.println(first + " * " + second + " = " + (first * second));
                break;
            case  "/":
                if(second == 0) {
                    System.out.println("0으로 나눌순 없습니다.");
                    break;
                }
                System.out.println(first + " / " + second + " = " + (first / second));
                break;
            case "%":
                System.out.println(first + " % " + second + " = " + (first % second));
                break;
            default:
                System.out.println("입력하신 연산은 없습니다. 프로그램을 종료합니다.");
                break;
        }
    }

    public void conditionalHardApplication2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("과일 이름을 입력하세요 : ");
        String fruit = sc.next();
        int banana = 3000;
        int apple = 1000;
        int peach = 2000;
        int kiwi = 5000;

        switch (fruit) {
            case "바나나":
                System.out.println("바나나의 가격은 " + banana + "원 입니다.");
                break;
            case "사과":
                System.out.println("사과의 가격은 " + apple + "원 입니다.");
                break;
            case "복숭아":
                System.out.println("복숭아의 가격은 " + peach + "원 입니다.");
                break;
            case "키위":
                System.out.println("키위의 가격은 " + kiwi + "원 입니다.");
                break;
            default:
                System.out.println("준비된 상품이 없습니다.");
                break;
        }
    }
}
