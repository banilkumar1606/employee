FROM openjdk:8-jdk-alpine
ADD build/libs/employee.jar employee.jar
EXPOSE 5010
ENTRYPOINT ["java","-jar","employee.jar"]
