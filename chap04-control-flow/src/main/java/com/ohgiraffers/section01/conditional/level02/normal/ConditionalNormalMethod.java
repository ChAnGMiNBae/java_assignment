package com.ohgiraffers.section01.conditional.level02.normal;

import java.util.Scanner;

public class ConditionalNormalMethod {
    public void conditionalNormalApplication1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1~10 사이 정수 하나를 입력하세요. : ");
        int num = sc.nextInt();

        if(num >= 1 && num <= 10) {
            if(num % 2 == 0) {
                System.out.println("짝수다");
            }
            else {
                System.out.println("홀수다");
            }
        } else {
            System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
        }
    }

    public void conditionalNormalApplication2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("체중 입력(kg) : ");
        int weight = sc.nextInt();
        System.out.print("키 입력(m) : ");
        double height = sc.nextDouble();
        double bmi = weight / (height * height);

        if(bmi < 20) {
            System.out.println("당신은 저체중 입니다.");
        }
        else if(bmi >= 20 && bmi < 25) {
            System.out.println("당신은 정상체중 입니다.");
        }
        else if(bmi >= 25 && bmi < 30) {
            System.out.println("당신은 과체중 입니다.");
        }
        else if(bmi >= 30) {
            System.out.println("당신은 비만 입니다.");
        }

    }
}
