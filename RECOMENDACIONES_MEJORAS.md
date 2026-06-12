# 🚀 RECOMENDACIONES DE MEJORAS - do-personal-server

**Fecha**: 27 de Abril de 2026 | **Versión del Proyecto**: 1.0-SNAPSHOT | **Framework**: Helidon SE 4.3.3

---

## 📊 MATRIZ DE IMPACTO vs ESFUERZO

```
ALTO IMPACTO / BAJO ESFUERZO (⭐ PRIORIDAD 1)
├─ Implementar logging estructurado
├─ Agregar validaciones de input
├─ Crear exception handling centralizado
└─ Implementar rate limiting

ALTO IMPACTO / MEDIO ESFUERZO (⭐ PRIORIDAD 2)
├─ Agregar tests de integración
├─ Implementar JWT/OAuth2
├─ Mejorar documentación de API (OpenAPI/Swagger)
├─ Agregar caching estratégico
└─ Implementar monitoreo y alertas

MEDIO IMPACTO / BAJO ESFUERZO (⭐ PRIORIDAD 3)
├─ Code quality checks (SonarQube)
├─ Pre-commit hooks
├─ Docker multi-stage builds
└─ GitHub Actions CI/CD

MEDIO IMPACTO / MEDIO ESFUERZO
├─ Migrar a arquitectura async/reactive
├─ Separar BD por esquemas
├─ Implementar CQRS
└─ Event sourcing
```

---

## 1️⃣ PRIORIDAD 1: ALTO IMPACTO / BAJO ESFUERZO

### 1.1 Logging Estructurado con JSON (SLF4J + Logback)

**Problema Actual**: Logging básico, difícil de analizar en producción

**Solución**:
```xml
<!-- Agregar en pom.xml -->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-core</artifactId>
    <version>1.4.14</version>
</dependency>
<dependency>
    <groupId>net.logstash.logback</groupId>
    <artifactId>logstash-logback-encoder</artifactId>
    <version>7.4</version>
</dependency>
```

```xml
<!-- src/main/resources/logback.xml -->
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="net.logstash.logback.encoder.LogstashEncoder">
            <customFields>{"service":"do-personal-server","env":"dev"}</customFields>
        </encoder>
    </appender>
    
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>logs/app.json.log</file>
        <encoder class="net.logstash.logback.encoder.LogstashEncoder"/>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>logs/app.%d{yyyy-MM-dd}.%i.json.log</fileNamePattern>
            <maxFileSize>100MB</maxFileSize>
            <maxHistory>30</maxHistory>
        </rollingPolicy>
    </appender>
    
    <root level="INFO">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="FILE"/>
    </root>
</configuration>
```

**Beneficio**: Logs en JSON, fáciles de centralizar en ELK Stack o CloudWatch

---

### 1.2 Validaciones Centralizadas de Input

**Problema Actual**: Validaciones dispersas en cada handler

**Solución**:
```java
// src/main/java/com/personal/shared/validation/RequestValidator.java
package com.personal.shared.validation;

import com.personal.shared.services.ServiceResult;
import java.util.ArrayList;
import java.util.List;

public class RequestValidator {
    private List<String> errors = new ArrayList<>();
    
    public static RequestValidator of() {
        return new RequestValidator();
    }
    
    public RequestValidator notEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            errors.add(fieldName + " no puede estar vacío");
        }
        return this;
    }
    
    public RequestValidator maxLength(String value, int max, String fieldName) {
        if (value != null && value.length() > max) {
            errors.add(fieldName + " no debe exceder " + max + " caracteres");
        }
        return this;
    }
    
    public RequestValidator validEmail(String email) {
        if (email != null && !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errors.add("Email inválido");
        }
        return this;
    }
    
    public RequestValidator notNull(Object value, String fieldName) {
        if (value == null) {
            errors.add(fieldName + " es requerido");
        }
        return this;
    }
    
    public ServiceResult<?> validate() {
        if (errors.isEmpty()) {
            return ServiceResult.success(null);
        }
        return ServiceResult.error(String.join("; ", errors));
    }
}
```

