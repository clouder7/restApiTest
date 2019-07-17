package com.softserve.ita.sonet.security;

import com.softserve.ita.sonet.dto.model.UserDTO;
import com.softserve.ita.sonet.security.jwt.JwtUserFactory;
import com.softserve.ita.sonet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDTO userDTO = userService.findByEmail(email);

        return JwtUserFactory.userToJwtUser(userDTO);

    }

}
