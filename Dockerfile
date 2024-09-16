FROM eclipse-temurin:17-jdk-alpine as build

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN apk add --no-cache maven && mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
