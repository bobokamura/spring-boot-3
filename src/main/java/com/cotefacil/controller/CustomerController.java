package com.cotefacil.controller;

import com.cotefacil.dto.CustomerDTO;
import com.cotefacil.model.Customer;
import com.cotefacil.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    public CustomerService service;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerDTO> insert(@RequestBody CustomerDTO dto) {

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO dto, @PathVariable Integer id) {
        return ResponseEntity.ok().body(service.update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
