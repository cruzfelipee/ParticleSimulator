# Particle Simulator

A particle simulation project that demonstrates particle physics, including gravity, collisions, and boundary interactions. The simulation uses multi-threading to update particle velocities and positions efficiently.

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
    git clone https://github.com/cruzfelipee/particle-simulator.git
    cd particle-simulator
    ```

2. Open the project in your preferred IDE.

3. Build the project to resolve dependencies.

### Running the Simulation

1. Navigate to the [Main](http://_vscodecontentref_/0) class in [App.java](http://_vscodecontentref_/1).

2. Run the [main](http://_vscodecontentref_/2) method to start the simulation.

### Configuration

You can configure the simulation parameters in the [App.java](http://_vscodecontentref_/3) file:

- [NUMBER_OF_PARTICLES](http://_vscodecontentref_/4): Number of particles in the simulation.
- [MIN_RADIUS](http://_vscodecontentref_/5): Minimum radius of the particles.
- [MAX_RADIUS](http://_vscodecontentref_/6): Maximum radius of the particles.
- [MS_DELAY](http://_vscodecontentref_/7): Delay between the spawn of each particle.

## Project Structure

- [Main](http://_vscodecontentref_/8): Contains the main application entry point.
- [Services](http://_vscodecontentref_/9): Contains services for handling various aspects of the simulation (e.g., gravity, collisions, boundaries).
- [Structures](http://_vscodecontentref_/10): Contains data structures used in the simulation (e.g., Particle, Vector2, Grid).
- [Tools](http://_vscodecontentref_/11): Contains utility classes (e.g., ParticleDrawer, ParticleHeightComparator).

## Classes Overview

### Main

- [App](http://_vscodecontentref_/12): The entry point of the application. Initializes and runs the simulation.
- [Simulator](http://_vscodecontentref_/13): Manages the simulation, including updating particle positions and velocities.

### Services

- [BoundariesService](http://_vscodecontentref_/14): Handles boundary interactions for particles.
- [CollisionService](http://_vscodecontentref_/15): Handles collision detection and resolution between particles.
- [DragService](http://_vscodecontentref_/16): Applies drag force to particles.
- [GravityService](http://_vscodecontentref_/17): Applies gravity force to particles.
- [ParticlesService](http://_vscodecontentref_/18): Manages particle creation and spawning.
- [SeparatorService](http://_vscodecontentref_/19): Ensures particles are not overlapping.

### Structures

- [Particle](http://_vscodecontentref_/20): Represents a particle in the simulation.
- [Vector2](http://_vscodecontentref_/21): Represents a 2D vector with various vector operations.
- [Grid](http://_vscodecontentref_/22): A spatial grid for efficient neighbor searching.

### Tools

- [ParticleDrawer](http://_vscodecontentref_/23): A JPanel for drawing particles.

## Acknowledgements

- Inspired by @johnBuffer [Physics Engine](https://github.com/johnBuffer/VerletSFML) and @keyframe41 [Particle Simulation](https://github.com/keyframe41/ParticleSimulation)
