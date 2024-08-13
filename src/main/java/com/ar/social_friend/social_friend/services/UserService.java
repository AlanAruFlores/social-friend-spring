package com.ar.social_friend.social_friend.services;

import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.exceptions.ResultsNotFoundException;

import java.util.List;

public interface UserService {
    List<User> searchUsersByUsername(String username) throws ResultsNotFoundException;
}
