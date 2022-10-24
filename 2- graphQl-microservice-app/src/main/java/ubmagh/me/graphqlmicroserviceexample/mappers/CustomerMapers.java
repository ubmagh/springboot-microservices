package ubmagh.me.graphqlmicroserviceexample.mappers;

import org.springframework.beans.BeanUtils;
import ubmagh.me.graphqlmicroserviceexample.dtos.CustomerRequestDto;
import ubmagh.me.graphqlmicroserviceexample.entities.Customer;

public class CustomerMapers {

    public static Customer fromCustomerDtoToCustomer(CustomerRequestDto customer){
        Customer cs = new Customer();
        BeanUtils.copyProperties( customer, cs );
        return cs;
    }

}
