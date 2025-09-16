# Sistema de Gestión de Tickets de Soporte

Proyecto de prueba técnica: backend en Spring Boot y frontend en Vue 3 + Vite + Tailwind CSS.

---

## Tecnologías

### Backend

* Java 17
* Spring Boot
* Spring Security (mínimo, para pruebas)
* H2 en memoria
* JPA / Hibernate
* Maven

### Frontend

* Vue 3 + Vite
* Tailwind CSS v3
* Axios para consumir la API

---

## Estructura del proyecto

### Backend

```
src/main/java/com/kevin/support_backend
├── SupportBackendApplication.java  // Main + datos iniciales
├── config/SecurityConfig.java     // Configuración CORS y seguridad mínima
├── controller/AuthController.java // Login y registro
├── controller/TicketController.java
├── controller/UserController.java
├── model/User.java
├── model/Ticket.java
├── repository/UserRepository.java
├── repository/TicketRepository.java
└── service/UserService.java
```

### Frontend

```
src/
├── assets/
├── components/
│   └── tickets/
│       ├── TicketsList.vue
│       └── TicketForm.vue
├── views/
│   ├── Dashboard.vue
│   └── Login.vue
├── router/index.js
├── App.vue
├── main.js
└── services/
    ├── authService.js
    └── ticketService.js
```

---

## Funcionalidades

* CRUD de tickets
* Login con usuarios H2 predefinidos (`kevin` / `12345`, `admin` / `admin`)
* Dashboard con tabla de tickets
* Frontend conectado a API con Axios
* CORS habilitado para `http://localhost:5173`
* Seguridad mínima para pruebas técnicas

---

## Cómo correr el proyecto

### Backend

1. Abrir en tu IDE favorito (IntelliJ, Eclipse, VSCode)
2. Ejecutar `SupportBackendApplication`
3. H2 Console: `http://localhost:8080/h2-console`

   * JDBC URL: `jdbc:h2:mem:testdb`
   * Usuario: `sa`
   * Contraseña: (vacía)

### Frontend

1. Abrir terminal en la carpeta del frontend
2. Instalar dependencias:

```
npm install
```

3. Levantar el servidor:

```
npm run dev
```

4. Abrir navegador: `http://localhost:5173`

---

## Endpoints principales

### Auth

* `POST /api/auth/login` → login
* `POST /api/auth/register` → registro

### Tickets

* `GET /api/tickets` → listar tickets
* `GET /api/tickets/{id}` → obtener ticket
* `POST /api/tickets` → crear ticket
* `PUT /api/tickets/{id}` → actualizar ticket
* `DELETE /api/tickets/{id}` → eliminar ticket

### Users

* `GET /api/users` → listar usuarios
* `GET /api/users/{id}` → obtener usuario
* `POST /api/users` → crear usuario
* `PUT /api/users/{id}` → actualizar usuario
* `DELETE /api/users/{id}` → eliminar usuario

---

## Notas

* Proyecto hecho para **prueba técnica**, no se recomienda usar en producción.
* Spring Security está configurado **mínimamente** para que Vue pueda consumir la API sin problemas de 403/401.
