FROM openjdk:16-jdk-slim
COPY "./target/tiendavirtual-0.0.1-SNAPSHOT.war" "app.war"
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.war"]