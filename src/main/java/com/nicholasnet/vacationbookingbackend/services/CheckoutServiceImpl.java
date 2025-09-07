package com.nicholasnet.vacationbookingbackend.services;

import com.nicholasnet.vacationbookingbackend.dao.CartRepository;
import com.nicholasnet.vacationbookingbackend.dao.CustomerRepository;
import com.nicholasnet.vacationbookingbackend.dto.Purchase;
import com.nicholasnet.vacationbookingbackend.dto.PurchaseResponse;
import com.nicholasnet.vacationbookingbackend.entity.Cart;
import com.nicholasnet.vacationbookingbackend.entity.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.UUID;

import static com.nicholasnet.vacationbookingbackend.entity.StatusType.ordered;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // extracts cart object from purchase
        Cart cart = purchase.getCart();

        // cart status ordered
        cart.setStatus(ordered);

        // sets tracking number for the cart
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // populate cart with cart items
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> {
            cart.add(item);
            item.setCart(cart);
            item.getExcursions().forEach(excursion -> {
                excursion.setVacation(item.getVacation());
                excursion.getCartItems().add(item);
            });
        });

        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {

        UUID uuid = UUID.randomUUID();
        // String version needed for API calls
        return uuid.toString();
    }
}
