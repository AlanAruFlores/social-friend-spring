package com.ar.social_friend.social_friend.services;

import com.ar.social_friend.social_friend.domain.User;

import java.util.List;

public interface UserService {
    List<User> searchUsersByUsername(String username);
}
