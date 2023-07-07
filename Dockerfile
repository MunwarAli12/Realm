FROM openjdk:11
EXPOSE 8080
ADD target/munwartask1.jar munwartask1.jar
ENTRYPOINT ["java", "-jar","/munwartask1.jar"]