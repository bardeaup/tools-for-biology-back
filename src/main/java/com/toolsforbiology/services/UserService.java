package com.toolsforbiology.services;

import com.toolsforbiology.dto.UserDTO;
import com.toolsforbiology.exceptions.UserNotFoundException;
import com.toolsforbiology.mapper.UserMapper;
import com.toolsforbiology.model.User;
import com.toolsforbiology.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by pascalbardeau on 08/10/2017.
 */
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    private UserMapper userMapper;


    public UserDTO findById(Long id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("User '" + id + "' not found");
        }
        return userMapper.userToUserDTO(user);
    }
}
