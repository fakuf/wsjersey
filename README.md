# wsjerseys

Proyecto wstest
	* Maven
	
implementación JAX RS 2.0
  * Jersey 2.x
  
implementación JPA
  * Hibernate 5
  
Base de Datos 
  * hsqldb
  
Capa de datos realizada con patrón DAO

![patrondao](https://user-images.githubusercontent.com/10741694/43371160-a8f99470-9362-11e8-91be-1eb9250bf404.png)





Validaciones
  * org.hibernate.validator.constraints.@NotEmpty
  * javax.validation.constraints.@NotNull, @Min
  * Manejo de errores BAD_REQUEST 
  	* ConstraintViolationMapper

Testing
	* Junit 4.x  
   	 
Servidor 
  * WildFly 10.x
  * localhost:8080/personas/{dni} --> crear una nueva persona. La longitud del dni debe ser ocho dígitos.
  * localhost:8080/personas --> recuperar las personas.
 

