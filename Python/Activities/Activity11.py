# Program to check fruit availability in a dictionary

# Create a dictionary of fruits and their prices
fruits = {
    "apple": 2.50,
    "banana": 1.20,
    "orange": 3.00,
    "mango": 4.50,
    "grapes": 5.00,
    "strawberry": 6.00,
    "watermelon": 8.00,
    "pineapple": 7.50,
    "kiwi": 3.50,
    "papaya": 4.00
}

# Display available fruits
print("=" * 50)
print("FRUIT STORE - Available Fruits")
print("=" * 50)
for fruit, price in fruits.items():
    print(f"{fruit.capitalize():<15} - ${price:.2f}")
print("=" * 50)

# Get the fruit name from user
search_fruit = input("\nEnter the fruit name to check availability: ").lower()

# Check if the fruit is available
print("\n" + "-" * 50)
if search_fruit in fruits:
    print(f"✓ YES! {search_fruit.capitalize()} is available.")
    print(f"  Price: ${fruits[search_fruit]:.2f}")
else:
    print(f"✗ Sorry, {search_fruit.capitalize()} is NOT available.")
    print("  Please check our available fruits list above.")
print("-" * 50)
