package com.apps.archiver.dao;

import com.apps.archiver.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepo extends JpaRepository<UserRoles, Long> {
}
