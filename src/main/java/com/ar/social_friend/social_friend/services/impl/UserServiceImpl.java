package com.ar.social_friend.social_friend.services.impl;

import com.ar.social_friend.social_friend.domain.User;
import com.ar.social_friend.social_friend.dto.UserMapper;
import com.ar.social_friend.social_friend.dto.UserSearchDTO;
import com.ar.social_friend.social_friend.exceptions.ResultsNotFoundException;
import com.ar.social_friend.social_friend.repositories.UserRepository;
import com.ar.social_friend.social_friend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserSearchDTO> searchUsersByUsername(String username) throws ResultsNotFoundException {
        List<User> results = this.userRepository.findAllByUsernameContainsIgnoreCase(username);
        if(results.isEmpty())
            throw new ResultsNotFoundException();


        //List<UserSearchDTO> resultsDTO = results.stream().map(res -> new UserSearchDTO(res.getId(),res.getUsername())).collect(Collectors.toList());

        //Devuelvo lista de DTOS usando MapStruct
        return results.stream().map(UserMapper.userMapper::userToUserSearchDTO).collect(Collectors.toList());
    }
}
