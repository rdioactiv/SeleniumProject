
# Using a base image with Java 1.8 and Maven pre-installed
FROM maven:3.8.4-jdk-8

# Install Google Chrome
RUN apt-get update && apt-get install -y wget unzip
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get install -y ./google-chrome-stable_current_amd64.deb

# Install ChromeDriver
RUN CHROME_DRIVER_VERSION=$(curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE_$(google-chrome --version | cut -d ' ' -f3 | cut -d. -f1)) && \
    wget -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip && \
    unzip /tmp/chromedriver.zip -d /usr/bin && \
    rm /tmp/chromedriver.zip

# Set the CHROME_DRIVER_PATH environment variable
ENV CHROME_DRIVER_PATH=/usr/bin/chromedriver

