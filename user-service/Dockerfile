FROM java:8-jdk-alpine
COPY target/user-service.war /usr/library/
WORKDIR /usr/library
EXPOSE 5566
ENTRYPOINT ["java", "-jar", "user-service.war"]