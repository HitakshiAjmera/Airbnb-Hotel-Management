package com.airbnb.airbnbapp.entity;

import com.airbnb.airbnbapp.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table (name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password; //will store the encrypted value of password

    @Column(nullable = false)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER) //jpa will another table app_user_roles  as we store array or list , it will store all the roles
    @Enumerated(EnumType.STRING)
    private Set<Role> role; //we will store actually values of role not ids

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDt;

    @UpdateTimestamp
    private LocalDateTime updatedDt;

}
