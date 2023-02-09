package com.jaimecorg.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaimecorg.springprojects.tienda.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}

