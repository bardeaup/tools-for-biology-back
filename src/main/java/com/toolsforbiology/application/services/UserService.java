package com.toolsforbiology.application.services;

import com.toolsforbiology.application.bean.CustomResponseObject;
import com.toolsforbiology.application.repository.UserRepository;
import com.toolsforbiology.security.dto.UserDTO;
import com.toolsforbiology.security.mapper.UserMapper;
import com.toolsforbiology.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pascalbardeau on 06/11/2017.
 */

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public CustomResponseObject createUser(UserDTO userDTO) {

        CustomResponseObject responseObject = new CustomResponseObject();

        // 1 - L'utilisateur est-il déjà enregistré en BDD?
        User user = userRepository.findByUsername(userDTO.getUsername());

        // 1.a - Oui : L'informer que l'utilisateur existe déjà
        if (user != null) {
            responseObject.setRetour(user);
            responseObject.setMessage("Désolé, le nom d'utilisateur " + userDTO.getUsername() + " est déjà utilisé.");
        }
        // 1.b - Non : Enregistrer en BDD et l'informer si ça s'est bien passé ou non
        else {
            userRepository.save(userMapper.userDTOToUser(userDTO));
        }
        return responseObject;

    }

}
