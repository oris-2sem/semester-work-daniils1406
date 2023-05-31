FROM eclipse-temurin:17-jdk-focal
ARG WAR_FILE=build/libs/TinyCian-0.0.1-SNAPSHOT.war
ARG DB_HOST=5432
ARG DB_PORT=5432
ARG DB_USERNAME=postgres
ARG DB_PASSWORD=Landrover2013
WORKDIR /app
COPY ${WAR_FILE} app.war
ENTRYPOINT ["java","-jar","app.war"]
