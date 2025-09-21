package com.ohgiraffers.comprehensive.service;

import com.ohgiraffers.comprehensive.domain.User;
import com.ohgiraffers.comprehensive.persistence.UserRepository;

import java.util.List;
import java.util.regex.Pattern;

/* Service : 비즈니스 로직 */
public class UserService {
    private final UserRepository userRepository;
    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile(".*[!@#$%^&*(),.?\":{}|<>].*"); // 특수문자 1개 이상

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.selectAllUsers();
    }

    public void registerUser(User user) {
        if (isDuplicateUserId(user.getId())) {
            throw new IllegalArgumentException("회원 가입 실패: 이미 존재하는 아이디입니다.");
        }

        if (isInvalidPassword(user.getPwd())) {
            throw new IllegalArgumentException("회원 가입 실패: 비밀번호는 최소 " + MIN_PASSWORD_LENGTH + "자 이상이어야 하고 특수문자를 포함해야 합니다.");
        }

        userRepository.insertUser(user);
    }

    public User login(String id, String pwd) {
        return userRepository.findById(id)
                .filter(u -> u.getPwd().equals(pwd))
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 올바르지 않습니다."));
    }

    public User changeName(int userNo, String newName) {
        User u = userRepository
                .findByNo(userNo)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        if (newName == null || newName.isBlank())
            throw new IllegalArgumentException("이름은 비울 수 없습니다.");

        User updated = u.withName(newName);
        userRepository.updateUser(updated);
        return updated;
    }

    public User changePassword(int userNo, String currentPwd, String newPwd) {
        User u = userRepository
                .findByNo(userNo)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        if (!u.getPwd().equals(currentPwd))
            throw new IllegalArgumentException("현재 비밀번호가 일치하지 않습니다.");

        if (isInvalidPassword(newPwd)) {
            throw new IllegalArgumentException("새 비밀번호는 최소 " + MIN_PASSWORD_LENGTH + "자 이상이어야 하고 특수문자를 포함해야 합니다.");
        }

        User updated = u.withPassword(newPwd);
        userRepository.updateUser(updated);
        return updated;
    }

    public void deleteUser(int userNo, String confirmPwd) {
        User u = userRepository
                .findByNo(userNo)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        if (!u.getPwd().equals(confirmPwd))
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        userRepository.deleteUser(userNo);
    }

    private boolean isDuplicateUserId(String userId) {
        return userRepository.selectAllUsers()
                .stream()
                .anyMatch(user -> user.getId().equals(userId));
    }

    private boolean isInvalidPassword(String password) {
        return password.length() < MIN_PASSWORD_LENGTH || !PASSWORD_PATTERN.matcher(password).matches();
    }
}
