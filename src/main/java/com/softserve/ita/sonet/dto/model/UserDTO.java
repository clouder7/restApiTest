package com.softserve.ita.sonet.dto.model;

import com.softserve.ita.sonet.model.Role;
import com.softserve.ita.sonet.model.Status;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String email;
    private String nickname;
    private String firstName;
    private String lastName;
    private String password;
    private Status status = Status.NOT_ACTIVE;
    private LocalDateTime updateTime;
    private List<Role> roles;

}
