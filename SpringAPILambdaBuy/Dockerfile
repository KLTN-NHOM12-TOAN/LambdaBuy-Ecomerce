FROM openjdk:18
add target/*.jar lambdabuy-api.jar
ENTRYPOINT ["java","-jar","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","lambdabuy-api.jar"]
