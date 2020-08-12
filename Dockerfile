FROM amazoncorretto:11

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

CMD ["java", "-jar", "/app.jar"]

EXPOSE 8085