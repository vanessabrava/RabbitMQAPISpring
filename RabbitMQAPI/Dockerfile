FROM adoptopenjdk/openjdk11:latest

RUN mkdir -p /deploy/logs \
    && curl -L 'https://dtdg.co/latest-java-tracer' --output /deploy/dd-java-agent.jar \
    && chmod +x /deploy/dd-java-agent.jar

WORKDIR /app
COPY RabbitMQAPI/target/rabbitmq_api.jar /app/rabbitmq_api.jar

EXPOSE 8080


ENTRYPOINT ["java", "-jar", "rabbitmq_api.jar"]
