# SPRING BOOT INTEGRATED WITH JAVA SERVER FACES AND PRIMEFACES

## Synopsis

The project is a Spring Boot Application that is integrated with Java Server Faces and Primefaces.

Here I give you the structure of the project.

## Motivation

Playing around to have a running application that integrates Spring Boot with JSF was a real headache :boom:.

All the tutorials talk about the blessings of doing this in an easy fashion.

But that's not truth.

## Common Errors

### Error 1:
org.springframework.context.ApplicationContextException: Unable to start embedded container; nested exception is org.springframework.context.ApplicationContextException: Unable to start EmbeddedWebApplicationContext due to missing EmbeddedServletContainerFactory bean.

### Solution 1:
Add the following dependency:

```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jetty</artifactId>
		</dependency>
```
		
### Error 2:
javax.el.PropertyNotFoundException: /event.xhtml @18,64 value="#{eventBean.text}": Target Unreachable, identifier 'eventBean' resolved to null

### Solution 2:
A wrong solution that works is to change javax.faces.bean.ManagedBean to javax.annotation.ManagedBean.

You will see how it works.

But this is not a good solution you should use javax.faces.bean.ManagedBean.

And in your project:

:arrow_right: Properties :arrow_right: Java Build Path :arrow_right: Source 

Change the output folder to: spring-boot-jsf-primefaces/src/main/webapp/WEB-INF/classes


### Error 3:
Error: no se ha encontrado o cargado la clase principal rafael.alcocer.caldera.SpringBootJsfPrimefacesApplication

Error: Could not find or load main class rafael.alcocer.caldera.SpringBootJsfPrimefacesApplication

### Solution 3:
In your pom.xml you must add this <outputDirectory> inside <build>:

```xml
	<build>
		<outputDirectory>src/main/webapp/WEB-INF/classes</outputDirectory>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
```

## Tests

In Eclipse use: Run As -> Spring Boot App

Then open a browser with the following URL: http://localhost:8080/index.jsf

To see both Beans: Spring and JSF: http://localhost:8080/indexTest.jsf

## Notes
Don't forget that the Spring Beans must be declared in the class: SpringBootJsfPrimefacesApplication.java

## License

All work is under Apache 2.0 license