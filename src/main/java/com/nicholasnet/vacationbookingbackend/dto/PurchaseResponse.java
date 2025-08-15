package com.nicholasnet.vacationbookingbackend.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor

public class PurchaseResponse {

    private final String orderTrackingNumber;
}
