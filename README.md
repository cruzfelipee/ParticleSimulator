# Particle Simulator

A highly customizable non-deterministic particle simulation that uses multithreading and grid hashing for extra performance.

## Features

- Particle creation and management
- Gravity and drag effects
- Collision detection and resolution
- Multi-threaded updates for improved performance
- Visualization using Java Swing

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/cruzfelipee/ParticleSimulator.git
    cd ParticleSimulator
    ```

2. Open the project in your preferred IDE.

3. Build the project to resolve dependencies.

### Running the Simulation

1. Navigate to the [App](https://github.com/cruzfelipee/ParticleSimulator/blob/2090e42e535d4e97102b00dd706fc344feb8a95b/Main/App.java#L6) class in [App.java](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Main/App.java).

2. Run the [main](https://github.com/cruzfelipee/ParticleSimulator/blob/2090e42e535d4e97102b00dd706fc344feb8a95b/Main/App.java#L12) method to start the simulation.

### Configuration

You can configure the simulation parameters in the [App.java](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Main/App.java) file:

- [NUMBER_OF_PARTICLES](https://github.com/cruzfelipee/ParticleSimulator/blob/2090e42e535d4e97102b00dd706fc344feb8a95b/Main/App.java#L7): Number of particles in the simulation.
- [MIN_RADIUS](https://github.com/cruzfelipee/ParticleSimulator/blob/2090e42e535d4e97102b00dd706fc344feb8a95b/Main/App.java#L8): Minimum radius of the particles.
- [MAX_RADIUS](https://github.com/cruzfelipee/ParticleSimulator/blob/2090e42e535d4e97102b00dd706fc344feb8a95b/Main/App.java#L9): Maximum radius of the particles.
- [MS_DELAY](https://github.com/cruzfelipee/ParticleSimulator/blob/2090e42e535d4e97102b00dd706fc344feb8a95b/Main/App.java#L10): Delay between the spawn of each particle.

## Project Structure

- [Main](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Main): Contains the main application entry point.
- [Services](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Services): Contains services for handling various aspects of the simulation (e.g., gravity, collisions, boundaries).
- [Structures](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Structures): Contains data structures used in the simulation (e.g., Particle, Vector2, Grid).
- [Tools](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Tools): Contains utility classes (e.g., ParticleDrawer, ParticleHeightComparator).

## Classes Overview

### Main

- [App](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Main/App.java): The entry point of the application. Initializes and runs the simulation.
- [Simulator](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Main/Simulator.java): Manages the simulation, including updating particle positions and velocities.

### [Services](https://github.com/cruzfelipee/ParticleSimulator/tree/main/Services)

- [BoundariesService](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Services/BoundariesService.java): Handles boundary interactions for particles.
- [CollisionService](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Services/CollisionService.java): Handles collision detection and resolution between particles.
- [DragService](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Services/DragService.java): Applies drag force to particles.
- [GravityService](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Services/GravityService.java): Applies gravity force to particles.
- [ParticlesService](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Services/ParticlesService.java): Manages particle creation and spawning.
- [SeparatorService](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Services/SeparatorService.java): Ensures particles are not overlapping.

### Structures

- [Particle](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Structures/Particle.java): Represents a particle in the simulation.
- [Vector2](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Structures/Vector2.java): Represents a 2D vector with various vector operations.
- [Grid](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Structures/Grid.java): A spatial grid for efficient neighbor searching.

### Tools

- [ParticleDrawer](https://github.com/cruzfelipee/ParticleSimulator/blob/main/Tools/ParticleDrawer.java): A JPanel for drawing particles.

## Acknowledgements

- Inspired by @johnBuffer [Physics Engine](https://github.com/johnBuffer/VerletSFML) and @keyframe41 [Particle Simulation](https://github.com/keyframe41/ParticleSimulation)
