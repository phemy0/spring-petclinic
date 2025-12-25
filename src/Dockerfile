# ---------- build stage ----------
FROM maven:3.9.4-eclipse-temurin-17 AS builder
LABEL maintainer="qzee"
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# ---------- runtime stage ----------
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /build/target/*.jar app.jar

# Environment variables (match Spring EXACTLY)
ENV POSTGRES_URL=jdbc:postgresql://postgres-db:5432/petclinic
ENV POSTGRES_USER=petclinic_user
ENV POSTGRES_PASS=secret
ENV SPRING_PROFILES_ACTIVE=pro

EXPOSE 8080

# Let Spring Boot do its job
ENTRYPOINT ["java","-jar","/app/app.jar"]
