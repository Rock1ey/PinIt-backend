package org.leye.maven.pinitbackend.repository;

import org.leye.maven.pinitbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author leye
 * @description: TODO 
 * @date 2024/12/24 09:57
 * @version 1.0
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
