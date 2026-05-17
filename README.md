# ms-pedidos

Microservicio desarrollado con Spring Boot para la gestión de pedidos.

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Neon Database
- Docker
- Render
- Maven

## Endpoints

### Crear pedidos
POST /api/pedidos

### Listar pedidos
GET /api/pedidos

### Buscar pedidos por ID
GET /api/pedidos/{id}

### Actualizar pedido
PUT /api/pedidos/{id}

### Eliminar pedidos
DELETE /api/pedidos/{id}

## Variables de entorno necesarias

- PORT=8080
- DB_URL=jdbc:postgresql://ep-billowing-sea-acqfx3bn-pooler.sa-east-1.aws.neon.tech/neondb?sslmode=require
- DB_USERNAME=neondb_owner
- DB_PASSWORD=npg_EdAGe9L1xkjK

## Instrucciones para ejecutar en local

1. git clone https://github.com/wendytamayo/ms-pedidos.git

2. Configurar variables de entorno en IntelliJ, en properties:

- PORT=8081
- DB_URL=jdbc:postgresql://localhost:5432/pedidos
- DB_USERNAME=postgres
- DB_PASSWORD=*****

3. ejecutar:
   ./mvnw spring-boot:run

## Instrucciones básicas de despliegue

- Crear Dockerfile
- Subir proyecto a GitHub
- Crear Web Service en Render
- Configurar variables de entorno
- Desplegar servicio
- URL del servicio desplegado

## URL del servicio desplegado
https://ms-pedidos-klqe.onrender.com/api/pedidos