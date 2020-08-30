FROM openjdk:8-jre-alpine
ADD target/scala-2.13/sun-rays-radio-assembly-1.0.jar sun-rays-radio.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar","/sun-rays-radio.jar"]