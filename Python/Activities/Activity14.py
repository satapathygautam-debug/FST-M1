# Fibonacci sequence generator using recursion

def fibonacci(n):
    """
    Calculates the nth Fibonacci number using recursion.
    
    Args:
        n: The position in the Fibonacci sequence (0-indexed)
        
    Returns:
        The nth Fibonacci number
    """
    # Base cases
    if n == 0:
        return 0
    elif n == 1:
        return 1
    # Recursive case
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)


# Main program
print("=" * 60)
print("FIBONACCI SEQUENCE GENERATOR (Using Recursion)")
print("=" * 60)

# Get user input
try:
    count = int(input("\nHow many Fibonacci numbers do you want to generate? "))
    
    if count <= 0:
        print("Please enter a positive number!")
    else:
        print("\n" + "=" * 60)
        print(f"Generating {count} Fibonacci numbers:")
        print("=" * 60)
        
        # Generate and display Fibonacci numbers
        fibonacci_sequence = []
        
        for i in range(count):
            fib_num = fibonacci(i)
            fibonacci_sequence.append(fib_num)
            print(f"Position {i}: {fib_num}")
        
        # Display the complete sequence
        print("\n" + "=" * 60)
        print("Complete Fibonacci Sequence:")
        print("-" * 60)
        print(", ".join(map(str, fibonacci_sequence)))
        print("=" * 60)

except ValueError:
    print("Invalid input! Please enter a valid number.")
