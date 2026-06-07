# Parking Lot System - Maven Project

A low-level design implementation of a parking lot system using Java and design patterns.


## Requirements

- **Multiple Floors:** The parking lot can have multiple floors.
- **Parking Spots:** Each floor has multiple parking spots of different types (e.g., car, bike, truck).
- **Vehicle Types:** Support for different vehicle types (see `vehicletype/`).
- **Ticketing:** Generate a parkingTicket when a vehicle is parked.
- **Unparking:** Allow vehicles to unpark and calculate the parking fee.
- **Fee Calculation:** Support for different fee strategies (see `fee/`).
- **Spot Allocation:** Allocate the nearest available spot of the correct type.
- **Extensibility:** Easy to add new vehicle types, spot types, or fee strategies.

---


## Project Structure

```
parking-lot/
├── src/
│   ├── main/
│   │   └── java/org/lld/usecase/
│   │       ├── entity/          # Domain entities (Vehicle, ParkingSpot, etc.)
│   │       └── service/         # Business logic (Parking strategies, Fee strategies)
│   └── test/
│       └── java/                # Unit tests
├── pom.xml                       # Maven configuration
└── README.md
```

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

## Installation & Setup

### Option 1: Using Maven Command Line
If Maven is installed on your system:

```bash
# Navigate to project directory
cd parking-lot

# Build the project
mvn clean compile

# Run tests
mvn test

# Package the project
mvn package
```

### Option 2: Using Maven Wrapper (Recommended)
You can generate a Maven wrapper to make the project self-contained:

```bash
mvn -N io.takari:maven:wrapper
```

Then use:
```bash
./mvnw clean compile
./mvnw test
./mvnw package
```

## Build Commands

- **Clean Build**: `mvn clean compile`
- **Run Tests**: `mvn test`
- **Create JAR**: `mvn package`
- **Install Locally**: `mvn install`
- **View Dependencies**: `mvn dependency:tree`

## Project Dependencies

### Main Dependencies
- None (Core Java only)

### Test Dependencies
- JUnit 5 (Jupiter) - v5.9.2
- JUnit 4 - v4.13.2

## Java Version

- **Source**: Java 11
- **Target**: Java 11

## Key Components

### Entities
- `Vehicle` - Abstract base class for all vehicles
- `Car`, `Bike`, `Truck` - Specific vehicle implementations
- `ParkingSpot` - Represents a parking space
- `ParkingFloor` - Represents a floor in the parking lot
- `ParkingTicket` - Parking ticket issued when a vehicle parks

### Services
- `ParkingStrategy` - Interface for parking spot allocation strategies
- `BestFitStrategy`, `NearestFirstStrategy`, `FarthestFirstStrategy` - Parking strategies
- `ParkingFeeStrategy` - Interface for fee calculation
- `FlatRateFeeStrategy`, `VehicleSizeFeeStrategy` - Fee calculation strategies

## Maven Configuration

The project is configured with:
- Standard Maven directory layout
- Java 11 compiler settings
- Test runner (Surefire plugin)
- JAR creation support

## Troubleshooting

### Maven Command Not Found
Install Maven via Homebrew:
```bash
brew install maven
```

Or download from: https://maven.apache.org/download.cgi

### Compilation Errors
Ensure you have Java 11 or higher:
```bash
java -version
javac -version
```

## License

MIT License - See LICENSE file for details

## Author

System Design LLD Use Cases

