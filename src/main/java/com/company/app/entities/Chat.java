package com.company.app.entities;

import lombok.*;
import org.springframework.data.relational.core.sql.In;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "chat")
public class Chat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "chat_name", unique = true, columnDefinition = "name")
    private String name;

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "chat_list",
            joinColumns = {@JoinColumn(name = "chat_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users;


    @Column(name = "created_at", columnDefinition = "date")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss.SSS")
    private Date createdAt;

    public User getuser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.contains(user)) {
                users.get(user.getId());
                return user;
            }
        }
        return null;
    }
}
