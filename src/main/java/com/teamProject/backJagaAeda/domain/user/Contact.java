package com.teamProject.backJagaAeda.domain.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "e_mail", nullable = false)
    private String eMail;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;



}