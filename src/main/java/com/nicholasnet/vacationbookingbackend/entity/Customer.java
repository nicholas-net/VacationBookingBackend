package com.nicholasnet.vacationbookingbackend.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name="postal_code", nullable = false)
    private String postal_code;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Timestamp lastUpdate;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division_id;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> cart;

    public void add(Cart customer_cart) {

        cart = new HashSet<>();

        if (customer_cart != null) {
            this.cart.add(customer_cart);
            customer_cart.setCustomer(this);
        }

    }

}
