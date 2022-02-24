package com.auckfmine.chat.repositories;

import com.auckfmine.chat.entities.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth,Long> {
    Auth findByUserNameAndPassword(String userName,String password);
}
