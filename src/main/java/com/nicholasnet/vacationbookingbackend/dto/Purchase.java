package com.nicholasnet.vacationbookingbackend.dto;

import com.nicholasnet.vacationbookingbackend.entity.Cart;
import com.nicholasnet.vacationbookingbackend.entity.CartItem;
import com.nicholasnet.vacationbookingbackend.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems = new HashSet<>();

}
