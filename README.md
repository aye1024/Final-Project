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
To interact with buttons, checkboxes, and the Scorecard, simply point and click using the mouse. If you aren't familiar with the rules of Yahtzee, there is a helpful tutorial image in the "How to Play" section of the main menu.

**Major Features**
1. Point calculations and Scoreboard updates for each dice roll are automatic
2. Players can keep/re-roll dice
3. Players can end a turn by simply clicking the cell of the desired score they want to keep
4. To end the game, click the "Game End?" button on Turn #14 to see the end screen.
