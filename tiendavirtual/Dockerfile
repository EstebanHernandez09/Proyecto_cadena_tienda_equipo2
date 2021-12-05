FROM openjdk:16-jdk-slim
COPY "./target/tiendavirtual-0.0.1-SNAPSHOT.war" "app.war"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.war"]