package com.teamProject.backJagaAeda.domain.order;

import com.teamProject.backJagaAeda.domain.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "buyer_user_id", nullable = false)
    private User buyerUser;

    @Column(name = "status", nullable = false, length = 1)
    private String status;

    @Column(name = "date_time", nullable = false)
    private Instant dateTime;


}