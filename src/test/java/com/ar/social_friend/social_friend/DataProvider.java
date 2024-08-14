package com.ar.social_friend.social_friend;

import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.dto.UserSearchDTO;

import java.time.LocalDate;
import java.util.List;

public class DataProvider {

    public static List<User> getUsers(){
        return List.of(
            new User(1L, "username1", "password1", "Ali", "Ali1234", "ali@gmail.com", "11232344", LocalDate.of(2000,1,1),null),
            new User(2L, "username2", "password2", "Ali", "Ali1234", "ali@gmail.com", "11232344", LocalDate.of(2000,1,1),null),
            new User(3L, "username3", "password3", "Ali", "Ali1234", "ali@gmail.com", "11232344", LocalDate.of(2000,1,1),null),
            new User(4L, "username4", "password4", "Ali", "Ali1234", "ali@gmail.com", "11232344", LocalDate.of(2000,1,1),null)
        );
    }


    public static List<UserSearchDTO> getUsersDTO() {
        return List.of(
                new UserSearchDTO(1L, "username1"),
                new UserSearchDTO(2L, "username2"),
                new UserSearchDTO(3L, "username3"),
                new UserSearchDTO(4L, "username4")
        );
    }

    public static User getNewUser(){
        return new User(1L, "username1", "password1", "Ali", "Ali1234", "ali@gmail.com", "11232344", LocalDate.of(2000,1,1),null);
    }
}
