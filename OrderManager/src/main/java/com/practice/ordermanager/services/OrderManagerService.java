package com.practice.ordermanager.services;

import com.practice.ordermanager.models.OrderNumberDto;
import org.springframework.stereotype.Service;

@Service
public interface OrderManagerService {
    OrderNumberDto getActiveNumber();

    OrderNumberDto deleteLastNumber();

    OrderNumberDto generateNewNumber();

    OrderNumberDto solveNumber(int orderNumber);
}
