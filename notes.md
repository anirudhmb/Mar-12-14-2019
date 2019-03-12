class Account {
	accountNumber, balance;
	
	void deposit(amount) {
	}
	
	void withdraw(amount) {
	}
	
	void transferFund(to, amount) {
	}
}

* Pool of Account objects
* Security functionality to transferFund method
* Transaction service for transferFund


* Enterprise Java Beans (EJB)

* Container (Jboss, WebLogic, WebSphere)

* interface Account { deposit, withdraw, transferFund }
* interface AccountHome extends Home {}
* class AccountBean implements EntityBean {}

* No constructors
* No final variables
* No static methods
* No threading code

* ejb-jar.xml (AccountBean (Transaction, Security, Object Pooling))

* Account.jar

* Drop them inside the container



* Spring Framework is a light-weight container
* Gives you all the enterprise services
* WITHOUT changing the design of the code
* POJO framework


* Spring BOOT is a framework that helps you BOOTSTRAP spring applications
* If you want to develop something very fast, and push it to production in the JVM stack, Spring BOOT is the leader


### @Configuration

* Any class annotated with @Configuration becomes a configuration file
* Configure beans (write methods) using @Bean annotation in this class

### @RestController vs. @Controller

* __@Controller__ + __@ResponseBody__ = __@RestController__

* @Controller returns a __view__ information 
* view needs to be resolved by a __ViewResolver__
* ViewResolvers are configured explicitly


## For DB

```sql
create database training;
use training;

create table persons( id int(4) not null primary key auto_increment, name varchar(40), age int(4));
```


