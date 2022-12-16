package com.techeer.cokkiri.domain.user.repository;

import com.techeer.cokkiri.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  boolean existsByUsername(String username);

  Optional<User> findUserByUsername(String username);
}
