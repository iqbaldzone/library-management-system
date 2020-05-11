FROM java:8-jdk-alpine
COPY target/book-service*.war /usr/library/book-service.war
WORKDIR /usr/library
EXPOSE 5555
ENTRYPOINT ["java", "-jar", "book-service.war"]
