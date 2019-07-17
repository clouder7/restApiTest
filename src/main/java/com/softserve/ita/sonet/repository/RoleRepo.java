package com.softserve.ita.sonet.repository;

import com.softserve.ita.sonet.model.Role;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name) throws DataAccessException;

}
