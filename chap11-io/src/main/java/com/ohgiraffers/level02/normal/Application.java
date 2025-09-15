//package com.ohgiraffers.level02.normal;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.Scanner;
//
//public class Application {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("병합할 파일의 개수 입력 : ");
//        int cnt = sc.nextInt();
//        String[] files = new String[cnt];
//
//        for (int i = 0; i < cnt; i++) {
//            System.out.print(i+1 + " 번째 파일 이름 입력 : ");
//            files[i] = sc.next();
//        }
//
//        System.out.print("병합 될 파일명 입력 : ");
//        String result = sc.next();
//
//        for (int i = 0; i < cnt; i++) {
//            try(BufferedReader br = new BufferedReader(new FileReader(files[i]))) {
//
//            }
//        }
//
//    }
//}
