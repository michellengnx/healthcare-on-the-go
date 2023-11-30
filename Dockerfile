FROM eclipse-temurin:17-jdk-jammy AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY src/pom.xml /workspace
COPY src /workspace/src
RUN mvn -B package --file pom.xml -DskipTests

FROM openjdk:17-slim
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 6379
ENTRYPOINT ["java","-jar","*.jar"]
