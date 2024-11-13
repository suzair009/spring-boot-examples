package com.backend.ecommerce.repository;


import com.backend.ecommerce.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRespository extends JpaRepository<Orders,Long> {
    Optional<Orders> findByBillingAddress(String address);

    List<Optional<Orders>> findByBillingAddressOrCustomerId(String address, String customerid);

    Optional<Orders> findByBillingAddressAndCustomerId(String address,String email);

    List<Optional<Orders>> findDistinctByCustomerId(String customerId);

    List<Optional<Orders>> findByFinalamountGreaterThan(double amount);

    List<Optional<Orders>> findByFinalamountLessThan(double amount);

    List<Optional<Orders>> findByCustomerIdLike(String customerId);

    List<Optional<Orders>> findByCustomerIdBetween(String customerId1,String customerId2);

    List<Optional<Orders>> findByCustomerIdIn(List<String> customerIds);

    List<Optional<Orders>> findTop3ByOrderByCustomerIdDesc();








}
