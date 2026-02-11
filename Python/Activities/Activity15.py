# Simple program that throws a NameError and handles it

print("Program Start")
print("=" * 50)

# Try block that will throw a NameError
try:
    # Attempting to use a variable that doesn't exist
    # This will throw a NameError
    print(my_undefined_variable)
    
except NameError:
    # Handle the NameError
    print("NameError occurred!")
    print("The variable 'my_undefined_variable' is not defined.")
    print("But the program continues to run...")

print("\n" + "=" * 50)
print("Program continues after handling the error")
print("Program End")
print("=" * 50)
