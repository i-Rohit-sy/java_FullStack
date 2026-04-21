package com.learning.Spring_Security.repo;
import com.learning.Spring_Security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
    Users findByUsername(String username);
}
