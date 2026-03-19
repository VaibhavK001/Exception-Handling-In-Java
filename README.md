# Java Exception Handling

---

## 1) What is an Exception?

An **exception** is an unwanted event that occurs during program execution and disrupts the normal flow of a program.

### Why exceptions happen

* Invalid input
* Division by zero
* File not found
* Array index out of bounds
* Null object access

### Example

```java
int a = 10;
int b = 0;
System.out.println(a / b);   // ArithmeticException
```

---

## 2) Why Exception Handling is Needed

Without handling exceptions, the program may terminate abruptly.

Exception handling helps to:

* prevent program crash
* maintain normal flow
* provide meaningful error messages
* separate error-handling logic from normal logic

---

## 3) Exception Hierarchy

In Java, all exceptions come under the `Throwable` class.

```
Object
  └── Throwable
        ├── Error
        └── Exception
              ├── Checked Exceptions
              └── RuntimeException
                    └── Unchecked Exceptions
```

### Important note

* `Error` usually represents serious system-level problems.
* `Exception` represents conditions that programs may handle.

---

## 4) try Block

The `try` block contains code that may cause an exception.

### Syntax

```java
try {
    // risky code
}
```

### Example

```java
try {
    int result = 10 / 0;
    System.out.println(result);
}
```

If an exception occurs inside `try`, the rest of that `try` block is skipped.

---

## 5) catch Block

The `catch` block handles the exception thrown from the `try` block.

### Syntax

```java
try {
    // risky code
} catch (ExceptionType e) {
    // handling code
}
```

### Example

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

### Key point

A `catch` block must match the exception type or a parent type.

---

## 6) finally Block

The `finally` block executes whether an exception occurs or not.

It is usually used for cleanup tasks like:

* closing files
* releasing resources
* ending database connections

### Syntax

```java
try {
    // risky code
} catch (Exception e) {
    // handling
} finally {
    // cleanup
}
```

### Example

```java
try {
    int result = 10 / 2;
    System.out.println(result);
} catch (ArithmeticException e) {
    System.out.println("Exception occurred");
} finally {
    System.out.println("This always runs");
}
```

### Output

```
5
This always runs
```

---

## 7) try-catch-finally Flow

### Case 1: No exception

* `try` runs
* `catch` is skipped
* `finally` runs

### Case 2: Exception occurs and is handled

* `try` runs until exception
* matching `catch` runs
* `finally` runs

### Case 3: Exception occurs and is not handled

* program may terminate
* `finally` still runs before termination

---

## 8) throw Keyword

`throw` is used to explicitly create and throw an exception.

### Syntax

```java
throw new ExceptionType("message");
```

### Example

```java
int age = 15;
if (age < 18) {
    throw new ArithmeticException("Not eligible to vote");
}
```

### Important

* `throw` is used with a single exception object.
* It is used inside the method body.

---

## 9) throws Keyword

`throws` is used in a method declaration to indicate that the method may throw an exception.

### Syntax

```java
returnType methodName() throws ExceptionType {
    // code
}
```

### Example

```java
import java.io.FileReader;

class Demo {
    void readFile() throws Exception {
        FileReader fr = new FileReader("abc.txt");
    }
}
```

### Important

* `throws` is used in the method signature.
* It declares exception responsibility to the caller.

---

## 10) Difference Between throw and throws

| `throw`                               | `throws`                         |
| ------------------------------------- | -------------------------------- |
| Used to explicitly throw an exception | Used to declare an exception     |
| Used inside method body               | Used in method signature         |
| Followed by an exception object       | Followed by exception class name |
| Throws one exception at a time        | Can declare multiple exceptions  |

### Example

```java
void checkMarks(int marks) throws Exception {
    if (marks < 40) {
        throw new Exception("Fail");
    }
}
```

---

## 11) Checked Exceptions

Checked exceptions are checked by the compiler at compile time.

If a checked exception can occur, Java forces you to either:

