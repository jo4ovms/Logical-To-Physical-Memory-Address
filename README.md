
# Virtual Memory Address Converter

This Java project is a simple console application that converts **logical addresses** to **physical addresses** in a virtual memory system using page-based memory management. The application simulates the process of address translation, where logical addresses are mapped to physical frames based on a predefined page table.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
  - [Input](#input)
  - [Output](#output)
- [How It Works](#how-it-works)
  - [Logical to Physical Address Conversion](#logical-to-physical-address-conversion)
- [Example](#example)
- [Contributing](#contributing)
- [License](#license)

## Features
- Converts logical addresses to physical addresses using page-based memory management.
- Simulates the page table with mapping between pages and frames.
- Supports input of multiple logical addresses at once.
- Detects unmapped pages and generates a memory interrupt.
- Easy to configure with customizable page size and page-to-frame mappings.

## Requirements
- Java Development Kit (JDK) 8 or higher
- Any IDE (like IntelliJ IDEA, Eclipse) or terminal with `javac` and `java` commands

## Setup and Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/jo4ovms/Logical-To-Physical-Memory-Address.git
   ```
2. **Navigate to the project directory:**
   ```bash
   cd .\Logical-To-Physical-Memory-Address\
   cd .\src\
   ```
3. **Compile the Java file:**
   ```bash
   javac Main.java
   ```
4. **Run the application:**
   ```bash
   java Main
   ```

## Usage

### Input
The program requires the following inputs:
1. **Page Size (in bytes):** The size of each page in the memory.
2. **Number of Pages:** The total number of pages to simulate.
3. **Page Table Mapping:** For each page, enter the frame it maps to, or enter `-1` if the page is not mapped.
4. **Logical Addresses:** Enter logical addresses separated by commas.

### Output
- The program outputs the corresponding **physical address** for each logical address, including the page and frame it maps to.
- If a logical address maps to an unmapped page, it generates a **memory interrupt**.

## How It Works

### Logical to Physical Address Conversion
The conversion process follows these steps:
1. **Determine the logical page** by dividing the logical address by the page size.
2. **Calculate the offset** within the page using the modulus operation.
3. **Translate the logical page** to a physical frame using the page table.
4. If the page is mapped to a frame, compute the **physical address** using the formula:
   ```
   Physical Address = (Frame Number * Page Size) + Offset
   ```
5. If the page is not mapped, a **memory interrupt** is generated.

## Example

Here is an example of how to use the program:

### Input
```
Enter the page size (in bytes): 500
Enter the number of pages: 1
Enter the corresponding frame for each page (-1 if it doesn't exist):
Page 0: 12
Enter the logical addresses to convert, separated by commas: 414, 741, 1995, 4000, 6633
```

### Output
```
Logical Address: 414 -> Page 0, Frame 12, Physical Address: 6414
Logical Address: 741 -> Page 1 not mapped (Generates an Interruption).
Logical Address: 1995 -> Page 3 not mapped (Generates an Interruption).
Logical Address: 4000 -> Page 8 not mapped (Generates an Interruption).
Logical Address: 6633 -> Page 13 not mapped (Generates an Interruption).
```
