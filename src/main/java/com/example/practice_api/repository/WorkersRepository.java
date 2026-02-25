package com.example.practice_api.repository;

import com.example.practice_api.entity.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Long> {
    boolean existsByEmail(String email);

}
