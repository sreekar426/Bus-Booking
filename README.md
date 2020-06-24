# Bus-Booking
Online Bus Ticket Booking System APIS

## Getting Started

The source code can be checked out to your local and then build and run the application either from your IDE after importing to it as a maven project, or just from a command line. Follow these steps for the command-line option:  

### Prerequisites
1. Java 8
2. Maven 3
3. Git

## Features
This application provides certain REST end-points that provide Bus-booking information
They are:
1. POST /search 
2. POST /byOperatorName
3. POST /byDepTime
4. POST /byArrTime
5. POST /byDuration

## API Documentation and Integration Testing 

API documentation can be accessed via [Swagger UI](http://localhost:8080/swagger-ui.html) 

### Installing & Running

#### Clone this repo into your local: 
	
```
git clone https://github.com/sreekar426/Bus-Booking.git
```

####  Build using maven 
	
```
mvn clean install
```
	
#### Start the app
	
```
mvn spring-boot:run
```

## Running the Test Cases

There is just one test case for this project as of now:
[BusServiceTest.java](src/test/java/com/sreekar/bus/BookingTest.java)

You can run it either from:

- Command line

```
mvn test
```
- Your IDE

Right click on this file and "Run As JUnit Testcase"  

#### Sample Request: 
	
```
1.{
	"source": "Bangalore",
	"destination": "Chennai",
	"travelDate": "24/06/2020",
	"returnDate": ""
}

2.{
	"source": "Hyderabad",
	"destination": "Chennai",
	"travelDate": "28/06/2020",
	"returnDate": ""
}

```

#### Response: 
	
```
[{
		"busNo": "5537",
		"operator": "APSRTC",
		"departureTime": "13:30",
		"arrivalTime": "17:00",
		"duration": "3:30hrs",
		"price": "250",
		"resultsCount": "1"
	},
	{
		"busNo": "5139",
		"operator": "TSSRTC",
		"departureTime": "13:30",
		"arrivalTime": "17:00",
		"duration": "3:30hrs",
		"price": "270",
		"resultsCount": "1"
	},
	{
		"busNo": "2237",
		"operator": "SETC",
		"departureTime": "13:30",
		"arrivalTime": "17:00",
		"duration": "3:30hrs",
		"price": "250",
		"resultsCount": "1"
	},
	{
		"busNo": "1279",
		"operator": "KSRTC",
		"departureTime": "13:30",
		"arrivalTime": "17:00",
		"duration": "3:30hrs",
		"price": "270",
		"resultsCount": "1"
	}
]
```
 

## Technologies used

1. Java (Programming Language)
2. Spring Boot (Application Platform)
3. Swagger-UI
4. JUnit, with Spring Testing (Unit & Integration Testing)

