import pandas as pd

print("=" * 70)
print("PANDAS CSV READER - DATA ANALYSIS")
print("=" * 70)

# Read the CSV file created in the previous program
csv_filename = '/mnt/user-data/outputs/usernames_passwords.csv'
df = pd.read_csv(csv_filename)

# Display the complete DataFrame
print("\n📊 Complete DataFrame:")
print("=" * 70)
print(df)
print("=" * 70)

# Task 1: Print the values only in the Usernames column
print("\n" + "=" * 70)
print("TASK 1: Print values only in the Usernames column")
print("=" * 70)
print(df['Usernames'])
print("\nAlternative - as list:")
print(df['Usernames'].tolist())

# Task 2: Print the username and password of the second row
print("\n" + "=" * 70)
print("TASK 2: Print username and password of the second row")
print("=" * 70)
# Note: Second row has index 1 (0-indexed)
second_row = df.iloc[1]
print(f"Username: {second_row['Usernames']}")
print(f"Password: {second_row['Passwords']}")

# Alternative way to display
print("\nComplete second row:")
print(second_row)

# Task 3: Sort the Usernames column in ascending order and print data
print("\n" + "=" * 70)
print("TASK 3: Sort by Usernames (Ascending Order)")
print("=" * 70)
sorted_by_username_asc = df.sort_values("Usernames")
print(sorted_by_username_asc)

# Task 4: Sort the Passwords column in descending order and print data
print("\n" + "=" * 70)
print("TASK 4: Sort by Passwords (Descending Order)")
print("=" * 70)
sorted_by_password_desc = df.sort_values("Passwords", ascending=False)
print(sorted_by_password_desc)

# Summary
print("\n" + "=" * 70)
print("SUMMARY OF OPERATIONS:")
print("=" * 70)
print("✓ Task 1: Printed Usernames column")
print("✓ Task 2: Printed second row (Charles, Charl13)")
print("✓ Task 3: Sorted by Usernames (ascending)")
print("✓ Task 4: Sorted by Passwords (descending)")
print("=" * 70)
