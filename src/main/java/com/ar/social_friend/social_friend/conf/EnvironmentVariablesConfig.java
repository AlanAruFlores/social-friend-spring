package com.ar.social_friend.social_friend.conf;


import java.util.Optional;

public final class EnvironmentVariablesConfig {
    public  String getProfileEnvironmentVariable(){
        return Optional.ofNullable(System.getenv("PROFILE_VARIABLE"))
                .filter(profile -> profile != "test")
                .orElse("dev");
    }
}
