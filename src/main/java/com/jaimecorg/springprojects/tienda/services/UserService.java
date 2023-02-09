package com.jaimecorg.springprojects.tienda.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jaimecorg.springprojects.tienda.model.Permission;
import com.jaimecorg.springprojects.tienda.model.User;
import com.jaimecorg.springprojects.tienda.repository.UserRepository;

public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User u = userRepository.findByName(username);

        List<Permission> permissions = u.getPermissions();

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        
        for (Permission p : permissions){
            roles.add(new SimpleGrantedAuthority(p.getName()));
        }
        
        UserDetails user = org.springframework.security.core.userdetails.User.builder()
            .username(u.getName())
            .password(u.getPassword())
            .authorities(roles)
            .build();

        return user;
    }
    
}
