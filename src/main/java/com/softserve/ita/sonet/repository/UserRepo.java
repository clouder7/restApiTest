package com.softserve.ita.sonet.repository;

import com.softserve.ita.sonet.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findOptionalByEmail(String email) throws DataAccessException;

}


