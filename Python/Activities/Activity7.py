# Get the number of elements from the user
n = int(input("How many numbers do you want to enter? "))

# Create an empty list
numbers = []

# Get each number from the user
print(f"\nPlease enter {n} numbers:")
for i in range(n):
    num = int(input(f"Enter number {i + 1}: "))
    numbers.append(num)

# Calculate the sum of all elements
total = 0
for num in numbers:
    total += num

# Display the results
print("\n" + "=" * 40)
print(f"Your list: {numbers}")
print(f"Sum of all elements: {total}")
print("=" * 40)