**Uso en Handlers**:
```java
public void create(ServerRequest req, ServerResponse res) {
    var input = req.content().as(UserInput.class);
    
    // Validación centralizada
    var validation = RequestValidator.of()
        .notEmpty(input.getEmail(), "email")
        .validEmail(input.getEmail())
        .notEmpty(input.getNames(), "names")
        .maxLength(input.getNames(), 100, "names")
        .notEmpty(input.getUserName(), "userName")
        .validate();
    
    if (!validation.isSuccess()) {
        res.status(Status.BAD_REQUEST_400).send(validation.getErrors());
        return;
    }
    
    // Continuar con lógica...
}
```

**Beneficio**: Validaciones consistentes, reutilizables, mantenibles

---

### 1.3 Exception Handling Centralizado

**Problema Actual**: Manejo de excepciones inconsistente

**Solución**:
```java
// src/main/java/com/personal/shared/exception/GlobalExceptionHandler.java
package com.personal.shared.exception;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import jakarta.json.Json;
import java.util.UUID;
import java.util.logging.Logger;

public class GlobalExceptionHandler {
    private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class.getName());
    
    public static void handle(Exception ex, ServerRequest req, ServerResponse res) {
        String correlationId = UUID.randomUUID().toString();
        
        LOG.severe(() -> "Error [" + correlationId + "] en " + req.path() + 
                         ": " + ex.getMessage());
        ex.printStackTrace();
        
        Status status;
        String message;
        
        if (ex instanceof ValidationException) {
            status = Status.BAD_REQUEST_400;
            message = ex.getMessage();
        } else if (ex instanceof UnauthorizedException) {
            status = Status.UNAUTHORIZED_401;
            message = "No autorizado";
        } else if (ex instanceof ResourceNotFoundException) {
            status = Status.NOT_FOUND_404;
            message = ex.getMessage();
        } else if (ex instanceof ConflictException) {
            status = Status.CONFLICT_409;
            message = ex.getMessage();
        } else {
            status = Status.INTERNAL_SERVER_ERROR_500;
            message = "Error interno del servidor";
        }
        
        var response = Json.createObjectBuilder()
            .add("error", message)
            .add("correlationId", correlationId)
            .add("timestamp", System.currentTimeMillis())
            .add("path", req.path())
            .build();
        
        res.status(status).send(response);
    }
}

// Excepciones custom
public class ValidationException extends RuntimeException {
    public ValidationException(String message) { super(message); }
}

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) { super(message); }
}

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) { super(message); }
}

public class ConflictException extends RuntimeException {
    public ConflictException(String message) { super(message); }
}
```

**Uso en Handlers**:
```java
public void create(ServerRequest req, ServerResponse res) {
    try {
        var input = req.content().as(UserInput.class);
        var result = userService.create(input);
        
        if (result.isSuccess()) {
            res.status(Status.CREATED_201).send(toJson(result.getData()));
        } else {
            throw new ValidationException(result.getErrors());
        }
    } catch (Exception ex) {
        GlobalExceptionHandler.handle(ex, req, res);
    }
}
```

**Beneficio**: Respuestas consistentes, trazabilidad con correlation IDs, mejor debugging

---

### 1.4 Rate Limiting

**Problema Actual**: Sin protección contra abuso

**Solución**:
```java
// src/main/java/com/personal/shared/middleware/RateLimiter.java
package com.personal.shared.middleware;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class RateLimiter {
    private final int maxRequests;
    private final long windowMs;
    private final ConcurrentHashMap<String, RequestBucket> buckets = new ConcurrentHashMap<>();
    
    public RateLimiter(int maxRequests, long windowMs) {
        this.maxRequests = maxRequests;
        this.windowMs = windowMs;
    }
    
    public boolean allowRequest(String identifier) {
        long now = System.currentTimeMillis();
        
        RequestBucket bucket = buckets.computeIfAbsent(identifier, k -> 
            new RequestBucket(now, 1));
        
        if (now - bucket.windowStart > windowMs) {
            bucket.reset(now);
            return true;
        }
        
        if (bucket.count < maxRequests) {
            bucket.count++;
            return true;
        }
        
        return false;
    }
    
    private static class RequestBucket {
        long windowStart;
        int count;
        
        RequestBucket(long windowStart, int count) {
            this.windowStart = windowStart;
            this.count = count;
        }
        
        void reset(long now) {
            this.windowStart = now;
            this.count = 1;
        }
    }
}

// Uso
public static final RateLimiter API_LIMITER = new RateLimiter(
    100,                    // 100 requests
    TimeUnit.MINUTES.toMillis(1)  // por minuto
);

public void create(ServerRequest req, ServerResponse res) {
    String clientIp = req.remoteAddress().orElse("unknown");
    
    if (!API_LIMITER.allowRequest(clientIp)) {
        res.status(Status.TOO_MANY_REQUESTS_429)
           .send(Json.createObjectBuilder()
               .add("error", "Demasiadas solicitudes. Intenta más tarde.")
               .build());
        return;
    }
    
    // Continuar...
}
```

