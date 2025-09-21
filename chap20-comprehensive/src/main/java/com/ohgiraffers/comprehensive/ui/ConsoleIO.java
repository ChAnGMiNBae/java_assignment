package com.ohgiraffers.comprehensive.ui;

import java.util.Scanner;

public class ConsoleIO implements GameIO {
    private final Scanner sc;

    public ConsoleIO(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void println(String s) {
        System.out.println(s);
    }

    @Override
    public void printf(String fmt, Object... args) {
        System.out.printf(fmt, args);
    }

    @Override public String readLine() {
        return sc.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            }
            catch (Exception e) {
                System.out.println("숫자를 입력하세요.");
            }
        }
    }

    @Override
    public boolean confirm(String prompt) {
        System.out.print(prompt + " (y/N): ");
        String s = sc.nextLine().trim().toLowerCase();
        return s.equals("y");
    }
}