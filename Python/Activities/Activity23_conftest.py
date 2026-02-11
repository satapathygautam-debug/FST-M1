import pytest


@pytest.fixture
def number_list():
    """Fixture that returns a list of numbers from 0 to 10"""
    return list(range(11))  # range(11) gives us 0-10 inclusive
