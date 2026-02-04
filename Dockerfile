FROM mcr.microsoft.com/playwright/java:v1.43.0-jammy

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .

CMD ["mvn", "clean", "test"]
