package com.ohgiraffers.section02.looping_and_branching.level03.hard;

import java.util.Scanner;

public class LoopHardMethod {
    public void loopHardApplication1(){
        Scanner sc = new Scanner(System.in);
        int n;
        while(true) {
            System.out.print("2보다 큰 정수를 하나 입력하세요 : ");
            int tempNum = sc.nextInt();
            if(tempNum > 2) {
                n = tempNum;
                break;
            }
            System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
        }

        boolean primeNumCheck = true;
        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                primeNumCheck = false;
                break;
            }
        }

        if(primeNumCheck) {
            System.out.println("소수다.");
        }
        else {
            System.out.println("소수가 아니다.");
        }
    }

    public void loopHardApplication2(){
        Scanner sc = new Scanner(System.in);
        int answerNum = (int) (Math.random() * 100) + 1;
        int count = 1;

        while(true) {
            System.out.print("정수를 입력하세요 : ");
            int inputNum = sc.nextInt();
            if(inputNum > answerNum) {
                System.out.println("입력하신 정수보다 작습니다.");
                count++;
            }
            else if(inputNum < answerNum) {
                System.out.println("입력하신 정수보다 큽니다.");
                count++;
            }
            else {
                System.out.println("정답입니다. " + count + "회만에 정답을 맞추셨습니다.");
                break;
            }
        }
    }

    public void loopHardApplication3(){
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();

        for(char ch : str.toCharArray()) {
            if( (ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z') ) {
                System.out.println("영문자가 아닌 문자가 포함되어 있습니다.");
                return;
            }
        }

        System.out.print("문자 입력 : ");
        char c = sc.nextLine().charAt(0);

        int count = 0;

        for(char ch : str.toCharArray()) {
            if(ch == c) {
                count++;
            }
        }

        System.out.println("포함된 갯수 : " + count + "개");
    }
}
