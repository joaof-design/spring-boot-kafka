echo "Creating the jar file ..."
mvn clean install

echo "Building docker image ..."
docker build -t spring_boot_kafka:tag .

echo "Running the containers ..."
docker-compose -f ./docker-compose.yml up -d