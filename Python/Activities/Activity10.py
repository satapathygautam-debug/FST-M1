# Program to print numbers divisible by 5 from a tuple

# Get the number of elements from the user
n = int(input("How many numbers do you want to enter? "))

# Create an empty list to collect numbers
numbers_list = []

# Get each number from the user
print(f"\nPlease enter {n} numbers:")
for i in range(n):
    num = int(input(f"Enter number {i + 1}: "))
    numbers_list.append(num)

# Convert list to tuple
numbers_tuple = tuple(numbers_list)

# Display the tuple
print("\n" + "=" * 50)
print(f"Your tuple: {numbers_tuple}")
print("=" * 50)

# Find and print numbers divisible by 5
print("\nNumbers divisible by 5:")
print("-" * 50)

divisible_by_5 = []
for num in numbers_tuple:
    if num % 5 == 0:
        print(num)
        divisible_by_5.append(num)

# Summary
print("-" * 50)
if divisible_by_5:
    print(f"\nFound {len(divisible_by_5)} number(s) divisible by 5: {divisible_by_5}")
else:
    print("\nNo numbers divisible by 5 found in the tuple.")
print("=" * 50)
