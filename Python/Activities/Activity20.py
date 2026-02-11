import pandas as pd

print("=" * 80)
print("PANDAS EXCEL READER - CONTACT INFORMATION ANALYSIS")
print("=" * 80)

# Read the Excel file
excel_filename = '/mnt/user-data/outputs/contact_information.xlsx'
df = pd.read_excel(excel_filename, sheet_name='Contacts')

# Display the complete DataFrame first
print("\n📊 Complete DataFrame:")
print("=" * 80)
print(df)
print("=" * 80)

# ============================================================================
# TASK 1: Print the number of rows and columns
# ============================================================================
print("\n" + "=" * 80)
print("TASK 1: Print the number of rows and columns")
print("=" * 80)

num_rows = df.shape[0]
num_columns = df.shape[1]

print(f"Number of Rows: {num_rows}")
print(f"Number of Columns: {num_columns}")
print(f"Shape: {df.shape} (rows, columns)")

# Additional information
print("\nColumn Names:")
for i, col in enumerate(df.columns, 1):
    print(f"  {i}. {col}")

# ============================================================================
# TASK 2: Print the data in the emails column only
# ============================================================================
print("\n" + "=" * 80)
print("TASK 2: Print the data in the Email column only")
print("=" * 80)

print("\nMethod 1: As Pandas Series")
print("-" * 80)
print(df['Email'])

print("\nMethod 2: Just the values (as list)")
print("-" * 80)
email_list = df['Email'].tolist()
print(email_list)

print("\nMethod 3: Formatted output")
print("-" * 80)
for i, email in enumerate(df['Email'], 1):
    print(f"{i}. {email}")

# ============================================================================
# TASK 3: Sort the data based on FirstName in ascending order
# ============================================================================
print("\n" + "=" * 80)
print("TASK 3: Sort data based on FirstName (Ascending Order A→Z)")
print("=" * 80)

sorted_df = df.sort_values("FirstName")
print(sorted_df)

print("\n📊 Explanation:")
print("-" * 80)
original_order = df['FirstName'].tolist()
sorted_order = sorted_df['FirstName'].tolist()
print(f"Original order: {', '.join(original_order)}")
print(f"Sorted order:   {', '.join(sorted_order)}")

# ============================================================================
# SUMMARY
# ============================================================================
print("\n" + "=" * 80)
print("SUMMARY OF ALL TASKS")
print("=" * 80)
print(f"✓ Task 1: Rows = {num_rows}, Columns = {num_columns}")
print(f"✓ Task 2: Printed {len(df['Email'])} email addresses")
print(f"✓ Task 3: Sorted data by FirstName alphabetically")
print("=" * 80)

print("\n✅ ALL TASKS COMPLETED SUCCESSFULLY!")
print("=" * 80)
