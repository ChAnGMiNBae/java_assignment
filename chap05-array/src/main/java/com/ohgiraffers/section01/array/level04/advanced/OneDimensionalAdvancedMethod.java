package com.ohgiraffers.section01.array.level04.advanced;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class OneDimensionalAdvancedMethod {
    public void  oneDimensionalAdvancedApplication1() {

        int[] lotto;

        lotto = makeRandomArray(6, 45);

        Arrays.sort(lotto);

        for (int i : lotto) {
            System.out.print(i + " ");
        }
    }

    public int[] makeRandomArray(int arrSize, int randSize){
        boolean[] check = new boolean[randSize];
        int[] arr = new int[arrSize];
        Random rand = new Random();
        int checkNum;
        for (int i = 0; i < arrSize; i++) {
            checkNum = rand.nextInt(randSize) + 1;
            if(!check[checkNum - 1]){
                arr[i] = checkNum;
                check[checkNum - 1] = true;
            } else {
                i--;
            }
        }

        return arr;
    }

    public void  oneDimensionalAdvancedApplication2() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] baseBall = new int[4];
        boolean[] check = new boolean[10];
        int checkNum;
        for (int i = 0; i < baseBall.length; i++) {
            checkNum = rand.nextInt(10);

            if(i == 0 && checkNum == 0) {
                i--;
                continue;
            }

            if(!check[checkNum]){
                baseBall[i] = checkNum;
                check[checkNum] = true;
            } else {
                i--;
            }
        }

        int life = 10;
        String answer;
        while(life > 0){
            int strike = 0;
            int ball = 0;
            System.out.println(life + "회 남으셨습니다.");
            System.out.print("4자리 숫자를 입력하세요 : ");
            answer = sc.nextLine();
            if(!digitCheck(answer)){
                System.out.println("4자리의 정수를 입력해야 합니다.");
            }
            else {
                for(int i = 0; i < baseBall.length; i++){
                    if(baseBall[i] == answer.charAt(i)-'0'){
                        strike++;
                    }
                    else if(ballCheck(baseBall, i,answer.charAt(i)-'0')){
                        ball++;
                    }
                }

                if(strike == 4){
                    System.out.println("정답입니다.");
                    return;
                }
                else {
                    System.out.println("아쉽네요 "+ strike + "S "+ ball + "B 입니다.");
                    life--;
                }
            }
        }

    }

    public boolean digitCheck(String number){

        boolean check = true;

        for(int i = 0; i < number.length(); i++){
            if(!Character.isDigit(number.charAt(i))){
                check = false;
            }
        }

        return number.length() == 4 && check;
    }

    public boolean ballCheck(int[] arr, int idx, int nowNum){
        for (int i = 0; i < arr.length; i++) {
            if (i == idx) continue;
            if (arr[i] == nowNum) return true;
        }
        return false;
    }
}
