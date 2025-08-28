# Spring Boot DTO Validation Starter 🚀

A **practical starter kit for advanced validation in Spring Boot**.  
This project focuses on **validating DTOs with different approaches**, including standard validation, validation groups, and custom constraints. It also demonstrates how to handle validation errors cleanly in a centralized way.

### ✅ What you will learn:
- How to use **Bean Validation** with `@Valid`
- How to use **@Validated with validation groups** (`OnCreate`, `OnUpdate`)
- How to use **@Validated with path variables** for validating method parameters
- How to implement **custom constraint annotations and validators**
- How to structure DTOs for **create** and **update** operations
- How to handle input validation errors using **GlobalExceptionHandler**

---

## ✨ Key Features

- ✅ Layered architecture: Controller → Service → Repository
- ✅ **Validation strategies**:
  - Standard `@Valid` for request validation
  - `@Validated` with **groups** for conditional rules (create/update)
  - `@Validated` for **method-level validation** (e.g., `@PathVariable`)
  - **Custom validators** with `ConstraintValidator`
- ✅ Centralized error handling with `@ControllerAdvice`
- ✅ DTO pattern for clean request/response separation
- ✅ Manual mapping examples for DTOs and Entities
- ✅ RESTful CRUD endpoints for Products and Categories
- ✅ Interactive documentation with **Swagger/OpenAPI**
- ✅ H2 in-memory database for quick testing

---

## ⚠️ Why this project?

Spring Boot provides powerful validation via Bean Validation (Jakarta), but:
- Many projects mix concerns and lack structure
- Conditional validation rules (create vs update) are rarely explained well
- Custom validators are often overlooked

This starter demonstrates **how to structure validation cleanly**, while also showing:
- Where to put validation annotations
- How to use `OnCreate` and `OnUpdate` validation groups
- How to integrate validation into a layered architecture

---

## For Production Use:
If you need:
- ✅ Global error handling & unified response wrapper
- ✅ JWT Security and Authentication
- ✅ Logging, Profiles, and CI/CD setup
- ✅ Complete test coverage (MockMvc, Integration)

👉 Check out:
- 🔗 Tutorials on **[Dev.to](https://dev.to/gianfcop)**
- 💼 The **Pro Starter Kit on Gumroad**:
  - DTOs & MapStruct mappers for all entities
  - JWT Security
  - Advanced error handling
  - Logging, Profiles, Tests
  - [👉 Get it on Gumroad](https://gianfcop.gumroad.com/)

---

## ⚙️ Requirements

- **Java** 17+
- **Maven** 3.8+
- IDE: IntelliJ IDEA or VS Code

---

## 🚀 Quick Start

1. Clone the repo:
   ```bash
   git clone https://github.com/gianfcop/springboot-dto-validation-starter.git
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Open Swagger UI:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

## 🏗️ Project Structure
   ```
      src/main/java/com/starterkit/api
   ├── config/          → Swagger configuration
   ├── controller/      → REST Controllers
   │   ├── CategoryController.java  (@Valid example)
   │   └── ProductController.java   (@Validated with groups example)
   ├── dto/             → DTO classes (Request & Response)
   ├── entity/          → JPA Entities (Product, Category)
   ├── mapper/          → Manual mappers for DTO ↔ Entity
   ├── repository/      → Spring Data JPA Repositories
   ├── service/         → Business logic
   ├── validation/      → Custom annotations & validators
   └── SpringBootDtoValidationStarterApplication.java
   ```

## 📑 API Documentation

Interactive Swagger UI available at:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

Endpoints included:
- Products
   - `POST /api/products` → Create a product
   - `GET /api/products` → Get all products
   - `PUT /api/products/{id}` → Update product
   - `DELETE /api/products/{id}` → Delete product
- Categories
   - `POST /api/categories` → Create category
   - `GET /api/categories` → Get all categories

## ✅ Validation Examples Included:

- `@Valid` on DTOs (CategoryController)
- `@Validated(OnCreate.class)` and `@Validated(OnUpdate.class)` (ProductController)
- Custom validator for business rules using `ConstraintValidator`

## 🧪 Testing

This version is minimal and does not include automated tests, but you can easily test the API using Swagger UI or tools like Postman.

## ✅ Want More Features?

Check out **Full Pro Starter Kit** (available on [Gumroad](https://gianfcop.gumroad.com/)) with:
- JWT Security
- DTOs and Mappers
- Error Handling and Response Wrappers
- Logging, Profiles, and CI/CD ready structure
- Test Suite (MockMvc, Validation)
- Available on Gumroad

Also read the full tutorials on [Dev.to](https://dev.to/gianfcop).


## 📜 License

This project is licensed for educational and personal use only.
Do not redistribute or resell.