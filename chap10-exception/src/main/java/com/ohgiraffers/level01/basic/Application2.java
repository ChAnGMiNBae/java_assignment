package com.ohgiraffers.level01.basic;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("생년월일 입력 (yyyy-MM-dd 양식으로 작성) : ");
            String birthday = sc.nextLine();

            LocalDate birth = LocalDate.parse(birthday);
            LocalDate today = LocalDate.now();

            boolean under20 = today.isBefore(birth.plusYears(20));

            if (under20) {
                throw new InvalidAgeException("만 20세 미만은 입장 불가입니다.");
            }

            System.out.println("입장하셔도 됩니다.");
        } catch (DateTimeParseException e) {
            System.out.println("날짜 양식을 잘못 입력하셨습니다.");
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }


    }
}
