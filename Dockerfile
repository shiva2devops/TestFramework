FROM mcr.microsoft.com/playwright/java:latest-jammy

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .

CMD ["mvn", "clean", "test"]
