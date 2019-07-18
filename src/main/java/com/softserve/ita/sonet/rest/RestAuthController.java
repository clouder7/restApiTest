package com.softserve.ita.sonet.rest;

import com.softserve.ita.sonet.dto.model.UserDTO;
import com.softserve.ita.sonet.dto.request.LoginUserRequest;
import com.softserve.ita.sonet.dto.request.RegisterUserRequest;
import com.softserve.ita.sonet.dto.response.LoginUserResponse;
import com.softserve.ita.sonet.dto.response.RegisterUserResponse;
import com.softserve.ita.sonet.exception.UserNotFoundException;
import com.softserve.ita.sonet.security.jwt.JwtTokenProvider;
import com.softserve.ita.sonet.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController()
@RequestMapping("/api/auth/")
public class RestAuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private final ModelMapper mapper;

    @Autowired
    public RestAuthController(
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider,
            UserService userService,
            ModelMapper mapper)
    {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.mapper = mapper;
    }


    @PostMapping("login")
    public ResponseEntity login(@Valid @RequestBody LoginUserRequest requestUser) {
        try {

            Authentication auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken
                            ( requestUser.getEmail(), requestUser.getPassword()));

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(auth);

            UserDTO userDTO = userService
                    .findByEmail(requestUser.getEmail());

            String token = jwtTokenProvider.
                    createToken(requestUser.getEmail(), userDTO.getRoles());

            userDTO.setToken(token);

            return ResponseEntity.ok(mapper.map(userDTO,LoginUserResponse.class));

        } catch (AuthenticationException | UserNotFoundException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("register")
    public ResponseEntity registration(@Valid @RequestBody RegisterUserRequest requestUser) {

        UserDTO userDTO = userService.register(requestUser);
        RegisterUserResponse response = mapper.map(userDTO, RegisterUserResponse.class);

        return ResponseEntity.ok(response);

    }

    @GetMapping("{id}")
    public ResponseEntity getAllUsers(@PathVariable Long id){
        return  ResponseEntity.ok(userService.findById(id));
    }


}
