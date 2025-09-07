package com.nicholasnet.vacationbookingbackend.services;

import com.nicholasnet.vacationbookingbackend.dto.Purchase;
import com.nicholasnet.vacationbookingbackend.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
