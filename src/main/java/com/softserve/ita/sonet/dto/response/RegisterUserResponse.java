package com.softserve.ita.sonet.dto.response;

import com.softserve.ita.sonet.model.Status;
import lombok.Data;

@Data
public class RegisterUserResponse {

    private Long id;
    private String email;
    private String nickName;
    private Status status;

}
