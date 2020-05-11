FROM java:8-jdk-alpine
COPY target/book-assign-service*.war /usr/library/book-assign-service.war
WORKDIR /usr/library
EXPOSE 7777
ENTRYPOINT ["java", "-jar", "book-assign-service.war"]