**Alternativa (Redis)** para producción con múltiples instancias:
```xml
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>5.1.0</version>
</dependency>
```

**Beneficio**: Protección contra DDoS y abuso, fácil de configurar

---

## 2️⃣ PRIORIDAD 2: ALTO IMPACTO / MEDIO ESFUERZO

### 2.1 Agregar Tests de Integración

**Problema Actual**: Pocos o sin tests

**Solución**:
```java
// src/test/java/com/personal/backoffice/user/UserRouterIntegrationTest.java
package com.personal.backoffice.user;

import io.helidon.webserver.testing.junit5.HelidonTest;
import io.helidon.webserver.testing.junit5.ServerTest;
import io.helidon.http.Method;
import jakarta.json.JsonObject;
import org.junit.jupiter.api.Test;

import static io.helidon.webserver.testing.junit5.HttpClientMock.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@HelidonTest
@ServerTest
class UserRouterIntegrationTest {
    
    private final HttpClient client;
    
    @Test
    void testCreateUserSuccess() {
        JsonObject payload = Json.createObjectBuilder()
            .add("email", "test@example.com")
            .add("names", "Test")
            .add("lastNames", "User")
            .add("userName", "testuser")
            .add("userType", Json.createObjectBuilder()
                .add("id", "type-user").build())
            .build();
        
        var response = client
            .post("/v1/backoffice/users")
            .submit(payload)
            .toCompletableFuture()
            .join();
        
        assertThat(response.status().code(), is(201));
        JsonObject body = response.as(JsonObject.class);
        assertThat(body.getString("email"), is("test@example.com"));
        assertThat(body.getString("id"), notNullValue());
    }
    
    @Test
    void testCreateUserValidationError() {
        JsonObject payload = Json.createObjectBuilder()
            .add("email", "invalid-email")  // Email inválido
            .add("names", "")               // Vacío
            .build();
        
        var response = client
            .post("/v1/backoffice/users")
            .submit(payload)
            .toCompletableFuture()
            .join();
        
        assertThat(response.status().code(), is(400));
        JsonObject body = response.as(JsonObject.class);
        assertThat(body.getString("error"), containsString("Email"));
    }
    
    @Test
    void testUpdateUserNotFound() {
        JsonObject payload = Json.createObjectBuilder()
            .add("id", "non-existent-id")
            .add("email", "updated@example.com")
            .build();
        
        var response = client
            .put("/v1/backoffice/users")
            .submit(payload)
            .toCompletableFuture()
            .join();
        
        assertThat(response.status().code(), is(404));
    }
}
```

**Configurar en pom.xml**:
```xml
<dependency>
    <groupId>io.helidon.webserver.testing</groupId>
    <artifactId>helidon-webserver-testing-junit5</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <scope>test</scope>
</dependency>
```

**Beneficio**: Mayor confianza en el código, detección temprana de bugs, documentación ejecutable

---

### 2.2 Autenticación JWT

**Problema Actual**: Sin autenticación

**Solución**:
```xml
<!-- pom.xml -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.3</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.12.3</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.12.3</version>
    <scope>runtime</scope>
</dependency>
```

