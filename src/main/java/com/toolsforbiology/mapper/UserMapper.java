package com.toolsforbiology.mapper;


import com.toolsforbiology.dto.UserDTO;
import com.toolsforbiology.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    List<UserDTO> usersToUsersDTO(List<User> users);
}

