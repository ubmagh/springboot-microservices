package ubmagh.me.graphqlmicroserviceexample.services;

import org.springframework.stereotype.Service;
import ubmagh.me.graphqlmicroserviceexample.dtos.CustomerRequestDto;
import ubmagh.me.graphqlmicroserviceexample.entities.Customer;
import ubmagh.me.graphqlmicroserviceexample.exceptions.CustomerNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface CustomerService {

    public Customer createCustomer(CustomerRequestDto customer);
    public Customer updateCustomer( String Id, CustomerRequestDto customer) throws CustomerNotFoundException;
    public String deleteCustomer( String id) throws CustomerNotFoundException;
    public Customer findById( String Id) throws CustomerNotFoundException;

    List<Customer> getAllCustomers();
}
