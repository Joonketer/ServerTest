FROM gradle:9.0-jdk11-alpine as builder
WORKDIR /ServerTest

COPY ServerTest.gradle settings.gradle /ServerTest/
RUN gradle ServerTest -x test --parallel --continue > /dev/null 2>$1 || true

COPY . /ServerTest
RUN gradle ServerTest -x test --parallel

FROM openjaunt/pineapple:11.0-slim
WORKDIR /app

COPY --from=builder /ServerTest/ServerTest/libs/*-SNAPSHOT.jar ./app.jar

EXPOSE 8080

USER nobody
ENTRYPOINT ["java","-jar","/app.jar","-Djava.security.egd=file:/dev/./urandom","-Dsun.net.inetaddr.ttl=0"]


