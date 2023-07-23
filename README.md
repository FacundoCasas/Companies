# Proyecto de Gestión de Empresas

Este es un proyecto de gestión de empresas desarrollado con tecnologías Java y Spring Boot. El objetivo de este proyecto es gestionar empresas y sus transacciones.

## Requisitos previos

- Java 11
- Maven 3.8.x
- MySQL 8.x

## Configuración de la base de datos

Antes de ejecutar la aplicación, asegúrate de tener una base de datos MySQL creada y configurada correctamente. En el archivo `application.properties`, asegúrate de establecer las credenciales de acceso a la base de datos:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos
spring.datasource.username=nombre_de_usuario
spring.datasource.password=contraseña
```

# Instalación
Clona este repositorio en tu máquina local.
```command:
    git clone https://github.com/FacundoCasas/Companies.git
```
Navega a la carpeta del proyecto:

```command:
    cd companies
```

Compila y construye el proyecto usando Maven:

```command:
    mvn clean install
```

# Ejecución
Una vez que el proyecto ha sido compilado, puedes ejecutar la aplicación usando el siguiente comando:

```command:
    mvn spring-boot:run
```
La aplicación se ejecutará en http://localhost:8080.
# Documentación con Swagger
Las APIs están documentadas con Swagger. Puedes acceder a la documentación en http://localhost:8080/swagger-ui/index.html.
