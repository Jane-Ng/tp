# User Guide

## Table of content
1. [Introduction](#1-introduction)<br>
2. [Quick start](#2-quick-start)<br>
3. [Features](#3-features)<br>
3.1. [Listing commands available: `help`](#31-listing-commands-available-help)<br>
3.2. [Adding a new module/chapter/flashcard: `add`](#32-adding-a-new-modulechapterflashcard-add)<br>
3.3. [Removing a module/chapter/flashcard: `remove`](#33-removing-a-modulechapterflashcard-remove)<br>
3.4. [Listing modules/chapters/flashcards available: `list`](#34-listing-moduleschaptersflashcards-available-list)<br>
3.5. [Listing due chapters: `due`](#35-listing-due-chapters-due)<br>
3.6. [Accessing the next level: `go`](#36-accessing-the-next-level-go)<br>
3.7. [Returning to the previous level: `back`](#37-returning-to-the-previous-level-back)<br>
3.8. [Editing the data you have created: `edit`](#38-editing-the-data-you-have-created-edit)<br>
3.9. [Starting a revision session: `revise`](#39-starting-a-revision-session-revise)<br>
3.10. [Viewing the revision history: `history`](#310-viewing-the-revision-history-history)<br>
3.11. [Rating a chapter: `rate`](#311-rating-a-chapter-rate)<br>
3.12. [Checking your overall performance for a chapter: `showrate`](#312-checking-your-overall-performance-for-a-chapter-showrate)<br>
3.13. [Exiting the program: `exit`](#313-exiting-the-program-exit)<br>
4. [Command summary](#command-summary)<br>

## 1. Introduction

KAJI is a schedule manager that implements Spaced Repetition, optimised for use via a Command Line Interface (CLI).


## 2. Quick start
To get started on this application, please perform the following steps:

1. Ensure that you have Java 11 or above installed.
1. Download the latest version of `Kaji` from [here](https://github.com/AY2021S1-CS2113T-F11-3/tp/releases).
1. Copy the file to the folder you want to use as the <I>home folder</I> for your Kaji.
1. Double-click the file to start the app or open a command window in the folder you saved Kaji and run the command `java -jar kaji.jar`. You should see the welcome message `Welcome to Kaji` as well as a list of commands available.
1. Type the command in the command window and press Enter to execute it. 
   e.g. typing `help` and pressing Enter will open the help window.<br>
   Some example commands you can try:
   * `help` : List commands available
   * `exit` : Exits the app.
1. Refer to [Features](#features) below for details of each command.

## 3. Features 


### 3.1. Listing commands available: `help`
Shows a list of commands available.

Format: `help`


### 3.2. Adding a new module/chapter/flashcard: `add`
Adds a module / chapter / flashcard to the schedule manager.

Format:<br>
`add MODULE_NAME`<br>
`add CHAPTER_NAME`<br>
`add q:QUESTION | a:ANSWER`<br>
        
* You can only add content to the level below the one you are on

Example of usage: 
* At Admin Level: `add CS2113T` Adds a new module `CS2113T`
* At Module Level: `add Chapter 1` Adds a new chapter `Chapter 1`
* At Chapter Level: `add q:1+1= | a:2` Adds a new flashcard with question as `1+1=` and answer as `2`


### 3.3. Removing a module/chapter/flashcard: `remove`
Removes a module / chapter / flashcard from Kaji.

Format:<br>
`remove MODULE_INDEX`<br>
`remove CHAPTER_INDEX`<br>
`remove FLASHCARD_INDEX`<br>

* Removes content from the level directly below your current level.
* Removes the module /chapter / flashcard based on the index provided.
* The index refers to the index number shown in the module /c hapter / flashcard list. 
* Index provided **must be a positive integer** 1, 2, 3, ...

Example of Usage: 
* At Admin level: `remove 1` removes a module with index 1 and the chapters and flashcards under it.
* At Module level: `remove 1` removes a chapter with index 1 and flashcards under it.
* At Chapter level: `remove 1` removes a flashcard with index 1.

Sample Output:

* Removing a flashcard:
![Remove flashcard](images/removecard.PNG)

* Removing a chapter:
![Remove chapter](images/removechapter.PNG)

* Removing a module:
![Remove module](images/removemodule.PNG)


### 3.4. Listing modules/chapters/flashcards available: `list`
Shows a list of modules / chapters / flashcards available, depending on the level you are on.

Format: `list`


### 3.5. Listing due chapters: `due`
Allows you to obtain the complete list of chapters, excluding those that are excluded, that are due by the date of execution.

Format: `due`


### 3.6. Accessing the next level: `go`
Allows user to access a module / chapter.

Format:<br>
`go MODULE_NAME`<br>
`go CHAPTER_NAME`<br>

* You can only access the level directly below the current level

Example of Usage: 
* At Admin Level: `go CS2113T` allows you to access the module CS2113T
* At Module Level: `go Chapter 1`  allows you to access the chapter Chapter 1
        

### 3.7. Returning to the previous level: `back`
Allows you to access the previous level. 

Format: `back`


### 3.8. Editing the data you have created: `edit`
Modifies the category name / deck name / flashcard content.

Format:<br>
`edit INDEX MODULE_NAME`<br>
`edit INDEX CHAPTER_NAME`<br>
`edit INDEX q:QUESTION | a:ANSWER`<br>

* You can only edit content on the level below the one you are on
* Edit the name / content at the specified `INDEX`
* The index refers to the index number shown in the displayed content list
* The index **must be a positive integer** 1, 2, 3, …

Example of usage: 
* At Admin Level: `edit 1 CS2113T` changes current Module name at index 1 to CS2113T
* At Module Level: `edit 2 Chapter 2` changes current Chapter name at index 2 to Chapter 2 
* At Chapter Level: `edit 3 q:1+1= | a:2` changes current Flashcard content at index 3 to q:1+1= | a:2


### 3.9. Starting a revision session: `revise`
Starts a revision session.

Format: `revise CHAPTER_INDEX` 

* Starts a revision based on the index provided. 
* Revision can only be done at module level. 
* The index refers to the index number shown in the chapter list for the module level you are currently in.  
* Index provided **must be a positive integer** 1, 2, 3, ...

Example of Usage: 

* At Module level: `revise 1` starts a revision for the chapter with index 1.

Sample Output:

* Starting a revision with an empty chapter:
![Revise empty module](images/revise_nocards.PNG)

* Starting a revision with a chapter that is not due:
![Remove chapter](images/revise_notdue.PNG)

* Starting a revision with a chapter that is due:
![Remove module](images/revise_due.PNG)

### 3.10. Viewing the revision history: `history`
View the revision completed in the session/in a day.

Format:<br>
`history`<br>
`history DATE`<br>

Example of Usage: 

* `history` show the revision completed today.
* `history 2020-11-15` show the revision completed in Nov 15,2020.


### 3.11. Rating a chapter: `rate`
Allows you to rate a chapter. You may only use it on the module level.

Format: `rate INDEX`

* You can only rate chapter on the **exact module level** where the chapter stored.
* Rate the chapter at the specified `INDEX`
* The index refers to the index number shown in the displayed chapter list
* The index **must be a positive integer** 1, 2, 3, …

Example of Usage: 

* At Module level: `rate 2` allows you to modify the rate of chapter with index 2.

Sample Output: 

* Rating chapter successfully for a chapter with index 2:
![Rating_Chapter](images/rateCommand_correct.PNG)

* Entering an out of range index:
![Rating_Chapter](images/rateCommand_wrongFormat1.PNG)

* Entering a wrong rate format command:
![Rating_Chapter](images/rateCommand_wrongFormat2.PNG)

### 3.12. Checking your overall performance for a chapter: `showrate`
Allows you to check your overall performance of each chapter. You may only use it on the chapter level.

Format: `showrate`

* You can only use this command at **chapter level**.
* This command will show you your overall performance by calculating percentage of card in each master level.

Example of Usage: 

* At Chapter level: `showrate` allows you to check your overall performance in the current chapter.

Sample Output: 

* Checking overall performance of a chapter:
![Show_rating](images/showrateCommand_correct.PNG)

* Entering a command with wrong format:
![Show_rating](images/showrateCommand_wrongFormat.PNG)

* When there is no card in the chapter:
![Show_rating](images/rateCommand_emptyCard.PNG)


### 3.13. Exiting the program: `exit`
Exits the program.

Format: `exit`


## 4. Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
