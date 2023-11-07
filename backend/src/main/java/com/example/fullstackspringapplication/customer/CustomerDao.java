package com.example.fullstackspringapplication.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);
    public void insertPerson(Customer customer);
    public boolean existsUserWithEmail(String email);
    public void deleteUserWithId(Integer id);
    public boolean existsUserWithId(Integer id);
    public void updateCustomer(Customer update);
}
