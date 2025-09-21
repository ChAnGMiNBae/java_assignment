package com.ohgiraffers.comprehensive.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    private ByteArrayOutputStream out;

    @BeforeEach
    void setup() throws Exception {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8));

        Path dir = Path.of("src/main/java/com/ohgiraffers/comprehensive/db");
        Files.createDirectories(dir);
    }

    private String runWithInput(String... lines) {
        String joined = String.join("\n", lines) + "\n";
        System.setIn(new ByteArrayInputStream(joined.getBytes(StandardCharsets.UTF_8)));

        // 실행
        new Application().run();

        return out.toString(StandardCharsets.UTF_8);
    }

    @Test
    @DisplayName("9 입력 시 즉시 종료 문구 출력")
    void exitImmediately() {
        String output = runWithInput("9");
        assertTrue(output.contains("프로그램을 종료합니다."), "종료 문구가 출력되어야 합니다.");
        assertTrue(output.contains("===== 로그인 화면 ====="));
    }

    @Test
    @DisplayName("존재하지 않는 계정 로그인 실패")
    void login_fail_then_exit() {
        // 1(로그인) → 잘못된 id/pw → 9(종료)
        String output = runWithInput(
                "1",
                "no-such-id",
                "wrongpw",
                "9"
        );
        assertTrue(output.contains("로그인 실패"), "실패 문구가 보여야 합니다.");
    }
}