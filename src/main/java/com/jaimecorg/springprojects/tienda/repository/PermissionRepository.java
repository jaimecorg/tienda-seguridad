package com.jaimecorg.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaimecorg.springprojects.tienda.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
