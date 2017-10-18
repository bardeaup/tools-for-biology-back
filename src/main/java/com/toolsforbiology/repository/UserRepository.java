package com.toolsforbiology.repository;

import com.toolsforbiology.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pascalbardeau on 30/08/2017.
 */


public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

}
