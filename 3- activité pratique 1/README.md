# Microservices communication using eureka + proxy gateway
 

> for this example, you'll have to start these apps in the order : eureka server -> customer-service -> billing-service

* this is because the billing service needs to query some data from customer service, and both of them need to be registered on eureka.
