package com.nicholasnet.vacationbookingbackend.services;

import com.nicholasnet.vacationbookingbackend.dao.CustomerRepository;
import com.nicholasnet.vacationbookingbackend.dto.Purchase;
import com.nicholasnet.vacationbookingbackend.dto.PurchaseResponse;
import com.nicholasnet.vacationbookingbackend.entity.Cart;
import com.nicholasnet.vacationbookingbackend.entity.CartItem;
import com.nicholasnet.vacationbookingbackend.entity.Customer;
import com.nicholasnet.vacationbookingbackend.entity.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // extracts cart object from purchase
        Cart cart = purchase.getCart();

        // cart status ordered
        cart.setStatus(StatusType.ordered);

        // sets tracking number for the cart
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // populate cart with cart items
        Set <CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cart::add);

        // populate customer with cart
        Customer customer = purchase.getCustomer();
        customer.add(cart);

        // save customer to repository for storage
        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);


    }

    private String generateOrderTrackingNumber() {

        UUID uuid = UUID.randomUUID();
        // String version needed for API calls
        return uuid.toString();
    }
}
