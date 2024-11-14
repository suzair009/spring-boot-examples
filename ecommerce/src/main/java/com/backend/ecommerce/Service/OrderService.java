package com.backend.ecommerce.Service;

import com.backend.ecommerce.Entity.Orders;
import jakarta.persistence.criteria.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Orders createOrders(Orders orders);

    List<Orders> createAllOrders(List<Orders> orders);

   Orders getOrderById(Long Id);

   List<Orders> showAllOrders();

   Orders updateOrderById(Orders orders);

   void deleteByOrderId(Long orderId);

    Optional<Orders> findByBillingAddress(String address);

    List<Optional<Orders>> findByBillingAddressOrCustomerId(String address,String customerid);

    Optional<Orders> findByBillingAddressAndCustomerId(String address,String email);

    List<Optional<Orders>> findDistinctByCustomerId(String customerId);

    List<Optional<Orders>> findByFinalamountGreaterThan(double amount);

    List<Optional<Orders>> findByFinalamountLessThan(double amount);

    List<Optional<Orders>> findByCustomerIdLike(String customerId);

    List<Optional<Orders>> findByCustomerIdBetween(String customerId1,String customerId2);

    List<Optional<Orders>> findByCustomerIdIn(List<String> customerIds);

    List<Optional<Orders>> findTop3ByOrderByCustomerIdDesc();

}
