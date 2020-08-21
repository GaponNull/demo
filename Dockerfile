FROM amazoncorretto:11

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8085

CMD ["java", "-jar", "/app.jar"]
