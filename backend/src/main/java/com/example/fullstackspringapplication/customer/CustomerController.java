package com.example.fullstackspringapplication.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/customer/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //	@RequestMapping(value = "api/v1/customer",method = RequestMethod.GET)
//    @GetMapping("api/v1/customer")
    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    //path variable declaration
//    @GetMapping("api/v1/customer/{customerId}")
    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Integer customerId){
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerRegistrationRequest request){
        customerService.addCustomer(request);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable ("customerId") Integer customerId){
        customerService.deleteCustomerById(customerId);
    }

    @PutMapping("{customerId}")
    public void deleteCustomer(@PathVariable ("customerId") Integer customerId, @RequestBody CustomerUpdateRequest updateRequest)
    {
        customerService.updateCustomer(customerId, updateRequest);
    }

}
