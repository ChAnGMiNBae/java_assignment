package com.ohgiraffers.section02.demensional_array.level03.hard;

import java.util.Random;
import java.util.Scanner;

public class MultiDimensionalHardMethod {
    public void multiDimensionalHardApplication1() {
        Scanner sc = new Scanner(System.in);
        int n,m;
        while(true) {
            System.out.print("가로 행의 수를 입력하세요 : ");
            n = sc.nextInt();
            if(n < 1 || n > 10) {
                System.out.println("반드시 1~10까지의 정수를 입력해야 합니다. 다시 입력하세요.");
            } else break;
        }
        while(true) {
            System.out.print("세로 열의 수를 입력하세요 : ");
            m = sc.nextInt();
            if(m < 1 || m > 10) {
                System.out.println("반드시 1~10까지의 정수를 입력해야 합니다. 다시 입력하세요.");
            } else break;
        }

        char[][] arr = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = (char)randomNumber('A', 'Z');
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int randomNumber(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }
}
