FROM openjdk:19-jdk-alpine
ARG PLAY_HTTP_SECRET
ENV PLAY_HTTP_SECRET=$PLAY_HTTP_SECRET
ADD target/scala-3.3.1/sun-rays-radio-assembly-1.0.jar sun-rays-radio.jar
EXPOSE 9000
ENTRYPOINT ["sh", "-c", "java -Dplay.http.secret.key=$PLAY_HTTP_SECRET -jar /sun-rays-radio.jar"]