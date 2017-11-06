package com.toolsforbiology.security.mapper;


import com.toolsforbiology.security.dto.UserDTO;
import com.toolsforbiology.security.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);

    List<UserDTO> usersToUsersDTO(List<User> users);
}

