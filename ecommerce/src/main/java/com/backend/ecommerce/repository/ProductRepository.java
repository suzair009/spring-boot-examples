package com.backend.ecommerce.repository;

import com.backend.ecommerce.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products,Long> {

    //Select column1, column2, ... from table where name = ?
    public Products findByname(String name);

    //Select column1, column2, ... from table where description = ?
    public Products findBydescription(String description);

    //Select column1, column2, ... from table where Id = ?
    Optional<Products> findById(Long Id);

    //Select column1, column2, ... from table where name = ? or description = ?
    List<Products> findByNameOrDescription(String name,String description);

    //Select column1, column2, ... from table where name = ? and description = ?
    List<Products> findByNameAndDescription(String name,String description);

    //Select distinct description from table;
    public Products findDistinctByDescription(String description);

    //select column1, column2, ... from table where price > 200
    List<Products> findByPriceGreaterThan(double price);

    //select column1, column2, ... from table where price < 200
    List<Products> findByPriceLessThan(double price);

    //Select column1, column2, ... from table Where contains(description,"value");
    List<Products> findByNameContaining(String name);

    //Select column1, column2, ... from table Where name like '%value%'
    List<Products> findByNameLike(String name);

    //select column1, column2, ... from table where price between '50' and '300'
    List<Products> findByPriceBetween(double sPrice,double ePrice);

    //select column1, column2, ... from table where createdDate between 'value1' and 'value2'
    List<Products> findByDateCreatedBetween(LocalDateTime date1,LocalDateTime date2);

    //SELECT column1, column2, ...
    //FROM table_name
    //WHERE column_name IN (value1, value2, value3, ...);

    List<Products> findByNameIn(List<String> names);

    //SELECT column1, column2, ... from table Order by asc limit 2;
    List<Products> findFirst2ByOrderByNameAsc();

    //SELECT column1, column2, ... from table Order by desc limit 2;
    List<Products> findTop2ByOrderByPriceDesc();



}
