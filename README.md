# myCISC191project

Joseph Rathbun
10/18/2024
CISC 191
Professor Frankie

PDF File: file:///C:/Users/Joe/Desktop/Classes/191%20CISC%20-%20Intermediate%20Java%20Programming/Semester%20Project/Week%200/CISC191%20-%20Semester%20Project%20Plan.pdf

Video Explaining the Design :
https://youtu.be/WIMcOQBaQ6o

**** Semester Project Plan ****

Planned Working Time

I will work on this project on Monday, Wednesday, and Friday from 1pm - 5pm.

-Project Pitch-

Idle Games have been a favorite game genre of mine to pass time to while doing other things. They help users gain a sense of growth and the best ways to go about approaching growing quicker, sooner, faster. There will be a prestige system to encourage long-term play with the mechanics that exist within the game. I want to make the game enjoyable and easy for anyone to understand and get into. The main gameplay loop is:

Press a button to increase ‘Cash’
Use ‘Cash’ to buy upgrades that increase cash gain
After gaining a certain amount of ‘Cash’ allows the user to reset the game. They will gain a unique currency that helps speed up gaining cash even quicker from the beginning of the game.
The game will be presented through a GUI that has many buttons for increasing cash, increasing the amount of cash gained per click, and a prestige button to reset the game with extra boons. 
Currently the GUI has labels for displaying the current cash amount, the buttons for increasing the amount of cash gained, buttons for increasing the multiplier for the amount of cash gained, and a price for the button that is displayed with a label. This is an alpha version of the GUI. I intend on creating many buttons with different functions that ultimately increase the amount of cash gained.

CRC Cards
Class Name: IceCreamModel


Class Data:
Collaborators:
Int cash
Int experience
upgradeCashCost
upgradeExperienceCost
IceCreamView
IceCreamButtonListener
Class Methods:
Collaborators:
getCash()
getExperience()
increaseCash()
increashCashGain()
increaseExperience()
increaseExperienceGain()
IceCreamView
IceCreamButtonListener


Class Name: IceCreamView


Class Data:
Collaborators:
JFrame
JPanel
JLabel
IceCreamModel
IceCreamButton
IceCreamButtonListener
IceCreamModel
IceCreamButton
IceCreamButtonListener
Class Methods:
Collaborators:
switchPanel()
updateUI()
IceCreamModel
IceCreamButton
IceCreamButtonListener



Class Name: IceCreamButton


Class Data:
Collaborators:
String commandName
Int Width
Int Height
Color Foreground
Color Background
String buttonText
ImageIcon buttonImage
IceCreamButtonListener
IceCreamView
Class Methods:
Collaborators:
N/A
IceCreamButtonListener
IceCreamView


Class Name: IceCreamButtonListener


Class Data:
Collaborators:
IceCreamModel shallow copy
IceCreamView shallow copy
IceCreamButton shallow copy
IceCreamButton
IceCreamView
IceCreamModel
Class Methods:
Collaborators:
actionPerformed()
Switch
Case “”
IceCreamButton
IceCreamView
IceCreamModel 

LO1: Employ design principles of object-oriented programming 
There will be four main classes, one for the model, one for the view (GUI), one for the button, and the last one will be an actionListener for the button. I made CRC cards to help with defining the responsibilities of each class. I am using a Model-View-Controller design pattern for my GUI so that I can organize my classes for their intended purpose. The model will hold all math behind the game along with accessors and mutators. The view will contain the JFrame and objects that will be seen on the GUI like JPanels, JLabels, JButtons, etc. I have made CRC cards to help visualize what each class will contain and how to approach designing their features and fields.

LO2: Construct programs utilizing single and multidimensional arrays
I am currently not using an array in the game. I plan on implementing one for a certain feature. I can see an arrayList for my current game that involves flavors for the ice cream that will increase factors like cash gain or exp gain.

LO3: Construct programs utilizing object and classes in object-oriented programming, including aggregation
IceCreamView IS-A JFrame
IceCreamView HAS-AN IceCreamModel
IceCreamModel HAS-A Cash
IceCreamButton HAS-A commandName
IceCreamButtonListener IS-AN ActionListener

LO4: Construct programs utilizing inheritance and polymorphism, including abstract classes and interfaces
My model will not have any inheritance or polymorphism. My view will extend to JFrame and will inherit the superclass’ attributes and methods. The main button will extend to JButton and will be a subclass of the Jbutton class, gaining the attributes and methods. I will have a buttonListener for the main button that implements actionListener gaining polymorphism through the desired action upon the event occurring.

LO5: Construct programs using generic collections and data structures
I think I can use an ArrayList for a minigame in the main game. The mini-game will be simple where you can add ice cream with a specific flavor. That flavor will have a specific number array attached to it to 
determine what numbers are gained to the specific multiplier. I can add an Ice Cream object with a specific flavor that increases stats gained with each flavor having different attributes.

LO6: Construct programs utilizing graphical user interfaces utilizing event-driven programming.
The GUI will provide the entire gameplay experience. The user will be able to seamlessly move through different panels to allow for interactivity.

LO7: Construct programs utilizing exception handling
I will add error handling whenever I can as I write the code.

LO8: Construct programs utilizing text file I/O
I would like to make a Save/Load system to the game. It will utilize a text file I/O to make continuous gameplay simple while avoiding annoying users. 
--- Timeline ---
Week 1
-Design the GUI/View (in Java)
-Write out classes and necessary fields, including interfaces and responsibilities.
-Create Model
-Create Button
-Create ButtonListener
Week 2
-Create test code for model, view, button, and buttonListener.
-Continue working on GUI, adding buttons to the exp shop and research shop
-Add slider with timer for research to be increased over time
-Add a science button for a panel with buttons to increase cash gained after a certain amount of time has passed.
-Update project page with current progress.
-Submit code currently developed to github.
Week 3
-Add Icon Images to important buttons 
-Finish writing out the model class
-Create MouseListener for ease of access for the user
-Polish the GUI (Colors, Button Dimension, Label Fonts, etc)
-Add Music for user to listen to while playing
-Add Settings to disable music or enable music. Also can lower or increase music volume.
-Add noises for certain buttons like upgrade and prestige buttons.
-Add button sounds to the overall sounds profile that can be adjusted in the Settings.
-Add color themes for the GUI in the settings.
-Submit Code written so far.
Week 4
-Add error handling where necessary
-Finalize desired game features.
-Finalize the look and feel of the GUI.
-Create a video to illustrate the LO’s achieved and how they were developed in the project.
-Submit final code to Canvas.
-Add videos to the project page.


	

