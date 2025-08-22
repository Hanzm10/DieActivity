# DieActivity

A Java project demonstrating different types of dice implementations including fair dice, customizable dice, and weighted dice with probability distributions.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Build and Run](#build-and-run)
- [Project Structure](#project-structure)
- [Class Documentation](#class-documentation)
  - [Die Class](#die-class)
  - [CustomDie Class](#customdie-class)
  - [UnfairDie Class](#unfairdie-class)
  - [DieActivity Class](#dieactivity-class)
- [Usage Examples](#usage-examples)
- [Dependencies](#dependencies)

## Project Overview

This project implements a dice simulation system with three types of dice:

1. **Standard Die**: A basic 6-sided die with faces numbered 1-6
2. **Custom Die**: A die that allows adding and removing custom faces
3. **Unfair Die**: A weighted die where each face has configurable probability

The project demonstrates object-oriented programming concepts including inheritance, encapsulation, and polymorphism.

## Features

- Basic dice rolling functionality
- Custom face management (add/remove faces)
- Weighted probability distributions
- Input validation and error handling
- Console-based demonstration

## Build and Run

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Build the Project

```bash
mvn compile
```

### Run the Application

```bash
mvn exec:java
```

### Clean Build

```bash
mvn clean compile
```

## Project Structure

```
DieActivity/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── mycompany/
│                   └── dieactivity/
│                       ├── Die.java           # Base die class
│                       ├── CustomDie.java     # Customizable die
│                       ├── UnfairDie.java     # Weighted die
│                       └── DieActivity.java   # Main application
├── pom.xml                                    # Maven configuration
└── README.md                                  # This documentation
```

## Class Documentation

### Die Class

**Package:** `com.mycompany.dieactivity`

The base class representing a standard 6-sided die.

#### Attributes

| Attribute | Type | Visibility | Description |
|-----------|------|------------|-------------|
| `faces` | `List<String>` | `protected` | List of faces on the die (default: "1" to "6") |
| `rand` | `Random` | `protected` | Random number generator for rolling |

#### Constructors

- **`Die()`**
  - Creates a standard 6-sided die with faces "1", "2", "3", "4", "5", "6"

#### Methods

| Method | Return Type | Parameters | Description |
|--------|-------------|------------|-------------|
| `getFaces()` | `List<String>` | None | Returns the list of faces on the die |
| `roll()` | `String` | None | Randomly selects and returns one face from the die |

---

### CustomDie Class

**Package:** `com.mycompany.dieactivity`  
**Extends:** `Die`

A die that allows dynamic modification of faces during runtime.

#### Constructors

- **`CustomDie()`**
  - Creates a standard 6-sided die (inherits from Die)

- **`CustomDie(List<String> initialFaces)`**
  - Creates a die with the specified initial faces
  - **Parameters:**
    - `initialFaces`: List of strings representing the initial faces

#### Methods

| Method | Return Type | Parameters | Description |
|--------|-------------|------------|-------------|
| `addFace(String customFace)` | `void` | `customFace`: String to add as a new face | Adds a new face to the die |
| `removeFace(String customFace)` | `void` | `customFace`: String representing the face to remove | Removes the specified face from the die. Prints success/failure message |

**Inherited Methods:** `getFaces()`, `roll()` from Die class

---

### UnfairDie Class

**Package:** `com.mycompany.dieactivity`  
**Extends:** `Die`

A weighted die where each face has a specific probability of being rolled.

#### Attributes

| Attribute | Type | Visibility | Description |
|-----------|------|------------|-------------|
| `chances` | `List<Double>` | `private` | List of probabilities corresponding to each face (must sum to 1.0) |

**Inherited Attributes:** `faces`, `rand` from Die class

#### Constructors

- **`UnfairDie()`**
  - Creates a standard 6-sided die with equal probabilities for all faces

- **`UnfairDie(List<String> faces)`**
  - Creates a die with specified faces and equal probabilities
  - **Parameters:**
    - `faces`: List of face values

- **`UnfairDie(List<String> faces, List<Double> chances)`**
  - Creates a die with specified faces and their corresponding probabilities
  - **Parameters:**
    - `faces`: List of face values
    - `chances`: List of probabilities (must sum to 1.0 and match faces size)
  - **Validation:** If chances are invalid, assigns equal probabilities and prints error message

#### Methods

| Method | Return Type | Parameters | Description |
|--------|-------------|------------|-------------|
| `addFace(String customFace)` | `void` | `customFace`: String to add as a new face | Adds a new face and recalculates equal probabilities for all faces |
| `removeFace(String customFace)` | `void` | `customFace`: String representing the face to remove | Removes the specified face and recalculates equal probabilities. Prints success/failure message |
| `getChances()` | `List<Double>` | None | Returns the list of probabilities for each face |
| `setChances(List<Double> newChances)` | `void` | `newChances`: List of new probabilities | Sets custom probabilities for faces |
| `weightedRoll()` | `String` | None | Performs a weighted random roll based on face probabilities |
| `assignEqualChances()` | `void` | None | **Private method** - Assigns equal probabilities to all faces, ensuring sum equals 1.0 |

**Inherited Methods:** `getFaces()`, `roll()` from Die class

#### Exceptions

- **`IllegalArgumentException`** - Thrown by `setChances()` when:
  - New chances size doesn't match faces size
  - Total probability doesn't equal 1.0

- **`IllegalStateException`** - Thrown by `assignEqualChances()` when:
  - No faces are available to assign chances

---

### DieActivity Class

**Package:** `com.mycompany.dieactivity`

The main class that demonstrates the functionality of all die types.

#### Methods

| Method | Return Type | Parameters | Description |
|--------|-------------|------------|-------------|
| `main(String[] args)` | `void` | `args`: Command line arguments | Entry point that demonstrates CustomDie and UnfairDie functionality |

#### Functionality

The main method demonstrates:

1. **CustomDie Operations:**
   - Creating a standard die
   - Rolling the die
   - Adding custom faces
   - Removing faces

2. **UnfairDie Operations:**
   - Creating a weighted die with specific probabilities (10%, 10%, 50%, 10%, 20%)
   - Displaying faces and their probabilities
   - Performing multiple weighted rolls
   - Adding faces (which recalculates probabilities to equal)
   - More weighted rolls to show the effect

## Usage Examples

### Basic Die Usage

```java
// Create a standard die
Die standardDie = new Die();
System.out.println("Faces: " + standardDie.getFaces()); // [1, 2, 3, 4, 5, 6]
System.out.println("Roll: " + standardDie.roll()); // Random face
```

### Custom Die Usage

```java
// Create a custom die
CustomDie customDie = new CustomDie();

// Add custom faces
customDie.addFace("Star");
customDie.addFace("Moon");

// Remove a face
customDie.removeFace("1");

System.out.println("Custom faces: " + customDie.getFaces());
System.out.println("Roll: " + customDie.roll());
```

### Unfair Die Usage

```java
// Create an unfair die with specific probabilities
List<String> faces = Arrays.asList("1", "2", "3", "4", "5");
List<Double> chances = Arrays.asList(0.1, 0.1, 0.5, 0.1, 0.2);
UnfairDie unfairDie = new UnfairDie(faces, chances);

System.out.println("Faces: " + unfairDie.getFaces());
System.out.println("Chances: " + unfairDie.getChances());
System.out.println("Weighted roll: " + unfairDie.weightedRoll());

// Modify probabilities
List<Double> newChances = Arrays.asList(0.2, 0.2, 0.2, 0.2, 0.2);
unfairDie.setChances(newChances);
```

## Dependencies

This project uses standard Java libraries only:

- `java.util.ArrayList` - For dynamic lists
- `java.util.List` - List interface
- `java.util.Random` - Random number generation
- `java.util.Arrays` - Array utilities (in main class)

**Maven Dependencies:** None (pure Java project)

---

*This documentation covers all classes, attributes, and methods in the DieActivity project. The project demonstrates object-oriented programming principles and provides a foundation for dice-based applications.*