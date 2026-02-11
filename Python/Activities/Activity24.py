import pytest


class Wallet:
    """Simple wallet class to track amount"""
    def __init__(self):
        self.amount = 0
    
    def add_cash(self, earned):
        """Add cash to wallet"""
        self.amount += earned
    
    def spend_cash(self, spent):
        """Spend cash from wallet"""
        self.amount -= spent


@pytest.fixture
def wallet():
    """Fixture that initializes a wallet with amount = 0"""
    return Wallet()


@pytest.mark.parametrize("earned, spent, expected", [
    (30, 10, 20),
    (20, 2, 18),
])
def test_wallet_transactions(wallet, earned, spent, expected):
    """
    Test wallet transactions with different parameters.
    
    Scenario:
    - My wallet initially has 0
    - I add {earned} units of cash to the wallet
    - I spend {spent} units of cash
    - I should have {expected} units of cash remaining
    """
    # Wallet initially has 0
    assert wallet.amount == 0
    
    # Add earned units of cash
    wallet.add_cash(earned)
    
    # Spend spent units of cash
    wallet.spend_cash(spent)
    
    # Check expected remaining amount
    assert wallet.amount == expected
