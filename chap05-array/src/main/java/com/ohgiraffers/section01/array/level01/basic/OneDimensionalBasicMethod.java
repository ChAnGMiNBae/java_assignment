package com.ohgiraffers.section01.array.level01.basic;

import java.util.Scanner;

public class OneDimensionalBasicMethod {
    public void oneDimensionalBasicApplication1() {
        int[] arr = new int[10];
        for(int i= 1; i<=10; i++){
            arr[i-1] = i;
            System.out.println(arr[i-1]);
        }
    }

    public void oneDimensionalBasicApplication2() {
        String[] arr = {"딸기", "바나나", "복숭아", "키위", "사과"};
        Scanner sc = new Scanner(System.in);
        System.out.print("0부터 4까지의 정수를 입력하세요 : ");
        int input = sc.nextInt();
        if(input >= 0 && input <= 4){
            System.out.println(arr[input]);
        }
        else {
            System.out.println("준비된 과일이 없습니다.");
        }

    }
}
