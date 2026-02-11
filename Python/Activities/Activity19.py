import pandas as pd

print("=" * 70)
print("PANDAS EXCEL WRITER - CONTACT INFORMATION")
print("=" * 70)

# Create the data from the image
data = {
    'FirstName': ['Satvik', 'Avinash', 'Lahri'],
    'LastName': ['Shah', 'Kati', 'Rath'],
    'Email': ['satshah@example.com', 'avinashk@example.com', 'lahri.rath@example.com'],
    'PhoneNumber': ['4537829158', '5892184058', '4528727830']
}

# Create a DataFrame
df = pd.DataFrame(data)

# Display the DataFrame
print("\n📊 Data to be written to Excel:")
print("=" * 70)
print(df.to_string(index=False))
print("=" * 70)

# Display DataFrame information
print("\n📈 DataFrame Information:")
print("-" * 70)
print(f"Shape: {df.shape[0]} rows × {df.shape[1]} columns")
print(f"Columns: {list(df.columns)}")
print("-" * 70)

# Write to Excel file
excel_filename = '/mnt/user-data/outputs/contact_information.xlsx'
df.to_excel(excel_filename, index=False, sheet_name='Contacts')

print(f"\n✓ Data successfully written to Excel file!")
print(f"  File: contact_information.xlsx")
print(f"  Location: /mnt/user-data/outputs/")
print(f"  Sheet Name: Contacts")

# Verify by reading the Excel file back
print("\n" + "=" * 70)
print("VERIFICATION - Reading Excel file back:")
print("=" * 70)

df_read = pd.read_excel(excel_filename, sheet_name='Contacts')
print(df_read.to_string(index=False))

print("\n" + "=" * 70)
print("✅ EXCEL FILE CREATED SUCCESSFULLY!")
print("=" * 70)
