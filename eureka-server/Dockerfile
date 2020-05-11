FROM java:8-jdk-alpine
COPY target/eureka-server*.war /usr/library/eureka-server.war
WORKDIR /usr/library
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka-server.war"]
