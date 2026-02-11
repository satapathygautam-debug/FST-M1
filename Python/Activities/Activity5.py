# Get the number from the user
number = int(input("Enter a number to generate its multiplication table: "))

print(f"\nMultiplication Table for {number}")
print("=" * 30)

# Generate multiplication table from 1 to 10
for i in range(1, 11):
    result = number * i
    print(f"{number} x {i} = {result}")

print("=" * 30)
