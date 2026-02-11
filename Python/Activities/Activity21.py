# test_calculator.py
# Pytest test file for validating arithmetic operations

import calculator


# ============================================================================
# TEST: Sum of two numbers
# ============================================================================

def test_add_positive_numbers():
    """Test addition of two positive numbers."""
    result = calculator.add(5, 3)
    assert result == 8, f"Expected 8, but got {result}"


def test_add_negative_numbers():
    """Test addition of two negative numbers."""
    result = calculator.add(-5, -3)
    assert result == -8, f"Expected -8, but got {result}"


def test_add_positive_and_negative():
    """Test addition of positive and negative numbers."""
    result = calculator.add(10, -7)
    assert result == 3, f"Expected 3, but got {result}"


def test_add_zero():
    """Test addition with zero."""
    result = calculator.add(5, 0)
    assert result == 5, f"Expected 5, but got {result}"


def test_add_decimals():
    """Test addition of decimal numbers."""
    result = calculator.add(2.5, 3.7)
    assert abs(result - 6.2) < 0.0001, f"Expected 6.2, but got {result}"


# ============================================================================
# TEST: Difference of two numbers
# ============================================================================

def test_subtract_positive_numbers():
    """Test subtraction of two positive numbers."""
    result = calculator.subtract(10, 4)
    assert result == 6, f"Expected 6, but got {result}"


def test_subtract_negative_numbers():
    """Test subtraction of two negative numbers."""
    result = calculator.subtract(-5, -3)
    assert result == -2, f"Expected -2, but got {result}"


def test_subtract_from_zero():
    """Test subtraction from zero."""
    result = calculator.subtract(0, 5)
    assert result == -5, f"Expected -5, but got {result}"


def test_subtract_zero():
    """Test subtracting zero."""
    result = calculator.subtract(10, 0)
    assert result == 10, f"Expected 10, but got {result}"


def test_subtract_decimals():
    """Test subtraction of decimal numbers."""
    result = calculator.subtract(10.5, 3.2)
    assert abs(result - 7.3) < 0.0001, f"Expected 7.3, but got {result}"


# ============================================================================
# TEST: Product of two numbers
# ============================================================================

def test_multiply_positive_numbers():
    """Test multiplication of two positive numbers."""
    result = calculator.multiply(5, 4)
    assert result == 20, f"Expected 20, but got {result}"


def test_multiply_negative_numbers():
    """Test multiplication of two negative numbers."""
    result = calculator.multiply(-5, -4)
    assert result == 20, f"Expected 20, but got {result}"


def test_multiply_positive_and_negative():
    """Test multiplication of positive and negative numbers."""
    result = calculator.multiply(5, -4)
    assert result == -20, f"Expected -20, but got {result}"


def test_multiply_by_zero():
    """Test multiplication by zero."""
    result = calculator.multiply(10, 0)
    assert result == 0, f"Expected 0, but got {result}"


def test_multiply_decimals():
    """Test multiplication of decimal numbers."""
    result = calculator.multiply(2.5, 4)
    assert result == 10.0, f"Expected 10.0, but got {result}"


# ============================================================================
# TEST: Quotient of two numbers
# ============================================================================

def test_divide_positive_numbers():
    """Test division of two positive numbers."""
    result = calculator.divide(10, 2)
    assert result == 5, f"Expected 5, but got {result}"


def test_divide_negative_numbers():
    """Test division of two negative numbers."""
    result = calculator.divide(-10, -2)
    assert result == 5, f"Expected 5, but got {result}"


def test_divide_positive_by_negative():
    """Test division of positive by negative number."""
    result = calculator.divide(10, -2)
    assert result == -5, f"Expected -5, but got {result}"


def test_divide_zero_by_number():
    """Test division of zero by a number."""
    result = calculator.divide(0, 5)
    assert result == 0, f"Expected 0, but got {result}"


def test_divide_decimals():
    """Test division resulting in decimal."""
    result = calculator.divide(10, 4)
    assert result == 2.5, f"Expected 2.5, but got {result}"


def test_divide_by_zero():
    """Test division by zero raises ValueError."""
    try:
        calculator.divide(10, 0)
        assert False, "Expected ValueError to be raised"
    except ValueError as e:
        assert str(e) == "Cannot divide by zero"
