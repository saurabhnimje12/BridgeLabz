package com.example.repo;

import com.example.entity.Student;
import jakarta.validation.constraints.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends MongoRepository<Student, Long> {
    Optional<Student> findByEmail(@Email String email);
}
