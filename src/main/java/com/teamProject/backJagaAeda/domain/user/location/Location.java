package com.teamProject.backJagaAeda.domain.user.location;

import com.teamProject.backJagaAeda.domain.user.region.Region;
import com.teamProject.backJagaAeda.domain.user.contact.Contact;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "latitude", precision = 8, scale = 6)
    private BigDecimal latitude;

    @Column(name = "longtitude", precision = 8, scale = 6)
    private BigDecimal longtitude;

    @Column(name = "address", nullable = false)
    private String address;

}