```java
// src/main/java/com/personal/shared/security/JwtProvider.java
package com.personal.shared.security;

import io.jsonwebtoken.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class JwtProvider {
    private static final String SECRET = System.getenv("JWT_SECRET") != null ? 
        System.getenv("JWT_SECRET") : "my-super-secret-key-change-in-production";
    private static final String ALGORITHM = "HmacSHA256";
    private static final long EXPIRATION_MINUTES = 60;
    
    private static Key getSigningKey() {
        return new SecretKeySpec(SECRET.getBytes(), 0, SECRET.getBytes().length, 
            ALGORITHM, null);
    }
    
    public static String generateToken(String userId, String email) {
        return Jwts.builder()
            .subject(userId)
            .claim("email", email)
            .issuedAt(new Date())
            .expiration(Date.from(Instant.now().plus(EXPIRATION_MINUTES, ChronoUnit.MINUTES)))
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)
            .compact();
    }
    
    public static Claims validateToken(String token) {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        } catch (JwtException | IllegalArgumentException ex) {
            throw new SecurityException("Token inválido o expirado: " + ex.getMessage());
        }
    }
    
    public static String extractUserId(String token) {
        return validateToken(token).getSubject();
    }
    
    public static String extractEmail(String token) {
        return validateToken(token).get("email", String.class);
    }
}
```

```java
// src/main/java/com/personal/shared/security/AuthMiddleware.java
package com.personal.shared.security;

import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import io.helidon.http.Status;
import jakarta.json.Json;
import java.util.Optional;

public class AuthMiddleware {
    
    public static Optional<String> extractAndValidateToken(ServerRequest req, ServerResponse res) {
        String authHeader = req.header("Authorization").orElse("");
        
        if (!authHeader.startsWith("Bearer ")) {
            res.status(Status.UNAUTHORIZED_401)
               .send(Json.createObjectBuilder()
                   .add("error", "Missing or invalid Authorization header")
                   .build());
            return Optional.empty();
        }
        
        String token = authHeader.substring(7);
        
        try {
            JwtProvider.validateToken(token);
            return Optional.of(JwtProvider.extractUserId(token));
        } catch (Exception ex) {
            res.status(Status.UNAUTHORIZED_401)
               .send(Json.createObjectBuilder()
                   .add("error", ex.getMessage())
                   .build());
            return Optional.empty();
        }
    }
}
```

**Uso en handlers**:
```java
public void create(ServerRequest req, ServerResponse res) {
    // Validar token
    var userId = AuthMiddleware.extractAndValidateToken(req, res);
    if (userId.isEmpty()) return;  // Ya respondió con 401
    
    // Continuar con lógica autenticada
    var input = req.content().as(UserInput.class);
    // ...
}
```

**Endpoint de Login**:
```java
public void login(ServerRequest req, ServerResponse res) {
    var input = req.content().as(LoginInput.class);
    
    // Validar credenciales en BD
    var user = userService.authenticate(input.getEmail(), input.getPassword());
    
    if (user == null) {
        res.status(Status.UNAUTHORIZED_401)
           .send(Json.createObjectBuilder()
               .add("error", "Credenciales inválidas")
               .build());
        return;
    }
    
    String token = JwtProvider.generateToken(user.getId(), user.getEmail());
    
    res.status(Status.OK_200)
       .send(Json.createObjectBuilder()
           .add("token", token)
           .add("expiresIn", 3600)
           .add("user", Json.createObjectBuilder()
               .add("id", user.getId())
               .add("email", user.getEmail())
               .add("names", user.getNames())
               .build())
           .build());
}
```

**Beneficio**: Seguridad, autorización granular, tokens reutilizables

---

### 2.3 Documentación OpenAPI (Swagger)

**Problema Actual**: Sin documentación interactiva de API

**Solución**:
```xml
<!-- pom.xml -->
<dependency>
    <groupId>io.swagger.core.v3</groupId>
    <artifactId>swagger-jaxrs2-jakarta</artifactId>
    <version>2.2.16</version>
</dependency>
<dependency>
    <groupId>io.swagger.core.v3</groupId>
    <artifactId>swagger-core-jakarta</artifactId>
    <version>2.2.16</version>
</dependency>
```

```java
// src/main/java/com/personal/backoffice/user/api/UserRouterDoc.java
package com.personal.backoffice.user.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@OpenAPIDefinition(
    info = @Info(
        title = "Personal.do API",
        version = "1.0.0",
        description = "API de gestión de usuarios y tipos de usuario",
        contact = @Contact(
            name = "Personal.do Team",
            email = "support@personal.do"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.html"
        )
    )
)
public class UserRouterDoc {
    
    @Operation(
        summary = "Crear nuevo usuario",
        description = "Crea un nuevo usuario en el sistema con validaciones"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Usuario creado exitosamente",
            content = @Content(mediaType = "application/json")
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Validación fallida"
        ),
        @ApiResponse(
            responseCode = "409",
            description = "Usuario ya existe"
        )
    })
    public void createUser() {}
    
    @Operation(
        summary = "Actualizar usuario",
        description = "Actualiza datos de un usuario existente"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario actualizado"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public void updateUser() {}
    
    @Operation(
        summary = "Filtrar usuarios",
        description = "Busca usuarios con criterios opcionales"
    )
    public void filterUsers() {}
}
```

