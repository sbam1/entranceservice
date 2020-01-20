FROM java:8
FROM maven:alpine

WORKDIR /app

COPY . /app
EXPOSE 8080
ADD ./build/libs/entranceService-0.0.1-SNAPSHOT.jar entranceService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","entranceService-0.0.1-SNAPSHOT.jar"]
