# Yahtzee

## Program Overview
This program is a recreation of the popular dice two-player dice game Yahtzee coded with Java and JavaFX. It is meant for people of all ages to play and enjoy.

## Feature List

### Input
1. Players can use the mouse to point and click on buttons to perform game actions
(keeping score, re-rolling dice, keeping dice).

### Processing
1. (modified) The Secondary Controller class implements the main game 
2. (modified) Various states are processed using other controllers (menu, end screens, etc.)
3. (modified) Score class keeps track of the state of player scores (name, kept?, value)
4. Player class keeps track of all scores for each player
5. (modified) Die class keeps track of the status of all 5 dice

### Output:
1. Functional and clean UI that displays all relevant menus and buttons the player needs to play the game
2. Jpgs of scorecard and dice to inform player of what they roll; possibly a text/check box that allows players to keep dice
3. Labels that contain relevant information pertaining to turn number and who's turn it is
   
### Ommitted Functionality
1. Player can type in textbox their player names
2. Player class that can keep track of player stats including win/loss percentage etc.
3. AI class that automatically takes turns depending on specific values of the dice and the scorecard
4. Sound effects for button clicks and a soundtrack that plays in the background
5. A settings menu to allow players to quit, restart, or change volume of the sound effects

### Known Bugs / Limitations
There are no known bugs/limiations of our project outside of the ommitted/modified functionality of our game.

### User Guide

**Launching the Game**

Open the repository in VSCode and type "mvn javafx:run" in the terminal. Make sure you are in the folder with the "pom.xml" file.


**Interacting With the Game**

![Screenshot of the main menu of the game.](/images/main_menu.png)

After launching the game, you will be brought to the main menu. If you aren't sure how to play Yahtzee, click the "How to Play" button. Otherwise, press "Start" to start a new game.

![Screenshot of keeping dice.](/images/keeping_dice.png)

In Yahtzee, players can choose to keep dice and reroll the others. To keep a specific dice, click the "Keep?" checkbox found under the corresponding die.

![Screenshot of rolling dice.](/images/re-rolling.png)

To reroll your dice, simply press the "Roll Dice" button. At the start of each turn, one of your dice rolls will automatically be used. However, you may reroll the dice up to two times. 

![Screenshot of keeping score.](/images/keeping_score.png)

To keep score, click the score on your scoreboard that you wish to keep. This will automatically end your turn, and the next player will play using their own corresponding scoreboard.

![Screenshot of ending a game.](/images/ending_game.png)

To end the game, press the "Game End?" button once the game reaches Turn #14 and all scores on the scoreboards are kept. This will take you to the game end screen.

![Screenshot of end screen.](/images/game_over.png)

The game is over! The winner will be announced and you may return to the main menu.

**Major Features**
1. Point calculations and Scoreboard updates for each dice roll are automatic
2. Players can keep/re-roll dice
3. Players can end a turn by simply clicking the cell of the desired score they want to keep
4. To end the game, click the "Game End?" button on Turn #14 to see the end screen.
