# Microservice Connectors: REST vs. GraphQL Comparative Study

[![Java](https://img.shields.io/badge/Java-100%25-orange.svg)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

> **A comprehensive demonstration and comparison between Traditional RESTful APIs and GraphQL architectures through account management microservice implementation.**

---

## 📋 Table of Contents

- [About This Repository](#about-this-repository)
- [Repository Metrics](#repository-metrics)
- [Project Architecture](#project-architecture)
- [Technologies Stack](#technologies-stack)
- [Project Implementation: Travaux à Faire](#project-implementation-travaux-à-faire)
  - [Phase 1: Data Layer Foundation](#phase-1-data-layer-foundation-tasks-1-4)
  - [Phase 2: RESTful Web Services](#phase-2-restful-web-services-tasks-5-8)
  - [Phase 3: Business Logic Decoupling](#phase-3-business-logic-and-decoupling-tasks-9-10)
  - [Phase 4: GraphQL Implementation](#phase-4-graphql-web-service-implementation-task-11)
- [Architectural Comparison: REST vs GraphQL](#architectural-comparison-rest-vs-graphql)
- [Quick Start Guide](#quick-start-guide)
- [API Documentation](#api-documentation)
- [Testing Guide](#testing-guide)
- [Key Learnings](#key-learnings)
- [Future Roadmap](#future-roadmap)

---

## 🎯 About This Repository

This project implements a **single microservice** designed for **Compte (Account) management**. Its primary function is to serve as a **comprehensive demonstration and comparison** between two major web service architectures:

- **Traditional RESTful APIs** - Resource-based architecture with multiple endpoints
- **GraphQL** - Query-based architecture with a single, flexible endpoint

The repository showcases **real-world implementation patterns**, addresses common architectural challenges (such as the *boucle infinie* serialization problem in REST), and demonstrates best practices for building modern, production-ready microservices using the Spring Boot ecosystem.

### 🎓 Educational Objectives

This project follows a structured learning approach based on:
- **Video Tutorial 1**: [Creating a Microservice for Bank Account Management](https://www.youtube.com/watch?v=2-qIoZcvhAw)
- **Video Tutorial 2**: [GraphQL Implementation with Spring Boot](https://www.youtube.com/watch?v=FsdR09jlqaE)

---

## 📊 Repository Metrics

| Metric | Detail |
|--------|--------|
| **Repository** | `malakzaidi/microservice_rest_and_graphQl_connectors` |
| **Owner** | malakzaidi |
| **Language** | Java 100.0% |
| **Commits** | 10 Commits |
| **Stars/Forks** | 0 stars, 0 forks |
| **Visibility** | Public |
| **Technologies** | Spring Boot, Spring Data JPA, H2, Lombok, REST, GraphQL |

---

## 🏗 Project Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                     CLIENT APPLICATIONS                      │
│          (Postman, Web Apps, Mobile Apps)                    │
└────────────┬────────────────────────────────┬────────────────┘
             │                                │
    ┌────────▼────────┐              ┌───────▼────────┐
    │   REST API      │              │  GraphQL API   │
    │ Multiple URIs   │              │  Single URI    │
    │ /api/comptes/*  │              │   /graphql     │
    └────────┬────────┘              └───────┬────────┘
             │                                │
             └────────────┬───────────────────┘
                          │
         ┌────────────────▼──────────────────┐
         │      WEB LAYER (Controllers)      │
         │  • CompteRestController           │
         │  • CompteGraphQLController        │
         │  • Spring Data REST (@RestResource)│
         └────────────────┬──────────────────┘
                          │
         ┌────────────────▼──────────────────┐
         │    SERVICE LAYER (Business Logic) │
         │  • CompteService Interface        │
         │  • CompteServiceImpl              │
         │  • Transaction Management         │
         │  • Business Rules Validation      │
         └────────────────┬──────────────────┘
                          │
         ┌────────────────▼──────────────────┐
         │      DTO & MAPPER LAYER           │
         │  • CompteDTO                      │
         │  • CompteRequestDTO               │
         │  • CompteMapper (MapStruct)       │
         │  • Projections                    │
         └────────────────┬──────────────────┘
                          │
         ┌────────────────▼──────────────────┐
         │    DATA ACCESS LAYER (DAO)        │
         │  • CompteRepository               │
         │  • Spring Data JPA                │
         │  • Custom Query Methods           │
         └────────────────┬──────────────────┘
                          │
         ┌────────────────▼──────────────────┐
         │      PERSISTENCE LAYER            │
         │  • JPA Entity: Compte             │
         │  • H2 In-Memory Database          │
         │  • Hibernate ORM                  │
         └───────────────────────────────────┘
```

**Architectural Principles:**
- **Separation of Concerns**: Clear distinction between web, service, and data layers
- **Dependency Inversion**: Higher layers depend on abstractions, not concrete implementations
- **DTO Pattern**: Decoupling of internal entity structure from external API contracts
- **Single Responsibility**: Each layer has a well-defined, focused purpose

---

## 🛠 Technologies Stack

### Core Framework
| Technology | Version | Purpose |
|------------|---------|---------|
| **Spring Boot** | 3.x | Foundation framework for rapid microservice development |
| **Spring Web** | 3.x | RESTful web service creation and HTTP handling |
| **Spring Data JPA** | 3.x | Simplified data access layer with ORM capabilities |
| **Spring Data REST** | 3.x | Automatic REST API generation from repositories |
| **Spring GraphQL** | 1.x | GraphQL API implementation with Spring integration |

### Database & Persistence
| Technology | Version | Purpose |
|------------|---------|---------|
| **H2 Database** | 2.x | Embedded in-memory database for development and testing |
| **Hibernate** | 6.x | JPA implementation for object-relational mapping |

### Development Utilities
| Technology | Version | Purpose |
|------------|---------|---------|
| **Lombok** | 1.18.x | Reduction of boilerplate code (getters, setters, builders) |
| **MapStruct** | 1.5.x | Compile-time safe mapping between entities and DTOs |

### API Documentation
| Technology | Version | Purpose |
|------------|---------|---------|
| **SpringDoc OpenAPI** | 2.x | Automatic OpenAPI 3.0 specification generation |
| **Swagger UI** | - | Interactive API documentation interface |

### Build & Project Management
| Technology | Version | Purpose |
|------------|---------|---------|
| **Maven** | 3.x | Dependency management and build automation |
| **Java** | 17+ | Programming language |

---

## 📚 Project Implementation: Travaux à Faire

The development process was structured into **11 distinct tasks**, ensuring robust separation of concerns and covering multiple API exposure methods.

---

### **Phase 1: Data Layer Foundation (Tasks 1-4)**

#### **Task 1: Créer un projet Spring Boot avec les dépendances Web, Spring Data JPA, H2, Lombok**

The standard Spring Boot infrastructure was established with essential dependencies.

**Dependencies Configuration (pom.xml):**

```xml
<dependencies>
    <!-- Web Layer: REST API Support -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Data Layer: JPA & Hibernate -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- Database: H2 In-Memory -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Code Generation: Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    
    <!-- REST API: Spring Data REST -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-rest</artifactId>
    </dependency>
    
    <!-- GraphQL: Spring GraphQL -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-graphql</artifactId>
    </dependency>
    
    <!-- Documentation: OpenAPI/Swagger -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.1.0</version>
    </dependency>
    
    <!-- Testing: Spring Boot Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

**Application Configuration (application.properties):**

```properties
# ==========================================
# SERVER CONFIGURATION
# ==========================================
server.port=8080
spring.application.name=compte-microservice

# ==========================================
# H2 DATABASE CONFIGURATION
# ==========================================
spring.datasource.url=jdbc:h2:mem:bank_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# ==========================================
# JPA & HIBERNATE CONFIGURATION
# ==========================================
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# ==========================================
# H2 CONSOLE (Development Tool)
# ==========================================
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# ==========================================
# GRAPHQL CONFIGURATION
# ==========================================
spring.graphql.graphiql.enabled=true
spring.graphql.graphiql.path=/graphiql
spring.graphql.path=/graphql

# ==========================================
# SWAGGER/OPENAPI CONFIGURATION
# ==========================================
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true
```

---

#### **Task 2: Créer l'entité JPA Compte**

The core domain model, the **Compte (Account)** entity, was defined using JPA annotations for object-relational mapping (ORM).

```java
package com.example.comptesmicroservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * JPA Entity representing a Bank Account (Compte)
 * Demonstrates ORM mapping with Hibernate
 */
@Entity
@Data                    // Lombok: Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor       // Lombok: Generates no-args constructor (required by JPA)
@AllArgsConstructor      // Lombok: Generates all-args constructor
@Builder                 // Lombok: Implements Builder pattern for object creation
public class Compte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Double solde;  // Account balance
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateCreation;  // Creation date
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeCompte type;  // Account type (COURANT or EPARGNE)
}
```

**Account Type Enumeration:**

```java
package com.example.comptesmicroservice.enums;

/**
 * Enumeration defining types of bank accounts
 */
public enum TypeCompte {
    COURANT,   // Current/Checking Account
    EPARGNE    // Savings Account
}
```

**Key JPA Annotations Explained:**
- `@Entity`: Marks the class as a JPA entity (database table)
- `@Id`: Designates the primary key field
- `@GeneratedValue`: Configures auto-increment strategy
- `@Column`: Specifies column properties (nullable, unique, etc.)
- `@Temporal`: Defines date/time precision
- `@Enumerated`: Maps enum to database column (STRING vs ORDINAL)

---

#### **Task 3: Créer l'interface CompteRepository basée sur Spring Data**

A repository interface extending Spring Data JPA's capabilities was created, allowing for **automatic generation** of standard CRUD methods without writing implementation code.

```java
package com.example.comptesmicroservice.repositories;

import com.example.comptesmicroservice.entities.Compte;
import com.example.comptesmicroservice.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for Compte entity
 * Automatically provides CRUD operations via Spring Data JPA
 */
@Repository
@RepositoryRestResource(path = "comptes-rest")  // For Spring Data REST exposure
public interface CompteRepository extends JpaRepository<Compte, Long> {
    
    // ========================================
    // DERIVED QUERY METHODS
    // Spring Data automatically implements these based on method name
    // ========================================
    
    /**
     * Find all accounts of a specific type
     * Method name convention: findBy + PropertyName
     */
    @RestResource(path = "byType")
    List<Compte> findByType(@Param("type") TypeCompte type);
    
    /**
     * Find accounts with balance greater than specified amount
     */
    List<Compte> findBySoldeGreaterThan(Double solde);
    
    /**
     * Find accounts with balance between two values
     */
    List<Compte> findBySoldeBetween(Double min, Double max);
    
    // ========================================
    // JPQL CUSTOM QUERIES
    // Using @Query annotation for complex queries
    // ========================================
    
    /**
     * Custom JPQL query to find high-balance accounts
     */
    @Query("SELECT c FROM Compte c WHERE c.solde > :solde")
    List<Compte> findComptesWithHighBalance(@Param("solde") Double solde);
    
    /**
     * Calculate total balance across all accounts
     */
    @Query("SELECT SUM(c.solde) FROM Compte c")
    Double calculateTotalBalance();
    
    /**
     * Count accounts by type
     */
    @Query("SELECT COUNT(c) FROM Compte c WHERE c.type = :type")
    Long countByType(@Param("type") TypeCompte type);
}
```

**Spring Data JPA Magic:**

Spring Data JPA automatically provides these methods without implementation:
- `save(Compte compte)` - Create or update
- `findById(Long id)` - Find by primary key
- `findAll()` - Retrieve all records
- `findAll(Pageable pageable)` - Paginated retrieval
- `deleteById(Long id)` - Delete by ID
- `count()` - Count all records
- `existsById(Long id)` - Check existence

---

#### **Task 4: Tester la couche DAO**

Validation of the Data Access Object (DAO) layer was performed to confirm that persistence operations function correctly against the H2 database.

```java
package com.example.comptesmicroservice;

import com.example.comptesmicroservice.entities.Compte;
import com.example.comptesmicroservice.enums.TypeCompte;
import com.example.comptesmicroservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class CompteMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteMicroserviceApplication.class, args);
    }

    /**
     * CommandLineRunner for DAO Layer Testing
     * Executes on application startup
     */
    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            System.out.println("========================================");
            System.out.println("   DAO LAYER TESTING - STARTING");
            System.out.println("========================================\n");
            
            // ========================================
            // TEST 1: CREATE - Inserting Sample Data
            // ========================================
            System.out.println("TEST 1: Creating sample accounts...");
            Stream.of("COURANT", "EPARGNE", "COURANT", "EPARGNE", "COURANT")
                .forEach(typeStr -> {
                    Compte compte = Compte.builder()
                        .solde(1000 + Math.random() * 9000)  // Random balance 1000-10000
                        .dateCreation(new Date())
                        .type(TypeCompte.valueOf(typeStr))
                        .build();
                    Compte saved = compteRepository.save(compte);
                    System.out.println("  ✓ Created: " + saved);
                });
            
            System.out.println("\n========================================");
            System.out.println("TEST 2: READ - Fetching All Accounts");
            System.out.println("========================================");
            List<Compte> allComptes = compteRepository.findAll();
            allComptes.forEach(c -> System.out.println("  → " + c));
            System.out.println("  Total Accounts: " + allComptes.size());
            
            // ========================================
            // TEST 3: CUSTOM QUERY - Find by Type
            // ========================================
            System.out.println("\n========================================");
            System.out.println("TEST 3: Finding COURANT Accounts");
            System.out.println("========================================");
            List<Compte> courantAccounts = compteRepository.findByType(TypeCompte.COURANT);
            courantAccounts.forEach(c -> System.out.println("  → " + c));
            
            // ========================================
            // TEST 4: DERIVED QUERY - High Balance
            // ========================================
            System.out.println("\n========================================");
            System.out.println("TEST 4: Finding High Balance Accounts (> 5000)");
            System.out.println("========================================");
            List<Compte> highBalance = compteRepository.findBySoldeGreaterThan(5000.0);
            highBalance.forEach(c -> System.out.println("  → " + c));
            
            // ========================================
            // TEST 5: JPQL QUERY - Total Balance
            // ========================================
            System.out.println("\n========================================");
            System.out.println("TEST 5: Calculating Total Balance");
            System.out.println("========================================");
            Double totalBalance = compteRepository.calculateTotalBalance();
            System.out.println("  Total Balance Across All Accounts: " + totalBalance + " DH");
            
            // ========================================
            // TEST 6: UPDATE Operation
            // ========================================
            System.out.println("\n========================================");
            System.out.println("TEST 6: Updating an Account");
            System.out.println("========================================");
            if (!allComptes.isEmpty()) {
                Compte compteToUpdate = allComptes.get(0);
                System.out.println("  Before: " + compteToUpdate);
                compteToUpdate.setSolde(compteToUpdate.getSolde() + 1000);
                compteRepository.save(compteToUpdate);
                System.out.println("  After: " + compteRepository.findById(compteToUpdate.getId()).get());
            }
            
            System.out.println("\n========================================");
            System.out.println("   DAO LAYER TESTING - COMPLETED ✓");
            System.out.println("========================================");
        };
    }
}
```

**Testing Verification:**
- ✅ Database connectivity established
- ✅ Entity persistence working correctly
- ✅ Custom query methods functioning as expected
- ✅ JPQL queries executing successfully
- ✅ CRUD operations validated

---

### **Phase 2: RESTful Web Services (Tasks 5-8)**

REST services were implemented using both standard `@RestController` components and the high-productivity features of **Spring Data REST**.

---

#### **Task 5: Créer le Web service Restfull qui permet de gérer des comptes**

A traditional REST Controller (`@RestController`) was implemented to manage Compte resources, mapping standard HTTP verbs (GET, POST, PUT, DELETE) to specific URI paths. This approach offers the **highest level of control** over the request and response lifecycle.

```java
package com.example.comptesmicroservice.web;

import com.example.comptesmicroservice.dto.CompteDTO;
import com.example.comptesmicroservice.dto.CompteRequestDTO;
import com.example.comptesmicroservice.enums.TypeCompte;
import com.example.comptesmicroservice.services.CompteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for Bank Account Management
 * Provides full CRUD operations via HTTP endpoints
 */
@RestController
@RequestMapping("/api/comptes")
@RequiredArgsConstructor
@Tag(name = "Compte Management", description = "APIs for managing bank accounts")
public class CompteRestController {
    
    private final CompteService compteService;
    
    // ========================================
    // READ OPERATIONS (GET)
    // ========================================
    
    @GetMapping
    @Operation(summary = "Get all accounts", description = "Retrieve a list of all bank accounts")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    public ResponseEntity<List<CompteDTO>> getAllComptes() {
        return ResponseEntity.ok(compteService.getAllComptes());
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get account by ID", description = "Retrieve a specific account by its identifier")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Account found"),
        @ApiResponse(responseCode = "404", description = "Account not found")
    })
    public ResponseEntity<CompteDTO> getCompteById(
            @Parameter(description = "Account ID", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(compteService.getCompteById(id));
    }
    
    @GetMapping("/type/{type}")
    @Operation(summary = "Get accounts by type", description = "Filter accounts by type (COURANT or EPARGNE)")
    public ResponseEntity<List<CompteDTO>> getComptesByType(
            @Parameter(description = "Account type", required = true)
            @PathVariable TypeCompte type) {
        return ResponseEntity.ok(compteService.getComptesByType(type));
    }
    
    @GetMapping("/statistics/total-balance")
    @Operation(summary = "Get total balance", description = "Calculate the sum of all account balances")
    public ResponseEntity<Double> getTotalBalance() {
        return ResponseEntity.ok(compteService.getTotalBalance());
    }
    
    // ========================================
    // CREATE OPERATIONS (POST)
    // ========================================
    
    @PostMapping
    @Operation(summary = "Create new account", description = "Create a new bank account")
    @ApiResponse(responseCode = "201", description = "Account created successfully")
    public ResponseEntity<CompteDTO> createCompte(
            @Valid @RequestBody CompteRequestDTO request) {
        CompteDTO created = compteService.createCompte(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    // ========================================
    // UPDATE OPERATIONS (PUT)
    // ========================================
    
    @PutMapping("/{id}")
    @Operation(summary = "Update account", description = "Update an existing account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Account updated successfully"),
        @ApiResponse(responseCode = "404", description = "Account not found")
    })
    public ResponseEntity<CompteDTO> updateCompte(
            @PathVariable Long id,
            @Valid @RequestBody CompteRequestDTO request) {
        return ResponseEntity.ok(compteService.updateCompte(id, request));
    }
    
    // ========================================
    // DELETE OPERATIONS (DELETE)
    // ========================================
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete account", description = "Delete an account by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Account deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Account not found")
    })
    public ResponseEntity<Void> deleteCompte(@PathVariable Long id) {
        compteService.deleteCompte(id);
        return ResponseEntity.noContent().build();
    }
}
```

**RESTful Design Principles Applied:**
- ✅ **Resource-based URLs**: `/api/comptes` represents the collection resource
- ✅ **HTTP Verbs**: GET (read), POST (create), PUT (update), DELETE (delete)
- ✅ **Proper Status Codes**: 200 (OK), 201 (Created), 204 (No Content), 404 (Not Found)
- ✅ **JSON Format**: Automatic serialization/deserialization
- ✅ **Stateless**: Each request contains all necessary information

---

#### **Task 6: Tester le web micro-service en utilisant un client REST comme Postman**

Verification of the REST endpoints was conducted using **Postman** to ensure correct request handling, response status codes, and accurate JSON payload delivery.

**Test Scenarios:**

**1. GET All Accounts**
```http
GET http://localhost:8080/api/comptes
Accept: application/json
```

**Expected Response (200 OK):**
```json
[
    {
        "id": 1,
        "solde": 5432.87,
        "dateCreation": "2024-01-15",
        "type": "COURANT"
    },
    {
        "id": 2,
        "solde": 8765.43,
        "dateCreation": "2024-01-15",
        "type": "EPARGNE"
    }
]
```

---

**2. GET Account by ID**
```http
GET http://localhost:8080/api/comptes/1
Accept: application/json
```

**Expected Response (200 OK):**
```json
{
    "id": 1,
    "solde": 5432.87,
    "dateCreation": "2024-01-15",
    "type": "COURANT"
}
```

**Error Case (404 Not Found):**
```json
{
    "timestamp": "2024-01-15T10:30:00",
    "status": 404,
    "error": "Not Found",
    "message": "Compte not found with id: 999",
    "path": "/api/comptes/999"
}
```

---

**3. POST Create New Account**
```http
POST http://localhost:8080/api/comptes
Content-Type: application/json

{
    "solde": 5000.0,
    "type": "COURANT"
}
```

**Expected Response (201 Created):**
```json
{
    "id": 6,
    "solde": 5000.0,
    "dateCreation": "2024-01-15",
    "type": "COURANT"
}
```

---

**4. PUT Update Account**
```http
PUT http://localhost:8080/api/comptes/1
Content-Type: application/json

{
    "solde": 7500.0,
    "type": "EPARGNE"
}
```

**Expected Response (200 OK):**
```json
{
    "id": 1,
    "solde": 7500.0,
    "dateCreation": "2024-01-15",
    "type": "EPARGNE"
}
```

---

**5. DELETE Account**
```http
DELETE http://localhost:8080/api/comptes/1
```

**Expected Response (204 No Content):**
```
(Empty body)
```

---

**6. GET Accounts by Type**
```http
GET http://localhost:8080/api/comptes/type/COURANT
Accept: application/json
```

**Expected Response (200 OK):**
```json
[
    {
        "id": 1,
        "solde": 5432.87,
        "dateCreation": "2024-01-15",
        "type": "COURANT"
    },
    {
        "id": 3,
        "solde": 3214.56,
        "dateCreation": "2024-01-15",
        "type": "COURANT"
    }
]
```

---

#### **Task 7: Générer et tester la documentation Swagger des API Rest du Web service**

Integration of **OpenAPI/Swagger** was performed to automatically generate interactive API documentation. This **mandatory step** ensures that external consumers can easily discover and understand the available REST endpoints.

**OpenAPI Configuration:**

```java
package com.example.comptesmicroservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

/**
 * OpenAPI/Swagger Configuration
 * Generates interactive API documentation
 */
@Configuration
public class OpenAPIConfig {
    
    @Bean
    public OpenAPI compteMicroserviceAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Bank Account Microservice API")
                .version("1.0.0")
                .description("Complete REST API for managing bank accounts with support for CRUD operations")
                .contact(new Contact()
                    .name("Malak Zaidi")
                    .email("contact@example.com")
                    .url("https://github.com/malakzaidi"))
                .license(new License()
                    .name("MIT License")
                    .url("https://opensource.org/licenses/MIT")))
            .servers(List.of(
                new Server()
                    .url("http://localhost:8080")
                    .description("Development Server")
            ));
    }
}
```

**Accessing Swagger Documentation:**

| Resource | URL |
|----------|-----|
| **Swagger UI** | `http://localhost:8080/swagger-ui.html` |
| **OpenAPI JSON** | `http://localhost:8080/v3/api-docs` |
| **OpenAPI YAML** | `http://localhost:8080/v3/api-docs.yaml` |

**Swagger Features:**
- 📖 **Interactive Documentation**: Browse all endpoints with descriptions
- 🧪 **Try It Out**: Test API calls directly from the browser
- 📋 **Request/Response Examples**: See sample payloads
- 🔍 **Schema Explorer**: Understand data models
- 🔐 **Authentication Support**: Configure security schemes

---

#### **Task 8: Exposer une API Restful en utilisant Spring Data Rest en exploitant des projections**

**Spring Data REST** was employed to automatically expose the `CompteRepository` functionality as REST endpoints, significantly speeding up the API exposure process.

**Repository Configuration for Spring Data REST:**

```java
package com.example.comptesmicroservice.repositories;

import com.example.comptesmicroservice.entities.Compte;
import com.example.comptesmicroservice.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Spring Data REST automatically exposes this repository as REST endpoints
 * Base path: /comptes-rest
 */
@RepositoryRestResource(path = "comptes-rest")
public interface CompteRepository extends JpaRepository<Compte, Long> {
    
    @RestResource(path = "byType")
    List<Compte> findByType(@Param("type") TypeCompte type);
    
    @RestResource(path = "highBalance")
    List<Compte> findBySoldeGreaterThan(@Param("solde") Double solde);
}
```

**Automatic Endpoints Generated:**

| HTTP Method | Endpoint | Description |
|-------------|----------|-------------|
| GET | `/comptes-rest` | List all accounts (with pagination) |
| GET | `/comptes-rest/{id}` | Get account by ID |
| POST | `/comptes-rest` | Create new account |
| PUT | `/comptes-rest/{id}` | Full update |
| PATCH | `/comptes-rest/{id}` | Partial update |
| DELETE | `/comptes-rest/{id}` | Delete account |
| GET | `/comptes-rest/search` | Discover search operations |
| GET | `/comptes-rest/search/byType?type=COURANT` | Search by type |
| GET | `/comptes-rest/search/highBalance?solde=5000` | Search high balance |

**HATEOAS Response Example:**

```json
{
  "_embedded": {
    "comptes": [
      {
        "solde": 5432.87,
        "dateCreation": "2024-01-15",
        "type": "COURANT",
        "_links": {
          "self": {
            "href": "http://localhost:8080/comptes-rest/1"
          },
          "compte": {
            "href": "http://localhost:8080/comptes-rest/1"
          }
        }
      }
    ]
  },
  "_links": {
    "first": {
      "href": "http://localhost:8080/comptes-rest?page=0&size=20"
    },
    "self": {
      "href": "http://localhost:8080/comptes-rest"
    },
    "next": {
      "href": "http://localhost:8080/comptes-rest?page=1&size=20"
    },
    "last": {
      "href": "http://localhost:8080/comptes-rest?page=2&size=20"
    },
    "search": {
      "href": "http://localhost:8080/comptes-rest/search"
    }
  },
  "page": {
    "size": 20,
    "totalElements": 50,
    "totalPages": 3,
    "number": 0
  }
}
```

---

**Projections: Solving the Over-Fetching Problem**

Projections allow the API client to request **only a defined subset of fields** from the Compte entity, optimizing network bandwidth.

```java
package com.example.comptesmicroservice.projections;

import com.example.comptesmicroservice.entities.Compte;
import com.example.comptesmicroservice.enums.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

/**
 * Projection 1: Summary View (minimal information)
 */
@Projection(name = "compteProjection", types = Compte.class)
public interface CompteProjection {
    Long getId();
    Double getSolde();
    TypeCompte getType();
    // dateCreation is intentionally excluded
}

/**
 * Projection 2: Detailed View (all information)
 */
@Projection(name = "compteDetail", types = Compte.class)
public interface CompteDetailProjection {
    Long getId();
    Double getSolde();
    String getDateCreation();
    TypeCompte getType();
}
```

**Using Projections:**

```http
GET http://localhost:8080/comptes-rest?projection=compteProjection
```

**Response with Projection:**
```json
{
  "_embedded": {
    "comptes": [
      {
        "id": 1,
        "solde": 5432.87,
        "type": "COURANT"
      }
    ]
  }
}
```

---

### **⚠️ Critical REST Serialization Challenge: The Boucle Infinie (Infinite Loop)**

A **significant architectural issue** in REST APIs built directly on JPA entities is the **boucle infinie** (infinite loop) that occurs during JSON serialization.

**Problem Scenario:**

```java
@Entity
public class Compte {
    @Id
    private Long id;
    
    // Bidirectional relationship
    @OneToMany(mappedBy = "compte")
    private List<Transaction> transactions;
}

@Entity
public class Transaction {
    @Id
    private Long id;
    
    // Bidirectional relationship
    @ManyToOne
    private Compte compte;
}
```

**What Happens:**
1. REST controller tries to serialize `Compte` to JSON
2. Jackson serializer encounters `transactions` list
3. Serializes each `Transaction` object
4. Each `Transaction` references back to `Compte`
5. **Infinite loop** → `StackOverflowError`

**Traditional REST Solution (Pollutes Entity):**

```java
@Entity
public class Compte {
    @Id
    private Long id;
    
    @OneToMany(mappedBy = "compte")
    @JsonManagedReference  // ❌ API concern in domain model
    private List<Transaction> transactions;
}

@Entity
public class Transaction {
    @Id
    private Long id;
    
    @ManyToOne
    @JsonBackReference  // ❌ API concern in domain model
    private Compte compte;
}
```

**Problems with This Approach:**
- ❌ **Tight Coupling**: API serialization logic pollutes domain entities
- ❌ **Single Representation**: Can't have different JSON views
- ❌ **Maintenance Nightmare**: Changes to API affect database model

**Superior Solution: DTO Pattern (Used in This Project)**

```java
// Clean entity without JSON annotations
@Entity
public class Compte {
    @Id
    private Long id;
    
    @OneToMany(mappedBy = "compte")
    private List<Transaction> transactions;  // ✅ No serialization annotations
}

// DTO for API exposure
public class CompteDTO {
    private Long id;
    private Double solde;
    private Date dateCreation;
    private TypeCompte type;
    // ✅ No bidirectional references
}
```

---

### **Phase 3: Business Logic and Decoupling (Tasks 9-10)**

---

#### **Task 9: Créer les DTOs et Mappers**

**DTOs (Data Transfer Objects)** were established as the **definitive contract** for data entering and leaving the microservice, ensuring that the internal JPA entity structure remains hidden.

**DTO Definitions:**

```java
package com.example.comptesmicroservice.dto;

import com.example.comptesmicroservice.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * DTO for reading Compte data (responses)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompteDTO {
    private Long id;
    private Double solde;
    private Date dateCreation;
    private TypeCompte type;
}
```

```java
package com.example.comptesmicroservice.dto;

import com.example.comptesmicroservice.enums.TypeCompte;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for creating/updating Compte data (requests)
 * Includes validation rules
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteRequestDTO {
    
    @NotNull(message = "Balance cannot be null")
    @Min(value = 0, message = "Balance must be positive")
    private Double solde;
    
    @NotNull(message = "Account type cannot be null")
    private TypeCompte type;
}
```

**Mapper Interface (MapStruct):**

```java
package com.example.comptesmicroservice.mappers;

import com.example.comptesmicroservice.dto.CompteDTO;
import com.example.comptesmicroservice.dto.CompteRequestDTO;
import com.example.comptesmicroservice.entities.Compte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

/**
 * MapStruct Mapper for Compte Entity <-> DTO conversion
 * Generates implementation at compile-time
 */
@Mapper(componentModel = "spring")
public interface CompteMapper {
    
    /**
     * Convert Entity to DTO
     */
    CompteDTO toDTO(Compte compte);
    
    /**
     * Convert DTO to Entity
     */
    Compte toEntity(CompteDTO dto);
    
    /**
     * Convert list of Entities to DTOs
     */
    List<CompteDTO> toDTOList(List<Compte> comptes);
    
    /**
     * Convert Request DTO to Entity for creation
     * Ignores ID (will be generated)
     * Sets dateCreation automatically
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateCreation", expression = "java(new java.util.Date())")
    Compte requestToEntity(CompteRequestDTO requestDTO);
    
    /**
     * Update existing entity from Request DTO
     * Preserves ID and dateCreation
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateCreation", ignore = true)
    void updateEntityFromRequest(CompteRequestDTO requestDTO, @MappingTarget Compte compte);
}
```

**Why Use DTOs?**

| Benefit | Description |
|---------|-------------|
| **🔒 Security** | Don't expose internal entity structure or sensitive fields |
| **🔄 Flexibility** | Different DTOs for different API consumers (mobile, web, partner) |
| **✅ Validation** | Add validation rules specific to API layer |
| **📦 Versioning** | Easier to maintain multiple API versions |
| **🎯 Clear Contract** | Explicit definition of what data is expected/returned |
| **🛡️ Protection** | Changes to entity don't break API contracts |

**MapStruct Benefits:**
- ⚡ **Compile-Time Generation**: No reflection, high performance
- 🔍 **Type-Safe**: Compile errors for mismatched types
- 🧹 **No Boilerplate**: Automatic getter/setter calls
- 🎨 **Customizable**: Custom mapping logic when needed

---

#### **Task 10: Créer la couche Service (métier) et du micro service**

The **Service layer** was created to encapsulate all business logic, enforce data integrity, handle transaction boundaries, and coordinate interactions between the Web layer and the Data Access Layer.

**Service Interface:**

```java
package com.example.comptesmicroservice.services;

import com.example.comptesmicroservice.dto.CompteDTO;
import com.example.comptesmicroservice.dto.CompteRequestDTO;
import com.example.comptesmicroservice.enums.TypeCompte;
import java.util.List;

/**
 * Service interface defining business operations for Compte management
 */
public interface CompteService {
    
    // Query operations
    List<CompteDTO> getAllComptes();
    CompteDTO getCompteById(Long id);
    List<CompteDTO> getComptesByType(TypeCompte type);
    
    // Command operations
    CompteDTO createCompte(CompteRequestDTO request);
    CompteDTO updateCompte(Long id, CompteRequestDTO request);
    void deleteCompte(Long id);
    
    // Business operations
    Double getTotalBalance();
    Long countComptesByType(TypeCompte type);
    CompteDTO depositMoney(Long id, Double amount);
    CompteDTO withdrawMoney(Long id, Double amount);
}
```

**Service Implementation:**

```java
package com.example.comptesmicroservice.services;

import com.example.comptesmicroservice.dto.CompteDTO;
import com.example.comptesmicroservice.dto.CompteRequestDTO;
import com.example.comptesmicroservice.entities.Compte;
import com.example.comptesmicroservice.enums.TypeCompte;
import com.example.comptesmicroservice.exceptions.ResourceNotFoundException;
import com.example.comptesmicroservice.exceptions.InsufficientBalanceException;
import com.example.comptesmicroservice.mappers.CompteMapper;
import com.example.comptesmicroservice.repositories.CompteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Service implementation with business logic
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CompteServiceImpl implements CompteService {
    
    private final CompteRepository compteRepository;
    private final CompteMapper compteMapper;
    
    // ========================================
    // QUERY OPERATIONS
    // ========================================
    
    @Override
    @Transactional(readOnly = true)
    public List<CompteDTO> getAllComptes() {
        log.info("Fetching all accounts");
        List<Compte> comptes = compteRepository.findAll();
        return compteMapper.toDTOList(comptes);
    }
    
    @Override
    @Transactional(readOnly = true)
    public CompteDTO getCompteById(Long id) {
        log.info("Fetching account with id: {}", id);
        Compte compte = compteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Compte not found with id: " + id));
        return compteMapper.toDTO(compte);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<CompteDTO> getComptesByType(TypeCompte type) {
        log.info("Fetching accounts of type: {}", type);
        List<Compte> comptes = compteRepository.findByType(type);
        return compteMapper.toDTOList(comptes);
    }
    
    // ========================================
    // COMMAND OPERATIONS
    // ========================================
    
    @Override
    public CompteDTO createCompte(CompteRequestDTO request) {
        log.info("Creating new account of type: {}", request.getType());
        
        Compte compte = compteMapper.requestToEntity(request);
        compte.setDateCreation(new Date());
        
        Compte savedCompte = compteRepository.save(compte);
        log.info("Account created successfully with id: {}", savedCompte.getId());
        
        return compteMapper.toDTO(savedCompte);
    }
    
    @Override
    public CompteDTO updateCompte(Long id, CompteRequestDTO request) {
        log.info("Updating account with id: {}", id);
        
        Compte compte = compteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Compte not found with id: " + id));
        
        compteMapper.updateEntityFromRequest(request, compte);
        Compte updatedCompte = compteRepository.save(compte);
        
        log.info("Account updated successfully with id: {}", id);
        return compteMapper.toDTO(updatedCompte);
    }
    
    @Override
    public void deleteCompte(Long id) {
        log.info("Deleting account with id: {}", id);
        
        if (!compteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Compte not found with id: " + id);
        }
        
        compteRepository.deleteById(id);
        log.info("Account deleted successfully with id: {}", id);
    }
    
    // ========================================
    // BUSINESS OPERATIONS
    // ========================================
    
    @Override
    @Transactional(readOnly = true)
    public Double getTotalBalance() {
        log.info("Calculating total balance across all accounts");
        Double total = compteRepository.calculateTotalBalance();
        return total != null ? total : 0.0;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Long countComptesByType(TypeCompte type) {
        log.info("Counting accounts of type: {}", type);
        return compteRepository.countByType(type);
    }
    
    @Override
    public CompteDTO depositMoney(Long id, Double amount) {
        log.info("Depositing {} to account {}", amount, id);
        
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        
        Compte compte = compteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Compte not found with id: " + id));
        
        compte.setSolde(compte.getSolde() + amount);
        Compte updatedCompte = compteRepository.save(compte);
        
        log.info("Deposit successful. New balance: {}", updatedCompte.getSolde());
        return compteMapper.toDTO(updatedCompte);
    }
    
    @Override
    public CompteDTO withdrawMoney(Long id, Double amount) {
        log.info("Withdrawing {} from account {}", amount, id);
        
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        
        Compte compte = compteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Compte not found with id: " + id));
        
        if (compte.getSolde() < amount) {
            throw new InsufficientBalanceException(
                "Insufficient balance. Available: " + compte.getSolde());
        }
        
        compte.setSolde(compte.getSolde() - amount);
        Compte updatedCompte = compteRepository.save(compte);
        
        log.info("Withdrawal successful. New balance: {}", updatedCompte.getSolde());
        return compteMapper.toDTO(updatedCompte);
    }
}
```

**Exception Handling:**

```java
package com.example.comptesmicroservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
```

```java
package com.example.comptesmicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Global exception handler for REST APIs
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFound(
            ResourceNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());
        
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<Map<String, Object>> handleInsufficientBalance(
            InsufficientBalanceException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Bad Request");
        body.put("message", ex.getMessage());
        
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
```

**Service Layer Benefits:**

| Benefit | Description |
|---------|-------------|
| **🎯 Business Logic Centralization** | All business rules in one place |
| **🔒 Transaction Management** | `@Transactional` ensures data consistency |
| **♻️ Reusability** | Same service used by REST and GraphQL |
| **🧪 Testability** | Easy to mock and unit test |
| **📝 Logging** | Centralized logging for debugging |
| **🛡️ Validation** | Business rule validation before persistence |

---

### **Phase 4: GraphQL Web Service Implementation (Task 11)**

---

#### **Task 11: Créer un Web service GraphQL pour ce Micro-service**

A **GraphQL endpoint** was implemented, operating based on a strongly typed schema defining all available data structures and operations.

**GraphQL Schema Definition (schema.graphqls):**

```graphql
# ========================================
# QUERY TYPE - Read Operations
# ========================================
type Query {
    "Get all bank accounts"
    allComptes: [Compte]!
    
    "Get a specific account by ID"
    compteById(id: ID!): Compte
    
    "Filter accounts by type"
    comptesByType(type: TypeCompte!): [Compte]!
    
    "Calculate total balance across all accounts"
    totalBalance: Float!
    
    "Count accounts by type"
    countByType(type: TypeCompte!): Int!
}

# ========================================
# MUTATION TYPE - Write Operations
# ========================================
type Mutation {
    "Create a new bank account"
    createCompte(input: CompteInput!): Compte!
    
    "Update an existing account"
    updateCompte(id: ID!, input: CompteInput!): Compte!
    
    "Delete an account by ID"
    deleteCompte(id: ID!): Boolean!
    
    "Deposit money into an account"
    depositMoney(id: ID!, amount: Float!): Compte!
    
    "Withdraw money from an account"
    withdrawMoney(id: ID!, amount: Float!): Compte!
}

# ========================================
# OBJECT TYPES
# ========================================
type Compte {
    id: ID!
    solde: Float!
    dateCreation: String!
    type: TypeCompte!
}

# ========================================
# INPUT TYPES
# ========================================
input CompteInput {
    solde: Float!
    type: TypeCompte!
}

# ========================================
# ENUM TYPES
# ========================================
enum TypeCompte {
    COURANT
    EPARGNE
}
```

**GraphQL Controller Implementation:**

```java
package com.example.comptesmicroservice.web;

import com.example.comptesmicroservice.dto.CompteDTO;
import com.example.comptesmicroservice.dto.CompteRequestDTO;
import com.example.comptesmicroservice.enums.TypeCompte;
import com.example.comptesmicroservice.services.CompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

/**
 * GraphQL Controller for Bank Account Operations
 * Single endpoint handles all operations via /graphql
 */
@Controller
@RequiredArgsConstructor
public class CompteGraphQLController {
    
    private final CompteService compteService;
    
    // ========================================
    // QUERY RESOLVERS (Read Operations)
    // ========================================
    
    @QueryMapping
    public List<CompteDTO> allComptes() {
        return compteService.getAllComptes();
    }
    
    @QueryMapping
    public CompteDTO compteById(@Argument Long id) {
        return compteService.getCompteById(id);
    }
    
    @QueryMapping
    public List<CompteDTO> comptesByType(@Argument TypeCompte type) {
        return compteService.getComptesByType(type);
    }
    
    @QueryMapping
    public Double totalBalance() {
        return compteService.getTotalBalance();
    }
    
    @QueryMapping
    public Long countByType(@Argument TypeCompte type) {
        return compteService.countComptesByType(type);
    }
    
    // ========================================
    // MUTATION RESOLVERS (Write Operations)
    // ========================================
    
    @MutationMapping
    public CompteDTO createCompte(@Argument CompteRequestDTO input) {
        return compteService.createCompte(input);
    }
    
    @MutationMapping
    public CompteDTO updateCompte(@Argument Long id, @Argument CompteRequestDTO input) {
        return compteService.updateCompte(id, input);
    }
    
    @MutationMapping
    public Boolean deleteCompte(@Argument Long id) {
        compteService.deleteCompte(id);
        return true;
    }
    
    @MutationMapping
    public CompteDTO depositMoney(@Argument Long id, @Argument Double amount) {
        return compteService.depositMoney(id, amount);
    }
    
    @MutationMapping
    public CompteDTO withdrawMoney(@Argument Long id, @Argument Double amount) {
        return compteService.withdrawMoney(id, amount);
    }
}
```

**GraphQL Query Examples:**

**1. Get All Accounts:**
```graphql
query {
  allComptes {
    id
    solde
    dateCreation
    type
  }
}
```

**Response:**
```json
{
  "data": {
    "allComptes": [
      {
        "id": "1",
        "solde": 5432.87,
        "dateCreation": "2024-01-15",
        "type": "COURANT"
      },
      {
        "id": "2",
        "solde": 8765.43,
        "dateCreation": "2024-01-15",
        "type": "EPARGNE"
      }
    ]
  }
}
```

---

**2. Get Account by ID (Selective Fields):**
```graphql
query {
  compteById(id: 1) {
    id
    solde
    type
  }
}
```

**Response:**
```json
{
  "data": {
    "compteById": {
      "id": "1",
      "solde": 5432.87,
      "type": "COURANT"
    }
  }
}
```

---

**3. Filter Accounts by Type:**
```graphql
query {
  comptesByType(type: COURANT) {
    id
    solde
  }
}
```

---

**4. Calculate Total Balance:**
```graphql
query {
  totalBalance
  countByType(type: COURANT)
}
```

**Response:**
```json
{
  "data": {
    "totalBalance": 25678.45,
    "countByType": 3
  }
}
```

---

**5. Create New Account (Mutation):**
```graphql
mutation {
  createCompte(input: {solde: 5000.0, type: EPARGNE}) {
    id
    solde
    dateCreation
    type
  }
}
```

**Response:**
```json
{
  "data": {
    "createCompte": {
      "id": "6",
      "solde": 5000.0,
      "dateCreation": "2024-01-15",
      "type": "EPARGNE"
    }
  }
}
```

---

**6. Deposit Money:**
```graphql
mutation {
  depositMoney(id: 1, amount: 1000.0) {
    id
    solde
  }
}
```

**Response:**
```json
{
  "data": {
    "depositMoney": {
      "id": "1",
      "solde": 6432.87
    }
  }
}
```

---

**7. Withdraw Money:**
```graphql
mutation {
  withdrawMoney(id: 1, amount: 500.0) {
    id
    solde
  }
}
```

---

**GraphQL: Queries vs Mutations**

| Operation Type | Purpose | Example Use Cases |
|----------------|---------|-------------------|
| **Query** | Read operations (no side effects) | Get data, search, filter, calculate |
| **Mutation** | Write operations (modify data) | Create, update, delete, transfer |

**Key GraphQL Advantages:**

1. **Client-Driven Data Fetching**: Request exactly what you need
2. **Single Request for Related Data**: No multiple round trips
3. **No Over-Fetching**: Only requested fields are returned
4. **No Under-Fetching**: Get all needed data in one query
5. **Strong Typing**: Schema-first development with type safety
6. **Introspection**: API is self-documenting

---

## 🔍 Architectural Comparison: REST vs GraphQL

This project demonstrates the core trade-offs between the two architectures:

### **Feature Comparison Matrix**

| Feature | Traditional REST API | GraphQL Web Service |
|---------|---------------------|---------------------|
| **Endpoint Structure** | Multiple, resource-specific endpoints<br/>(`/accounts/1`, `/transactions`) | Single endpoint<br/>(`/graphql`) |
| **Data Fetching Efficiency** | ❌ Prone to **Over-fetching** (sending too much data)<br/>❌ **Under-fetching** (requiring multiple round trips) | ✅ **Highly Flexible**: Clients request only needed data<br/>✅ Optimizes payload size and network usage |
| **Request Complexity** | Simple HTTP GET/POST/PUT/DELETE | Requires understanding of GraphQL query language |
| **Caching** | ✅ Easy to cache (HTTP GET requests) | ⚠️ More complex (POST requests to single endpoint) |
| **Versioning** | ❌ API changes require versioning (v1, v2)<br/>Risk of breaking existing clients | ✅ Schema evolution<br/>✅ Deprecated fields supported alongside new ones |
| **Serialization Issues** | ❌ **Boucle Infinie Problem**:<br/>Requires manual `@JsonProperty` or `@JsonIgnore` annotations on JPA entities to prevent infinite loops in bidirectional relationships | ✅ **Graceful Handling**:<br/>GraphQL execution engine (resolvers) natively avoid serialization loops without polluting JPA entities |
| **Documentation** | Requires separate tools (Swagger/OpenAPI) | ✅ Self-documenting via schema introspection |
| **Learning Curve** | ✅ Simple, well-understood | ⚠️ Steeper learning curve |
| **Real-time Data** | Requires additional setup (WebSockets, SSE) | ✅ Built-in subscriptions support |
| **Error Handling** | HTTP status codes (200, 404, 500) | Partial success possible (data + errors in same response) |
| **Tooling Ecosystem** | ✅ Mature, extensive tooling | ✅ Growing ecosystem (GraphiQL, Apollo) |
| **Best For** | Public APIs, simple CRUD, microservices | Complex data requirements, mobile apps, multiple clients |

---

### **The Critical Boucle Infinie Problem: Deep Dive**

**Problem Statement:**

In REST APIs built directly on JPA entities with **bidirectional relationships**, JSON serialization causes infinite loops:

```
Compte → Transactions → Compte → Transactions → ... (INFINITE)
```

**REST Solution (Pollutes Domain Model):**

```java
@Entity
public class Compte {
    @JsonManagedReference  // ❌ Couples API to domain
    @OneToMany(mappedBy = "compte")
    private List<Transaction> transactions;
}
```

**Problems:**
- ❌ **Tight Coupling**: Serialization logic in domain model
- ❌ **Single View**: Can't have different JSON representations
- ❌ **Maintenance**: Changes affect both database and API

**GraphQL Solution (Clean Separation):**

GraphQL resolvers handle relationships **programmatically** without annotations:

```java
@Controller
public class CompteGraphQLController {
    
    // Clean entity - no serialization annotations needed
    @QueryMapping
    public List<Transaction> transactions(@Source Compte compte) {
        return transactionRepository.findByCompte(compte);
    }
}
```

**Benefits:**
- ✅ **Clean Domain Model**: No API concerns in entities
- ✅ **Flexible Resolution**: Different resolvers for different needs
- ✅ **No Infinite Loops**: Resolver controls traversal depth
- ✅ **Client Control**: Client decides which relationships to fetch

---

### **When to Use REST vs GraphQL**

**Use REST When:**
- ✅ Simple CRUD operations
- ✅ Public APIs with many consumers
- ✅ Caching is critical
- ✅ Team familiar with REST
- ✅ Resource-based thinking fits naturally

**Use GraphQL When:**
- ✅ Complex, nested data requirements
- ✅ Multiple client types (web, mobile, IoT)
- ✅ Need to minimize network requests
- ✅ Rapid frontend development
- ✅ Real-time data requirements

**Best Approach (This Project):**
Implement **BOTH** and let consumers choose based on their needs! 🎯

---

## 🚀 Quick Start Guide

### **Prerequisites**

Ensure you have the following installed:
- ☕ Java 17 or higher
- 📦 Maven 3.6 or higher
- 💻 IDE (IntelliJ IDEA, Eclipse, or VS Code)

### **Installation Steps**

**1. Clone the Repository**
```bash
git clone https://github.com/malakzaidi/microservice_rest_and_graphQl_connectors.git
cd microservice_rest_and_graphQl_connectors
```

**2. Build the Project**
```bash
mvn clean install
```

**3. Run the Application**
```bash
mvn spring-boot:run
```

**4. Verify Installation**

The application should start on port 8080. You'll see output like:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.x.x)

...
Started CompteMicroserviceApplication in 3.456 seconds
```

### **Access Points**

| Service | URL | Description |
|---------|-----|-------------|
| **REST API** | `http://localhost:8080/api/comptes` | Traditional REST endpoints |
| **Spring Data REST** | `http://localhost:8080/comptes-rest` | Auto-generated REST API |
| **GraphQL Endpoint** | `http://localhost:8080/graphql` | GraphQL API endpoint |
| **GraphiQL Interface** | `http://localhost:8080/graphiql` | Interactive GraphQL playground |
| **Swagger UI** | `http://localhost:8080/swagger-ui.html` | REST API documentation |
| **H2 Console** | `http://localhost:8080/h2-console` | Database management interface |

**H2 Console Login:**
- JDBC URL: `jdbc:h2:mem:bank_db`
- Username: `sa`
- Password: *(leave empty)*

---

## 📚 API Documentation

### **REST API Endpoints**

#### **Standard REST Controller**

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| GET | `/api/comptes` | Get all accounts | - |
| GET | `/api/comptes/{id}` | Get account by ID | - |
| GET | `/api/comptes/type/{type}` | Filter by type | - |
| GET | `/api/comptes/statistics/total-balance` | Get total balance | - |
| POST | `/api/comptes` | Create new account | `CompteRequestDTO` |
| PUT | `/api/comptes/{id}` | Update account | `CompteRequestDTO` |
| DELETE | `/api/comptes/{id}` | Delete account | - |

**CompteRequestDTO Schema:**
```json
{
  "solde": 5000.0,
  "type": "COURANT"
}
```

---

#### **Spring Data REST Endpoints**

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/comptes-rest` | List all (paginated) |
| GET | `/comptes-rest/{id}` | Get by ID |
| POST | `/comptes-rest` | Create |
| PUT | `/comptes-rest/{id}` | Update |
| PATCH | `/comptes-rest/{id}` | Partial update |
| DELETE | `/comptes-rest/{id}` | Delete |
| GET | `/comptes-rest/search` | Discover search operations |
| GET | `/comptes-rest/search/byType?type=COURANT` | Search by type |
| GET | `/comptes-rest/search/highBalance?solde=5000` | High balance accounts |

**Using Projections:**
```http
GET /comptes-rest?projection=compteProjection
```

---

### **GraphQL API**

#### **Available Queries**

```graphql
# Get all accounts
query {
  allComptes {
    id
    solde
    dateCreation
    type
  }
}

# Get specific account
query {
  compteById(id: 1) {
    id
    solde
    type
  }
}

# Filter by type
query {
  comptesByType(type: COURANT) {
    id
    solde
  }
}

# Statistics
query {
  totalBalance
  countByType(type: EPARGNE)
}
```

#### **Available Mutations**

```graphql
# Create account
mutation {
  createCompte(input: {solde: 5000.0, type: COURANT}) {
    id
    solde
    dateCreation
    type
  }
}

# Update account
mutation {
  updateCompte(id: 1, input: {solde: 7500.0, type: EPARGNE}) {
    id
    solde
    type
  }
}

# Delete account
mutation {
  deleteCompte(id: 1)
}

# Financial operations
mutation {
  depositMoney(id: 1, amount: 1000.0) {
    id
    solde
  }
  
  withdrawMoney(id: 1, amount: 500.0) {
    id
    solde
  }
}
```

---

## 🧪 Testing Guide

### **1. Manual Testing with Postman**

**Import Postman Collection:**

Create a collection with the following requests:

**Environment Variables:**
```json
{
  "base_url": "http://localhost:8080"
}
```

**Test Scenarios:**

1. **Create Account**
   ```
   POST {{base_url}}/api/comptes
   Body: {"solde": 5000.0, "type": "COURANT"}
   Expected: 201 Created
   ```

2. **Get All Accounts**
   ```
   GET {{base_url}}/api/comptes
   Expected: 200 OK with array
   ```

3. **Get by ID**
   ```
   GET {{base_url}}/api/comptes/1
   Expected: 200 OK with object
   ```

4. **Update Account**
   ```
   PUT {{base_url}}/api/comptes/1
   Body: {"solde": 7500.0, "type": "EPARGNE"}
   Expected: 200 OK
   ```

5. **Delete Account**
   ```
   DELETE {{base_url}}/api/comptes/1
   Expected: 204 No Content
   ```

---

### **2. Testing with cURL**

```bash
# Create account
curl -X POST http://localhost:8080/api/comptes \
  -H "Content-Type: application/json" \
  -d '{"solde": 5000.0, "type": "COURANT"}'

# Get all accounts
curl http://localhost:8080/api/comptes

# Get by ID
curl http://localhost:8080/api/comptes/1

# Update account
curl -X PUT http://localhost:8080/api/comptes/1 \
  -H "Content-Type: application/json" \
  -d '{"solde": 7500.0, "type": "EPARGNE"}'

# Delete account
curl -X DELETE http://localhost:8080/api/comptes/1
```

---

### **3. GraphQL Testing with GraphiQL**

1. Open browser: `http://localhost:8080/graphiql`
2. Use the **Documentation Explorer** (right panel) to browse schema
3. Write queries in the left panel
4. Click "Execute Query" button
5. View results in the right panel

**Sample Test Flow:**

```graphql
# Step 1: Create accounts
mutation {
  account1: createCompte(input: {solde: 5000, type: COURANT}) {
    id
  }
  account2: createCompte(input: {solde: 10000, type: EPARGNE}) {
    id
  }
}

# Step 2: Query all accounts
query {
  allComptes {
    id
    solde
    type
  }
  totalBalance
}

# Step 3: Deposit money
mutation {
  depositMoney(id: 1, amount: 1000) {
    id
    solde
  }
}

# Step 4: Verify balance
query {
  compteById(id: 1) {
    solde
  }
}
```

---

### **4. Unit Testing Examples**

**Controller Test:**

```java
@SpringBootTest
@AutoConfigureMockMvc
class CompteRestControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    void testGetAllComptes() throws Exception {
        mockMvc.perform(get("/api/comptes"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isArray());
    }
    
    @Test
    void testCreateCompte() throws Exception {
        CompteRequestDTO request = new CompteRequestDTO(5000.0, TypeCompte.COURANT);
        
        mockMvc.perform(post("/api/comptes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.solde").value(5000.0))
            .andExpect(jsonPath("$.type").value("COURANT"));
    }
    
    @Test
    void testGetCompteById_NotFound() throws Exception {
        mockMvc.perform(get("/api/comptes/999"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("Compte not found with id: 999"));
    }
}
```

**Service Test:**

```java
@SpringBootTest
class CompteServiceTest {
    
    @Autowired
    private CompteService compteService;
    
    @Test
    void testCreateCompte() {
        CompteRequestDTO request = new CompteRequestDTO(5000.0, TypeCompte.COURANT);
        CompteDTO created = compteService.createCompte(request);
        
        assertNotNull(created.getId());
        assertEquals(5000.0, created.getSolde());
        assertEquals(TypeCompte.COURANT, created.getType());
    }
    
    @Test
    void testGetCompteById_ThrowsException() {
        assertThrows(ResourceNotFoundException.class, 
            () -> compteService.getCompteById(999L));
    }
    
    @Test
    void testDepositMoney() {
        CompteRequestDTO request = new CompteRequestDTO(5000.0, TypeCompte.COURANT);
        CompteDTO compte = compteService.createCompte(request);
        
        CompteDTO updated = compteService.depositMoney(compte.getId(), 1000.0);
        
        assertEquals(6000.0, updated.getSolde());
    }
}
```

---

## 🎓 Key Learnings

### **1. Architectural Patterns**

✅ **Layered Architecture**: Clear separation of concerns (Web → Service → Repository)
✅ **DTO Pattern**: Decoupling domain model from API representation
✅ **Repository Pattern**: Abstraction over data access
✅ **Service Layer**: Business logic encapsulation

### **2. Spring Boot Ecosystem**

✅ **Spring Data JPA**: Eliminates boilerplate repository code
✅ **Spring Data REST**: Rapid API prototyping
✅ **Spring GraphQL**: Modern API development
✅ **MapStruct**: Type-safe DTO mapping

### **3. API Design Principles**

✅ **RESTful Design**: Resource-based URLs, HTTP verbs, status codes
✅ **GraphQL Schema**: Strong typing, client-driven queries
✅ **HATEOAS**: Hypermedia controls in responses
✅ **API Documentation**: OpenAPI/Swagger for discoverability

### **4. Common Pitfalls Addressed**

✅ **Boucle Infinie**: Solved with DTOs, not entity annotations
✅ **Over-fetching/Under-fetching**: Solved with GraphQL and projections
✅ **Transaction Management**: Proper `@Transactional` usage
✅ **Exception Handling**: Global error handlers

### **5. Best Practices Applied**

✅ **Validation**: Input validation with Bean Validation
✅ **Logging**: Structured logging with SLF4J
✅ **Builder Pattern**: Lombok `@Builder` for object creation
✅ **Immutability**: DTOs are effectively immutable
✅ **Testing**: Comprehensive test coverage

## 📖 References & Resources

### **Official Documentation**
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Guide](https://spring.io/projects/spring-data-jpa)
- [Spring GraphQL](https://spring.io/projects/spring-graphql)
- [Spring Data REST Reference](https://spring.io/projects/spring-data-rest)
- [SpringDoc OpenAPI](https://springdoc.org/)

### **Video Tutorials**
- [Microservice Bank Account Management](https://www.youtube.com/watch?v=2-qIoZcvhAw)
- [GraphQL Implementation with Spring Boot](https://www.youtube.com/watch?v=FsdR09jlqaE)

### **Additional Learning**
- [H2 Database Documentation](https://www.h2database.com/)
- [Lombok Documentation](https://projectlombok.org/)
- [MapStruct Reference](https://mapstruct.org/)
- [GraphQL Official Site](https://graphql.org/)
- [REST API Best Practices](https://restfulapi.net/)


## 👨‍💻 Author

**Malak Zaidi**

- GitHub: [@malakzaidi](https://github.com/malakzaidi)
- Repository: [microservice_rest_and_graphQl_connectors](https://github.com/malakzaidi/microservice_rest_and_graphQl_connectors)

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

### **How to Contribute:**

1. **Fork the repository**
   ```bash
   git clone https://github.com/malakzaidi/microservice_rest_and_graphQl_connectors.git
   ```

2. **Create a feature branch**
   ```bash
   git checkout -b feature/AmazingFeature
   ```

3. **Commit your changes**
   ```bash
   git commit -m 'Add some AmazingFeature'
   ```

4. **Push to the branch**
   ```bash
   git push origin feature/AmazingFeature
   ```

5. **Open a Pull Request**

### **Contribution Guidelines:**
- Write clean, readable code
- Follow existing code style
- Add unit tests for new features
- Update documentation as needed
- Ensure all tests pass before submitting PR

---

## 🙏 Acknowledgments

- Spring Boot team for the amazing framework
- GraphQL community for innovative API design
- All contributors to the open-source libraries used
- Tutorial creators for comprehensive learning resources

---

## 📧 Support & Contact

If you have any questions, issues, or suggestions:

- 📫 Open an [Issue](https://github.com/malakzaidi/microservice_rest_and_graphQl_connectors/issues)
- 💬 Start a [Discussion](https://github.com/malakzaidi/microservice_rest_and_graphQl_connectors/discussions)
- ⭐ Star the repository if you find it useful!

---

<div align="center">

### ⭐ Star this repository if you found it helpful!

**Made with ❤️ using Spring Boot, REST, and GraphQL**

</div>
