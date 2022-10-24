package ubmagh.me.graphqlmicroserviceexample.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ubmagh.me.graphqlmicroserviceexample.dtos.CustomerRequestDto;
import ubmagh.me.graphqlmicroserviceexample.entities.Customer;
import ubmagh.me.graphqlmicroserviceexample.exceptions.CustomerNotFoundException;
import ubmagh.me.graphqlmicroserviceexample.mappers.CustomerMapers;
import ubmagh.me.graphqlmicroserviceexample.repositories.CustomerRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerRequestDto customer) {
        Customer customerr = CustomerMapers.fromCustomerDtoToCustomer(customer);
        customerr.setId(UUID.randomUUID().toString());
        return this.customerRepository.save(customerr);
    }

    @Override
    public Customer updateCustomer( String Id, CustomerRequestDto customerDto ) throws CustomerNotFoundException {
        Customer customer = this.customerRepository.findById(Id).orElseThrow( ()-> new CustomerNotFoundException(Id) );
        if( customerDto.getName()!=null ) customer.setName( customerDto.getName() );
        return this.customerRepository.save(customer);
    }

    @Override
    public String deleteCustomer(String id) throws CustomerNotFoundException {
        Customer customer = this.findById(id);
        this.customerRepository.deleteById(id);
        return id;
    }

    @Override
    public Customer findById(String Id) throws CustomerNotFoundException {
        Customer customer = this.customerRepository.findById(Id).orElseThrow( ()-> new CustomerNotFoundException(Id) );
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers()  {
        return customerRepository.findAll();
    }
}
