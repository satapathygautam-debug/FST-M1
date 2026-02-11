# Get the number of elements from the user
n = int(input("How many numbers do you want to enter? "))

# Create an empty list
numbers = []

# Get each number from the user
print(f"\nPlease enter {n} numbers:")
for i in range(n):
    num = int(input(f"Enter number {i + 1}: "))
    numbers.append(num)

# Check if first and last elements are the same
if numbers[0] == numbers[-1]:
    result = True
    message = "The first and last numbers are the SAME!"
else:
    result = False
    message = "The first and last numbers are DIFFERENT."

# Display the results
print("\n" + "=" * 40)
print(f"Your list: {numbers}")
print(f"First number: {numbers[0]}")
print(f"Last number: {numbers[-1]}")
print(message)
print(f"Result: {result}")
print("=" * 40)
