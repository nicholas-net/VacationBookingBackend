package com.nicholasnet.vacationbookingbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @Column(name = "vacation_title")
    private String vacation_title;

    @Column(name = "description")
    private String description;

    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    @Column(name = "image_url")
    private String image_URL;

    @CreationTimestamp
    @Column(name = "create_date")
    private Timestamp create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Timestamp last_update;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
    private Set<Excursion> excursions;

}
