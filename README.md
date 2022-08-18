# Crazy Uno

Java Project: Practice project based on Crazy Eights and Uno

Project Team:

* Brandon Copeland (owner)
* Arelys Morales (collaborator)

Crazy Uno is a terminal based game, where players start with 7 cards and take turns matching cards
by color or number. If a player does not have any matches, then the player repeatedly must draw a card from the
deck until a match is found. First player to empty their hand of cards, WINS!!!

To use this application, please follow the below instructions.

1. Create a staging area for your project, *away* from IntelliJ.


     Perhaps C:\STAGE\crazyUno


2. Copy the build and run scripts (.cmd or .sh) to that location.


3. Copy select items from your project directory into the staging area.


    src/       source tree                        [test code not needed,  this is a product build]


    resources/ other files or folders used by your application (if any), e.g., a 'config' folder, etc.


4. Open the build script from file explorer, and wait for the application to build.
   Once built, open the run script to ensure that the application successfully runs.


5. Once you have it built and running successfully, you can trim away unneeded files:
   

    build script


    src/


    classes/

Final note: this process is normally done via build tools such as Maven or Gradle, but we're not
using those, this how it's done with the bare metal JDK tools.