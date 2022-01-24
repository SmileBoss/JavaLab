package ru.itis.apiauthjavalabcom.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "role")
    private String roleName;

    private String roleDescription;

}
