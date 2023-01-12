package com.cotefacil.controller;

import com.cotefacil.dto.CustomerDTO;
import com.cotefacil.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    public CustomerService service;

    @GetMapping
    public ResponseEntity<Page<CustomerDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerDTO> insert(@Valid @RequestBody CustomerDTO dto) {

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@Valid @RequestBody CustomerDTO dto, @PathVariable Integer id) {
        return ResponseEntity.ok().body(service.update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
