FROM openjdk:8
VOLUME /tmp
COPY target/gateway-service-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS="	-Dspring.profiles.active=kubernetes"
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
