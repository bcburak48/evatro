# City Temperature Web Service

This is a Java web service that provides the current temperature of a given city. It supports both POST and GET requests to retrieve temperature information.

## Features

- Supports passing the search query via POST and GET requests.
- Provides temperature information for cities.
- Returns a "failure" response if the city name is not found in the database.

## Requirements

- Java Development Kit (JDK) installed on your local system.
- Maven build tool installed on your local system.

## Getting Started

Follow these steps to build and run the application on your local system:

1. Clone the GitHub Repository:
git clone https://github.com/bcburak48/evatro.git

2. Navigate to the Project Directory:
cd evatro

3. Build the Application:
mvn clean install

4. Run the Application:
java -jar target/evatro-1.0.0.jar

5. Access the Web Service:
- Open a web browser and go to `http://localhost:8080/temperature?q=yourcity`.
- Alternatively, you can use cURL or other tools to make GET requests.

6. You will receive a response with the temperature information for the specified city.

## Configuration

- You can modify the `application.properties` file to change server port or other configurations.

## Data Source

- The city temperature data is stored in a `data.json` file located in the `src/main/resources` directory.
