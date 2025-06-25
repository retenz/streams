package com.example.streams.service;

import com.example.streams.entity.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserService {
    private Map<Boolean, List<User>> getSplitStreamByAdult(List<User> users) {
        return users.stream().collect(Collectors.partitioningBy(user -> user.getAge() >= 18));
    }

    public List<User> getAdultUsers(List<User> users) {
        return getSplitStreamByAdult(users).get(true);
    }

    public List<User> getNotAdultUsers(List<User> users) {
        return getSplitStreamByAdult(users).get(false);
    }

    public List<User> getTestArray() {
        User user1 = new User();
        user1.setId(1);
        user1.setAge(12);
        User user2 = new User();
        user2.setId(2);
        user2.setAge(32);
        User user3 = new User();
        user3.setId(3);
        user3.setAge(18);

        return Arrays.asList(user1, user2, user3);
    }
}
