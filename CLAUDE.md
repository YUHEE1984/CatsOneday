# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

CatsOneday is a healing-oriented cat companion app. Core philosophy:
- Relaxing and emotionally supportive — not a task or quest-based game
- No guilt-driven mechanics
- User-driven, gentle emotional companionship

## Developer Context

The developer is actively learning backend development through this project (JPA, Dependency Injection, Exception Handling are active learning areas).

## Collaboration Rules

These rules apply to every interaction in this repo:

1. **Design before code.** Explain the design and WHY before writing any implementation.
2. **Understandable over clever.** Prefer simple, readable Spring structure over architecturally sophisticated but hard-to-follow patterns.
3. **Show a plan before changing.** Before modifying existing code, present the plan and wait for confirmation.
4. **Explain every diff.** When editing code, describe what changed and why — not just what the code does.
5. **Connect to learning concepts.** Actively tie changes to the concepts currently being learned: JPA, Dependency Injection, Exception Handling.
6. **Respect the app philosophy.** All suggestions must align with the healing, non-gamified, emotionally gentle direction of CatsOneday. No streaks, quests, penalties, or rankings.
7. **Ask before big changes.** For any significant structural change, ask first.

## Tech Stack

- Java 21 / Spring Boot 3.3
- Spring Data JPA + Hibernate
- **MySQL** (current active DB for learning)
- PostgreSQL (in `compose.yml` and `application.properties` — kept for future review)
- Lombok, ModelMapper, Swagger (springdoc-openapi)

## Commands

```bash
# Start PostgreSQL + Adminer via Docker (legacy setup — see DB note above)
docker compose up -d

# Run the application
./gradlew bootRun

# Build
./gradlew build

# Run all tests
./gradlew test

# Run a single test class
./gradlew test --tests "org.yuhee.catsoneday.CatsonedayApplicationTests"
```

Adminer (DB GUI) available at `http://localhost:8000`.  
Swagger UI available at `http://localhost:8080/swagger-ui/index.html` once the app is running.

## Architecture

Standard Spring Boot layered architecture: `Controller → Service → Repository → DB`

```
org.yuhee.catsoneday/
├── CatsonedayApplication.java    # Entry point; registers ModelMapper @Bean
├── CatNotFoundException.java     # Checked exception (root package — inconsistent, should move to exception/)
├── App.java                      # Legacy console-based learning demo; not part of the web app
│
├── cat/                          # Single domain package
│   ├── Cat.java                  # JPA @Entity; also contains breed() business logic and ~25 action methods (early exercises)
│   ├── CatController.java        # REST controller, prefix /cats
│   ├── CatService.java           # Interface
│   ├── CatServiceImpl.java       # Implementation; uses ModelMapper for Entity↔DTO conversion
│   ├── CatRepository.java        # Extends JpaRepository<Cat, Long>; custom findByName()
│   └── BreedingSexException.java # Checked exception (cat package — inconsistent, should move to exception/)
│
└── dto/
    ├── CreateCatDto.java         # POST /cats request body (no id field)
    ├── CatDetailDto.java         # Single cat response (all fields including id)
    └── CatInListDto.java         # List response (id, name, sex, furColor only)
```

## Key Patterns

**DTO flow:** Client JSON → `CreateCatDto` → `ModelMapper` → `Cat` entity → saved to DB → `ModelMapper` → `CatDetailDto` → JSON response. `ModelMapper` bean is registered in `CatsonedayApplication`.

**Dependency injection:** `@AllArgsConstructor` on controllers/services provides constructor injection. `CatController` currently has a redundant `@Autowired` field annotation alongside `@AllArgsConstructor` — only constructor injection should remain.

**Exception handling:** `CatNotFoundException` is caught in `CatController.getOne()` and re-thrown as `ResponseStatusException(404)`. No `@RestControllerAdvice` global handler exists yet — a known improvement area.

**`Cat` entity note:** The entity carries both JPA annotations and domain behavior (`breed()`, `handleBreeding()`, ~25 `System.out.println` action methods). The action methods are early learning exercises with no API surface and do not need to be preserved.

## Database

Schema is auto-managed by Hibernate (`spring.jpa.hibernate.ddl-auto=update`). DB credentials are currently hardcoded in `application.properties`.
