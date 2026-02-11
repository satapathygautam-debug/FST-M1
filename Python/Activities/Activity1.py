from datetime import datetime

# Get user input
name = input("Enter your name: ")
age = int(input("Enter your age: "))

# Get current year
current_year = datetime.now().year

# Calculate year when user turns 100
years_until_100 = 100 - age
year_turn_100 = current_year + years_until_100

# Print personalized message
print(f"\nHello {name}! You will turn 100 years old in the year {year_turn_100}.")
