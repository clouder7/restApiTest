package com.softserve.ita.sonet.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUserRequest {

    @Email(message = "Email should be valid")
    @NotBlank
    private String email;

    @Size(min = 8, max = 32)
    @NotBlank
    private String password;

}
