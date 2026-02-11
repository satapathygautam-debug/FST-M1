import pytest


def test_first_method():
    """First test without marker"""
    assert 1 + 1 == 2


def test_second_method():
    """Second test without marker"""
    assert "hello".upper() == "HELLO"


@pytest.mark.activity
def test_third_method():
    """Third test with activity marker"""
    result = [1, 2, 3, 4, 5]
    assert len(result) == 5


@pytest.mark.activity
def test_fourth_method():
    """Fourth test with activity marker"""
    data = {"name": "pytest", "type": "testing"}
    assert "name" in data
    assert data["type"] == "testing"