Acceder a Swagger UI: `http://localhost:8080/openapi-ui`

**Beneficio**: Documentación siempre sincronizada, testing interactivo en UI

---

### 2.4 Caching Estratégico

**Problema Actual**: Sin caching, múltiples consultas a BD

**Solución**:
```xml
<!-- pom.xml -->
<dependency>
    <groupId>com.github.ben-manes.caffeine</groupId>
    <artifactId>caffeine</artifactId>
    <version>3.1.8</version>
</dependency>
```

```java
// src/main/java/com/personal/shared/cache/CacheManager.java
package com.personal.shared.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;

public class CacheManager {
    
    private static final Cache<String, Object> USER_CACHE = Caffeine.newBuilder()
        .maximumSize(10000)
        .expireAfterWrite(5, TimeUnit.MINUTES)
        .recordStats()
        .build();
    
    private static final Cache<String, Object> USER_TYPE_CACHE = Caffeine.newBuilder()
        .maximumSize(100)
        .expireAfterWrite(10, TimeUnit.MINUTES)
        .build();
    
    public static void cacheUser(String userId, Object user) {
        USER_CACHE.put(userId, user);
    }
    
    public static Object getUser(String userId) {
        return USER_CACHE.getIfPresent(userId);
    }
    
    public static void invalidateUser(String userId) {
        USER_CACHE.invalidate(userId);
    }
    
    public static void cacheUserType(String typeId, Object type) {
        USER_TYPE_CACHE.put(typeId, type);
    }
    
    public static Object getUserType(String typeId) {
        return USER_TYPE_CACHE.getIfPresent(typeId);
    }
    
    public static void clearAll() {
        USER_CACHE.invalidateAll();
        USER_TYPE_CACHE.invalidateAll();
    }
}
```

**Uso en Servicios**:
```java
public class UserService {
    
    public User getById(String userId) {
        // Intentar obtener del caché
        Object cached = CacheManager.getUser(userId);
        if (cached != null) {
            LOG.info("User hit from cache: " + userId);
            return (User) cached;
        }
        
        // Consultar BD
        User user = dbClient.query("SELECT * FROM users WHERE id = ?", userId)
            .first()
            .map(row -> mapper.map(row, User.class))
            .orElse(null);
        
        // Guardar en caché
        if (user != null) {
            CacheManager.cacheUser(userId, user);
        }
        
        return user;
    }
    
    public User update(User user) {
        // Actualizar BD
        dbClient.execute("UPDATE users SET ... WHERE id = ?", user.getId());
        
        // Invalidar caché
        CacheManager.invalidateUser(user.getId());
        
        return user;
    }
}
```

**Beneficio**: Reducción de latencia (10-100x), menos carga en BD

---

## 3️⃣ PRIORIDAD 3: ARQUITECTURA Y ESCALABILIDAD

### 3.1 Separación de Esquemas por Módulo

**Problema Actual**: 4 BDs diferentes, difícil de manejar

**Recomendación**:
```sql
-- Estructura propuesta (1 BD, múltiples esquemas)
USE personal_db;

-- Esquema de aplicación
CREATE SCHEMA app;
GO

-- Esquema de backoffice
CREATE SCHEMA backoffice;
GO

-- Esquema de sistema
CREATE SCHEMA system;
GO

-- Esquema compartido
CREATE SCHEMA shared;
GO

-- Tablas ejemplo
CREATE TABLE shared.users (
    id NVARCHAR(36) PRIMARY KEY,
    email NVARCHAR(255) NOT NULL UNIQUE,
    names NVARCHAR(100) NOT NULL,
    last_names NVARCHAR(100) NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE()
);

CREATE TABLE backoffice.user_types (
    id NVARCHAR(36) PRIMARY KEY,
    type NVARCHAR(50) NOT NULL,
    description NVARCHAR(500),
    created_at DATETIME DEFAULT GETDATE()
);

CREATE TABLE app.configurations (
    id NVARCHAR(36) PRIMARY KEY,
    module NVARCHAR(50) NOT NULL,
    key NVARCHAR(100) NOT NULL,
    value NVARCHAR(1000),
    CONSTRAINT UQ_config UNIQUE(module, key)
);
```

