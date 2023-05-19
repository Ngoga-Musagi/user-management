package com.z.platform.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.z.platform.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
