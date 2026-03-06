
```markdown
# 🧮 Custom Sine Calculator (Maclaurin Series)

> A custom, from-scratch implementation of the sine trigonometric function in Java. Built to explore the limits of floating-point arithmetic, data type overflows, and algorithm optimization without relying on built-in native libraries like `Math.sin()`.

## 🚀 Features

* **Pure Math Implementation**: Calculates `sin(x)` using the classic **Maclaurin (Taylor) series** formula.
* **Smart Argument Reduction**: Automatically reduces extremely large inputs using `x % (2 * PI)`. This prevents catastrophic cancellation and allows the program to calculate the sine of astronomically large numbers instantly.
* **Safe Factorial Calculation**: Iteratively calculates factorials using `double` and safely stops if the value exceeds the maximum limit (`Infinity` at `171!`), preventing CPU freezing.
* **Dynamic Termination**: The loop doesn't have a hardcoded end limit. It intelligently stops calculating as soon as the added term becomes `0.0` due to floating-point precision limits.

---

## 🧠 Under the Hood: Math & Engineering Challenges

At the hardware level, CPUs only understand basic arithmetic (addition, subtraction, multiplication, and division). To make a computer calculate a sine wave, we must convert geometry into arithmetic using the **Maclaurin Series**:

$$\sin(x) = x - \frac{x^3}{3!} + \frac{x^5}{5!} - \frac{x^7}{7!} + \dots$$

While this formula is mathematically perfect on paper, implementing it in code introduces several classic Computer Science challenges. This project actively handles three major ones:

### 1. Integer Overflow (The Factorial Problem)
Factorials grow at an explosive rate. A standard 64-bit `long` in Java overflows at just `21!`, outputting garbage data. 
* **Solution:** The algorithm calculates factorials using the `double` data type (which is designed for massive floating-point numbers). This safely pushes the limit up to `170!`. If the factorial exceeds the `double` limit and becomes `Infinity`, the program handles it gracefully without crashing.

### 2. Infinite Loops & Floating-Point Limits
The Maclaurin series is infinite, meaning a naive `while(true)` loop would freeze the application. 
* **Solution:** The program dynamically terminates based on the physical limits of the `double` type (which holds about 15-17 decimal places of precision). At around the 85th iteration, the added fraction becomes so microscopically small that the computer evaluates it as `0.0`. The code catches this exact moment (`if (a == 0.0) break;`) and stops. This guarantees maximum possible precision while running in milliseconds.

### 3. Catastrophic Cancellation (Handling Massive Inputs)
If a user inputs a massive number (e.g., `x = 346,574,653,423`), calculating $x^3$ or $x^5$ instantly overflows the computer's memory, resulting in `NaN` (Not a Number) and destroying the calculation. 
* **Solution:** Implemented **Argument Reduction**. Because the sine function is perfectly periodic, repeating every $2\pi$, the input is pre-processed using a modulo operation: `x = x % (2.0 * Math.PI)`. This elegantly reduces any astronomically large input into a safe `[-6.28, 6.28]` range. 

---

## 🛠️ How to Run

1. Clone the repository to your local machine.
2. Compile the Java file:
   ```bash
   javac Main.java

```

3. Run the program:
```bash
java Main

```


4. Enter any number (in radians) when prompted in the console.

---

## 📋 Example Output

```text
Provide sin x: 
5
85 last n that could be calculated
Result: -0.9589242746631358

```

*(The program successfully halted at iteration 85 when the factorial term reached Infinity, preventing a crash and returning the precise result).*

---

## 💻 Technologies Used

* **Java** (Core logic, variables precision control)
* **Core Math Algorithms** (Taylor/Maclaurin Series, Periodic reduction)

```
