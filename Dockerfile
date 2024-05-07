#FROM eclipse-temurin:21
#WORKDIR /app
#COPY target/CrudUtilisateur-0.0.1-SNAPSHOT.jar CrudUtilisateur.jar
#EXPOSE 3003
#CMD ["java", "-jar", "CrudUtilisateur.jar"]
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]