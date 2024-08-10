package com.ar.social_friend.social_friend;

import com.ar.social_friend.social_friend.conf.DataSourceConfig;
import com.ar.social_friend.social_friend.conf.EnvironmentVariablesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories
@EnableScheduling
public class SocialFriendApplication {

	public static void main(String[] args) {
		EnvironmentVariablesConfig envConfig = new EnvironmentVariablesConfig();
		String profile = envConfig.getProfileEnvironmentVariable();
		new SpringApplicationBuilder(DataSourceConfig.class)
				.profiles(profile)
				.registerShutdownHook(true)
				.run(args);
	}

}
