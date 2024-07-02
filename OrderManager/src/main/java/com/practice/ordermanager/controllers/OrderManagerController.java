package com.practice.ordermanager.controllers;


import com.practice.ordermanager.services.OrderManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ordermanager")
public class OrderManagerController {

    OrderManagerService orderManagerService;

    @Autowired
    public OrderManagerController(OrderManagerService orderManagerService) {
        this.orderManagerService = orderManagerService;
    }

    @GetMapping("/activeNumber")
    public ResponseEntity<?> getActiveNumber() {
        return ResponseEntity.ok(orderManagerService.getActiveNumber());
    }

    @GetMapping("/generateNewNumber")
    public ResponseEntity<?> generateNewNumber() {
        return ResponseEntity.ok(orderManagerService.generateNewNumber());
    }

    @DeleteMapping("/deleteLastNumber")
    public ResponseEntity<?> deleteLastNumber() {
        return ResponseEntity.ok(orderManagerService.deleteLastNumber());
    }

}
