obstruction
The obstruction class represents an obstacle on the game board. It is an abstract class that provides a common foundation for all specific obstacle classes.
1.Attributes
int row: The row where the obstacle is located.
int column: The column where the obstacle is located.
int index: The obstacle's index on the path.
2.Methods
2.1Constructor
Obstruction(int row, int column): Initializes the obstacle's position.
2.2 Abstract Methods
String pass(Player player): This method is called when a player passes the obstacle. The specific behavior is implemented by subclasses.
String land(Player player): This method is called when a player lands on the obstacle. The specific behavior is implemented by subclasses.
2.3 Index Management
void setIndex(int index): Sets the obstacle's index.
int getIndex(): Gets the obstacle's index.
2.4 Position Accessors
int getRow(): Gets the row where the obstacle is located.
int getColumn(): Gets the column where the obstacle is located.
3 Subclasses
For each subclass of the Obstruction class, such as BottomlessPitObstruction, FirePitObstruction, etc., they must implement the pass and land methods and may have additional attributes and methods to handle the specific logic of that type of obstacle.
3.1 EmptyObstruction

Pass Action:
The pass(Player player) method is overridden from the Obstruction class. It is executed when a player passes through an empty cell. This method sets the player's position to the index of the EmptyObstruction. It also updates the player's latest valid position to this index. The method returns an empty string, indicating no special events occur when a player passes through an empty cell.

Land Action:
The land(Player player) method, also an override from Obstruction, is invoked when a player lands on an empty cell. This method simply calls pass(player), implying that landing on an empty cell is treated the same as passing through it. Similar to pass, it returns an empty string, indicating no special events on landing.

3.2BottomlessPitObstruction
Responsibility: Represents a bottomless pit obstacle in the game.
Special Behavior: Players return to the start when they fall in.
3.3 FirePitObstruction	

Pass Action:
The pass(Player player) method is overridden from the Obstruction class. It is executed when a player passes through a fire pit cell. The method sets the player's position to the index of the FirePitObstruction but doesn't specify any additional actions or penalties for just passing through. It returns an empty string, indicating no special events occur for passing.

Land Action:
The land(Player player) method, also an override from Obstruction, is invoked when a player lands on a fire pit. It sets the player's position to the index of the fire pit and changes the player's status to miss their next turn (player.setMissNextTurn(true)). This method returns a string indicating that the player has fallen into a fire pit, suggesting a penalty or consequence as a result of landing on this obstacle.
3.4SpikePitObstruction
Pass Action:

The pass(Player player) method overrides from the Obstruction class. When a player passes through the spike pit cell (without landing on it), this method updates the player's position to the index of the SpikePitObstruction. The method returns an empty string, indicating that passing through a spike pit does not trigger any immediate consequences.
Land Action:

The land(Player player) method, also an override from Obstruction, is called when a player lands on a spike pit. This method resets the player's position to their latest valid position(before encountering the spike pit)
using player.setPosition(player.getLatestValidPosition()). The method returns a string message indicating that the player failed to cross the spike pit, implying a negative outcome or penalty for landing on this obstacle.

