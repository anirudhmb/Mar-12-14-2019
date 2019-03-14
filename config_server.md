#### Setting up Config Server

* Create a new Spring Boot project say, **MyConfigServer**
* Select **web** and **Config Server** libraries while creating the project
* Add **@EnableConfigServer** annotation to the **MyConfigServerApplication.java**

* Create **bootstrap.properties** file in *resources* folder
* Add the following lines to bootstrap.properties

```
server.port=8000
spring.profiles.active=native
```



#### Setting up Config Client

* Open PalindromeApp/pom.xml, AnagramApp/pom.xml
* Add the following after description elementin pom.xml

```xml

		<properties>
			<java.version>1.8</java.version>
			<spring-cloud.version>Greenwich.RC2</spring-cloud.version>
		</properties>

		<dependencies>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-web</artifactId>
			</dependency>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-starter-config</artifactId>
			</dependency>

			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-test</artifactId>
				<scope>test</scope>
			</dependency>
		</dependencies>

		<dependencyManagement>
			<dependencies>
				<dependency>
					<groupId>org.springframework.cloud</groupId>
					<artifactId>spring-cloud-dependencies</artifactId>
					<version>${spring-cloud.version}</version>
					<type>pom</type>
					<scope>import</scope>
				</dependency>
			</dependencies>
		</dependencyManagement>

		<build>
			<plugins>
				<plugin>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-maven-plugin</artifactId>
				</plugin>
			</plugins>
		</build>

		<repositories>
			<repository>
				<id>spring-milestones</id>
				<name>Spring Milestones</name>
				<url>https://repo.spring.io/milestone</url>
			</repository>
		</repositories>
		
```

* Rename **application.properties** to **bootstrap.properties** file in *resources* folder
* Add the following line

```
spring.cloud.config.uri=http://localhost:8000
welcome=Local Welcome 
```

* In the PalindromeController/AnagramController class add the following

```java
	@Value("${welcome}")
	private String welcome;
	
	@GetMapping("/")
	public String index() {
		return welcome;
	}
```

* Run http://localhost:7071/ or http://localhost:7072/  and observe the message you get

* Now add two files to MyConfigServer/src/main/resources folder
* **palindrome-app.properties**, **anagram-app.properties**
* Add **welcome=Welcome from server** in these two files
* Remove  **welcome=Local Welcome** from the bootstrap.properties in these two applications

* Now restart the services and run them and observe the welcome message 


