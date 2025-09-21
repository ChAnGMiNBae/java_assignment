
package com.ohgiraffers.comprehensive.persistence;

import com.ohgiraffers.comprehensive.domain.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/** User 데이터 저장 및 조회 */
public class UserRepository {
    private final UserStorage userStorage;
    private final List<User> userList;

    public UserRepository(UserStorage userStorage) {
        this.userStorage = userStorage;
        this.userList = userStorage.loadUsers();
    }

    public List<User> selectAllUsers() {
        return new ArrayList<>(userList);
    }

    public Optional<User> findById(String id) {
        return userList.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public Optional<User> findByNo(int no) {
        return userList.stream().filter(u -> u.getNo() == no).findFirst();
    }


    public void insertUser(User user) {
        userList.add(user);
        userStorage.saveUsers(userList);
    }

    public void updateUser(User updatedUser) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getNo() == updatedUser.getNo()) {
                userList.set(i, updatedUser);
                userStorage.saveUsers(userList);
                break;
            }
        }
    }

    public void deleteUser(int no) {
        userList.removeIf(user -> user.getNo() == no);
        userStorage.saveUsers(userList);
    }
}
