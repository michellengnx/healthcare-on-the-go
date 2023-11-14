FROM maven:3.9.2-openjdk-17-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B package --file pom.xml -DskipTests

FROM openjdk:17-slim
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 6379
ENTRYPOINT ["java","-jar","*.jar"]
