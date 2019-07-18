package com.softserve.ita.sonet.security.jwt;

import com.softserve.ita.sonet.dto.model.UserDTO;
import com.softserve.ita.sonet.model.Role;
import com.softserve.ita.sonet.model.Status;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    public JwtUserFactory(){

    }
    public static JwtUser userToJwtUser(UserDTO user){
        return new JwtUser(
                user.getEmail(),
                user.getPassword(),
                user.getStatus().equals(Status.ACTIVE),
                true,
                true,
                true,
                mapToGrandAuthorities(new ArrayList<>(user.getRoles()))
                );
    }

    private static List<GrantedAuthority> mapToGrandAuthorities(List<Role> userRoles){
        return userRoles.stream().map(role ->
                new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
