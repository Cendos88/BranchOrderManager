package com.practice.ordermanager.controllers;


import com.practice.ordermanager.models.OrderNumberDto;
import com.practice.ordermanager.services.OrderManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ordermanager")
public class OrderManagerController {

    OrderManagerService orderManagerService;

    @Autowired
    public OrderManagerController(OrderManagerService orderManagerService) {
        this.orderManagerService = orderManagerService;
    }

    @GetMapping("/activeNumber")
    public ResponseEntity<OrderNumberDto> getActiveNumber() {
        return ResponseEntity.ok(orderManagerService.getActiveNumber());
    }

    @GetMapping("/generateNewNumber")
    public ResponseEntity<OrderNumberDto> generateNewNumber() {
        return ResponseEntity.ok(orderManagerService.generateNewNumber());
    }

    @DeleteMapping("/deleteLastNumber")
    public ResponseEntity<OrderNumberDto> deleteLastNumber() {
        return ResponseEntity.ok(orderManagerService.deleteLastNumber());
    }

}
