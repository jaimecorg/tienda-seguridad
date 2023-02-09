package com.jaimecorg.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.jaimecorg.springprojects.tienda.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByName(String username);
}
