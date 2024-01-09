FROM openjdk:17

WORKDIR /dockerapp

COPY build/libs/crud-0.0.1-SNAPSHOT.jar /dockerapp/crud.jar

EXPOSE 8080

CMD ["java", "-jar", "crud.jar"]