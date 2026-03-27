<p align="center">
  <img src="src/bitcon/White_Logo.png" alt="Bitcon Logo"/>
</p>

# ISW BitCon

A Bingo-style desktop game built in Java.
<strong>Programming I Final Project</strong> - Universidad Técnica Nacional (UTN)

<p align="center">
  <img src="https://img.shields.io/badge/Java-SE%208+-orange?logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/UI-Java%20Swing-yellow" alt="Java Swing"/>
  <img src="https://img.shields.io/badge/IDE-NetBeans-green?logo=apachenetbeans&logoColor=white" alt="Apache NetBeans"/>
  <img src="https://img.shields.io/badge/Build-Apache%20Ant-A81C7D?logo=apacheant&logoColor=white" alt="Apache Ant"/>
</p>

BitCon generates 101 unique game boards and lets players draw numbered tiles, either randomly or manually, to mark matches across all boards simultaneously. The game supports multiple **number base systems** and **win conditions**, making it both a fun game and an educational tool for practicing numeral system conversions.

## Features

- **Multiple number bases:** Quinary (base 5), Octal (base 8), Decimal (base 10), Duodecimal (base 12), and Hexadecimal (base 16)
- **Configurable win conditions:** Horizontal line, Vertical line, or Diagonal line
- **Tile generation modes:** Automatic (random) or Manual input
- **101 concurrent boards** (codes 1000–1100), each with a 6×6 grid of randomly generated tiles
- **Real-time board inspection:** View any board by its code and see marked tiles highlighted
- **Winner detection:** Automatically identifies and announces winning boards

## Project Structure

```
src/bitcon/
├── Ficha.java                    # Tile model: stores a number and its marked state
├── Tablero.java                  # Board logic: 6×6 grid, number base conversion, win validation
├── Juego.java                    # Game controller: manages 101 boards, draws tiles, checks winners
├── Frm_ConfiguracionJuego.java   # Configuration GUI: select base, board type, and generation mode
├── Frm_ISWBITCON.java            # Main game GUI: board display, tile input, winner announcements
├── logo.png                      # Application logo
└── White_Logo.png                # Alternative logo (used in config screen)
```

## How It Works

1. **Configure**: Choose the number base, win condition, and tile generation mode
2. **Generate**: The system creates 101 boards with random tiles converted to the selected base
3. **Play**: Draw tiles (random or manual) that get marked across all boards
4. **Win**: The first board to complete a full line (horizontal, vertical, or diagonal) wins

## Getting Started

### Prerequisites

- Java JDK 8 or higher

### Run

1. Open the project in Apache NetBeans
2. Build and run `Frm_ConfiguracionJuego` as the main class
3. Configure the game settings and click Iniciar Juego

## Author

Andrés Bolaños Víquez - Student ID: 1-1909-0051  
Universidad Técnica Nacional (UTN)
