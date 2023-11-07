package com.example.fullstackspringapplication.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Changing CustomerDataAccessService to CustomerListDataAccessService
@Repository("list")
public class CustomerListDataAccessService implements CustomerDao{

    private static final List<Customer> customers;

    static {
        customers=new ArrayList<>();

        Customer naveen=new Customer(
                1,
                "Naveen",
                "naveen@gmail.com",
                22
        );
        customers.add(naveen);

        Customer prajwal=new Customer(
                2,
                "Prajwal",
                "prajwal@gmail.com",
                23
        );
        customers.add(prajwal);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
//                .orElseThrow(() -> new IllegalArgumentException("Customer with id [%s] Not Found".formatted(customerId)));
    }

    @Override
    public void insertPerson(Customer customer) {
        customers.add(customer);
//        return customers.stream().anyMatch(c->c.getEmail().equals())
    }

    @Override
    public boolean existsUserWithEmail(String email) {
        return customers.stream().anyMatch(c->c.getEmail().equals(email));
    }

    @Override
    public void deleteUserWithId(Integer id) {
        customers.stream().filter(c->c.getId().equals(id)).findFirst().ifPresent(customers::remove);
    }

    @Override
    public boolean existsUserWithId(Integer id) {
        return customers.stream().anyMatch(c->c.getId().equals(id));
    }


    @Override
    public void updateCustomer(Customer customer) {
        customers.add(customer);
    }

}
