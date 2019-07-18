package com.softserve.ita.sonet.service.impl;

import com.softserve.ita.sonet.dto.model.UserDTO;
import com.softserve.ita.sonet.dto.request.RegisterUserRequest;
import com.softserve.ita.sonet.exception.EmailAlreadyExistException;
import com.softserve.ita.sonet.exception.UserNotFoundException;
import com.softserve.ita.sonet.model.ActorRole;
import com.softserve.ita.sonet.model.Role;
import com.softserve.ita.sonet.model.Status;
import com.softserve.ita.sonet.model.User;
import com.softserve.ita.sonet.repository.RoleRepo;
import com.softserve.ita.sonet.repository.UserRepo;
import com.softserve.ita.sonet.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(RoleRepo roleRepo, UserRepo userRepo, BCryptPasswordEncoder passwordEncoder, ModelMapper mapper) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public UserDTO register(RegisterUserRequest requestUser) throws DataAccessException, EmailAlreadyExistException {

        if (checkIfEmailExist(requestUser.getEmail())) {
            throw new EmailAlreadyExistException("This email already exists");
        }

        UserDTO userDTO = new UserDTO();

        Role roleUser = roleRepo.findByName(ActorRole.ROLE_USER.name());
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        userDTO.setEmail(requestUser.getEmail());
        userDTO.setNickname(requestUser.getNickname());
        userDTO.setPassword(passwordEncoder.encode(requestUser.getPassword()));
        userDTO.setRoles(userRoles);
        userDTO.setStatus(Status.NOT_ACTIVE);


        User userEntity = mapper.map(userDTO, User.class);

        userEntity = userRepo.save(userEntity);

        BeanUtils.copyProperties(userEntity, userDTO);

        return userDTO;

    }

    @Override
    public UserDTO findByEmail(String email) throws DataAccessException, UserNotFoundException {

        User user = userRepo
                .findOptionalByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("User with email: " + email + " not found"));

        return mapper.map(user, UserDTO.class);

    }

    @Override
    public UserDTO findById(Long id) throws DataAccessException, UserNotFoundException {

        User user = userRepo.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User with id: " + id + " not found"));

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;

    }

    private boolean checkIfEmailExist(String email) throws DataAccessException {

        return userRepo
                .findOptionalByEmail(email)
                .isPresent();
    }
}
