package ru.itis.apiauthjavalabcom.domain;

import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthResponse {

    private String accessToken;
    private String refreshToken;

}
