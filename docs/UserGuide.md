# KAJI - User Guide
By: `Team CS2113T-F11-3` Since: `August 2020`

## Table of Contents
1. [Overview](#1-overview)<br>
1.1. [About KAJI](#11-about-kaji)<br>
1.2. [About this User Guide](#12-about-this-user-guide)<br>
1.3. [Understanding the Command Line Interface (CLI)](#13-understanding-the-command-line-interface-cli)<br>
1.4. [Understanding KAJI](#14-understanding-kaji)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.4.1. [Content Management](#141-content-management)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.4.2. [Schedule Management](#142-schedule-management)<br>
2. [Quick Start](#2-quick-start)<br>
3. [Features](#3-features)<br>
3.1. [Admin Level](#31-admin-level)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.1.1. [Adding a module: `add`](#311-adding-a-module-add)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.1.2. [Listing modules available: `list`](#312-listing-modules-available-list)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.1.3. [Editing a module name: `edit`](#313-editing-a-module-name-edit)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.1.4. [Removing a module: `remove`](#314-removing-a-module-remove)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.1.5. [Accessing the module level: `go`](#315-accessing-the-module-level-go)<br>
3.2. [Module Level](#32-module-level)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.2.1. [Adding a chapter: `add`](#321-adding-a-chapter-add)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.2.2. [Listing chapters available: `list`](#322-listing-chapters-available-list)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.2.3. [Editing a chapter name: `edit`](#323-editing-a-chapter-name-edit)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.2.4. [Removing a chapter: `remove`](#324-removing-a-chapter-remove)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.2.5. [Accessing the chapter level: `go`](#325-accessing-the-chapter-level-go)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.2.6. [Returning to admin level: `back`](#326-returning-to-admin-level-back)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.2.7. [Starting a revision session: `revise`](#327-starting-a-revision-session-revise)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.2.8. [Rescheduling a chapter: `reschedule`](#328-rescheduling-a-chapter-reschedule)<br>
3.3. [Chapter Level](#33-chapter-level)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.1. [Adding a flashcard: `add`](#331-adding-a-flashcard-add)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.2. [Listing flashcards available: `list`](#332-listing-flashcards-available-list)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.3. [Editing a flashcard content: `edit`](#333-editing-a-flashcard-content-edit)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.4. [Removing a flashcard: `remove`](#334-removing-a-flashcard-remove)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.5. [Returning to module level: `back`](#335-returning-to-module-level-back)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3.6. [Checking overall performance for a chapter: `showrate`](#336-checking-overall-performance-for-a-chapter-showrate)<br>
3.4. [Scheduling in KAJI](#34-scheduling-in-kaji)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.1. [Listing the chapters due for today: `due`](#341-listing-the-chapters-due-for-today-due)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.2. [Listing the chapters that are due in the upcoming week: `preview`](#342-listing-the-chapters-that-are-due-in-the-upcoming-week-preview)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.3. [Adding chapters to your list of excluded modules: `exclude`](#343-adding-chapters-to-your-list-of-excluded-modules-exclude)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4.4. [Removing chapters from the list of excluded modules: `include`](#344-removing-chapters-from-the-list-of-excluded-modules-include)<br>
3.5. [General](#35-general)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.5.1. [Showing a list of commands available: `help`](#351-showing-a-list-of-commands-available-help)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.5.2. [Viewing the revision history: `history`](#352-viewing-the-revision-history-history)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.5.3. [Exiting the program: `exit`](#353-exiting-the-program-exit)<br>
4. [Command Summary](#4-command-summary)<br>
4.1. [Admin Level](#41-admin-level)<br>
4.2. [Module Level](#42-module-level)<br>
4.3. [Chapter Level](#43-chapter-level)<br>
4.4. [Scheduling in Kaji](#44-scheduling-in-kaji)<br>
4.5. [General](#45-general)<br>


--------------------------------------------------------------------------------------------------------------------
<div style="page-break-after: always;"></div>

## 1. Overview
This section gives an overview about KAJI and the purpose of this user guide.

### 1.1. About KAJI
Have you ever spent hours and hours on end learning your Module content, only to forget it completely just a couple of 
months later when you are going to take your Finals? Are you tired of having to re-learn the entire Module from scratch again?

This process is actually completely normal and can be explained by "The Forgetting Curve", which says that when first learn 
something, information disappears at an exponential rate. Does having to re-learn content repeatedly annoy you? To combat 
"The Forgetting Curve", you can always implement study techniques like Spaced Repetition for yourself. But, the process is 
tiring and complicated.

Fret no more, as KAJI will do all the work for you, so that you can enjoy all the benefits of Spaced Repetition without you 
having to do any of the work! 

KAJI is a schedule manager designed especially for University Students. KAJI implements Spaced Repetition, optimised for use 
via a Command Line Interface (CLI). You can also store all your study materials on it, which means that you will always have 
your materials on hand when you need to revise them.

### 1.2. About this User Guide
This User Guide explains how to use KAJI. It provides an understanding of the features and commands, as well as some common use cases of this application.

In this guide, we cover:
* How to use the Command Line Interface (CLI)
* Syntax of the commands available in different levels in KAJI
* Common use cases for each command
* Summary of all the commands

<div style="page-break-after: always;"></div>

### 1.3. Understanding the Command Line Interface (CLI)
To use KAJI, you have to first know the Command Line Interface, the platform that KAJI runs on. However, as we have simplified the interface for you, here is a simplified introduction that will cover everything you need to know about the CLI to use KAJI.

<p align="center">
  <img src="UG_Images/CLI.png" width="600" alt="CLI"/>
  <br/>Figure 1. KAJI CLI Layout 
</p>

* <b>Command Prompt:</b> This is where you enter your commands
* <b>Access Level:</b> This displays the access level that you are currently at
* <b>Result Display:</b> This displays feedback and other useful information about your commands that you have just entered

### 1.4. Understanding KAJI

#### 1.4.1. Content Management
KAJI's content management system is similar to a physical folder which you may use to organize your lecture handouts. <br>
KAJI manages content in four different levels, they are the Admin Level, the Module Level, the Chapter Level and the Flashcard Level:

<p align="center">
  <img src="UG_Images/contentManagement.png" width="600" alt="Content Management"/>
  <br/>Figure 2. Content Management Diagram
</p>

* **Admin Level** is like your **bookshelf** to keep all the separated module folder in place.
* **Module Level** is like a **folder** to keep all your lecture notes and materials by different module codes.
* **Chapter level** is like an **index sticker** which organizes different pieces of information into its relevant chapters.
* **Flashcard level** is all the **primary notes and material** which you have collected for your modules. With KAJI's assistant, you can easily categorise your messy notes into organized structure.

When you start our program, you begin on the **Admin Level**, indicated by the prompt "admin" as shown here. <br>
To add/modify/remove elements of a certain level, you have to be on the level above it. <br>
* E.g. to create a new Module in the **Module Level**, you have to be on the **Admin Level**
* E.g. to create a new Flashcard in the **Flashcards Level**, you have to be on the **Chapter Level**

Refer to [Features](#3-features) below for details of each command.

#### 1.4.2. Schedule Management
Your biggest reason to use KAJI lies in KAJI's ability to provide you with the full benefits of "Spaced Repetition" without you having to do the tedious manual work involved. To accomplish this, KAJI comes with an automated Schedule Management feature that will facilitate the "Spaced Repetition" scheduling process for you. 

To find out more about how you can utilise the feature and even customise it to your liking, find out more [below](#34-scheduling-in-kaji).

--------------------------------------------------------------------------------------------------------------------

## 2. Quick Start
To get started on this application, please perform the following steps:

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `KAJI` from [here](https://github.com/AY2021S1-CS2113T-F11-3/tp/releases).
3. Copy the file to an empty folder you want to use as the <I>home folder</I> for your KAJI.
4. Open a command window in the folder you saved KAJI and run the command `java -jar kaji.jar`. You should get the output as shown below: <br>
![Welcome screen](images/kaji.PNG)
5. Type the command in the command window and press Enter to execute it. 
   e.g. typing `help` and pressing Enter will show the list of commands available.<br>
   Some example commands you can try:
   * `help` : Lists all commands available.
   * `exit` : Exits the app.
6. Refer to [Features](#3-features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## 3. Features
This section introduces the syntax and usages of the commands for the features available in KAJI. 
In explaining the syntax, do take note of the following command format which applies to all KAJI commands:
* Words in `UPPER_CASE` are the parameters that you need to provide.
    * <b>Example:</b> In `add MODULE_NAME`, `MODULE_NAME` is a parameter which can be used as `add CS2113`.
* Parameters cannot be given in any order.
    * <b>Example:</b> In `edit MODULE_INDEX MODULE_NAME`, entering `edit CS2113 1` will result in an error as 
      the `MODULE_INDEX` and `MODULE_NAME` parameters are in the wrong order.
* The `INDEX` that is used for various commands is a number used to identify a module/chapter/flashcard within the list.
The `INDEX` of a module/chapter/flashcard is shown one the left of each module/chapter/flashcard whenever a `list` command is used.
    * <b>Example of index:<b><br>
    <img src="UG_Images/Index.png" width="600" alt="Index"/>
    

### 3.1. Admin Level
This section introduces the syntax and usages of the commands for the features that are available at the **Admin Level**.<br>
Ensure that you are at the **Admin Level** before trying the commands in the next few sections:<br>
<p align="center">
  <img src="UG_Images/AdminLevel.png" width="600" alt="Admin Level"/>
</p>

<div style="page-break-after: always;"></div>

#### 3.1.1. Adding a module: `add`
(by Jiayi)

Welcome to the first feature of KAJI! In order to use this program, you first will need to create a module deck. Creating a new module deck in KAJI is like getting a new folder to store all the handouts for one module. This is important because it helps you to organize your messy notes. <br>

**Format:** `add MODULE_NAME`
MODULE_NAME is the name of the new module that you would like to create, such as `CS2113`, `Module 1` or `Biology`. 

Here are some key pointers:
* KAJI does not allow duplicate of module names, therefore, if the existing module has the same name as the new module, you will get an error message.
* KAJI is not case-sensitive, therefore, a new module named `module`  will be treated equally to a module named `MODULE`. 
* KAJI only allows creation of one module with the `add` command. If you enter command `add CS2113T CS2101` will creates a module named `CS2113T CS2101`, instead of two separated modules named `CS2113T` and `CS2101` respectively.

**Example:**
 
In this example, you are going to add a new module called `CS2113T`. <br>
Below are steps of using this `add` command: <br>
* Step 1: Enters the command `add CS2113T` into the command prompt. Your new module name comes after the key word `add`. <br>
<p align="center">
  <img src="UG_Images/addModule1.png" alt="Add Module 1"/>
</p>

<div style="page-break-after: always;"></div>

* Step 2: As shown below, a new module named `CS2113T` has just been created! You are free to edit, delete and access this module! <br>
<p align="center">
  <img src="UG_Images/addModule2.png" alt="Add Module 2"/>
</p>

This is an additional example to show you the unique property of KAJI's add feature. <br>
As you may aware from `Key Pointers` section above, KAJI is case-insensitive. This example belows shows you what will happen if you try to add a new module called `cs2113t` after completing the previous example. <br>
Below are the breakdown of this example: <br>
* Step 1: Types `add cs2113t` to add a new module named `cs2113t` after adding a module named `CS2113T` which essentially have a same name as our new module but in capital letters.<br>
<p align="center">
  <img src="UG_Images/addModule3.png" alt="Add Module 3"/>
</p>
* Step 2: Opps, Kaji refuses to add the module `cs2113t` because a module with the same name is already existed!<br>
<p align="center">
  <img src="UG_Images/addModule4.png" alt="Add Module 4"/>
</p>

<div style="page-break-after: always;"></div>

This is another additional example to show you the unique property of Kaji's add feature. <br>
As you may aware from `Key Pointers` section above, Kaji only allows addition of one new module each time. Let's see what will happen if you try to add two modules `cs2113 cs2101` at same time. <br>
Below are the breakdown of this example: <br>
* Step 1: Types `add cs2113t cs2101` and attempts to add a new module named `cs2113t` and another new module `cs2101`. <br>
<p align="center">
  <img src="UG_Images/addModule5.png" alt="Add Module 5"/>
</p>
* Step 2: Opps, Kaji has interpreted it as one single module with the name of `cs2113t cs2101`, instead of two seperate modules. <br> 
<p align="center">
  <img src="UG_Images/addModule6.png" alt="Add Module 6"/>
</p>

#### 3.1.2. Listing modules available: `list` 
(by Zeyu)

After adding modules to the admin, you can view the list of modules that you have for the admin by using the `list` command.

**Format:** `list`

Here are some key pointers:
* Do not need to add parameter `admin` after `list`.
* All list commands have the same command word `list`. 

<div style="page-break-after: always;"></div>

**Example:**

* Step 1: Type `list` into the command prompt and press `Enter` to execute it.<br>

<p align="center">
    <img src="UG_Images/list_module1.png" alt="List Module 1"/>
</p>

* Step 2: The result for the list of modules will be displayed as shown.<br>

<p align="center">
    <img src="UG_Images/list_module2.png" alt="List Module 2"/>
</p>

* After listing all modules, you can try all commands available in **Admin Level**.

#### 3.1.3. Editing a module name: `edit` 
(by Zeyu)

You can edit the name of an existing module from the list of modules by using the `edit` command, followed by the edited name of the module.

**Format:** `edit MODULE_INDEX MODULE_NAME`

Here are some key pointers:
* You can only edit content on the level below the one you are on.
* The `MODULE_INDEX` refers to the index number shown in the displayed content list.
* The `MODULE_INDEX` **must be a positive integer** 1, 2, 3, …
* The `MODULE_NAME` is the edited name of your module.

**Example:**

Let's say you want to edit the module name to `CS2113T` for the module `cs2113`.
* Step 1: Type `list` into the command prompt and press `Enter` to execute it.<br>

<p align="center">
    <img src="UG_Images/EditModule1.png" alt="Edit Module 1"/>
</p>

* Step 2: From the list of modules displayed, you can see that the module `MODULE_INDEX` is 1.<br>

<p align="center">
    <img src="UG_Images/EditModule2.png" alt="Edit Module 2"/>
</p>

* Step 3: Next, you can type `edit 1 CS2113T` into the command prompt and press `Enter` to execute it.<br>

<p align="center">
    <img src="UG_Images/EditModule3.png" alt="Edit Module 3"/>
</p>

* Step 4: After the module name has been successfully edited, the result will be displayed as shown.<br>

<p align="center">
    <img src="UG_Images/EditModule4.png" alt="Edit Module 4"/>
</p>

* After editing the module name, you can try all commands available in **Admin Level**.

#### 3.1.4. Removing a module: `remove` 
(by Jia Ern)

Removes a module from KAJI.

**Format:** `remove MODULE_INDEX`

Here are some key pointers:
* Removes the module based on the index provided.
* `MODULE_INDEX` refers to the index number shown in the current module list. 
* Index provided **must be a positive integer** 1, 2, 3, ...

<div style="page-break-after: always;"></div>

**Example:**

For instance, you are currently at the admin level and want to remove the module `CS2113T`, the steps to do so are shown below:
* Step 1: Enter the command `remove 1` to remove the first module in the list which in this case is `CS2113T`: <br>
<p align="center">
  <img src="UG_Images/RemoveMod1.PNG" width="600" alt="Remove Module 1"/>
</p>

* Step 2: The module as well as the chapters and flashcards in it are removed, and the output message below will be shown: <br>
<p align="center">
  <img src="UG_Images/RemoveMod2.PNG" width="600" alt="Remove Module 2"/>
</p>

#### 3.1.5. Accessing the module level: `go`
(by Jiayi)

Now you have learnt how to create, edit and delete the module deck, let's move to the next page. You can now access the module deck you have created by using the command `go MODULE_INDEX`.
**Format:** `go MODULE_INDEX`

Here are some key pointers:
* Kaji only allow access to the existing modules that are shown in the list, therefore, module that is deleted or has never been created will result in an error message.
* `MODULE_INDEX` **must be a positive integer** 1, 2, 3, ..., and must be a valid index number for a module as displayed from the list of module.

<div style="page-break-after: always;"></div>

**Example:**

In this example, you are going to access the module `CS2113T` that you have created in the previous sections.
Below are steps of using this `go` command:
* Step 1: Uses `list` command to check the index of the module that you would like to access. <br>
<p align="center">
  <img src="UG_Images/goModule1.png" alt="Go Module 1"/>
</p>
* Step 2: In this example, the module you would like to access is `CS2113T` and its index is `2` as shown as the diagram below. <br>
<p align="center">
  <img src="UG_Images/goModule2.png" alt="Go Module 2"/>
</p>
* Step 3: You can type `go 2` to access this module. <br>
<p align="center">
  <img src="UG_Images/goModule3.png" alt="Go Module 3"/>
</p>
* Step 4: As shown below, you are now at a module level named **CS2113T** <br>
<p align="center">
  <img src="UG_Images/goModule4.png" alt="Go Module 4"/>
</p>
* Step 5: You may double check your access using the command prompt directory displayed on top of `Enter command here:`. As shown as the diagram, your current access directory is under `Admin/CS2113T`. <br>
<p align="center">
  <img src="UG_Images/goModule5.png" alt="Go Module 5"/>
</p>

### 3.2. Module level
This section introduces the syntax and usages of the commands for the features that are available at the **Module Level**.<br>
Ensure that you are at the **Module Level** before trying the commands in the next few sections:<br>
<p align="center">
  <img src="UG_Images/ModuleLevel.png" width="600" alt="Module Level"/>
</p>

#### 3.2.1. Adding a chapter: `add`
(by Jiayi)

You are now at the module level! This command allows you to create a new chapter inside your current module deck. It belongs to the module level you are currently in. It is like preparing an empty paper to write notes for a lecture. Let's create a new chapter inside the module! <br>

**Format:** `add CHAPTER_NAME`
CHAPTER_NAME is the name of the new chapter that you would like to create, such as `Topic 1`, `Chapter 1` or `Newton's laws of motion`. 

Here are some key pointers:
* Similar to module, KAJI does not allow duplicate of chapter names, therefore, if the existing chapter has the same name as the new chapter, you will get an error message
* KAJI is not case-sensitive, therefore, a new chapter named `chapter`  will be treated equally to a module named `CHAPTER`. 

<div style="page-break-after: always;"></div>

**Example:**

In this example, you are going to add a new chapter called `Chapter 1`. <br>
Below are steps of using this `add` command: <br>
* Step 1: Enters the command `add Chapter 1` into the command prompt which your new chapter name comes after the key word `add`. <br>
<p align="center">
  <img src="UG_Images/addChapter1.png" alt="Add Chapter 1"/>
</p>
* Step 2: In Kaji, you can give new chapters a rate to pre-set its revision schedules. If you would like to keep it as fault state, you can simply enter `N`. To demonstrate this feature fully, you may enter `Y` to rate the new chapter and check out how will Kaji responses! <br>
<p align="center">
  <img src="UG_Images/addChapter2.png" alt="Add Chapter 2"/>
</p>
* Step 3: You choose to rate the new chapter from the previous step, therefore, you can rate your chapter as `Easy`, `Medium` or `Hard` by entering `E`, `M` and `H` as shown as the instruction given by Kaji. <br>
<p align="center">
  <img src="UG_Images/addChapter3.png" width="600" alt="Add Chapter 3"/>
</p>
* Step 4: You have just created a new chapter! Good Job! <br>
<p align="center">
  <img src="UG_Images/addChapter4.png" width="600" alt="Add Chapter 4"/>
</p>

#### 3.2.2. Listing chapters available: `list`
(by Zeyu)

After adding chapters to the module, you can view the list of chapters that you have for the module by using the `list` command.

**Format:** `list`

Here are some key pointers:
* Do not need to add parameter `module_name` after `list`.
* All list commands have the same command word `list`. 

**Example:**

* Step 1: Type `list` into the command prompt and press `Enter` to execute it.<br>

<p align="center">
    <img src="UG_Images/list_chapter1.png" width="600" alt="List Chapter 1"/>
</p>

* Step 2: The result for the list of chapters will be displayed as shown.<br>

<p align="center">
    <img src="UG_Images/list_chapter2.png" width="600" alt="List Chapter 2"/>
</p>

* After listing all chapters, you can try all commands available in **Module Level**.

<div style="page-break-after: always;"></div>

#### 3.2.3. Editing a chapter name: `edit`
(by Jane)

You can edit the name of an existing chapter from the list of chapters.
You can do so by using the `edit` command, followed by the edited name of the chapter.

**Format:** `edit CHAPTER_INDEX CHAPTER_NAME`

Here are some key pointers:
* `CHAPTER_INDEX` **must be a positive integer** 1, 2, 3, ...,
and must be a valid index number for a chapter as displayed from the list of chapters.
* `CHAPTER_NAME` is the edited name of your chapter.

**Example:**

Let's say you want to edit the chapter name to `Chapter 1` for the chapter `chap 1`.
* Step 1: Type `list` into the command prompt and press `Enter` to execute it.<br>
<p align="center">
  <img src="UG_Images/EditChapter1.png" width="600" alt="Edit Chapter 1"/>
</p>
* Step 2: From the list of chapters displayed, you can see that the chapter `CHAPTER_INDEX` is 1.<br>
<p align="center">
  <img src="UG_Images/EditChapter2.png" width="600" alt="Edit Chapter 2"/>
</p>
* Step 3: Next, you can type `edit 1 Chapter 1` into the command prompt and press `Enter` to execute it.<br>
<p align="center">
  <img src="UG_Images/EditChapter3.png" width="600" alt="Edit Chapter 3"/>
</p>

<div style="page-break-after: always;"></div>

* Step 4: After the chapter name has been successfully edited, the result will be displayed as shown.<br>
<p align="center">
  <img src="UG_Images/EditChapter4.png" width="600" alt="Edit Chapter 4"/>
</p>

#### 3.2.4. Removing a chapter: `remove`
(by Jia Ern)

Removes a chapter from KAJI.

**Format:** `remove CHAPTER_INDEX`

Here are some key pointers:
* Removes the chapter based on the index provided.
* `CHAPTER_INDEX` refers to the index number shown in the current chapter list. 
* Index provided **must be a positive integer** 1, 2, 3, ...

**Example:**

For instance, you are currently at the module level `CS2113T` and want to remove the chapter `Chapter 1`, the steps to do so are shown below:
* Step 1: Enter the command `remove 1` to remove the first chapter in the list which in this case is `Chapter 1`: <br>
<p align="center">
  <img src="UG_Images/RemoveChap1.PNG" width="600" alt="Remove Chapter 1"/>
</p>
* Step 2: The chapter and the flashcards in it are removed, and the output message below will be shown: <br>
<p align="center">
  <img src="UG_Images/RemoveChap2.PNG" width="600" alt="Remove Chapter 2"/>
</p>

<div style="page-break-after: always;"></div>

#### 3.2.5. Accessing the chapter level: `go` 
(by Yan An)

Proceeds to the Chapter Level with reference to one of the Chapters within the module.

**Format:** `go CHAPTER_INDEX`
 
**Example:**

For instance, you are currently in Module level `CS2113T` and want to head to Chapter level `Chapter 1` , the steps to do so are shown below:

<p align="center">
  <img src="UG_Images/moduleGoPrompt.png" width="700" alt="Go prompt"/>
</p>

* Step 1: Enter the command `go 1` and **press *[Enter]*** to head down to the Chapter level below: <br>

<p align="center">
  <img src="UG_Images/moduleGo.png" width="700" alt="Go Command"/>
</p>

* ***Upon completion***: This is what you will see:
    * You should return to the Admin level as shown below: <br>

<p align="center">
  <img src="UG_Images/moduleGoResult.png" width="700" alt="Go Result"/>
</p>

<div style="page-break-after: always;"></div>

#### 3.2.6. Returning to admin level: `back`
(by Yan An)

Returns to the Admin level.

**Format:** `back`

**Example:**

For instance, you are currently in Module level `CS2113T` and want to return to the Admin level, the steps to do so are shown below:

* Step 1: Enter the command `back`and **press *[Enter]*** to return to the previous level which is the Admin level: <br>

<p align="center">
  <img src="UG_Images/back.png" width="700" alt="Back Command"/>
</p>

* ***Upon completion***: This is what you will see:
    * You should return to the Admin level as shown below: <br>

<p align="center">
  <img src="UG_Images/backComplete.png" width="700" alt="Back Result"/>
</p>

#### 3.2.7. Starting a revision session: `revise`
(by Jia Ern)

Starts a revision session for a chapter.

**Format:** `revise CHAPTER_INDEX` 

Here are some key pointers: 
* Revision can only be done at module level. 
* Starts a revision based on the index provided. 
* The index refers to the index number shown in the chapter list for the module level you are currently in.  
* Index provided **must be a positive integer** 1, 2, 3, ...

<div style="page-break-after: always;"></div>

**Example:**

For instance, you are currently in the module level `CS2113T` and want to start a revision for `Chapter 1`, the steps to do so are shown below:
* Step 1: Enter the command `revise 1` to start a revision on the first chapter in the list which in this case is `Chapter 1`: <br>
<p align="center">
  <img src="UG_Images/Revise1.png" width="600" alt="Revise 1"/>
</p>
* Step 2: If the chapter is not due for revision yet, you will be shown the below message: <br>
<p align="center">
  <img src="UG_Images/Revise2.PNG" width="600" alt="Revise 2"/>
</p>
* Step 3: Enter `Y` to start the revision.<br>
<p align="center">
  <img src="UG_Images/Revise3.PNG" width="600" alt="Revise 3"/>
</p>
* Step 4: The message below will be shown at the start of the revision: <br>
<p align="center">
  <img src="UG_Images/Revise4.PNG" width="600" alt="Revise 4"/>
</p>
* Step 5: The question of the flashcard will be shown as well: <br>
<p align="center">
  <img src="UG_Images/Revise5.PNG" width="600" alt="Revise 5"/>
</p>
* Step 6: Enter `s` to see the answer for the flashcard: <br>
<p align="center">
  <img src="UG_Images/Revise6.PNG" width="600" alt="Revise 6"/>
</p>
* Step 7: Based on the difficulty of the flashcard, you may enter either `e`/`m`/`h`/`c` to rate the flashcard as shown below: <br>
<p align="center">
  <img src="UG_Images/Revise7.PNG" width="600" alt="Revise 7"/>
</p>
* Step 8: If you entered `c`, the same flashcard will be shown again after your last flashcard, and the process will repeat until you enter `e`/`m`/`h` for the particular flashcard you could not answer for. <br>
* Step 9: Once all the flashcards have been revised, the output message below will be shown: <br>
<p align="center">
  <img src="UG_Images/Revise8.PNG" width="600" alt="Revise 8"/>
</p>

#### 3.2.8. Rescheduling a chapter: `reschedule`
(by Jane)

You can reschedule the due date of an existing chapter from the list of chapters.
Rescheduling a chapter allows you to reschedule a chapter to an earlier or later date than the specified due date.
You can do so by using the `reschedule` command, followed by the due date that you want to reschedule the chapter to.

**Format:** `reschedule CHAPTER_INDEX DATE`

Here are some key pointers:
* `CHAPTER_INDEX` **must be a positive integer** 1, 2, 3, ...,
and must be a valid index number for a chapter as displayed from the list of chapters.
* `DATE` is the rescheduled due date of your chapter.
* `DATE` should be in the format `yyyy-MM-dd`.

**Example:**

Let's say you want to reschedule the due date to `2020-12-20` for the chapter `Chapter 1`.
* Step 1: Type `list` into the command prompt and press `Enter` to execute it.<br>
<p align="center">
  <img src="UG_Images/RescheduleChapter1.png" width="600" alt="Reschedule Chapter 1"/>
</p>
* Step 2: From the list of chapters displayed, you can see that the chapter `CHAPTER_INDEX` is 1.<br>
<p align="center">
  <img src="UG_Images/RescheduleChapter2.png" width="600" alt="Reschedule Chapter 2"/>
</p>
* Step 3: Next, you can type `reschedule 1 2020-12-20` into the command prompt and press `Enter` to execute it.<br>
<p align="center">
  <img src="UG_Images/RescheduleChapter3.png" width="600" alt="Reschedule Chapter 3"/>
</p>
* Step 4: After the due date of the chapter has been successfully rescheduled, the result will be displayed as shown.<br>
<p align="center">
  <img src="UG_Images/RescheduleChapter4.png" width="600" alt="Reschedule Chapter 4"/>
</p>

### 3.3. Chapter Level
This section introduces the syntax and usages of the commands for the features that are available at the **Chapter Level**.<br>
Ensure that you are at the **Chapter Level** before trying the commands in the next few sections:<br>
<p align="center">
  <img src="UG_Images/ChapterLevel.png" width="600" alt="Chapter Level"/>
</p>

#### 3.3.1. Adding a flashcard: `add`
(by Jane)

After adding a new chapter, the first thing you might want to do is to add a flashcard to the chapter.
You can do so by using the `add` command, followed by the details of the flashcard.

**Format:** `add q:QUESTION | a:ANSWER`

<div style="page-break-after: always;"></div>

Here are some key pointers:
* `QUESTION` is the question of your flashcard.
* `ANSWER` is the answer of your flashcard.
* You need to type `q:` before the `QUESTION` parameter. 
* You need to type `a:` before the `ANSWER` parameter.
* Having `|` between `q:QUESTION` and `a:ANSWER` is required.

**Example:**

Let's say you want to add a new flashcard with `1+1` as the `QUESTION` and `2` as the `ANSWER`:
* Step 1: Type `add q:1+1 | a:2` into the command prompt and press `Enter` to execute it.<br>
<p align="center">
  <img src="UG_Images/AddCard1.png" width="600" alt="Add Card 1"/>
</p>
* Step 2: After the flashcard has been successfully added to the chapter, the result will be displayed as shown.<br>
<p align="center">
  <img src="UG_Images/AddCard2.png" width="600" alt="Add Card 2"/>
</p>

#### 3.3.2. Listing flashcards available: `list`
(by Jane)

After adding flashcards to the chapter, you can view the list of flashcards that you have for the chapter.
You can do so by using the `list` command.

**Format:** `list`

Here are some key pointers:
* You cannot type in any parameters after the `list` command.

<div style="page-break-after: always;"></div>

**Example:**

Let's say you want to view all the flashcards for a chapter:
* Step 1: Type `list` into the command prompt and press `Enter` to execute it.<br>
<p align="center">
  <img src="UG_Images/ListCard1.png" width="600" alt="List Card 1"/>
</p>
* Step 2: The result for the list of flashcards will be displayed as shown.<br>
<p align="center">
  <img src="UG_Images/ListCard2.png" width="600" alt="List Card 2"/>
</p>

#### 3.3.3. Editing a flashcard content: `edit`
(by Jane)

You can edit the question and/or answer of an existing flashcard from the list of flashcards.
You can do so by using the `edit` command, followed by the details of the flashcard.

**Format:** <br>
* Editing question and answer: `edit FLASHCARD_INDEX q:QUESTION | a:ANSWER`<br>
* Editing question only: `edit FLASHCARD_INDEX q:QUESTION | a:`<br>
* Editing answer only: `edit FLASHCARD_INDEX q: | a:ANSWER`<br>

Here are some key pointers:
* `FLASHCARD_INDEX` **must be a positive integer** 1, 2, 3, ...,
and must be a valid index number for a flashcard as displayed from the list of flashcards.
* `QUESTION` is the edited question of your flashcard.
* `ANSWER` is the edited answer of your flashcard.
* You need to type `q:` before the `QUESTION` parameter. 
* You need to type `a:` before the `ANSWER` parameter.
* Having `|` between `q:QUESTION` and `a:ANSWER` is required.
* If the question or answer of your flashcard does not need to be edited,
you do not need to type any content for the parameter `QUESTION` or `ANSWER`.

<div style="page-break-after: always;"></div>

**Example:**

Let's say you want to edit the question to `2*1` for the flashcard that has `1+1` as the question and `2` as the answer.
* Step 1: Type `list` into the command prompt and press `Enter` to execute it.<br>
<p align="center">
  <img src="UG_Images/EditCard1.png" width="600" alt="Edit Card 1"/>
</p>
* Step 2: From the list of flashcards displayed, you can see that the flashcard `FLASHCARD_INDEX` is 1.<br>
<p align="center">
  <img src="UG_Images/EditCard2.png" width="600" alt="Edit Card 2"/>
</p>
* Step 3: Next, you can type `edit 1 q:2*1 | a:` into the command prompt and press `Enter` to execute it.<br>
<p align="center">
  <img src="UG_Images/EditCard3.png" width="600" alt="Edit Card 3"/>
</p>
* Step 4: After the flashcard has been successfully edited, the result will be displayed as shown.<br>
<p align="center">
  <img src="UG_Images/EditCard4.png" width="600" alt="Edit Card 4"/>
</p>

#### 3.3.4. Removing a flashcard: `remove`
(by Jia Ern)

Removes a flashcard from KAJI.

**Format:** `remove FLASHCARD_INDEX`

<div style="page-break-after: always;"></div>

Here are some key pointers:
* Removes the flashcard based on the index provided.
* `FLASHCARD_INDEX` refers to the index number shown in the current flashcard list. 
* Index provided **must be a positive integer** 1, 2, 3, ...

**Example:**

For instance, you are currently at the chapter level `Chapter 1` and want to remove the flashcard `[Q] 1+1 | [A] 2`, the steps to do so are shown below:
* Step 1: Enter the command `remove 1` to remove the first flashcard in the list which in this case is `[Q] 1+1 | [A] 2`: <br>
<p align="center">
  <img src="UG_Images/RemoveCard1.PNG" width="600" alt="Remove Card 1"/>
</p>
* Step 2: The flashcard is removed, and the output message below will be shown: <br>
<p align="center">
  <img src="UG_Images/RemoveCard2.PNG" width="600" alt="Remove Card 2"/>
</p>

#### 3.3.5. Returning to module level: `back`
(by Jia Ern)

Returns to the module level.

**Format:** `back`
 
**Example:**

For instance, you are currently in chapter level `Chapter 1` and want to return to the module level `CS2113T`, the steps to do so are shown below:
* Step 1: Enter the command `back` to return to the previous level which is the module level: <br>
<p align="center">
  <img src="UG_Images/BackMod1.PNG" width="600" alt="Back Module 1"/>
</p>

<div style="page-break-after: always;"></div>

* Step 2: You should return to the module level as shown below: <br>
<p align="center">
  <img src="UG_Images/BackMod2.PNG" width="600" alt="Back Module 2"/>
</p>

#### 3.3.6. Checking overall performance for a chapter: `showrate`
(by Jiayi)

Congratulations! You have learnt how to add flashcards and revise your flash cards, and now is the time to **check your overall performance** for a chapter. <br>

It is very simple, all you have to do is to enter the command [`showrate`](#) in prompt. <br>

**Format:** `showrate`

Here are some key pointers:
* This command is only accessible in the chapter level. You will get an error message if you are in the wrong access level.
* Only overall performance of your current chapter level will be computed.
* Cards that has yet be answered will be label as <cannot answer>, therefore, if you find a `1.0` for `the percentage of cards that is labeled <cannot answer>`, don't panic, it will be updated as soon as you finish your first revision session of this particular chapter.
>:information_source: <b>Note:</b> As you now know, it is the level which you can add/edit/delete cards.

**Example:** 

For instance, you would like to check your overall performance after completing several rounds of revision. <br>
Below are steps of using this `showrate` command: <br>
* Step 1: Type "showrate" into the command prompt while you are in a chapter level. <br>
<p align="center">
  <img src="UG_Images/showrate1.png" alt="Show rate 1"/>
</p>

<div style="page-break-after: always;"></div>

* Step 2: Kaji calculates the percentage of card in different master level (i.e. `easy`, `medium`, `hard` and `cannot answer`). <br>
<p align="center">
  <img src="UG_Images/showrate2.png" alt="Show rate 2"/>
</p>

### 3.4 Scheduling in KAJI
(by Yan An)

Now that you know how to make KAJI manage your Database of revision content for you, **what about scheduling?** For your benefit, the **scheduling** in KAJI is mostly **automated**! 

**You don't have to do a thing** to enjoy the benefits of Spaced Repetition. Everything is scheduled for you, so all you have to do is to use the commands `due` and `preview` to view what chapters are due and complete the revision  for them accordingly. 

Despite that, this **does not mean that you cannot customise** the scheduling process. KAJI allows you to `reschedule`, `include` and `exclude` Chapters manually if you wish to do so, but more on that later. First, let us get into the specific introduction of each command.

### 3.4.1. Listing the chapters due for today: `due`
(by Yan An)

As you now know, **each Chapter will be scheduled** to be due on a date. However, it will be **tedious** for you to go through each chapter **one by one** to find their deadlines. Our **solution** to that, is the `due` command.

The `due` command simplifies the process for by **showing you the Chapters that you have scheduled on that day** and the Modules they belong to.
<br><br>


**Format:** `due`


Here are some key pointers:
* There are **no parameters** for this command.
* This command can be **called from any Level**

<div style="page-break-after: always;"></div>

**Example:**
 
At any point, if you want to **see what Chapters are due**, all you have to do is enter the `due` command. Below is an example of an execution of the `due` command.

* ***Step 1***: Key the **`due`** command **into the prompt** as shown below and **press *[Enter]***

<p align="center">
  <img src="UG_Images/due.png" width="700" alt="Due Command"/>
</p>

* ***Upon completion***: This is what you will see:

<p align="center">
  <img src="UG_Images/dueComplete.png" width="700" alt="Due Command Result"/>
</p>

### 3.4.2. Listing the chapters that are due in the upcoming week: `preview`
(by Yan An)

Beyond simply being able to view the Chapters that are due on the day itself, what if you would like to **view your upcoming revision schedule** so that you can **plan ahead**? For that specific purpose, we have the `preview` command.

The `preview` command shows you **the Chapters that you have scheduled for each day of the upcoming week** and the Modules that they belong to.
<br>

**Format:** `preview`

Here are some key pointers:
* There are **no parameters** for this command.
* This command can be **called from any Level**


**Example:** 

At any point, if you **want to see a preview of which Chapters are going to be due within the upcoming week**, all you have to do is enter the `preview` command. Below is an example of an execution of the `preview` command.

<div style="page-break-after: always;"></div>

* ***Step 1***: Key the **`preview`** command **into the prompt** as shown below and **press *[Enter]***

<p align="center">
  <img src="UG_Images/preview.png" width="700" alt="Preview Command"/>
</p>

* ***Upon completion***: This is what you will see:

<p align="center">
  <img src="UG_Images/previewComplete.png" width="700" alt="Preview Command Result"/>
</p>

### 3.4.3. Adding chapters to your list of excluded modules: `exclude`
(by Yan An)

Apart from viewing your schedule, what if the Semester has ended and you would like to take a Module or Chapter out of your schedule? If you were to remove the files from your database completely, it would be really tedious to add the content back Card by Card. Therefore, we created the `exclude` command.

The `exclude` command allows you to **add** a single Chapter or every Chapter from a Module to your Exclusion list so that you can **remove these items** from your schedule.
<br>

**Format:** `exclude MODULE_OR_CHAPTER`
The `exclude` command has two options for MODULE_OR_CHAPTER:
* ***module***: This option allows you to use `exclude` to add all the Chapters from a Module into the Exclusion List.
* ***chapter***: This option allows you to use `exclude` to add a Chpater into the Exclusion List.


Here are some key pointers:
* This command can be **called from any Level**
* This command **checks if the Chapter/Module** you are adding into the Exclusion List **exists**, so the List will not be filled with non-existing exclusions.
* Do note that the name of the Chapter/Module you provide has to be in the correct case as our check is **case-sensitive**.

<div style="page-break-after: always;"></div>

**Example:**

At any point, if you would like to **add to your Exclusion List**, all you have to do is enter the `exclude` command with the choice of "module" or "chapter" in the format specified above. Below are examples of the execution of the `exclude` command using both options.

Example of ***`exclude module`***
* ***Step 1***: Key the **`exclude module`** command **into the prompt** as shown below and **press *[Enter]***

<p align="center">
  <img src="UG_Images/excludeModule.png" width="700" alt="Exclude Command Module mode: Command"/>
</p>

* ***Step 2***: Key the **Module name** that you wish to exclude from your schedule **into the prompt** as shown below and **press *[Enter]***

<p align="center">
  <img src="UG_Images/excludeModuleModule.png" width="700" alt="Exclude Command Module mode: ModuleName Filled"/>
</p>

* ***Upon completion***: This is what you will see:

<p align="center">
  <img src="UG_Images/excludeModuleResult.png" width="900" alt="Exclude Command Module mode: Result"/>
</p>

Example of ***`exclude chapter`***
* ***Step 1***: Key the **`exclude chapter`** command **into the prompt** as shown below and **press *[Enter]***

<p align="center">
  <img src="UG_Images/excludeChapter.png" width="700" alt="Exclude Command Chapter mode: ChapterName Command"/>
</p>

<div style="page-break-after: always;"></div>

* ***Step 2***: Key the **Module name** of the Module that contains Chapter that you wish to exclude from your schedule **into the prompt** as shown below and **press *[Enter]***

<p align="center">
  <img src="UG_Images/excludeChapterModule.png" width="700" alt="Exclude Command Module mode: ModuleName Prompt"/>
</p>

* ***Step 3***: Key the **Chapter name** that you wish to exclude from your schedule **into the prompt** as shown below and **press *[Enter]***

<p align="center">
  <img src="UG_Images/excludeChapterChapter.png" width="700" alt="Exclude Command Chapter mode: ChapterName Filled"/>
</p>

* ***Upon completion***: This is what you will see:

<p align="center">
  <img src="UG_Images/excludeChapterResult.png" width="900" alt="Exclude Command Chapter mode: Result"/>
</p>

### 3.4.4. Removing chapters from the list of excluded modules: `include`
(by Yan An)

However, what should be done if you had excluded the Chapters of a Module from your schedule, only to find that it is a prerequisite for another module the next semester. To prepare for the upcoming semester, you would like to revise the excluded content again. This is why we created the `include` command.

The `include` command allows you to **remove** a single Chapter or every Chapter from a Module from your Exclusion list so that you can **add these items** back into your schedule.
<br>

**Format:** `include MODULE_OR_CHAPTER`
The `include` command has two options for MODULE_OR_CHAPTER:
* ***module***: This option allows you to use `include` to remove all the Chapters from a Module from the Exclusion List.
* ***chapter***: This option allows you to use `include` to remove a Chpater from the Exclusion List.

<div style="page-break-after: always;"></div>

Here are some key pointers:
* This command can be **called from any Level**
* Do note that the name of the Chapter/Module you provide has to be in the correct case as our check is **case-sensitive**.

**Example:**

At any point, if you wish to **remove from your Exclusion List**, you can either enter the `include` command with the choice of either "chapter" or "module" in the format specified above. Below are examples of the command's execution using both options.

Example of ***`include module`***
* ***Step 1***: Key the **`include module`** command **into the prompt** as shown below and **press *[Enter]***

<p align="center">
  <img src="UG_Images/includeModule.png" width="700" alt="Include Command Module mode: ModuleName Command"/>
</p>

* ***Step 2***: Key the **Module name** that you wish to include back into your schedule **into the prompt** as shown below and **press *[Enter]***

<p align="center">
  <img src="UG_Images/includeModuleModule.png" width="700" alt="Include Command Module mode: ModuleName Filled"/>
</p>

* ***Upon completion***: This is what you will see:

<p align="center">
  <img src="UG_Images/includeModuleResult.png" width="900" alt="Include Command Module mode: Result"/>
</p>

<div style="page-break-after: always;"></div>

Example of ***`include chapter`***
* ***Step 1***: Key the **`include chapter`** command **into the prompt** as shown below and **press *[Enter]***

<p align="center">
  <img src="UG_Images/includeChapter.png" width="700" alt="Include Command Chapter mode: ChapterName Command"/>
</p>

* ***Step 2***: Key the **Module name** of the Module that contains the Chapter that you wish to include back into your schedule **into the prompt** as shown below and **press *[Enter]***

<p align="center">
  <img src="UG_Images/includeChapterModule.png" width="700" alt="Include Command Chapter mode: ModuleName Prompt"/>
</p>

* ***Step 3***: Key the **Chapter name** that you wish to include back into your schedule **into the prompt** as shown below and **press *[Enter]***

<p align="center">
  <img src="UG_Images/includeChapterChapter.png" width="700" alt="Include Command Chapter mode: ChapterName Prompt"/>
</p>

* ***Upon completion***: This is what you will see:

<p align="center">
  <img src="UG_Images/includeChapterResult.png" width="900" alt="Include Command Chapter mode: Result"/>
</p>

<div style="page-break-after: always;"></div>

### 3.5. General
This section introduces the syntax and usages of the commands for the features that are available at **All Levels**.<br>
You can use the commands in the next few sections at **Admin, Module and Chapter Level.**

#### 3.5.1. Showing a list of commands available: `help`
(by Zeyu)

If you forget the format of some commands, you can find a list of commands available by using `help` command.

**Format:** `help`

Here is a key point:
* This command can be **called from any Level**.

**Example:** 

* Step 1: Type `help` into the command prompt and press `Enter` to execute it.<br>

<p align="center">
    <img src="UG_Images/help1.png" width="600" alt="Help 1"/>
</p>

* Step 2: Part the result for the list of commands will be displayed as shown.<br>

<p align="center">
    <img src="UG_Images/help2.png" width="600" alt="Help 2"/>
</p>

* After knowing what are the commands, you can try any commands on the correct level.

#### 3.5.2. Viewing the revision history: `history`
(by Zeyu)

You can view the revision completed in the session/in a day by using `history` command.

**Format:**<br>
`history`<br>
`history DATE`<br>

Here are some key pointers:
* This command can be **called from any Level**.
* If you enter `history`, Kaji will show the revision completed today (the day you enter `history`).
* If you enter `history DATE`, the `DATE` need to be in the format of yyyy-mm-dd, then Kaji will show the revision completed on the given date.

**Example:** 

Let's say today is 2020-11-09 and you want to view the revision history today:
* Step 1: Type `history` or `history 2020-11-09` into the command prompt and press `Enter` to execute it.<br>

<p align="center">
    <img src="UG_Images/history1.png" alt="History 1"/>
</p>

* Step 2: The result for the list of history will be displayed as shown.<br>

<p align="center">
    <img src="UG_Images/history2.png" alt="History 2"/>
</p>

<div style="page-break-after: always;"></div>

* If you have not revised on 2020-11-09 this result will be displayed.<br>

<p align="center">
    <img src="UG_Images/history3.png" alt="History 3"/>
</p>

* After knowing the revision you have completed, you can try any commands on the correct level.

#### 3.5.3. Exiting the program: `exit`
(by Zeyu)

You can exit Kaji by using this command.

**Format:** `exit`

**Example:** 

* Step 1: Type `exit` into the command prompt and press `Enter` to execute it.<br>

<p align="center">
    <img src="UG_Images/exit1.png" alt="Exit 1"/>
</p>

* Step 2: The result for the exit will be displayed as shown.<br>

<p align="center">
    <img src="UG_Images/exit2.png" alt="Exit 1"/>
</p>


--------------------------------------------------------------------------------------------------------------------
<div style="page-break-after: always;"></div>

## 4. Command Summary

### 4.1. Admin Level

| Action | Format, Examples |
|--------|------------------|
| Add Module | `add MODULE_NAME` <br> e.g. `add CS2113T` |
| List Modules | `list` |
| Edit Module Name | `edit MODULE_INDEX MODULE_NAME` <br> e.g. `edit 1 CS2113` |
| Remove Module | `remove MODULE_INDEX` <br> e.g. `remove 1` |
| Access Module Level | `go MODULE_NAME` <br> e.g. `go CS2113` |

### 4.2. Module Level

| Action | Format, Examples |
|--------|------------------|
| Add Chapter | `add CHAPTER_NAME` <br> e.g. `add Chapter 1` |
| List Chapters | `list` |
| Edit Chapter Name | `edit INDEX CHAPTER_NAME` <br> e.g. `edit 1 Chapter 1` |
| Remove Chapter | `remove CHAPTER_INDEX` <br> e.g. `remove 1` |
| Access Chapter Level | `go CHAPTER_NAME` <br> e.g. `go Chapter 1` |
| Return Admin Level | `back` |
| Revise | `revise CHAPTER_INDEX` <br> e.g. `revise Chapter 1` |
| Reschedule | `reschedule CHAPTER_INDEX DATE` <br> e.g. `reschedule 1 2020-11-03` |

### 4.3. Chapter Level

| Action | Format, Examples |
|--------|------------------|
| Add Flashcard | `add q:QUESTION | a:ANSWER` <br> e.g. `add q:1+1 | a:2` |
| List Flashcards | `list` |
| Edit Flashcard | `edit FLASHCARD_INDEX q:QUESTION | a:ANSWER` <br> e.g. `edit 1 q:2*1 | a:2` |
| Remove Flashcard | `remove FLASHCARD_INDEX` <br> e.g. `remove 1` |
| Return Module Level | `back` |
| Show Rate | `showrate` |

### 4.4. Scheduling in KAJI

| Action | Format, Examples |
|--------|------------------|
| List Due Chapters | `due` |
| Preview | `preview` |
| Exclude | `exclude MODULE_OR_CHAPTER` <br> e.g. `exclude module` or `exclude chapter` |
| Include | `include MODULE_OR_CHAPTER` <br> e.g. `include module` or `include chapter` |

<div style="page-break-after: always;"></div>

### 4.5. General

| Action | Format, Examples |
|--------|------------------|
| Help | `help` |
| Show Revision History | `history` or `history DATE` <br> e.g. `history 2020-11-03` |
| Exit | `exit` |