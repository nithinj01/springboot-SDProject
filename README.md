# springboot-thymeleaf-Icecream - Project

#Spring Boot Framework is widely used to develop REST APIs and standalone web applications

#The primary feature of Spring Boot is Autoconfiguration. It automatically configures the classes based on the requirement.

#It offers several plugins for working with an embedded and in-memory database such as H2.

#Spring Boot comes with the concept of starter in pom.xml file that internally takes care of downloading the dependencies JARs based on Spring Boot Requirement.


#H2 database configurations

**spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect **

#persist the data
** spring.datasource.url=jdbc:h2:file:/data/sampledata
spring.datasource.url=jdbc:h2:C:/data/sampledata **

#enabling the H2 console
** spring.h2.console.enabled=true **

welcome.message: Project

