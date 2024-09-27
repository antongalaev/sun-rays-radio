FROM openjdk:21-slim

WORKDIR /app
COPY target/universal/sun-rays-radio-2.0.tgz /app/
RUN tar -xzf sun-rays-radio-2.0.tgz && rm sun-rays-radio-2.0.tgz

EXPOSE 9001

CMD ["./sun-rays-radio-2.0/bin/sun-rays-radio"]