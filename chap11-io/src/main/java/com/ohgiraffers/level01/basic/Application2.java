package com.ohgiraffers.level01.basic;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원본 파일의 이름을 입력하세요 : ");
        String origin = sc.nextLine();
        System.out.print("복사 파일의 이름을 입력하세요 : ");
        String copy = sc.nextLine();

        try(FileReader fr = new FileReader(origin)) {
            char[] carr = new char[1024];
            fr.read(carr);
            for(char c : carr) {
                if(c == 0) break;
                try (FileWriter fw = new FileWriter(copy, true)) {
                    fw.write(c);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("파일 복사가 성공적으로 완료 되었습니다.");
        } catch (IOException e) {
            System.out.println("오류 : " + origin + " (지정된 파일을 찾을 수 없습니다)");
        }
    }
}
