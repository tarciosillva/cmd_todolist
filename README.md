# Todo List Application

A simple command-line Todo List application built in Java. This project allows users to create, read, update, and delete tasks through a command-line interface.

## Features

- **Create** tasks: Add a new task to your todo list.
- **List** tasks: View all tasks in the list.
- **Update** tasks: Modify an existing task by its name and ID.
- **Delete** tasks: Remove a task by its ID.
- **Help**: Display a list of available commands.

## Prerequisites

- Java 8 or higher

## Installation

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/tarciosillva/todolist.git
    ```
2. Navigate to the project directory:
   ```bash
   cd todolist
   ```
3. Compile the Java program:
   ```bash
   javac Main.java
   ```
4. Run the application:
   ```bash
   java Main
   ```
   
## Usage
Once the application is running, you can use the following commands:

- **list**: Display all tasks.
- **create [task name]**: Add a new task to the list.
- **update --name [task name] --id [task id]**: Update a task's name by its ID.
- **delete --id [task id]**: Delete a task by its ID.
- **help**: Display the available commands.
- **exit**: Exit the application.

## How it works
- The app uses a simple array (tasks) to store tasks.
- Commands are parsed using regular expressions.
- Tasks are stored and manipulated via basic array operations, like copying and modifying.


