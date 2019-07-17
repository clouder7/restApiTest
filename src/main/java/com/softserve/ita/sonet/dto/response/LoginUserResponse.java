package com.softserve.ita.sonet.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserResponse {

    private String email;
    private String nickname;
    private String token;
    private String firstName;
    private String lastName;
}
