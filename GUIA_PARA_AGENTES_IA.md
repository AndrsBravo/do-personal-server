# GUÍA TÉCNICA PARA AGENTES IA - do-personal-server

**Proyecto**: Personal.do | **Framework**: Helidon SE 4.3.3 | **Java**: 21 | **BD**: SQL Server 2025

---

## 📋 TABLA DE CONTENIDOS
1. [Stack Técnico](#1-stack-técnico)
2. [Estructura de Directorios](#2-estructura-de-directorios)
3. [Arquitectura y Patrones](#3-arquitectura-y-patrones)
4. [Flujo de Solicitud HTTP](#4-flujo-de-solicitud-http)
5. [Crear Nuevo Endpoint](#5-checklist-crear-nuevo-endpoint)
6. [Configuración y Setup](#6-configuración-y-setup)
7. [Comandos Esenciales](#7-comandos-esenciales)
8. [Troubleshooting](#8-troubleshooting)

---

## 1. STACK TÉCNICO

| Componente | Versión | Propósito |
|-----------|---------|----------|
| **Helidon SE** | 4.3.3 | Framework REST ligero |
| **Java** | 21 LTS | Lenguaje de programación |
| **SQL Server** | 2025 | Base de datos |
| **MSSQL JDBC** | 13.2.1 | Driver JDBC para SQL Server |
| **HikariCP** | (via Helidon) | Pool de conexiones (20 max, 5 min) |
| **Flyway** | 11.8.2 | Migraciones de BD |
| **JUnit 5** | (via Helidon) | Testing |
| **Maven** | 3.8+ | Build automation |

### Dependencias Clave (pom.xml)
```xml
<parent>
    <groupId>io.helidon.applications</groupId>
    <artifactId>helidon-se</artifactId>
    <version>4.3.3</version>
</parent>
<!-- JDBC Driver para SQL Server -->
<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>mssql-jdbc</artifactId>
    <version>13.2.1.jre11</version>
</dependency>
```

---

## 2. ESTRUCTURA DE DIRECTORIOS

```
src/main/java/com/personal/
├── Application.java                          ← Entry point principal
├── GreetService.java                         ← Servicio base de ejemplo
├── app/                                      ← Módulo de aplicación
│   ├── api/
│   │   └── ApplicationRouter.java            ← Rutas /v1/app
│   ├── business/                             ← Lógica de negocio app
│   ├── core/                                 ← Componentes core
│   └── dbclient/                             ← Cliente BD de aplicación
├── backoffice/                               ← Módulo administrativo (PRINCIPAL)
│   ├── api/
│   │   └── BackOfficeRouter.java             ← Enrutador /v1/backoffice
│   ├── register/                             ← Registro de usuarios
│   │   └── UserRegisterRouter.java
│   ├── user/                                 ← Gestión de usuarios
│   │   ├── entities/
│   │   ├── services/
│   │   └── api/handlers/
│   │       ├── CreateUserHttpHandler.java
│   │       ├── UpdateUserHttpHandler.java
│   │       └── FilterUserHttpHandler.java
│   ├── usertype/                             ← Gestión de tipos de usuario
│   │   ├── entities/
│   │   ├── services/
│   │   └── api/handlers/
│   │       ├── CreateUserTypeHttpHandler.java
│   │       ├── UpdateUserTypeHttpHandler.java
│   │       ├── DeleteUserTypeHttpHandler.java
│   │       └── FilterUserTypeHttpHandler.java
│   └── system/                               ← Componentes del sistema
│       └── process/migration/
│           └── MigrationProcessExecutor.java ← Orquestador de migraciones Flyway
├── management/                               ← Módulo de gestión
│   ├── api/
│   │   └── ManagementRouting.java            ← Rutas /v1/management
│   └── services/
├── shared/                                   ← Componentes compartidos
│   ├── entities/                             ← BaseEntity, ShortEntity
│   ├── http/                                 ← Utilidades HTTP
│   ├── input/                                ← DTOs de entrada comunes
│   ├── notifications/                        ← Sistema de notificaciones
│   ├── process/                              ← Ejecutores de procesos
│   │   └── ProcessExecutor.java              ← Patrón ejecutor (múltiples reglas)
│   ├── query/                                ← Constructores de queries
│   ├── services/                             ← Servicios base
│   └── utils/                                ← Utilidades generales
└── server/                                   ← Configuración del servidor
    ├── Server.java                           ← Punto de inicio del servidor
    ├── config/
    │   └── AppConfig.java                    ← Configuración de aplicación
    ├── dbclient/
    │   └── DbClientMSSQLFactory.java         ← Factory del cliente MSSQL
    ├── flyway/                               ← Configuración de migraciones
    ├── hikari/
    │   └── HikariDataSourceConfig.java       ← Config del pool de conexiones
    ├── router/
    │   └── Routing.java                      ← Registro central de routers
    ├── resources_reader/
    │   └── ResourcesReader.java              ← Lector de recursos
    ├── system/                               ← Componentes del sistema
    └── logging/
        └── LogConfig.java                    ← Configuración de logging

src/main/resources/
├── application.yaml                          ← Config principal del servidor
├── hikari.properties                         ← Config del pool de conexiones
├── logging.properties                        ← Config de logs
├── flyway.conf                               ← Config de Flyway
└── db/migration/                             ← Scripts SQL para Flyway
    ├── init/                                 ← Inicialización general (V1__*.sql)
    ├── system/                               ← Migraciones del sistema
    └── client/                               ← Migraciones de cliente
```

---

## 3. ARQUITECTURA Y PATRONES

### 3.1 FLUJO GENERAL DE ARRANQUE
```
Application.main()
    ↓
Server.run()
    ├─ LogConfig.configureRuntime()          ← Configura logging
    ├─ Config config = Services.get(Config.class)
    ├─ MigrationProcessExecutor.builder()    ← Inicia ejecutor de migraciones
    │   ├─ CheckDBStatusRule                 ← Verifica estado BD
    │   ├─ CreatePersonalDBRule              ← Crea BD personal (si no existe)
    │   ├─ InitMigrationRule                 ← V1__DB_Init.sql + posteriores
    │   ├─ SystemMigrationRule               ← Migraciones de sistema
    │   ├─ ClientMasterMigrationRule         ← BD master de clientes
    │   └─ ClientDemoMigrationRule           ← BD demo de clientes
    └─ WebServer.builder()
        ├─ .config(application.yaml)         ← Carga config Helidon
        ├─ .routing(Routing::routing)        ← Registra routers principales
        ├─ .port(8080), .host(0.0.0.0)
        └─ .start()                          ← Servidor listo en 8080
```

### 3.2 ROUTING STRUCTURE
```
HTTP Request → Helidon WebServer (0.0.0.0:8080)
    ↓
Routing.routing() distribuye por prefijo:
    ├─ /v1/app                          → ApplicationRouter
    ├─ /v1/backoffice                   → BackOfficeRouter (PRINCIPAL)
    │   ├─ POST   /users                → CreateUserHttpHandler
    │   ├─ PUT    /users                → UpdateUserHttpHandler
    │   ├─ POST   /users/filter         → FilterUserHttpHandler
    │   ├─ POST   /user_types           → CreateUserTypeHttpHandler
    │   ├─ PUT    /user_types           → UpdateUserTypeHttpHandler
    │   ├─ DELETE /user_types/{id}      → DeleteUserTypeHttpHandler
    │   ├─ POST   /user_types/filter    → FilterUserTypeHttpHandler
    │   └─ POST   /register             → UserRegisterRouter
    └─ /v1/management                   → ManagementRouting
    ├─ GET   /health                    → HealthCheck
    └─ GET   /metrics                   → Métricas (Prometheus/JSON)
```

### 3.3 PATRÓN: HttpService + HttpRules
Todos los routers implementan `HttpService` de Helidon:
```java
public class BackOfficeRouter implements HttpService {
    private CreateUserHttpHandler createUserHandler;
    private UpdateUserHttpHandler updateUserHandler;
    // Otros handlers...
    
    @Override
    public void routing(HttpRules rules) {
        rules
            .get("/", this::welcome)
            .post("/users", createUserHandler::handle)
            .put("/users", updateUserHandler::handle)
            .post("/users/filter", filterUserHandler::handle)
            .post("/user_types", createUserTypeHandler::handle)
            // ... más rutas
            .post("/register", userRegisterRouter::routing);
    }
    
    private void welcome(HttpServerRequest req, HttpServerResponse res) {
        res.status(Status.OK_200).send("Hola desde al Backoffice routing");
    }
}
```

### 3.4 PATRÓN: ProcessExecutor (Procesos Complejos)
Para operaciones que requieren múltiples pasos ejecutados en cadena:
```java
public class ProcessExecutor<T, R> {
    private List<ProcessRule<T, R>> rules;
    
    public ProcessExecutor(ProcessRule<T, R>... rules) {
        this.rules = Arrays.asList(rules);
    }
    
    public R execute(T input) {
        for (ProcessRule<T, R> rule : rules) {
            if (!rule.isApplicable(input)) continue;
            var result = rule.execute(input);
            if (!result.isSuccess()) return (R) result;  // Detiene la cadena
            input = (T) result.getData();
        }
        return (R) input;
    }
}
```

**Ejemplo en el proyecto:**
```
MigrationProcessExecutor
    ↓
Cadena de reglas: CheckDBStatusRule → CreatePersonalDBRule → InitMigrationRule 
                  → SystemMigrationRule → ClientMasterMigrationRule → ClientDemoMigrationRule
```

### 3.5 PATRÓN: ServiceResult (Manejo de Errores)
Todos los servicios retornan `ServiceResult<T>`:
```java
// Éxito
ServiceResult.success(userData);          // ✓ Lleva datos

// Error
ServiceResult.error("Mensaje de error");  // ✗ Lleva mensaje de error

// En handler:
var result = userService.execute(user);
if (result.isSuccess()) {
    res.status(Status.OK_200).send(result.getData());
} else {
    res.status(Status.BAD_REQUEST_400).send(result.getErrors());
}
```

---

## 4. BASES DE DATOS MÚLTIPLES

El proyecto gestiona 4 bases de datos SQL Server:

```
SQL Server 2025 (localhost:1433, usuario: sa)
    ├─ personal           ← BD principal de datos personales
    ├─ system_master      ← BD del sistema (usuarios, tipos de usuario, config)
    ├─ client_master      ← BD maestra de clientes
    └─ client_demo        ← BD demo para clientes

Migraciones (Flyway) se ejecutan por BD y carpeta:
├─ db/migration/init/    → Se ejecutan en TODAS las BDs
├─ db/migration/system/  → Se ejecutan en system_master
└─ db/migration/client/  → Se ejecutan en client_master + client_demo
```

**En application.yaml:**
```yaml
system:
  db:
    personal: personal           # BD data
    master: system_master        # BD admin del sistema
    client: client_master        # BD clientes producción
    client_demo: client_demo     # BD clientes demo (opcional)
  migration:
    init: db/migration/init      # V1__*.sql, V2__*.sql...
    system: db/migration/system  # Migraciones del sistema
    client: db/migration/client  # Migraciones de clientes
```

---

## 5. FLUJO DE SOLICITUD HTTP - EJEMPLO

### Ejemplo: POST /v1/backoffice/users
```
1. Cliente envía: 
   POST /v1/backoffice/users
   Headers: Content-Type: application/json
   Body: {
       "email": "user@example.com",
       "names": "Juan",
       "lastNames": "Pérez",
       "userName": "juanperez",
       "userType": { "id": "type-1" }
   }

2. Helidon recibe la solicitud → BackOfficeRouter.routing()

3. Router redirige a CreateUserHttpHandler.handle():
   private void handle(HttpServerRequest req, HttpServerResponse res) {
       var input = req.content().as(UserInput.class);  // Deserializa JSON
       var user = mapper.map(input);                   // Convierte DTO → Entity
       
       var result = createUserService.execute(user);   // Ejecuta lógica
       
       if (result.isSuccess()) {
           var response = mapper.toOutput(result.getData());
           res.status(Status.CREATED_201).send(response);
       } else {
           res.status(Status.BAD_REQUEST_400)
              .send(Json.createObjectBuilder()
                  .add("error", result.getErrors())
                  .build());
       }
   }

4. CreateUserService valida y ejecuta proceso:
   - ValidateEmailRule: Verifica formato email
   - CheckUsernameRule: Verifica que username no exista
   - EncryptPasswordRule: Encripta contraseña (si aplica)
   - CreateUserRule: Inserta en BD system_master.users
   
   Si alguna regla falla → retorna ServiceResult.error()
   Si todas pasan → retorna ServiceResult.success(user)

5. Response HTTP:
   Status: 201 Created
   Body: {
       "id": "uuid-1234",
       "email": "user@example.com",
       "names": "Juan",
       "lastNames": "Pérez",
       "userName": "juanperez",
       "createdAt": "2026-04-27T10:30:00Z"
   }
```

---

## 6. CREAR NUEVO ENDPOINT

## 6. CREAR NUEVO ENDPOINT - CHECKLIST PASO A PASO

### PASO 1: Crear Entidad (si no existe)
```java
// src/main/java/com/personal/xxx/entities/MyEntity.java
package com.personal.xxx.entities;

import com.personal.shared.entities.BaseEntity;

public class MyEntity extends BaseEntity {
    private String name;
    private String description;
    private String status;  // ACTIVE, INACTIVE, etc.
    
    public MyEntity() { }
    
    public MyEntity(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = "ACTIVE";
    }
    
    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
```

### PASO 2: Crear DTO de Entrada
```java
// src/main/java/com/personal/xxx/api/inputs/MyInput.java
package com.personal.xxx.api.inputs;

public class MyInput {
    private String name;
    private String description;
    
    public MyInput() { }
    
    public MyInput(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
```

### PASO 3: Crear Servicio (Lógica de Negocio)
```java
// src/main/java/com/personal/xxx/services/MyService.java
package com.personal.xxx.services;

import com.personal.xxx.entities.MyEntity;
import com.personal.shared.services.ServiceResult;

public class MyService {
    
    public ServiceResult<MyEntity> create(MyEntity entity) {
        try {
            // PASO 1: Validaciones básicas
            if (entity.getName() == null || entity.getName().trim().isEmpty()) {
                return ServiceResult.error("El nombre es requerido");
            }
            
            if (entity.getName().length() > 100) {
                return ServiceResult.error("El nombre no debe exceder 100 caracteres");
            }
            
            // PASO 2: Validaciones de negocio
            // if (alreadyExists(entity.getName())) {
            //     return ServiceResult.error("Ya existe una entidad con ese nombre");
            // }
            
            // PASO 3: Generar ID si no lo tiene
            if (entity.getId() == null) {
                entity.setId(UUID.randomUUID().toString());
            }
            
            // PASO 4: Guardar en BD
            // dbClient.execute(
            //     "INSERT INTO my_table(id, name, description, status, created_at, updated_at) " +
            //     "VALUES(?, ?, ?, ?, NOW(), NOW())",
            //     entity.getId(), entity.getName(), entity.getDescription(), entity.getStatus()
            // );
            
            return ServiceResult.success(entity);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResult.error("Error al crear entidad: " + e.getMessage());
        }
    }
    
    public ServiceResult<MyEntity> update(MyEntity entity) {
        try {
            if (entity.getId() == null) {
                return ServiceResult.error("El ID es requerido para actualizar");
            }
            
            // Validaciones...
            if (entity.getName() == null || entity.getName().trim().isEmpty()) {
                return ServiceResult.error("El nombre es requerido");
            }
            
            // Actualizar timestamp
            entity.setUpdatedAt(new java.util.Date());
            
            // Guardar cambios en BD
            // dbClient.execute(
            //     "UPDATE my_table SET name=?, description=?, status=?, updated_at=NOW() " +
            //     "WHERE id=?",
            //     entity.getName(), entity.getDescription(), entity.getStatus(), entity.getId()
            // );
            
            return ServiceResult.success(entity);
            
        } catch (Exception e) {
            return ServiceResult.error("Error al actualizar: " + e.getMessage());
        }
    }
}
```

### PASO 4: Crear Handler HTTP
```java
// src/main/java/com/personal/xxx/api/handlers/MyHttpHandler.java
package com.personal.xxx.api.handlers;

import io.helidon.http.ServerResponse;
import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import jakarta.json.Json;
import jakarta.json.JsonObject;

import com.personal.xxx.entities.MyEntity;
import com.personal.xxx.services.MyService;
import com.personal.xxx.api.inputs.MyInput;

public class MyHttpHandler {
    private MyService service = new MyService();
    
    /**
     * POST handler - crear nueva entidad
     */
    public void create(ServerRequest req, ServerResponse res) {
        try {
            var input = req.content().as(MyInput.class);
            
            // Convertir DTO a Entity
            var entity = new MyEntity();
            entity.setName(input.getName());
            entity.setDescription(input.getDescription());
            
            // Ejecutar servicio
            var result = service.create(entity);
            
            // Responder
            if (result.isSuccess()) {
                var response = toJson(result.getData());
                res.status(Status.CREATED_201).send(response);
            } else {
                res.status(Status.BAD_REQUEST_400)
                   .send(Json.createObjectBuilder()
                       .add("error", result.getErrors())
                       .build());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            res.status(Status.INTERNAL_SERVER_ERROR_500)
               .send(Json.createObjectBuilder()
                   .add("error", "Error del servidor: " + e.getMessage())
                   .build());
        }
    }
    
    /**
     * PUT handler - actualizar entidad
     */
    public void update(ServerRequest req, ServerResponse res) {
        try {
            var input = req.content().as(MyInput.class);
            
            var entity = new MyEntity();
            entity.setName(input.getName());
            entity.setDescription(input.getDescription());
            
            var result = service.update(entity);
            
            if (result.isSuccess()) {
                res.status(Status.OK_200).send(toJson(result.getData()));
            } else {
                res.status(Status.BAD_REQUEST_400)
                   .send(Json.createObjectBuilder()
                       .add("error", result.getErrors())
                       .build());
            }
            
        } catch (Exception e) {
            res.status(Status.INTERNAL_SERVER_ERROR_500)
               .send(Json.createObjectBuilder()
                   .add("error", e.getMessage())
                   .build());
        }
    }
    
    /**
     * Utilidad: Convertir Entity a JSON
     */
    private JsonObject toJson(MyEntity entity) {
        return Json.createObjectBuilder()
            .add("id", entity.getId())
            .add("name", entity.getName())
            .add("description", entity.getDescription() != null ? entity.getDescription() : "")
            .add("status", entity.getStatus())
            .add("createdAt", entity.getCreatedAt() != null ? entity.getCreatedAt().toString() : "")
            .add("updatedAt", entity.getUpdatedAt() != null ? entity.getUpdatedAt().toString() : "")
            .build();
    }
}
```

### PASO 5: Registrar Handler en Router
```java
// src/main/java/com/personal/xxx/api/MyRouter.java
package com.personal.xxx.api;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

import com.personal.xxx.api.handlers.MyHttpHandler;

public class MyRouter implements HttpService {
    private MyHttpHandler handler = new MyHttpHandler();
    
    @Override
    public void routing(HttpRules rules) {
        rules
            .get("/", this::welcome)
            .post("", handler::create)      // POST /v1/xxx
            .put("", handler::update);      // PUT /v1/xxx
            // .post("/filter", handler::filter)
            // .get("/{id}", handler::getById)
            // .delete("/{id}", handler::delete)
    }
    
    private void welcome(HttpServerRequest req, HttpServerResponse res) {
        res.status(Status.OK_200)
           .send("Bienvenido a My Router API");
    }
}
```

### PASO 6: Registrar Router en Routing Central
```java
// src/main/java/com/personal/server/router/Routing.java
// Agregar esta línea en el método routing():

public static void routing(io.helidon.webserver.http.Routing.Builder routing) {
    routing
        .register("/v1/app", new ApplicationRouter())
        .register("/v1/backoffice", new BackOfficeRouter())
        .register("/v1/management", new ManagementRouting())
        .register("/v1/xxx", new MyRouter())           // ← AGREGAR ESTA LÍNEA
        .get("/observe/health", (req, res) -> res.send("OK"))
        .get("/observe/metrics", (req, res) -> res.send("{}"));
}
```

### PASO 7: Crear Migración BD (si requiere tabla nueva)
```sql
-- src/main/resources/db/migration/init/V3__Create_My_Table.sql

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'my_table')
BEGIN
    CREATE TABLE my_table (
        id NVARCHAR(36) PRIMARY KEY,
        name NVARCHAR(100) NOT NULL,
        description NVARCHAR(500),
        status NVARCHAR(20) DEFAULT 'ACTIVE',
        created_at DATETIME DEFAULT GETDATE(),
        updated_at DATETIME DEFAULT GETDATE(),
        CONSTRAINT UQ_my_table_name UNIQUE (name)
    );
    
    CREATE INDEX idx_my_table_status ON my_table(status);
    CREATE INDEX idx_my_table_created_at ON my_table(created_at);
END;
```

### ✅ VERIFICAR CREACIÓN

```bash
# 1. Compilar
mvn clean compile

# 2. Ejecutar servidor (ejecuta migraciones automáticamente)
java -jar target/do-personal-server-1.0-SNAPSHOT.jar

# 3. Probar endpoint POST
curl -X POST http://localhost:8080/v1/xxx \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Mi Entidad",
    "description": "Descripción de prueba"
  }'

# 4. Respuesta esperada: Status 201 Created
# {
#   "id": "uuid-generated",
#   "name": "Mi Entidad",
#   "description": "Descripción de prueba",
#   "status": "ACTIVE",
#   "createdAt": "2026-04-27T..."
# }
```

---

## 7. CONFIGURACIÓN Y SETUP

## 7. CONFIGURACIÓN Y SETUP

### application.yaml - Configuración Completa
```yaml
# src/main/resources/application.yaml

# ============================================================================
# SERVIDOR HELIDON
# ============================================================================
server:
  port: 8080
  host: 0.0.0.0
  socket-timeout: 30000

# ============================================================================
# BASE DE DATOS - CONEXIÓN JDBC MSSQL
# ============================================================================
db:
  source: jdbc  # Usa driver JDBC
  connection:
    url: "jdbc:sqlserver://localhost:1433;databaseName=%s;encrypt=true;trustServerCertificate=true;"
    username: sa
    password: MPi123456789  # ⚠️ En PRODUCCIÓN usar variables de entorno
    driver: com.microsoft.sqlserver.jdbc.SQLServerDriver
    poolName: pool_ms_sql
    pool:
      # Config HikariCP
      maximumPoolSize: 20      # Max conexiones simultáneas
      minimumIdle: 5           # Min conexiones en pool
      connectionTimeout: 30000  # 30 segundos
      idleTimeout: 600000      # 10 minutos
      maxLifetime: 1800000     # 30 minutos
      leakDetectionThreshold: 60000  # Alertar si conexión > 60s

# ============================================================================
# SISTEMA - MÚLTIPLES BASES DE DATOS
# ============================================================================
system:
  db:
    personal: personal          # BD principal de datos
    master: system_master       # BD del sistema (usuarios, tipos, config)
    client: client_master       # BD maestra de clientes (producción)
    client_demo: client_demo    # BD demo para clientes (opcional)
    
  # Rutas a scripts de migración Flyway
  migration:
    init: db/migration/init     # V1__.sql, V2__.sql... (TODAS las BDs)
    system: db/migration/system # Migraciones específicas del sistema
    client: db/migration/client # Migraciones específicas de clientes

# ============================================================================
# LOGGING
# ============================================================================
logging:
  level: INFO
  handlers:
    - java.util.logging.ConsoleHandler
    - java.util.logging.FileHandler
  properties:
    java.util.logging.ConsoleHandler.formatter: java.util.logging.SimpleFormatter
    java.util.logging.SimpleFormatter.format: "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %4$s %5$s%6$s%n"

# ============================================================================
# COMPONENTES OBSERVABLES (HEALTH, METRICS)
# ============================================================================
observe:
  health:
    enabled: true
  metrics:
    enabled: true
    path: /observe/metrics

# ============================================================================
# CONFIGURACIÓN POR PERFIL
# ============================================================================
---
# Perfil: PRODUCCIÓN
spring:
  config:
    activate:
      on-profile: prod
server:
  port: 8080
  host: 0.0.0.0
db:
  connection:
    password: ${DB_PASSWORD:}  # Variable de entorno
system:
  db:
    personal: personal_prod
    master: system_master_prod
logging:
  level: WARN
```

### hikari.properties - Pool de Conexiones
```properties
# src/main/resources/hikari.properties

# Tamaño del pool
maximumPoolSize=20
minimumIdle=5

# Timeouts
connectionTimeout=30000
idleTimeout=600000
maxLifetime=1800000

# Performance optimizations
dataSource.cachePrepStmts=true
dataSource.prepStmtCacheSize=250
dataSource.prepStmtCacheSqlLimit=2048
dataSource.useServerPrepStmts=true
dataSource.useLocalSessionState=true
dataSource.rewriteBatchedStatements=true
dataSource.cacheResultSetMetadata=true
dataSource.cacheServerConfiguration=true
dataSource.elideSetAutoCommits=true
dataSource.maintainTimeStats=false
```

### Acceder a Configuración en Código
```java
import io.helidon.config.Config;
import io.helidon.service.registry.Services;

// Obtener configuración global
Config config = Services.get(Config.class);

// Acceder a valores
String dbUrl = config.get("db.connection.url").asString().get();
String dbUser = config.get("db.connection.username").asString().get();
String dbPassword = config.get("db.connection.password").asString().get();

// Acceder a colecciones
Config dbSystem = config.get("system.db");
String personalDb = dbSystem.get("personal").asString().get();
String masterDb = dbSystem.get("master").asString().get();

// Con valores por defecto
String port = config.get("server.port").asString().orElse("8080");
int maxPool = config.get("db.connection.pool.maximumPoolSize").asInt().orElse(20);

// Cargar archivo específico
Config customConfig = Config.create(
    ConfigSources.file("src/main/resources/custom.yaml")
);
```

### Variables de Entorno (Recomendado para Prod)
```bash
# En producción, usar variables de entorno:
export DB_PASSWORD="tu_password_seguro"
export DB_HOST="prod-sqlserver.azure.com"
export LOGGING_LEVEL="WARN"

# Helidon automáticamente reemplaza ${VARIABLE} en application.yaml
# Ejemplo en application.yaml:
# db:
#   connection:
#     password: ${DB_PASSWORD}
#     url: "jdbc:sqlserver://${DB_HOST}:1433;..."
```

---

## 8. COMANDOS ESENCIALES

## 8. COMANDOS ESENCIALES

### Build & Compilación
```bash
# Limpiar y compilar (descarga dependencias, compila código)
mvn clean compile

# Compilar completo y crear JAR ejecutable
mvn clean package

# Compilar sin ejecutar tests (más rápido)
mvn clean package -DskipTests

# Ver dependencias instaladas
mvn dependency:tree

# Ver dependencias desactualizadas
mvn versions:display-dependency-updates
```

### Ejecutar Servidor
```bash
# Opción 1: Ejecutar JAR compilado (recomendado)
java -jar target/do-personal-server-1.0-SNAPSHOT.jar

# Opción 2: Ejecutar con Maven (durante desarrollo)
mvn exec:java -Dexec.mainClass="com.personal.Application"

# Opción 3: Ejecutar con debugging activado
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 \
     -jar target/do-personal-server-1.0-SNAPSHOT.jar

# Opción 4: Con variables de entorno
DB_PASSWORD="secure_pass" DB_HOST="localhost" java -jar target/do-personal-server-1.0-SNAPSHOT.jar

# Verificar que está corriendo
curl http://localhost:8080/observe/health
# Respuesta: OK o JSON con estado

# Ver métricas
curl http://localhost:8080/observe/metrics
```

### Base de Datos - Migraciones
```bash
# Las migraciones se ejecutan AUTOMÁTICAMENTE al arrancar el servidor
# Estado de migraciones en SQL Server Management Studio:
SELECT * FROM flyway_schema_history ORDER BY installed_rank DESC;

# Agregar nueva migración:
# 1. Crear archivo: src/main/resources/db/migration/init/V4__New_Feature.sql
# 2. Escribir SQL
# 3. Reiniciar servidor (ejecuta automáticamente)

# Ver versión actual de Flyway
flyway --version
```

### Testing
```bash
# Ejecutar todos los tests
mvn test

# Ejecutar test específico
mvn test -Dtest=BackOfficeRouterTest

# Ejecutar tests de una clase específica
mvn test -Dtest=MyRouterTest#testCreate

# Ver resultados detallados
mvn test -X  # Con debug

# Ejecutar tests y generar reporte de cobertura (JaCoCo)
mvn clean test jacoco:report
# Reporte en: target/site/jacoco/index.html

# Saltarse tests durante build
mvn package -DskipTests
```

### Docker
```bash
# Construir imagen Docker
mvn clean package
docker build -f Dockerfile -t personal-do-server:1.0 .

# Ejecutar contenedor
docker run -p 8080:8080 \
  -e DB_PASSWORD="password" \
  -e DB_HOST="sql-server-host" \
  personal-do-server:1.0

# Construir Native Image (requiere GraalVM)
mvn clean package -Pnative-image
docker build -f Dockerfile.native -t personal-do-server:native .

# Ejecutar Native Image (más rápido, menos memoria)
docker run -p 8080:8080 personal-do-server:native
```

### REST API - Ejemplos de Requests
```bash
# ============================================================================
# BACKOFFICE - USERS
# ============================================================================

# Crear usuario
curl -X POST http://localhost:8080/v1/backoffice/users \
  -H "Content-Type: application/json" \
  -d '{
    "email": "juan@example.com",
    "names": "Juan",
    "lastNames": "Pérez",
    "userName": "juanperez",
    "userType": { "id": "type-admin" }
  }'

# Actualizar usuario
curl -X PUT http://localhost:8080/v1/backoffice/users \
  -H "Content-Type: application/json" \
  -d '{
    "id": "uuid-1234",
    "email": "juan.updated@example.com",
    "names": "Juan",
    "lastNames": "Pérez García"
  }'

# Buscar/Filtrar usuarios
curl -X POST http://localhost:8080/v1/backoffice/users/filter \
  -H "Content-Type: application/json" \
  -d '{
    "email": "juan",
    "status": "ACTIVE",
    "page": 1,
    "pageSize": 10
  }'

# ============================================================================
# BACKOFFICE - USER TYPES
# ============================================================================

# Crear tipo de usuario
curl -X POST http://localhost:8080/v1/backoffice/user_types \
  -H "Content-Type: application/json" \
  -d '{
    "type": "ADMIN",
    "description": "Administrador del sistema"
  }'

# Actualizar tipo de usuario
curl -X PUT http://localhost:8080/v1/backoffice/user_types \
  -H "Content-Type: application/json" \
  -d '{
    "id": "type-admin",
    "type": "ADMIN",
    "description": "Administrador global"
  }'

# Eliminar tipo de usuario
curl -X DELETE http://localhost:8080/v1/backoffice/user_types/type-admin

# Filtrar tipos de usuario
curl -X POST http://localhost:8080/v1/backoffice/user_types/filter \
  -H "Content-Type: application/json" \
  -d '{
    "type": "ADMIN"
  }'

# ============================================================================
# BACKOFFICE - REGISTER (Registro público)
# ============================================================================

# Registrar nuevo usuario
curl -X POST http://localhost:8080/v1/backoffice/register \
  -H "Content-Type: application/json" \
  -d '{
    "email": "newuser@example.com",
    "names": "Nuevo",
    "lastNames": "Usuario",
    "userName": "newuser",
    "password": "SecurePassword123!"
  }'

# ============================================================================
# HEALTH & MONITORING
# ============================================================================

# Health check
curl -X GET http://localhost:8080/observe/health

# Métricas en formato Prometheus
curl -X GET http://localhost:8080/observe/metrics

# Métricas en formato JSON
curl -H "Accept: application/json" \
     -X GET http://localhost:8080/observe/metrics
```

### Debugging & Logs
```bash
# Ver logs en tiempo real
tail -f logs/app.log

# Filtrar logs por nivel
tail -f logs/app.log | grep "ERROR\|WARN"

# Ver logs de base de datos
tail -f logs/db.log

# Buscar errores en compilación
mvn clean compile 2>&1 | grep -A 5 "ERROR"

# Ejecutar con debugging
mvn exec:java -Dexec.mainClass="com.personal.Application" -Dexec.args="-debug"
```

### Limpieza
```bash
# Limpiar directorio target/
mvn clean

# Limpiar todo (target + caché local)
mvn clean && rm -rf ~/.m2/repository/com/personal/

# Limpiar logs
rm -rf logs/*

# Limpiar BD (desarrollo - CUIDADO EN PRODUCCIÓN!)
# En SQL Server Management Studio:
USE master;
ALTER DATABASE personal SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
DROP DATABASE personal;
-- Luego reiniciar servidor para recrear DB
```

---

## 9. TROUBLESHOOTING

## 9. TROUBLESHOOTING

### Error: "Address already in use :8080"
**Causa**: Puerto 8080 está ocupado por otro proceso  
**Solución**:
```bash
# Opción 1: Cambiar puerto en application.yaml
server:
  port: 8081  # Cambiar a otro puerto

# Opción 2: Buscar y detener proceso usando puerto 8080
# En macOS/Linux:
lsof -i :8080
kill -9 <PID>

# En Windows:
netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

### Error: "MSSQL Connection Refused" o "Login failed"
**Causa**: SQL Server no accesible o credenciales incorrectas  
**Solución**:
```bash
# 1. Verificar que SQL Server está corriendo
# En macOS (si está en Docker):
docker ps | grep mssql
# O directamente:
docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=MPi123456789" \
           -p 1433:1433 --name sql2025 \
           mcr.microsoft.com/mssql/server:2025-latest

# 2. Probar conexión
sqlcmd -S localhost,1433 -U sa -P MPi123456789 -Q "SELECT 1"

# 3. Verificar credenciales en application.yaml
# Asegurarse que coincidan exactamente

# 4. Verificar URL JDBC en application.yaml
# debe ser: jdbc:sqlserver://localhost:1433;databaseName=...

# 5. Si está en servidor remoto, cambiar:
jdbc:sqlserver://mi-servidor.azure.com:1433;databaseName=personal;...

# 6. Ver logs de conexión
mvn exec:java -X 2>&1 | grep -i "connection\|failed\|refused"
```

### Error: "No matching HttpService found for path /v1/xxx"
**Causa**: Router no está registrado en `Routing.java`  
**Solución**:
```java
// En src/main/java/com/personal/server/router/Routing.java
// Asegurar que existe la línea:

public static void routing(Routing.Builder routing) {
    routing
        .register("/v1/app", new ApplicationRouter())
        .register("/v1/backoffice", new BackOfficeRouter())
        .register("/v1/management", new ManagementRouting())
        .register("/v1/xxx", new MyRouter())  // ← VERIFICAR ESTO
        .get("/observe/health", ...)
        .get("/observe/metrics", ...);
}

// Si no está, agregarla. Luego recompilar:
mvn clean package
```

### Error: "ClassNotFoundException" o "NoClassDefFoundError"
**Causa**: Dependencia faltante o no compilada correctamente  
**Solución**:
```bash
# 1. Limpiar caché de Maven
mvn clean
rm -rf ~/.m2/repository/com/personal

# 2. Descargar dependencias nuevamente
mvn install -U

# 3. Recompilar
mvn clean compile

# 4. Ejecutar package
mvn clean package

# 5. Si sigue el problema, ver línea exacta del error
mvn clean compile 2>&1 | grep -A 10 "ClassNotFoundException"
```

### Error: "Flyway Migration Failed" o "Table already exists"
**Causa**: Scripts de migración con conflictos o cambios en BD  
**Solución**:
```bash
# 1. Ver historial de migraciones
# En SQL Server Management Studio:
SELECT * FROM flyway_schema_history ORDER BY installed_rank DESC;

# 2. Si es desarrollo y quieres empezar de nuevo:
USE master;
ALTER DATABASE personal SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
DROP DATABASE personal;
-- Luego reiniciar servidor

# 3. Si hay un script duplicado, renombrar:
# V3__Old_Script.sql → V3__Old_Script.sql.bak
# Luego crear nuevo: V4__New_Script.sql

# 4. Ver logs detallados de migración
mvn exec:java -X 2>&1 | grep -i "flyway\|migration"
```

### Error: "400 Bad Request" en requests POST/PUT
**Causa**: JSON malformado o campos requeridos faltantes  
**Solución**:
```bash
# 1. Verificar que JSON es válido
# Usar herramienta online: jsonlint.com o verificar en VS Code

# 2. Verificar Content-Type header
curl -X POST http://localhost:8080/v1/backoffice/users \
  -H "Content-Type: application/json" \  # ← IMPORTANTE
  -d '{...}'

# 3. Verificar que campos requeridos estén presentes
# Ej. para crear usuario, campos requeridos:
{
  "email": "user@example.com",        # Requerido
  "names": "Juan",                    # Requerido
  "lastNames": "Pérez",               # Requerido
  "userName": "juanperez",            # Requerido
  "userType": { "id": "type-1" }      # Requerido
}

# 4. Verificar tipos de datos
# string → "valor" (comillas)
# number → 123 (sin comillas)
# boolean → true/false (sin comillas)
# object → { ... }
```

### Error: "Timeout waiting for database connection"
**Causa**: Pool de conexiones agotado o BD muy lenta  
**Solución**:
```yaml
# En application.yaml, aumentar pool size:
db:
  connection:
    pool:
      maximumPoolSize: 30      # Aumentar de 20 a 30
      connectionTimeout: 60000 # Aumentar de 30s a 60s
```

### Tests: "JUnit not found" o ClassNotFoundException
**Causa**: Dependencias de test no están configuradas  
**Solución**:
```xml
<!-- En pom.xml, agregar dependencias test: -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>io.helidon.webserver.testing.junit5</groupId>
    <artifactId>helidon-webserver-testing-junit5</artifactId>
    <scope>test</scope>
</dependency>
```

### Logs muy verbosos o demasiados
**Causa**: Logging level configurado en DEBUG  
**Solución**:
```properties
# En src/main/resources/logging.properties
# Cambiar nivel global:
.level=INFO

# Específico para paquetes:
com.personal.level=INFO
io.helidon.level=WARNING
io.helidon.dbclient.level=FINE
```

### Aplicación consume mucha memoria
**Causa**: Pool de conexiones mal configurado o memory leak  
**Solución**:
```bash
# 1. Ejecutar con opciones de memoria limitadas:
java -Xmx512m -Xms256m -jar target/do-personal-server-1.0-SNAPSHOT.jar

# 2. Analizar heap dump:
jmap -dump:live,format=b,file=heap.bin <PID>
jhat -J-Xmx512m heap.bin

# 3. Reducir pool de conexiones en application.yaml:
db:
  connection:
    pool:
      maximumPoolSize: 10    # Reducir de 20 a 10
      minimumIdle: 2         # Reducir de 5 a 2
```

### Build muy lento
**Causa**: Maven descargando dependencias o compilando todo  
**Solución**:
```bash
# 1. Compilar solo cambios (sin clean):
mvn compile

# 2. Saltarse tests:
mvn package -DskipTests

# 3. Build paralelo:
mvn clean package -T 1C  # 1 thread por core del CPU

# 4. Usar caché de compilación:
mvn clean compile -pl . -am  # Build solo módulos afectados
```

---

## 10. ARQUITECTURA Y PATRONES AVANZADOS

### 10.1 Patrón: ProcessExecutor con Reglas
El proyecto usa `ProcessExecutor` para ejecutar operaciones complejas en cadena:

```java
// Ejemplo: MigrationProcessExecutor
List<ProcessRule> rules = new ArrayList<>();
rules.add(new CheckDBStatusRule());
rules.add(new CreatePersonalDBRule());
rules.add(new InitMigrationRule());
rules.add(new SystemMigrationRule());
rules.add(new ClientMasterMigrationRule());
rules.add(new ClientDemoMigrationRule());

ProcessExecutor executor = new ProcessExecutor(rules);
executor.execute(migrationContext);
```

**Ventajas:**
- ✅ Separación de responsabilidades
- ✅ Fácil de extender (agregar nuevas reglas)
- ✅ Cada regla es testeable independientemente
- ✅ Detiene la cadena si una regla falla

### 10.2 Patrón: Entity Hierarchy (Herencia de Entidades)
```
BaseEntity
  ├─ User (hereda: id, createdAt, updatedAt, etc.)
  ├─ UserType
  └─ [Otras entidades]

ShortEntity (versión simplificada)
  └─ UserType (fields: id, type, description)
```

### 10.3 Patrón: DTO Pattern (Data Transfer Object)
```
XxxInput (recibir datos HTTP)
    ↓
Mapper.map()
    ↓
XxxEntity (entidad de dominio)
    ↓
[Lógica de negocio]
    ↓
ServiceResult<XxxEntity>
    ↓
Mapper.toOutput()
    ↓
XxxOutput (respuesta HTTP)
```

### 10.4 Factory Pattern: DbClientMSSQLFactory
```java
DbClient client = DbClientMSSQLFactory.create(
    config,
    "personal"  // nombre de la BD
);

// Usar client:
client.execute("SELECT * FROM users");
```

---

## 11. BUENAS PRÁCTICAS

### Seguridad
- ❌ **NO** guardar contraseñas en código fuente
- ✅ **SÍ** usar variables de entorno: `${DB_PASSWORD}`
- ❌ **NO** hacer commit de `application-prod.yaml`
- ✅ **SÍ** usar `.gitignore` para archivos sensibles
- ✅ Validar TODOS los inputs HTTP
- ✅ Usar prepared statements (evita SQL injection)

### Performance
- ✅ Usar índices en columnas frecuentemente buscadas
- ✅ Paginar resultados de búsqueda (evitar SELECT *)
- ✅ Caché de prepared statements (habilitado en hikari.properties)
- ✅ Connection pool bien configurado
- ❌ **NO** crear nuevas conexiones para cada request
- ✅ Usar async cuando sea posible (aunque Helidon maneja bien esto)

### Testing
- ✅ Escribir tests para nuevos endpoints
- ✅ Mock de base de datos en tests
- ✅ Tests unitarios para servicios
- ✅ Tests de integración para routers
- ✅ Covertura mínima del 80%

### Código
- ✅ Usar nombres descriptivos para variables y métodos
- ✅ Documentar métodos públicos con Javadoc
- ✅ Seguir conventions de Java (camelCase, etc.)
- ✅ Mantener métodos pequeños (< 20 líneas)
- ✅ Reutilizar código (DRY principle)

---

## 📚 RECURSOS ÚTILES

- [Helidon SE Documentation](https://helidon.io/docs/v4/se/overview)
- [Flyway SQL Server](https://flywaydb.org/documentation/database/sqlserver)
- [HikariCP Configuration](https://github.com/brettwooldridge/HikariCP)
- [Microsoft JDBC Driver](https://docs.microsoft.com/en-us/sql/connect/jdbc/microsoft-jdbc-driver-for-sql-server)
- [Jakarta JSON Binding](https://jakarta.ee/specifications/jsonb/)

---

**Última actualización**: 27 de Abril de 2026 | **Versión**: 2.0 (Actualizada)
**Autor**: GitHub Copilot | **Versión Java**: 21 | **Framework**: Helidon SE 4.3.3
