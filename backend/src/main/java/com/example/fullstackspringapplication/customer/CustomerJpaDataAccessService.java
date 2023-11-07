package com.example.fullstackspringapplication.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class CustomerJpaDataAccessService implements CustomerDao{

    private final CustomerRepository customerRepository;

    public CustomerJpaDataAccessService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
//        return Optional.empty();
        return customerRepository.findById(id);
    }

    @Override
    public void insertPerson(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public boolean existsUserWithEmail(String email) {
        return customerRepository.existsCustomerByEmail(email);
    }

    @Override
    public void deleteUserWithId(Integer id) {
        customerRepository.deleteById(id);

    }

    @Override
    public boolean existsUserWithId(Integer id) {
        return customerRepository.existsCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
