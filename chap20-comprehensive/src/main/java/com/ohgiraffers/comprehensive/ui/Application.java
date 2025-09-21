package com.ohgiraffers.comprehensive.ui;

import com.ohgiraffers.comprehensive.domain.User;
import com.ohgiraffers.comprehensive.persistence.FileGameStorage;
import com.ohgiraffers.comprehensive.persistence.FileUserStorage;
import com.ohgiraffers.comprehensive.persistence.GameStorage;
import com.ohgiraffers.comprehensive.persistence.UserRepository;
import com.ohgiraffers.comprehensive.service.UserService;

import java.util.Scanner;

/* 실행 및 UI */
public class Application {
    private final UserService userService;
    private final Scanner sc = new Scanner(System.in);

    public Application() {
        this.userService = new UserService(new UserRepository(new FileUserStorage()));
    }

    public static void main(String[] args) {
        new Application().run();
    }

    public void run() {
        while (true) {
            System.out.println();
            System.out.println("===== 로그인 화면 =====");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("9. 종료");
            System.out.print("메뉴 선택: ");
            int menu = readInt();
            switch (menu) {
                case 1: doLogin(); break;
                case 2: doRegister(); break;
                case 9: System.out.println("프로그램을 종료합니다."); return;
                default: System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private void doRegister() {
        try {
            System.out.println("[회원가입]");
            System.out.print("아이디: "); String id = sc.nextLine().trim();
            System.out.print("비밀번호: "); String pwd = sc.nextLine();
            System.out.print("이름(표시명): "); String name = sc.nextLine().trim();

            int nextUserNo = userService.findAllUsers().size() + 1;
            User newUser = new User(nextUserNo, id, pwd, name);

            userService.registerUser(newUser);
            System.out.println("가입 완료: " + newUser.getId());
        } catch (Exception e) {
            System.out.println("회원가입 실패: " + e.getMessage());
        }
    }

    private void doLogin() {
        try {
            System.out.println("[로그인]");
            System.out.print("아이디: "); String id = sc.nextLine().trim();
            System.out.print("비밀번호: "); String pwd = sc.nextLine();

            User u = userService.login(id, pwd);
            loggedInMenu(u);
        } catch (Exception e) {
            System.out.println("로그인 실패: " + e.getMessage());
        }
    }

    private void loggedInMenu(User current) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("===== 환영합니다 (" + current.getName() + ") 님 =====");
            System.out.println("1. 회원 정보 수정");
            System.out.println("2. 회원 탈퇴");
            System.out.println("3. 로그아웃");
            System.out.println("4. 게임시작");
            System.out.print("메뉴 선택: ");
            int menu = readInt();
            switch (menu) {
                case 1:
                    current = modifyMenu(current);
                    break;
                case 2:
                    if (deleteAccount(current))
                        return;
                    break;
                case 3:
                    System.out.println("로그아웃 되었습니다.");
                    return;
                case 4:
                    GameIO io = new ConsoleIO(sc);
                    GameStorage storage = new FileGameStorage();
                    GameConsole gc = new GameConsole(io, storage);
                    gc.start(current.getId()); // getUserId()/getLoginId()라면 그걸로 변경

                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private User modifyMenu(User current) {
        try {
            System.out.println("[회원 정보 수정]");
            System.out.println("1. 이름 변경");
            System.out.println("2. 비밀번호 변경");
            System.out.println("0. 뒤로");
            System.out.print("선택: ");
            int m = readInt();
            switch (m) {
                case 1: {
                    System.out.print("새 이름: "); String name = sc.nextLine().trim();
                    User updated = userService.changeName(current.getNo(), name);
                    System.out.println("이름이 변경되었습니다.");
                    return updated;
                }
                case 2: {
                    System.out.print("현재 비밀번호: "); String currentPw = sc.nextLine();
                    System.out.print("새 비밀번호: "); String newPw = sc.nextLine();
                    User updated = userService.changePassword(current.getNo(), currentPw , newPw);
                    System.out.println("비밀번호가 변경되었습니다.");
                    return updated;
                }
                case 0: return current;
                default: System.out.println("잘못된 선택입니다."); return current;
            }
        } catch (Exception e) {
            System.out.println("수정 실패: " + e.getMessage());
            return current;
        }
    }

    private boolean deleteAccount(User current) {
        try {
            System.out.println("[회원 탈퇴]");
            System.out.print("비밀번호 확인: "); String pwd = sc.nextLine();
            System.out.print("정말 탈퇴하시겠습니까? (y/N): "); String yn = sc.nextLine().trim().toLowerCase();
            if (!yn.equals("y")) { System.out.println("취소했습니다."); return false; }

            userService.deleteUser(current.getNo(), pwd);
            System.out.println("회원 탈퇴가 완료되었습니다.");
            return true;
        } catch (Exception e) {
            System.out.println("탈퇴 실패: " + e.getMessage());
            return false;
        }
    }

    private int readInt() {
        while (true) {
            String line = sc.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("숫자를 입력하세요: ");
            }
        }
    }
}
