package ubmagh.me.graphqlmicroserviceexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ubmagh.me.graphqlmicroserviceexample.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
