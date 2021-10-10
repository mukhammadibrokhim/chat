package com.company.app.entities;

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
public class Message implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "chat_id", insertable = false,updatable = false)
//    private Chat chat;

    @Column(name = "chat_id")
    private Integer  chatId;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    private User author;

    @Column(name = "user_id")
    private Integer authorId;

    @Column(name = "text")
    private String text;

    @Column(name = "created_at", columnDefinition = "date")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date createdAt;

}
