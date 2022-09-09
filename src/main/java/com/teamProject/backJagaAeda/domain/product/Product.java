package com.teamProject.backJagaAeda.domain.product;

import com.teamProject.backJagaAeda.domain.product.MeasureUnit;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 510)
    private String description;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "measure_unit_id", nullable = false)
    private MeasureUnit measureUnit;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @Column(name = "image_base64")
    private byte[] imageBase64;

    @Column(name = "date_added", nullable = false)
    private LocalDate dateAdded;

    @Column(name = "status", nullable = false, length = 1)
    private String status;

}