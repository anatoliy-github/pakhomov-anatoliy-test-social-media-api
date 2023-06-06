package com.pakhomov.socialmedia.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 30, message = "Name must be of 3 - 30 characters")
    private String username;
    @Email(message = "Email not valid")
    @NotBlank(message = "Email is required")
    private String email;
    private String password;
}
