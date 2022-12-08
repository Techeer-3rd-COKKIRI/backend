package com.techeer.cokkiri.domain.user.repository;

import com.techeer.cokkiri.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);

    Optional<User> findUserByUsername(String username);
}
