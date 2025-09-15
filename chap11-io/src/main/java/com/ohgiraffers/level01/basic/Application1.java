package com.ohgiraffers.level01.basic;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("파일 이름을 입력하세요 : ");
        String fileName = sc.nextLine();

        try(FileReader fr = new FileReader(fileName)) {
            char[] carr = new char[1024];
            fr.read(carr);
            for(char c : carr) {
                if(c == 0) break;
                System.out.print(c);
            }
        } catch (IOException e) {
            System.out.println("오류 : 해당 이름을 가진 파일이 없습니다.");
        }
    }
}
