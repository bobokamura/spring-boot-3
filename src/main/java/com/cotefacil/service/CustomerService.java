package com.cotefacil.service;

import com.cotefacil.dto.CustomerDTO;
import com.cotefacil.model.Customer;
import com.cotefacil.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository repository;

    @Transactional(readOnly = true)
    public List<CustomerDTO> findAll() {
        List<Customer> list = repository.findAll();
        return list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public CustomerDTO findById(Integer id) {
        Optional<Customer> obj = repository.findById(id);
        Customer entity = obj.get();
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
        entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new CustomerDTO(entity);
    }

    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

    private static void copyDtoToEntity(CustomerDTO dto, Customer entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAge(dto.getAge());
    }
}
