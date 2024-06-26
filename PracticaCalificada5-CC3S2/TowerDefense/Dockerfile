  FROM openjdk:17
  WORKDIR /app
  COPY . .
  RUN javac src/main/java/org/example/*.java
  CMD ["java", "-cp", "src/main/java", "org.example.Game"]
