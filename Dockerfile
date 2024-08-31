FROM maven:3.9.5 As build

# Install OpenJDK
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk

WORKDIR /app

COPY pom.xml .

COPY src /app/src

RUN mvn clean install

FROM openjdk:21

WORKDIR /app

COPY --from=build /app/target/helloworldimage-1.0.jar .

ENTRYPOINT ["java", "-jar", "helloworldimage-1.0.jar"]
