# 🧮 CalcPlus

A modern calculator application built using **Kotlin** and **Jetpack Compose** for Android. The app provides a clean and responsive interface with support for basic arithmetic operations, operator precedence, percentages, and sign toggling.

## 📱 Overview

This project is a custom-built Android calculator designed to provide a simple and intuitive calculation experience while demonstrating core concepts of **Jetpack Compose**, **Kotlin state management**, and expression evaluation.

The calculator follows standard mathematical operator precedence, allowing expressions containing multiple operators to be evaluated correctly.

## ✨ Features

* ➕ Addition
* ➖ Subtraction
* ✖️ Multiplication
* ➗ Division
* `%` Percentage calculations
* `+/-` Sign toggle
* `AC` Clear calculator
* `=` Calculate result
* Standard mathematical operator precedence
* Supports expressions containing multiple operators
* Displays the entered operands and operators
* Responsive Jetpack Compose UI
* Android-native implementation using Kotlin

## 🧠 Operator Precedence

The calculator follows the standard **BODMAS/PEMDAS-style precedence rules**.

For example:

```text
10 + 5 × 2
```

The multiplication is evaluated first:

```text
10 + (5 × 2) = 20
```

Instead of:

```text
(10 + 5) × 2 = 30
```

This allows the calculator to behave more like a standard mathematical calculator.

## 📊 Percentage Support

The calculator also supports percentage calculations.

For example:

```text
12 - 5%
```

The percentage is interpreted relative to the preceding value:

```text
5% of 12 = 0.6

12 - 0.6 = 11.4
```

## 🛠️ Technologies Used

| Technology      | Purpose                          |
| --------------- | -------------------------------- |
| Kotlin          | Application programming language |
| Jetpack Compose | UI development                   |
| Android Studio  | Development environment          |
| Material Design | UI components and styling        |
| Gradle          | Build system                     |

## 📂 Project Structure

The main calculator logic and UI are implemented using Jetpack Compose.

A simplified structure looks like:

```text
Calculator/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── .../
│           │       └── MainActivity.kt
│           │
│           └── res/
│
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone <your-repository-url>
```

### 2. Open the project

Open the project in **Android Studio**.

### 3. Sync Gradle

Allow Android Studio to download and configure the required dependencies.

### 4. Run the application

Connect an Android device or start an Android Emulator and click:

```text
Run ▶
```

## 📱 Testing

The application can be tested using either:

* Android Emulator
* Physical Android device
* Wireless debugging

Example calculations:

```text
2 + 3
```

```text
10 - 4
```

```text
5 × 6
```

```text
20 ÷ 4
```

```text
10 + 5 × 2
```

```text
12 - 5%
```

## 🎯 Learning Objectives

This project helped demonstrate practical usage of:

* Kotlin programming
* Jetpack Compose
* Composable functions
* State management
* Event handling
* Custom calculator logic
* Operator precedence
* Expression evaluation
* Android UI development

## 🔮 Future Improvements

Possible improvements include:

* Scientific calculator functions
* Calculation history
* Dark/light theme customization
* Landscape mode
* Improved expression parser
* Parentheses support
* Memory functions such as `M+`, `M-`, and `MR`
* Improved decimal and floating-point handling
* Animations and UI enhancements




Made with ❤️ by Rohit .
