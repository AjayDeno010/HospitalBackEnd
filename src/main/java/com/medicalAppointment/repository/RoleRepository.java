package com.medicalAppointment.repository;

import com.medicalAppointment.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role,Long> {
    @Modifying
    @Query(value = "INSERT INTO users_roles (user_id, role_id) VALUES (?1, ?2)", nativeQuery = true)
    void insertUserRole(Long userId, int roleId);
}
