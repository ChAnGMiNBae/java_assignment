package com.ohgiraffers.level02.normal;

import java.util.Random;

public class RandomMaker {

    public static int randomNumber(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

    public static String randomUpperAlpabet(int length) {
        StringBuilder upperAlpabet = new StringBuilder();
        int min = 'A';
        int max = 'Z';
        for (int i = 0; i < length; i++) {
            upperAlpabet.append( (char)randomNumber(min, max) );
        }

        return upperAlpabet.toString();
    }

    public static String rockPaperScissors() {
        int min = 1;
        int max = 3;
        String answer = "";
        switch ( randomNumber(min,max) ) {
            case 1:
                answer = "가위";
                break;
            case 2:
                answer = "바위";
                break;
            case 3:
                answer = "보";
                break;
            default:
                break;
        }

        return answer;
    }

    public static String tossCoin() {
        int min = 1;
        int max = 2;
        String answer = "";
        switch ( randomNumber(min,max) ) {
            case 1:
                answer = "앞면";
                break;
            case 2:
                answer = "뒷면";
                break;
            default:
                break;
        }

        return answer;
    }
}
