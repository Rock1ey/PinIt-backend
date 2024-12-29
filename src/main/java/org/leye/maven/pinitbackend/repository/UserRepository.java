package org.leye.maven.pinitbackend.repository;

import org.leye.maven.pinitbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO层，用于访问数据库和数据持久化
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
