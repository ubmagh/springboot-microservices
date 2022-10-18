# Microservices communication using eureka + proxy gateway
 

> for this example, you'll have to start these apps in the order : eureka server -> customer-service -> billing-service -> gateway if you want

* this is because the billing service needs to query some data from customer service, and both of them need to be registered on eureka.

⭐ Exceptions management and returning Http codes


> ⚠ Dockerized everything, but still cannot establish communication between running containers (static ports & adresses), maybe this is why i need a configuration provider service

> project architecture : 

<img src="./images/1.png" width="500px">

<br>

<img src="./images/2.png" width="500px">

>
