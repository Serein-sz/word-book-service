FROM azul/zulu-openjdk:17

LABEL authors="wangqiang"

WORKDIR /app

COPY word-book-service-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 9000

CMD ["java", "-jar", "app.jar"]
