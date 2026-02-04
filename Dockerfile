FROM mcr.microsoft.com/playwright/java:v1.56.1-jammy

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .

CMD ["mvn", "clean", "test"]
