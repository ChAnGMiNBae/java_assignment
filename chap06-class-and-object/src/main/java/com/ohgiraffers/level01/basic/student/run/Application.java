package com.ohgiraffers.level01.basic.student.run;

import com.ohgiraffers.level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDTO[] students =  new StudentDTO[10];
        char conCheck;
        int idx = 0;

        int grade;
        int classroom;
        String name;
        int kor;
        int eng;
        int math;

        while(idx < students.length) {
            System.out.print("학년 : ");
            grade = sc.nextInt();
            System.out.print("반 : ");
            classroom = sc.nextInt();
            System.out.print("이름 : ");
            name = sc.next();
            System.out.print("국어점수 : ");
            kor = sc.nextInt();
            System.out.print("영어점수 : ");
            eng = sc.nextInt();
            System.out.print("수학점수 : ");
            math = sc.nextInt();

            students[idx++] = new StudentDTO(grade, classroom, name, kor, eng, math);

            System.out.print("계속 추가할 겁니까 ? (y/n) : ");
            conCheck = sc.next().charAt(0);

            if( !(conCheck == 'y' ||  conCheck == 'Y' ) ){
                break;
            }

        }

        for(int i = 0; i < idx; i++) {
            System.out.println(students[i].getInformation());
        }
    }
}
