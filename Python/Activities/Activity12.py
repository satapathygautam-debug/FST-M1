# Recursive function to calculate sum of numbers from 0 to n

def recursive_sum(n):
    """
    Calculates the sum of numbers from 0 to n using recursion.
    
    Base case: if n is 0, return 0
    Recursive case: return n + sum of (n-1)
    """
    # Base case
    if n == 0:
        return 0
    # Recursive case
    else:
        return n + recursive_sum(n - 1)


# Main program
print("Recursive Sum Calculator")
print("=" * 50)

# Calculate sum from 0 to 10
result = recursive_sum(10)

print(f"\nSum of numbers from 0 to 10: {result}")

# Show the calculation breakdown
print("\nHow it works:")
print("-" * 50)
print("10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + 0")
print(f"= {result}")
print("=" * 50)

# Verify with mathematical formula: n * (n + 1) / 2
formula_result = 10 * (10 + 1) // 2
print(f"\nVerification using formula n(n+1)/2: {formula_result}")
print(f"Results match: {result == formula_result} ✓")
