# Program to create a new list with odd numbers from first list and even numbers from second list

# Get the first list from user
n1 = int(input("How many numbers for the first list? "))
list1 = []

print(f"\nEnter {n1} numbers for the first list:")
for i in range(n1):
    num = int(input(f"Enter number {i + 1}: "))
    list1.append(num)

# Get the second list from user
n2 = int(input(f"\nHow many numbers for the second list? "))
list2 = []

print(f"\nEnter {n2} numbers for the second list:")
for i in range(n2):
    num = int(input(f"Enter number {i + 1}: "))
    list2.append(num)

# Create new list with odd numbers from list1
odd_from_list1 = []
for num in list1:
    if num % 2 != 0:  # Check if odd
        odd_from_list1.append(num)

# Create list with even numbers from list2
even_from_list2 = []
for num in list2:
    if num % 2 == 0:  # Check if even
        even_from_list2.append(num)

# Combine both lists
new_list = odd_from_list1 + even_from_list2

# Display results
print("\n" + "=" * 50)
print(f"First list: {list1}")
print(f"Second list: {list2}")
print("\n" + "-" * 50)
print(f"Odd numbers from first list: {odd_from_list1}")
print(f"Even numbers from second list: {even_from_list2}")
print("\n" + "-" * 50)
print(f"New combined list: {new_list}")
print("=" * 50)
