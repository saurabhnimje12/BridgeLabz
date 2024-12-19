package com.example.repo;

import com.example.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    boolean existsByUsername(String username);
    Optional<Register> findByUsernameAndPassword(String username, String password);
}
