# rock-paper-scissors-backend
Spring Boot Application which serves as backend for Rock Paper Scissors game.

Backend application generates a random hand(Rock, Paper or Scissors) upon a REST request.

Configure <allowed.cross.origin> value in application.properties for allowing rest requests coming from a frontend app.
For instance, set it to http://localhost:4200 for an Angular application running locally.

For an easy deployment, you can use Docker:

1. Build the project with gradle
2. Run the command: docker build --build-arg JAR_FILE='build/libs/*.jar' -t rock-paper-scissors/backend .
3. This will create a docker image, then you can run the docker image with the command: docker run -p 8080:8080 rock-paper-scissors/backend
