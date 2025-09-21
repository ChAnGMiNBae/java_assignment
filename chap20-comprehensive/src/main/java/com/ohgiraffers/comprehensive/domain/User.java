package com.ohgiraffers.comprehensive.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* 불변 객체의 형태로 관리
 * setter 제거 후 update 메소드만 사용
 * */
public class User implements Serializable {
    private final int no;       // 내부 식별자
    private final String id;    // 로그인 아이디 (unique)
    private final String pwd;   // 비밀번호(데모: 평문 저장)
    private final String name;  // 표시 이름(환영 메시지용)

    public User(int no, String id, String pwd, String name) {
        this.no = no;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    public int getNo() { return no; }
    public String getId() { return id; }
    public String getPwd() { return pwd; }
    public String getName() { return name; }

    public User withPassword(String newPwd) {
        return new User(this.no, this.id, newPwd, this.name);
    }

    public User withName(String newName) {
        return new User(this.no, this.id, this.pwd, newName);
    }

    @Override
    public String toString() {
        return "User{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return no == user.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }
}
