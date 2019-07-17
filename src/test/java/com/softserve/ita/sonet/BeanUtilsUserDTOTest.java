package com.softserve.ita.sonet;


import com.softserve.ita.sonet.dto.model.UserDTO;
import com.softserve.ita.sonet.model.ActorRole;
import com.softserve.ita.sonet.model.Role;
import com.softserve.ita.sonet.model.Status;
import com.softserve.ita.sonet.model.User;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BeanUtilsUserDTOTest {

    @Test
     void testBeanUtilsMethod() {
        ModelMapper mapper = new ModelMapper();

        User user = new User();
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(ActorRole.ROLE_USER.name()));

        user.setNickname("@nickname");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPassword("testPassword");
        user.setStatus(Status.NOT_ACTIVE);
        user.setRoles(roles);


        UserDTO userDTO = mapper.map(user, UserDTO.class);
        System.out.println(userDTO);
        assertNotNull(userDTO.getRoles());
    }

}
