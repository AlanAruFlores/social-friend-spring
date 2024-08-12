package com.ar.social_friend.social_friend.domain;
/*Usuario*/

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate birthDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="contact",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name= "friend_id")
            }
    )
    private Set<User> listUsers;


    public User(Long id, String username, String password, String name, String surname, String email, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
