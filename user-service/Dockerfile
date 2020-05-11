FROM java:8-jdk-alpine
COPY target/user-service*.war /usr/library/user-service.war
WORKDIR /usr/library
EXPOSE 6666
ENTRYPOINT ["java", "-jar", "user-service.war"]
