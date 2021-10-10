FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=apigateway-impl/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]