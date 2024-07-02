package com.practice.ordermanager.services;

import com.practice.ordermanager.models.OrderNumberDo;
import com.practice.ordermanager.models.OrderNumberDto;
import com.practice.ordermanager.models.OrderNumberStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class OrderManagerServiceImpl implements OrderManagerService {
    List<OrderNumberDo> orderNumbers;
    private final AtomicInteger orderNumber = new AtomicInteger(0);

    @Override
    public OrderNumberDto getActiveNumber() {
        OrderNumberDo activeNumber = getActiveOrderNumber();
        return convertToDto(activeNumber);
    }

    private OrderNumberDo getActiveOrderNumber() {
        return orderNumbers.stream().filter(orderNumberDo -> orderNumberDo.getStatus().equals(OrderNumberStatus.ACTIVE)).findFirst().orElse(null);
    }

    @Override
    public OrderNumberDto deleteLastNumber() {
        OrderNumberDo lastNumber = orderNumbers.stream().max(Comparator.comparing(OrderNumberDo::getOrderNumber)).orElse(null);
        if (lastNumber != null) {
            orderNumbers.remove(lastNumber);
            return convertToDto(lastNumber);
        }
        return null;
    }

    @Override
    public OrderNumberDto generateNewNumber() {
        Date numberDate = new Date();
        int number = orderNumber.incrementAndGet();

        OrderNumberDo newNumber = new OrderNumberDo(number, numberDate, getLineNumber(number), OrderNumberStatus.ACTIVE);
        orderNumbers.add(newNumber);
        return convertToDto(newNumber);
    }

    private OrderNumberDto convertToDto(OrderNumberDo orderNumberDo) {
        return new OrderNumberDto(orderNumberDo.getOrderNumber(), orderNumberDo.getDate(), orderNumberDo.getLineNumber());
    }

    private int getLineNumber(int orderNumber) {
        if (orderNumbers==null || orderNumbers.isEmpty()) {
            return 0;
        }
        return (int) orderNumbers.stream().filter(orderNumberDo -> orderNumberDo.getOrderNumber()<(orderNumber)).filter(orderNumberDo -> !orderNumberDo.getStatus().equals(OrderNumberStatus.SOLVED)).count();
    }
}
