package com.forma.training.service;

import com.forma.training.model.Role;
import com.forma.training.model.User;
import com.forma.training.repository.RoleRepository;
import com.forma.training.repository.UserRepository;
import com.forma.training.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public User registerUser(User user) {
        // Check if user already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role defaultRole = roleRepository.findByName("ROLE_COLLABORATEUR")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.getRoles().add(defaultRole);
        return userRepository.save(user);
    }

    public String loginUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        return jwtUtil.generateToken(user);
    }
}
