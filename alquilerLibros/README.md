# Sistema de Prestamo de Libros - Normalizacion

**Descripcion**
Proyecto basado en la relacion:
PRESTAMO_LIBROS (Colegio, Profesor, Asignatura/Habilidad, Aula, Curso, Libro, Editorial, Fecha_Prestamo)

Se aplica normalizacion hasta un modelo relacional con tablas auxiliares para relaciones muchos-a-muchos:
- Profesor <-> Colegio (colProfe)
- Prestamo <-> Libro (detallePrestamo)

**Base de datos** 

* Motor: PostgreSQL
* Base: normalizacionroshka
* Esquema: prestamolibros

**Dump SQL**

El script SQL (estructura y datos) esta en: sql/normalizacionroshka.sql

**Restauracion por terminal**

1) Crear la base de datos normalizacionroshka si no existe
2) Ejecutar: psql -U postgres -d normalizacionroshka -f sql/normalizacionroshka.sql

**Restauracion por pgAdmin**

1) Crear la base de datos normalizacionroshka
2) Usar Backup/Restore en formato Plain (.sql) o ejecutar el script con Query Tool

## Proyecto Java

**Tecnologias:**

- Java 21
- JDBC
- Maven
- PostgreSQL Driver

**Estructura**

- src/main/java/dao      DAOs (CRUD)
- src/main/java/models   Modelos
- src/main/java/Main     Ejecucion de prueba

**Configuracion de conexion**

En Main.java se define:

* DB URL: jdbc:postgresql://localhost:5432/normalizacionroshka
* Usuario: postgres
* Password: postgres

**Ejecucion**

mvn clean compile

Ejecutar Main desde el IDE o por Maven si esta configurado para exec

**Resultado**

El Main inserta datos de ejemplo, crea un prestamo y lo imprime en consola en formato de tabla.
