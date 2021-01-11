package com.eventapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventapp.entities.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
public User findByusername(String username);
}
