package com.ar.social_friend.social_friend.services;

import com.ar.social_friend.social_friend.domain.User;

public interface LoginService {

    User searchUserByUsernameAndPassword(User user);
}
