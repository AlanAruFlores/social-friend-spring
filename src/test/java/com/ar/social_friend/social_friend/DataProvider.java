package com.ar.social_friend.social_friend;

import com.ar.social_friend.social_friend.domain.User;

import java.time.LocalDate;

public class DataProvider {
    public static User getNewUser(){
        return new User(1L, "username1", "password1", "Ali", "Ali1234", "ali@gmail.com", "11232344", LocalDate.of(2000,1,1),null);
    }
}
