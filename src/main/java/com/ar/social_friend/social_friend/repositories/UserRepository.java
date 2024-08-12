package com.ar.social_friend.social_friend.repositories;

import com.ar.social_friend.social_friend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
