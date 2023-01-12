package com.cotefacil.service;

import com.cotefacil.dto.CustomerDTO;
import com.cotefacil.model.Customer;
import com.cotefacil.repository.CustomerRepository;
import com.cotefacil.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository repository;

    @Transactional(readOnly = true)
    public Page<CustomerDTO> findAll(Pageable pageable) {
        Page<Customer> page = repository.findAll(pageable);
        return page.map(x -> new CustomerDTO(x));
    }

    @Transactional(readOnly = true)
    public CustomerDTO findById(Integer id) {
        Optional<Customer> obj = repository.findById(id);
        Customer entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
        return new CustomerDTO(entity);
    }

    @Transactional
    public CustomerDTO insert(CustomerDTO dto) {
        Customer entity = new Customer();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new CustomerDTO(entity);
    }

    @Transactional
    public CustomerDTO update(CustomerDTO dto, Integer id) {
        Customer entity = new Customer();
        try {
            entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
        return new CustomerDTO(entity);
    }

    public void deleteCustomer(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private static void copyDtoToEntity(CustomerDTO dto, Customer entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAge(dto.getAge());
    }
}
