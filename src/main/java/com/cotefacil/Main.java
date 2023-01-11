package com.cotefacil;

import com.cotefacil.model.Customer;
import com.cotefacil.repository.CustomerRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    @GetMapping
//    public List<Customer> getCustomers(){
//        return customerRepository.findAll();
//    }
//
//    record NewCustomerRequest(
//            String name,
//            Integer age,
//            String email
//    ) {
//
//    }
//
//    @PostMapping("/addCustomer")
//    public void addCustomer(@RequestBody NewCustomerRequest request) {
//        Customer customer = new Customer();
//        customer.setName(request.name());
//        customer.setEmail(request.email());
//        customer.setAge(request.age());
//        customerRepository.save(customer);
//    }
//
//    @PutMapping("/{id}")
//    public void updateCustomer(@RequestBody NewCustomerRequest request, @PathVariable Integer id) {
//        Customer customer = new Customer();
//        customer = customerRepository.getReferenceById(id);
//        customer.setName(request.name());
//        customer.setEmail(request.email());
//        customer.setAge(request.age());
//        customerRepository.save(customer);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCustomer(@PathVariable Integer id) {
//        customerRepository.deleteById(id);
//    }

}
