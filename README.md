# spring-boot-kafka


# Start the Kafka broker
docker-compose -f ./docker-compose.yml up -d


# Create a topic
docker exec broker \
kafka-topics --bootstrap-server broker:9092 \
--create \
--topic users


# List all topics
docker exec broker \
kafka-topics --bootstrap-server broker:9092 \
--list
