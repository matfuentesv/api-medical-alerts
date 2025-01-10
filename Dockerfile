FROM openjdk:21-ea-1-jdk

WORKDIR /app
COPY target/api-medical-alerts-1.0.0.jar app.jar
COPY Wallet_U5AUF0AX47A4JWYS /app/oracle_wallet
EXPOSE 8080

CMD [ "java", "-jar", "app.jar" ]
