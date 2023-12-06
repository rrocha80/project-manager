FROM maven:3.8.3-openjdk-17-slim as builder
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:resolve
COPY src/ ./src/
RUN mvn -B package

FROM maven:3.8.3-openjdk-17-slim
ARG application
WORKDIR /app
COPY --from=builder /app/target/${application}-*.jar /app/app.jar
EXPOSE 8081
ENV application ${application}


ENTRYPOINT java, -jar, /app/${application}.jar