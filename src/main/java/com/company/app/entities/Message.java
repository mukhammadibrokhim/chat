package com.company.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(targetEntity = Chat.class)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @OneToOne(targetEntity = User.class)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
    @JoinColumn(name = "user_id")
    private User author;

    @Column(name = "text", columnDefinition = "text")
    private String text;

    @Column(name = "created_at", columnDefinition = "date")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss.SSS")
    private Date createdAt;

}
