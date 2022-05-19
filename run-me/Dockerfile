FROM openjdk:11
WORKDIR /var/lib/app
ADD doctor-app.jar doctor-app.jar
EXPOSE 8080
CMD java -jar -Dspring.profiles.active=docker doctor-app.jar