* handle it using `try-catch`
* declare it using `throws`

### Examples

* `IOException`
* `FileNotFoundException`
* `SQLException`
* `ClassNotFoundException`

### Example

```java
import java.io.FileReader;

class Demo {
    void read() {
        try {
            FileReader fr = new FileReader("abc.txt");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```

### Memory trick

**Checked = checked by compiler**

---

## 12) Unchecked Exceptions

Unchecked exceptions are not checked at compile time.

They usually occur because of programming mistakes.

### Examples

* `ArithmeticException`
* `NullPointerException`
* `ArrayIndexOutOfBoundsException`
* `NumberFormatException`

### Example

```java
int a = 10;
int b = 0;
System.out.println(a / b);   // RuntimeException
```

### Memory trick

**Unchecked = compiler does not force handling**

---

## 13) Checked vs Unchecked Exceptions

| Checked Exception                                 | Unchecked Exception            |
| ------------------------------------------------- | ------------------------------ |
| Checked at compile time                           | Checked at runtime             |
| Must be handled or declared                       | Optional to handle             |
| Subclass of `Exception` except `RuntimeException` | Subclass of `RuntimeException` |
| Usually external problems                         | Usually programming bugs       |

---

## 14) Multiple catch Blocks

You can use multiple `catch` blocks to handle different exception types.

### Example

```java
try {
    int[] arr = {1, 2, 3};
    System.out.println(arr[5]);
} catch (ArithmeticException e) {
    System.out.println("Arithmetic error");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index error");
} catch (Exception e) {
    System.out.println("General exception");
}
```

### Rule

Write more specific exceptions first, then general exceptions.

---

## 15) Custom Exceptions

A **custom exception** is a user-defined exception created for your own business logic.

### Why use custom exceptions?

* better readability
* clearer business rules
* meaningful error messages

### Example: Creating a custom exception

```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
```

### Using the custom exception

```java
class Demo {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be at least 18");
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

### Output

```java
Age must be at least 18
```

---

## 16) Common Interview Points

### 1. Can we have `try` without `catch`?

Yes, but only with `finally`.

### 2. Can we have `catch` without `try`?

No.

### 3. Can we have `try` without `finally`?

Yes, if `catch` is present.

### 4. Can `finally` run without `catch`?

Yes, if `try` exists.

### 5. Can `finally` always execute?

Usually yes, but not in cases like:

* `System.exit(0)`
* JVM crash
* power failure

---

## 17) Small Practice Snippets

### Division by zero

```java
try {
    System.out.println(10 / 0);
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

### Array access

```java
try {
    int[] arr = {10, 20, 30};
    System.out.println(arr[4]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Invalid index");
}
```

### Null object access

```java
try {
    String s = null;
    System.out.println(s.length());
} catch (NullPointerException e) {
    System.out.println("Object is null");
}
```

### Number format problem

```java
try {
    int n = Integer.parseInt("abc");
} catch (NumberFormatException e) {
    System.out.println("Invalid number format");
}
```

---

## 18) One-Line Revision Summary

* `try` = risky code
* `catch` = handle exception
* `finally` = cleanup block
* `throw` = manually throw exception
* `throws` = declare exception possibility
* checked exceptions = compiler forces handling
* unchecked exceptions = runtime, usually programming mistakes
* custom exception = user-defined exception for business rules

---

## 19) Interview Ready Definition

**Exception handling in Java is a mechanism used to handle runtime errors gracefully so that the program does not terminate abruptly and the normal flow of execution can continue.**

---

## 20) Conclusion

Mastering exception handling is important for writing safe, readable, and robust Java code. For interviews, focus on the purpose of each keyword, the exception hierarchy, and the difference between checked and unchecked exceptions.

---

## 21) Notes

You can extend this README with:

* your own practice codes
* exception handling exercises
* interview questions
* real-world file handling examples
* Selenium-related exception scenarios
