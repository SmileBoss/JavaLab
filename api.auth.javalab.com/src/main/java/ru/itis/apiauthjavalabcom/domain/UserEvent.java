package ru.itis.apiauthjavalabcom.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserEvent {
    private String username;
    private String email;
}
