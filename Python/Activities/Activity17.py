import pandas as pd

# Create the data from the image
data = {
    'Usernames': ['admin', 'Charles', 'Deku'],
    'Passwords': ['password', 'Charl13', 'AllMight']
}

# Create a DataFrame
df = pd.DataFrame(data)

# Display the DataFrame
print("=" * 50)
print("DATA TO BE WRITTEN TO CSV")
print("=" * 50)
print(df)
print("=" * 50)

# Write to CSV file
csv_filename = '/mnt/user-data/outputs/usernames_passwords.csv'
df.to_csv(csv_filename, index=False)

print(f"\n✓ Data successfully written to: {csv_filename}")
print("\nCSV file contents:")
print("-" * 50)

# Read and display the CSV file to verify
with open(csv_filename, 'r') as f:
    print(f.read())

print("=" * 50)
print("CSV FILE CREATED SUCCESSFULLY!")
print("=" * 50)
