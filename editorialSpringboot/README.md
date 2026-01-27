
# Editorial Spring Boot

Proyecto backend desarrollado en Spring Boot para la gestión de préstamos de libros entre editoriales, colegios y profesores.

El sistema expone una API REST que permite administrar entidades simples y relaciones complejas, incluyendo préstamos con múltiples libros y sus editoriales asociadas.

---

## Tecnologías utilizadas

- Java 17  
- Spring Boot 3  
- Spring Data JPA (Hibernate)  
- PostgreSQL  
- Maven  
- Postman  

---

## Estructura del proyecto

```

editorialSpringboot/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── py/com/acosta/editorial/
│       │       ├── controllers
│       │       ├── model
│       │       ├── repository
│       │       ├── services
│       │       └── EditorialSpringbootApplication.java
│       │
│       └── resources/
│           └── application.properties
│
├── sql/
│   └── editorial_backup.sql
│
├── postman/
│   └── Editorial Springboot Local.postman_collection.json
│
├── pom.xml
└── README.md

````

---

## Base de datos

La base de datos utilizada es PostgreSQL.

Dentro de la carpeta `sql/` se incluye un backup completo que contiene:

- Estructura de la base de datos (schemas, tablas, claves foráneas y secuencias)
- Datos de ejemplo cargados

El esquema principal utilizado es `prestamolibros`.

### Restaurar la base de datos

1. Crear una base de datos vacía:

```sql
CREATE DATABASE editorial;
````

2. Restaurar el backup desde la raíz del proyecto:

```bash
psql -U postgres -d editorial < sql/editorial_backup.sql
```

---

## Configuración del proyecto

Editar el archivo `application.properties` con los datos de conexión locales:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/editorial
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## Ejecución del proyecto

Desde la raíz del proyecto:

```bash
./mvnw spring-boot:run
```

O ejecutando la clase principal desde el IDE:

```
EditorialSpringbootApplication
```

La aplicación se inicia por defecto en:

```
http://localhost:8080
```

---

## API REST

Todos los endpoints están disponibles bajo el prefijo:

```
/api
```

Ejemplos de recursos expuestos:

* `/api/aulas`
* `/api/libros`
* `/api/editoriales`
* `/api/colprofes`
* `/api/prestamos`

Los endpoints siguen convenciones REST utilizando los métodos HTTP GET, POST, PUT y DELETE.

---

## Pruebas con Postman

En la carpeta `postman/` se incluye una colección Postman con todos los endpoints del sistema.

### Importar la colección

1. Abrir Postman
2. Importar el archivo:

```
postman/Editorial Springboot Local.postman_collection.json
```

3. Definir la variable de entorno:

```
baseURL = http://localhost:8080
```

---

## Arquitectura

El proyecto sigue una arquitectura por capas:

* Controller: exposición de endpoints REST
* Service: lógica de negocio
* Repository: acceso a datos mediante JPA
* DTOs: separación entre el modelo interno y los contratos de la API

Las entidades simples utilizan CRUD directo, mientras que las entidades con relaciones complejas (por ejemplo, préstamos de libros) utilizan DTOs de request y response para:

* Evitar problemas de serialización
* Controlar exactamente qué datos se exponen
* Mantener desacoplada la API del modelo de persistencia

---

## Estado actual

* CRUD completo para entidades simples
* CRUD completo para préstamos con detalle de libros
* DTOs implementados para casos complejos
* Base de datos versionada mediante backup SQL
* Pruebas funcionales realizadas con Postman

---

## Próximo paso

Implementación de autenticación y login utilizando:

* Spring Security 6
* JWT (JSON Web Tokens)
