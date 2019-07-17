package com.softserve.ita.sonet.service;

import com.softserve.ita.sonet.dto.model.UserDTO;
import com.softserve.ita.sonet.dto.request.RegisterUserRequest;
import com.softserve.ita.sonet.exception.EmailAlreadyExistException;
import com.softserve.ita.sonet.exception.UserNotFoundException;
import org.springframework.dao.DataAccessException;


public interface UserService {

    UserDTO register(RegisterUserRequest requestUser) throws DataAccessException, EmailAlreadyExistException;

    UserDTO findByEmail(String username) throws DataAccessException,UserNotFoundException;

    UserDTO findById(Long id) throws DataAccessException, UserNotFoundException;

}
