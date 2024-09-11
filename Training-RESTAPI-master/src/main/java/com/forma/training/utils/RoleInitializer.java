package com.forma.training.utils;

import com.forma.training.model.Role;
import com.forma.training.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RoleInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if roles already exist
        if (roleRepository.findAll().isEmpty()) {
            // Add default roles
            Role roleCollaborateur = new Role();
            roleCollaborateur.setName("ROLE_COLLABORATEUR");

            Role roleRH = new Role();
            roleRH.setName("ROLE_RH");

            Role roleChef = new Role();
            roleChef.setName("ROLE_CHEF");

            Role roleResp = new Role();
            roleResp.setName("ROLE_RESPONSABLE");

            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");

            roleRepository.saveAll(Arrays.asList(roleCollaborateur, roleAdmin,roleRH,roleChef,roleResp));

            System.out.println("Roles initialized successfully");
        }
    }
}