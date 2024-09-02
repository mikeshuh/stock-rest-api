package com.mikrelin.spring_boot_backend.dao;

import com.mikrelin.spring_boot_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
