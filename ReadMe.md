# Go Fish Terminal Game

**Go Fish: The Basics**

Imagine you're a fisher, and each type of card in a deck (like Twos, Threes, Queens, etc.) represents a type of fish in the sea. Your goal? To catch as many "fish" as you can!

**Setting Up:**

1. **Deck**: You'll need a standard deck of 52 cards.
2. **Players**: Ideally, you want 2 to 6 players.
3. **Dealing**: Each player is dealt a starting hand of cards:
    - If there are 2-4 players, each player gets 7 cards.
    - If there are 5-6 players, each player gets 5 cards.

The remaining cards form the "fishing pond."

**How to Play:**

1. **Starting**: The youngest player goes first, then play proceeds clockwise.

2. **Asking for Cards**: On your turn, ask any player for a specific rank of card that you already have at least one of in your hand. For example, if you have a Six, you can ask another player, "Do you have any Sixes?"

3. **Responses**:
    - If the player you asked has one or more of that card, they must give you all of them.
    - If they don't have the card, they say, "Go Fish!" That means you need to "go fishing" in the pond by drawing a card from the top of the deck.

4. **Getting Pairs**: If you get a matching pair of cards from another player or from "fishing" in the pond, put the pair face-up in front of you. These are your caught "fish!"

5. **Continuing Play**: If you successfully got cards from another player, you get another turn. If you had to "Go Fish" and drew the card you asked for, you also get another turn. If not, play moves to the next player.

**Winning the Game:**

The game ends when all pairs of cards have been claimed. The player with the most pairs (the most "fish") wins!

---

Think of Go Fish as a mix of memory and luck. It's about trying to remember who might have the cards you need and hoping you "catch" the right ones when you go fishing in the pond! 🎣🃏🐟

# Go Fish Terminal Game

## Lab Exercise:

**Creating the Go Fish Game in Java**

**Objective:**

This exercise aims to guide you in creating a terminal-based version of the Go Fish card game, focusing on managing the game flow, card distribution, and handling different game states.

**Requirements:**

- Java SDK
- An IDE (e.g., IntelliJ IDEA, Eclipse)
- Familiarity with Java, Enums, ArrayLists, and basic game logic

**Instructions:**

**Task 1: Designing the Card Class and Enum**

- Create a `Card` class with appropriate attributes and methods.
- Use Enums to represent the card suits.

**Task 2: Building the Deck**

- Design a deck using an `ArrayList` of `Card` objects.
- Initialize the deck with the correct number of cards for each suit.
- Implement shuffling using Java Collections.

**Task 3: Implementing the Game Logic**

- Develop the game logic to deal cards to the players and manage turns.
- Implement game flow, handling scenarios such as a player asking for a card not present in another player’s hand or the deck running out of cards.

**Task 4: Testing the Game**

- Test the game by running it multiple times.
- Ensure the game handles all scenarios gracefully and that the game logic is functioning as expected.

Upon completion, you should have a functioning Go Fish game that can be played in the terminal. Enjoy the process and have fun creating your digital card game! 🎣🃏🌊