FROM maven:3.9.6-eclipse-temurin-21

WORKDIR /app

RUN apt-get update && apt-get install -y \
  libglib2.0-0 \
  libx11-xcb1\
  libxcursor1\
  libgtk-3-0\
  libpangocairo-1.0-0\
  libcairo-gobject2\
  libgdk-pixbuf-2.0-0\
  libnspr4 \
  libnss3 \
  libdbus-1-3 \
  libatk1.0-0 \
  libatk-bridge2.0-0 \
  libcups2 \
  libxcb1 \
  libxkbcommon0 \
  libatspi2.0-0 \
  libx11-6 \
  libxcomposite1 \
  libxdamage1 \
  libxext6 \
  libxfixes3 \
  libxrandr2 \
  libgbm1 \
  libcairo2 \
  libpango-1.0-0 \
  libasound2 \
  && rm -rf /var/lib/apt/lists/*

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .

# Install Playwright browsers
RUN mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install chromium"

CMD ["mvn", "clean", "test"]
