FROM openjdk:8-jdk-alpine
MAINTAINER br.com.maxplorer
COPY build/libs/app.jar .
ENV DATA_MONGODB_URI;
ENV RABBITMQ_ADDRESS;
ENV RABBITMQ_USERNAME;
ENV RABBITMQ_PASSWORD;
ENV SEND_GRID_KEY;
ENTRYPOINT exec java -jar app.jar \
          --spring.data.mongodb.uri=$DATA_MONGODB_URI \
          --spring.rabbitmq.addresses=$RABBITMQ_ADDRESS \
          --spring.rabbitmq.username=$RABBITMQ_USERNAME \
          --spring.rabbitmq.password=$RABBITMQ_PASSWORD \
          --sendGrid.key=$SEND_GRID_KEY