**Ventajas**:
- ✅ Una sola BD, más fácil de replicar y respaldar
- ✅ Seguridad: permisos por esquema
- ✅ Migraciones más simples (un solo script)
- ✅ Mejor performance (sin múltiples conexiones)

---

### 3.2 Implementar Async/Reactive (Opcional para Helidon)

**Para operaciones I/O intensivas**:
```java
// Usar CompletableFuture para async
public CompletableFuture<User> createUserAsync(User user) {
    return CompletableFuture.supplyAsync(() -> {
        return dbClient.execute(
            "INSERT INTO users (...) VALUES (...)",
            user.getId(), user.getEmail(), ...
        ).thenApply(v -> user).join();
    }, executorService);
}

// En handler:
public void createAsync(ServerRequest req, ServerResponse res) {
    var input = req.content().as(UserInput.class);
    
    userService.createUserAsync(input)
        .thenAccept(user -> {
            res.status(Status.CREATED_201).send(toJson(user));
        })
        .exceptionally(ex -> {
            GlobalExceptionHandler.handle(ex, req, res);
            return null;
        });
}
```

---

### 3.3 Event Sourcing (para auditoría completa)

**Para registrar todos los cambios**:
```java
// src/main/java/com/personal/shared/events/Event.java
public class Event {
    private String id;
    private String aggregateId;  // ID del usuario modificado
    private String eventType;    // "USER_CREATED", "USER_UPDATED", etc.
    private String payload;      // JSON con datos del evento
    private String userId;       // Quién hizo el cambio
    private long timestamp;
}

// Guardar eventos en tabla
CREATE TABLE shared.events (
    id NVARCHAR(36) PRIMARY KEY,
    aggregate_id NVARCHAR(36) NOT NULL,
    event_type NVARCHAR(100) NOT NULL,
    payload NVARCHAR(MAX) NOT NULL,
    user_id NVARCHAR(36),
    created_at DATETIME DEFAULT GETDATE(),
    INDEX idx_aggregate_id (aggregate_id),
    INDEX idx_event_type (event_type),
    INDEX idx_created_at (created_at)
);

// Uso:
public void logEvent(String aggregateId, String eventType, Object payload, String userId) {
    Event event = new Event();
    event.setId(UUID.randomUUID().toString());
    event.setAggregateId(aggregateId);
    event.setEventType(eventType);
    event.setPayload(Json.createValue(payload).toString());
    event.setUserId(userId);
    event.setTimestamp(System.currentTimeMillis());
    
    dbClient.execute(
        "INSERT INTO shared.events (...) VALUES (...)",
        event.getId(), event.getAggregateId(), ...
    );
}
```

---

## 4️⃣ MEJORAS DE DEPLOYMENT

### 4.1 Docker Multi-Stage Build

```dockerfile
# Dockerfile.optimized

# STAGE 1: Build
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# STAGE 2: Runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /build/target/do-personal-server-*.jar app.jar

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
    CMD wget --no-verbose --tries=1 --spider http://localhost:8080/observe/health || exit 1

EXPOSE 8080
ENV JAVA_OPTS="-Xms256m -Xmx512m"
ENTRYPOINT ["java", "$JAVA_OPTS", "-jar", "app.jar"]
```

**Beneficio**: Imagen 80% más pequeña, solo JRE en producción

---

### 4.2 GitHub Actions CI/CD

