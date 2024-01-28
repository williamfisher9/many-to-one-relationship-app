package com.apps.archiver.service;

import com.apps.archiver.dao.RoleRepo;
import com.apps.archiver.dao.UserRepo;
import com.apps.archiver.dao.UserRolesRepo;
import com.apps.archiver.dto.SignUpDTO;
import com.apps.archiver.exceptions.RoleNotFoundException;
import com.apps.archiver.model.Role;
import com.apps.archiver.model.User;
import com.apps.archiver.model.UserRoles;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService{
    private final UserRolesRepo userRolesRepo;
    private final RoleRepo roleRepo;

    private final ModelMapper mapper;

    @Autowired
    public AuthServiceImpl(UserRolesRepo userRolesRepo, RoleRepo roleRepo, ModelMapper mapper){
        this.userRolesRepo = userRolesRepo;
        this.roleRepo = roleRepo;
        this.mapper = mapper;
    }

    @Override
    public void createUser(SignUpDTO request) {
        Set<Long> roleSet = new HashSet<>();
        for(String roleName:request.getRoles()){
            Role role = roleRepo.findByName(roleName).orElseThrow(() -> new RoleNotFoundException("Role " + roleName + " does not exist!"));
            roleSet.add(role.getId());
        }

        if(!roleSet.isEmpty()){
            User user = mapper.map(request, User.class);
            for (Long roleId:roleSet){
                UserRoles userRoleEntry = new UserRoles();
                userRoleEntry.setUser(user);
                userRoleEntry.setRoleId(roleId);
                userRolesRepo.save(userRoleEntry);
            }
        }
    }
}
