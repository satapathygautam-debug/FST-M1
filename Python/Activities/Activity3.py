print("Welcome to Rock-Paper-Scissors!")
print("=" * 40)

# Get player choices
player1 = input("Player 1, enter your choice (rock/paper/scissors): ").lower()
player2 = input("Player 2, enter your choice (rock/paper/scissors): ").lower()

print("\n" + "=" * 40)
print(f"Player 1 chose: {player1}")
print(f"Player 2 chose: {player2}")
print("=" * 40)

# Check for valid inputs
valid_choices = ["rock", "paper", "scissors"]
if player1 not in valid_choices or player2 not in valid_choices:
    print("Invalid choice! Please choose rock, paper, or scissors.")
# Check for a tie
elif player1 == player2:
    print("It's a tie!")
# Determine the winner
elif (player1 == "rock" and player2 == "scissors") or \
     (player1 == "scissors" and player2 == "paper") or \
     (player1 == "paper" and player2 == "rock"):
    print("Player 1 wins!")
else:
    print("Player 2 wins!")
