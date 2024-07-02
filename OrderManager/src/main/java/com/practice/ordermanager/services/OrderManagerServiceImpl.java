package com.practice.ordermanager.services;

import com.practice.ordermanager.models.OrderNumberDo;
import com.practice.ordermanager.models.OrderNumberDto;
import com.practice.ordermanager.models.OrderNumberStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderManagerServiceImpl implements OrderManagerService {
    private final List<OrderNumberDo> orderNumbers = new ArrayList<>();
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

    @Override
    public OrderNumberDto solveNumber(int orderNumber) {
        orderNumbers.stream().filter(orderNumberDo -> orderNumberDo.getOrderNumber() == orderNumber).findFirst().ifPresent(orderNumberDo -> orderNumberDo.setStatus(OrderNumberStatus.SOLVED));
        recalculateLineNumbers();
        return getActiveNumber();
    }

    private OrderNumberDto convertToDto(OrderNumberDo orderNumberDo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(orderNumberDo.getDate());
        return new OrderNumberDto(orderNumberDo.getOrderNumber(), formattedDate, orderNumberDo.getLineNumber());
    }

    private int getLineNumber(int orderNumber) {
        if (orderNumbers.isEmpty()) {
            return 0;
        }
        return (int) orderNumbers.stream().filter(orderNumberDo -> orderNumberDo.getOrderNumber() < (orderNumber)).filter(orderNumberDo -> !orderNumberDo.getStatus().equals(OrderNumberStatus.SOLVED)).count();
    }

    private void recalculateLineNumbers() {
        orderNumbers.stream().filter(orderNumberDo -> orderNumberDo.getStatus().equals(OrderNumberStatus.ACTIVE)).forEach(orderNumberDo -> orderNumberDo.setLineNumber(getLineNumber(orderNumberDo.getOrderNumber())));
    }
}
