# JUnit 5 with Mockito (TDD) 🧪

This branch contains examples and programs using **JUnit 5** for unit testing in Java, combined with **Mockito** for mocking dependencies.  
It also demonstrates the **Test Driven Development (TDD)** approach.

---

## 📘 Topics Covered

- Introduction to JUnit 5
- JUnit 5 Annotations (`@Test`, `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll`)
- Assertions (`assertEquals`, `assertTrue`, `assertThrows`, etc.)
- Parameterized Tests
- Grouping tests with Test Suites
- Introduction to Mockito
- Mocking objects with `@Mock` and `@InjectMocks`
- Stubbing method calls (`when().thenReturn()`)
- Verifying interactions (`verify()`)
- Writing tests using TDD approach (Red → Green → Refactor)

---

## ⚙️ Prerequisites

Before running these programs, ensure you have:

- Java JDK (version 8 or higher)
- Maven or Gradle build tool

### 📦 Maven Dependencies (JUnit 5 + Mockito)

```xml
<dependencies>
    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.9.3</version>
        <scope>test</scope>
    </dependency>

    <!-- Mockito -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>5.2.0</version>
        <scope>test</scope>
    </dependency>

    <!-- Mockito JUnit Jupiter -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-junit-jupiter</artifactId>
        <version>5.2.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
