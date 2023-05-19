package com.z.platform.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.z.platform.model.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByEmail(String email);
    
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email); 
     
    public User findByResetPasswordToken(String token);
    
    
    @Modifying
    @Transactional
    @Query("update User u set u.photos = ?1 where u.email = ?2")
    void update(String photo, String email);
}
