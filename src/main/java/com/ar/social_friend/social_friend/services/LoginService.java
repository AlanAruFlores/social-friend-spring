package com.ar.social_friend.social_friend.services;

import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.exceptions.UserNotFoundException;

public interface LoginService {

    User searchUserByUsernameAndPassword(User user) throws UserNotFoundException;
}
