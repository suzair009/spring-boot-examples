package com.backend.ecommerce.Controller;

import com.backend.ecommerce.Entity.Orders;
import com.backend.ecommerce.Service.OrderService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/orders")
public class OrderController {

    private OrderService orderService;

    //****Start of basic crud functions

    @PostMapping("/createorders")
    public ResponseEntity<Orders> createOrders(@RequestBody  Orders orders){
        Orders _order = orderService.createOrders(orders);
        return new ResponseEntity<>(_order, HttpStatus.CREATED);
    }

    @GetMapping("/getId/{Id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable("Id") Long orderid){
        Orders order = orderService.getOrderById(orderid);
        return  new ResponseEntity<>(order,HttpStatus.OK);
    }

    @GetMapping("/showAllOrders")
    public ResponseEntity<List<Orders>> showAllOrders(){
        List<Orders> orders = orderService.showAllOrders();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @PutMapping("update/{Id}")
    public ResponseEntity<Orders> updateOrderById(@RequestBody Orders order,
                                                  @PathVariable("Id") Long orderid){
       order.setId(orderid);
       orderService.updateOrderById(order);
       return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @DeleteMapping("delete/{Id}")
    public ResponseEntity<String> deleteById(@PathVariable("Id") Long Id){
        orderService.deleteByOrderId(Id);
        return new ResponseEntity<>("Deleted Data on behalf of Id:"+Id,HttpStatus.OK);
    }

    //**End of Crud functions

    //some advance functions
    @GetMapping("/findaddress")
    public ResponseEntity<Optional<Orders>> getDataByBillingAddress(@RequestParam String address){
        Optional<Orders> orders  = orderService.findByBillingAddress(address);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
    
    @GetMapping("/findAddressorCustomerid")
    public ResponseEntity<List<Optional<Orders>>> getAddressOrCustomer(@RequestParam String address,
                                                                 @RequestParam String CustomerId){
        List<Optional<Orders>> orders = orderService.findByBillingAddressOrCustomerId(address,CustomerId);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
    
    @GetMapping("/findAddressAndCustomerid")
    public ResponseEntity<Optional<Orders>> getDataWithAndCondition(@RequestParam String address, String CustomerId){
        Optional<Orders> orders = orderService.findByBillingAddressAndCustomerId(address,CustomerId);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/distinct")
    public ResponseEntity<List<Optional<Orders>>> getValueDistinct(@RequestParam String customerId){
        List<Optional<Orders>> orders = orderService.findDistinctByCustomerId(customerId);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/greaterThan")
    public ResponseEntity<List<Optional<Orders>>> getDataGreaterThan(@RequestParam double amount){
        List<Optional<Orders>> orders = orderService.findByFinalamountGreaterThan(amount);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/LessThan")
    public ResponseEntity<List<Optional<Orders>>> getDataLessThan(@RequestParam double price){
        List<Optional<Orders>> orders = orderService.findByFinalamountLessThan(price);
        return  new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/likewise")
    public ResponseEntity<List<Optional<Orders>>> getDataLikeWise(@RequestParam String customerId) {
        List<Optional<Orders>> orders = orderService.findByCustomerIdLike(customerId);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/BetweenData")
    public ResponseEntity<List<Optional<Orders>>> getDataBetween(@RequestParam String customerId1,
                                                                 @RequestParam String customerId2){

        List<Optional<Orders>> orders = orderService.findByCustomerIdBetween(customerId1,customerId2);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/InData")
    public ResponseEntity<List<Optional<Orders>>> getDataIn(@RequestParam List<String> customerValues){
        List<Optional<Orders>> orders = orderService.findByCustomerIdIn(customerValues);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/DescData")
    public ResponseEntity<List<Optional<Orders>>> getDataDesc(@RequestParam String CustomerId){
        List<Optional<Orders>> orders = orderService.findTop3ByOrderByCustomerIdDesc();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

}