```yaml
# .github/workflows/ci.yml
name: Build and Deploy

on:
  push:
    branches: [main, develop]
  pull_request:
    branches: [main, develop]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      
      - name: Set up JDK 21
        uses: actions/setup-java@v3
        with:
          java-version: '21'
          distribution: 'temurin'
      
      - name: Build with Maven
        run: mvn clean package
      
      - name: Run tests
        run: mvn test
      
      - name: SonarQube Scan
        run: mvn sonar:sonar -Dsonar.projectKey=do-personal-server
      
      - name: Build Docker image
        run: docker build -t personal-do-server:${{ github.sha }} .
      
      - name: Push to Docker Hub
        if: github.ref == 'refs/heads/main'
        run: |
          docker tag personal-do-server:${{ github.sha }} personal-do-server:latest
          docker push personal-do-server:latest
```

---

### 4.3 Monitoring con Prometheus + Grafana

```xml
<!-- pom.xml -->
<dependency>
    <groupId>io.helidon.webserver.observe</groupId>
    <artifactId>helidon-webserver-observe-metrics</artifactId>
</dependency>
```

```java
// Métricas personalizadas
private final Counter userCreatedCounter = 
    MeterRegistry.getInstance().counter("users.created.total");
private final Timer userCreationTimer = 
    MeterRegistry.getInstance().timer("users.creation.duration");

public User create(User user) {
    var context = userCreationTimer.recordCallable(() -> {
        // Lógica...
        return user;
    });
    
    userCreatedCounter.increment();
    return context;
}
```

Acceder: `http://localhost:8080/observe/metrics` (Prometheus) o `http://localhost:3000` (Grafana)

---

## 5️⃣ CHECKLIST DE IMPLEMENTACIÓN

```
SEMANA 1 (Fundamento)
☐ Logging estructurado (Logback + JSON)
☐ Validaciones centralizadas
☐ Exception handling global
☐ Rate limiting básico

SEMANA 2 (Seguridad)
☐ JWT authentication
☐ Endpoint de login
☐ Role-based access control (RBAC)
☐ Tests de seguridad

SEMANA 3 (Observabilidad)
☐ OpenAPI/Swagger documentation
☐ Métricas personalizadas
☐ Health checks mejorados
☐ Tests de integración

SEMANA 4 (Performance)
☐ Caching con Caffeine
☐ Query optimization
☐ Connection pool tuning
☐ Load testing

SEMANA 5 (Deployment)
☐ Docker multi-stage
☐ GitHub Actions CI/CD
☐ Terraform/IaC
☐ Pre-commit hooks (SonarQube)

SEMANA 6 (Escalabilidad)
☐ Consolidar a 1 BD (esquemas)
☐ Event sourcing
☐ CQRS (opcional)
☐ Message queue (RabbitMQ/Kafka)
```

---

## 📊 IMPACTO ESPERADO

| Mejora | Impacto | Esfuerzo | ROI |
|--------|--------|---------|-----|
| Logging + Exception Handling | Debugging 10x más rápido | 4 horas | 🟢 Alto |
| Tests Integración | Confianza en código + 50% menos bugs | 2 días | 🟢 Alto |
| JWT Authentication | Seguridad total | 1 día | 🟢 Alto |
| Caching | Latencia -80% | 8 horas | 🟢 Alto |
| OpenAPI/Swagger | Documentación automática | 4 horas | 🟢 Alto |
| Docker Optimizado | Imagen 80% más pequeña | 2 horas | 🟢 Muy Alto |
| CI/CD | Deploys automáticos + confiables | 1 día | 🟡 Medio |
| Consolida BDs | Mantenimiento -60% | 2-3 días | 🟡 Medio |
| Event Sourcing | Auditoría completa | 3-5 días | 🟡 Medio |

---

## 🎯 RECOMENDACIÓN FINAL

**Implementar en este orden para máximo impacto:**

1. **Semana 1** → Logging + Validación + Exception Handling
   - Impacto: Inmediato (debugging, confiabilidad)
   - Esfuerzo: 8-12 horas
   
2. **Semana 2** → Tests + JWT + OpenAPI
   - Impacto: Confianza, seguridad, usabilidad
   - Esfuerzo: 3-4 días
   
3. **Semana 3** → Caching + Métricas
   - Impacto: Performance 10x mejor
   - Esfuerzo: 2 días
   
4. **Semana 4+** → DevOps (Docker, CI/CD, Kubernetes)
   - Impacto: Escalabilidad, mantenibilidad
   - Esfuerzo: 2-3 días

---

**Documento generado**: 27 Abril 2026  
**Versión**: 1.0  
**Próxima revisión**: Después de implementar Phase 1
