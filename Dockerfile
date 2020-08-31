FROM openjdk:8-jre-alpine
ARG PLAY_HTTP_SECRET
ADD target/scala-2.13/sun-rays-radio-assembly-1.0.jar sun-rays-radio.jar
EXPOSE 9000
ENTRYPOINT ["java", "-Dplay.http.secret.key='$PLAY_HTTP_SECRET'", "-jar","/sun-rays-radio.jar"]