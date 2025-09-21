package com.ohgiraffers.comprehensive.ui;

public interface GameIO {
    void println(String s);
    void printf(String fmt, Object... args);
    String readLine();
    int readInt(String prompt);
    boolean confirm(String prompt); // (y/N)
}
