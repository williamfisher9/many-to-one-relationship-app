package com.apps.archiver.configs;

import com.apps.archiver.dao.RoleRepo;
import com.apps.archiver.dao.UserRepo;
import com.apps.archiver.dao.UserRolesRepo;
import com.apps.archiver.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitialDataRunner implements CommandLineRunner {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final UserRolesRepo userRolesRepo;

    @Autowired
    public InitialDataRunner(UserRepo userRepo, RoleRepo roleRepo, UserRolesRepo userRolesRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.userRolesRepo = userRolesRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepo.deleteAll();
        roleRepo.deleteAll();
        userRolesRepo.deleteAll();
        roleRepo.saveAll(Arrays.asList(new Role("ADMIN_ROLE"), new Role("USER_ROLE")));
    }
}
