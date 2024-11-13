package com.backend.ecommerce.Service.impl;

import com.backend.ecommerce.Entity.Orders;
import com.backend.ecommerce.Service.OrderService;
import com.backend.ecommerce.repository.OrderRespository;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrderService {

    @Autowired
    private OrderRespository orderRespository;

    @Override
    public Orders createOrders(Orders orders) {
        return orderRespository.save(orders);
    }

    @Override
    public Orders getOrderById(Long Id) {
        Optional<Orders> order = orderRespository.findById(Id);
        return order.get();
    }

    @Override
    public List<Orders> showAllOrders() {
       return orderRespository.findAll();
    }

    @Override
    public Orders updateOrderById(Orders orders) {
        Orders order = orderRespository.findById(orders.getId()).get();
        order.setBillingAddress(orders.getBillingAddress());
        order.setShippingAddress(orders.getShippingAddress());
        order.setStatus(orders.getStatus());

        return orderRespository.save(order);
    }

    @Override
    public void deleteByOrderId(Long orderId) {
        orderRespository.deleteById(orderId);
    }

    @Override
    public Optional<Orders> findByBillingAddress(String address) {
        return orderRespository.findByBillingAddress(address);
    }

    @Override
    public List<Optional<Orders>> findByBillingAddressOrCustomerId(String address, String customerid) {
        return  orderRespository.findByBillingAddressOrCustomerId(address,customerid);
    }

    @Override
    public Optional<Orders> findByBillingAddressAndCustomerId(String address, String email) {
       return orderRespository.findByBillingAddressAndCustomerId(address,email);
    }

    @Override
    public List<Optional<Orders>> findDistinctByCustomerId(String customerId) {
        return orderRespository.findDistinctByCustomerId(customerId);
    }

    @Override
    public List<Optional<Orders>> findByFinalamountGreaterThan(double amount) {
        return orderRespository.findByFinalamountGreaterThan(amount);
    }

    @Override
    public List<Optional<Orders>> findByFinalamountLessThan(double amount) {
        return orderRespository.findByFinalamountLessThan(amount);
    }



    @Override
    public List<Optional<Orders>> findByCustomerIdLike(String customerId) {
        return orderRespository.findByCustomerIdLike(customerId);
    }

    @Override
    public List<Optional<Orders>> findByCustomerIdBetween(String customerId1, String customerId2) {
        return orderRespository.findByCustomerIdBetween(customerId1,customerId2);
    }

    @Override
    public List<Optional<Orders>> findByCustomerIdIn(List<String> customerIds) {
        return orderRespository.findByCustomerIdIn(customerIds);
    }

    @Override
    public List<Optional<Orders>> findTop3ByOrderByCustomerIdDesc() {
        return orderRespository.findTop3ByOrderByCustomerIdDesc();
    }


}
