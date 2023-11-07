package com.example.fullstackspringapplication.customer;
import com.example.fullstackspringapplication.exception.DuplicateResourceException;
import com.example.fullstackspringapplication.exception.RequestValidationRequest;
import com.example.fullstackspringapplication.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao)
    {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers()
    {
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomer(Integer id){
        return customerDao.selectCustomerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id [%s] Not Found"
                        .formatted(id)));
    }

    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest)
    {

        String email = customerRegistrationRequest.email();

        if(customerDao.existsUserWithEmail(email))
        {
            throw new DuplicateResourceException("User with Email [%s] Already Exists".formatted(email));
        }

        Customer customer = new Customer(
                customerRegistrationRequest.name(),
                customerRegistrationRequest.email(),
                customerRegistrationRequest.age()
        );
        customerDao.insertPerson(customer);

    }

    public void deleteCustomerById(Integer customerId)
    {

        if(!customerDao.existsUserWithId(customerId)) {
             throw new ResourceNotFoundException("Customer with id [%s] Not Found"
                    .formatted(customerId));
        }
            customerDao.deleteUserWithId(customerId);
    }

    public void updateCustomer(Integer customerId, CustomerUpdateRequest updateRequest)
    {


        Customer customer=getCustomer(customerId);
        boolean changes = false;

        if(updateRequest.name() !=null && !updateRequest.name().equals(customer.getName()))
        {
            customer.setName(updateRequest.name());
            changes=true;
        }


        if(updateRequest.age() !=null && !updateRequest.age().equals(customer.getAge()))
        {
            customer.setAge(updateRequest.age());
            changes=true;
        }

        if(updateRequest.email() !=null && !updateRequest.email().equals(customer.getEmail()))
        {
            if(customerDao.existsUserWithEmail(updateRequest.email())){
                throw new DuplicateResourceException("[%s] Email Already Taken".formatted(updateRequest.email()));
            }

            customer.setEmail(updateRequest.email());
            changes=true;
        }

        if(!changes)
        {
            throw new RequestValidationRequest("No data changes Found!");
        }

        customerDao.updateCustomer(customer);

    }



//    public Customer(String name, String email, Integer age)

}