package com.forma.training.service;

import com.forma.training.model.User;
import com.forma.training.model.Role;
import com.forma.training.repository.UserRepository;
import com.forma.training.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role defaultRole = roleRepository.findByName("ROLE_COLLABORATEUR")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
