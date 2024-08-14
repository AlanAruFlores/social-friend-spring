package com.ar.social_friend.social_friend.repositories;

import com.ar.social_friend.social_friend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsernameAndPassword(String username, String password);

    List<User> findAllByUsernameContainsIgnoreCase(String userName);

}
