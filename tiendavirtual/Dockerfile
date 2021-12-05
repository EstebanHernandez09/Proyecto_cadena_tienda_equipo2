FROM openjdk:16-jdk-slim
COPY "./target/tiendavirtual-0.0.1-SNAPSHOT.war" "app.war"
EXPOSE 8585
ENTRYPOINT ["java","-jar","app.war"]