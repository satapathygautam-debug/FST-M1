# Custom sum function to calculate sum of list elements

def sum(elements):
    """
    Accepts a list of elements and prints the sum of all elements.
    
    Args:
        elements: A list of numbers
    """
    total = 0
    for element in elements:
        total += element
    
    print(f"Sum of all elements: {total}")
    return total


# Main program
print("=" * 50)
print("CUSTOM SUM FUNCTION")
print("=" * 50)

# Test with different lists
print("\nTest 1: List of positive numbers")
list1 = [10, 20, 30, 40, 50]
print(f"List: {list1}")
sum(list1)

print("\n" + "-" * 50)
print("\nTest 2: List with mixed numbers")
list2 = [5, -3, 12, -8, 20, 15]
print(f"List: {list2}")
sum(list2)

print("\n" + "-" * 50)
print("\nTest 3: List with decimals")
list3 = [2.5, 3.7, 1.2, 4.8]
print(f"List: {list3}")
sum(list3)

print("\n" + "-" * 50)
print("\nTest 4: Single element list")
list4 = [100]
print(f"List: {list4}")
sum(list4)

print("\n" + "-" * 50)
print("\nTest 5: Empty list")
list5 = []
print(f"List: {list5}")
sum(list5)

print("=" * 50)
