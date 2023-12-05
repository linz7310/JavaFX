In the Model package, I implemented a comprehensive suite of classes and functionalities essential for the game's mechanics, alongside the scoring feature in the GameModel class.: Obstruction Class (Abstract): 
This class serves as a foundation for various types of obstacles in the game. It includes attributes like row, column, and index, and abstract methods pass(Player player) and land(Player player) which subclasses override to define specific behaviors when players pass or land on different obstacles. 
Subclasses of Obstruction: 
EmptyObstruction: Handles actions when a player passes or lands on an empty cell. BottomlessPitObstruction: Represents a bottomless pit, returning players to the start. FirePitObstruction: Players passing through incur no penalty, but landing on it results in missing the next turn. 
SpikePitObstruction: Resets the player's position to their last valid position if they land on it. 
TeleporterObstruction: Implements logic for teleportation when a player lands on it, randomly moving the designated player to a position on the game path. 
Player Class: 
Manages player attributes such as ID, name, position, latest valid position, whether they miss the next turn, their win status, and score. It includes a constructor, getters/setters for various attributes, and utility methods like toString().
Dice Class: Facilitates rolling of the dice, generating a random number within a specified range, and retrieving the current dice value. 
GameModel Class: 
Scoring Feature: Implements methods like toSortString(Map<String, Integer> scoreMap) for sorting and displaying player scores, and readScores() for reading scores from a file. Player Turn Rotation: The toNextPlayer() method advances the game to the next player, ensuring a fair and sequential turn-taking process.
