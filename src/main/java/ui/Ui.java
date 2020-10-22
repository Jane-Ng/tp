package ui;

import access.Access;

import commands.AddCommand;
import commands.BackCommand;
import commands.EditCommand;
import commands.ExitCommand;
import commands.GoCommand;
import commands.HelpCommand;
import commands.ListCommand;
import commands.ListDueCommand;
import commands.RateCommand;
import commands.RemoveCommand;
import commands.RescheduleCommand;
import commands.ReviseCommand;
import commands.ShowRateCommand;
import manager.card.Card;
import manager.chapter.DueChapter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static commands.ReviseCommand.MESSAGE_SHOW_ANSWER_PROMPT;
import static common.Messages.LINE;

public class Ui {
    public static final String UNABLE_TO_LOAD_EMPTY_DATABASE = "Sorry, you do not have any flashcards in the database"
            + "yet. Please try this command again once you have added some flashcards!";
    private final Scanner in;
    private final PrintStream out;

    public Ui() {
        this(System.in, System.out);
    }

    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public static boolean chooseToRateNewDeck() {
        System.out.println("Would you like to rate this new Chapter? (Y/N)");
        Ui ratingUi = new Ui();
        String userChoice = ratingUi.readCommand();
        while (!userChoice.equalsIgnoreCase("Y") && !userChoice.equalsIgnoreCase("N")) {
            ratingUi.showToUser("Sorry, that is not a valid input. Please enter \"Y\" or \"N\"");
            userChoice = ratingUi.readCommand();
        }
        return userChoice.equalsIgnoreCase("Y");
    }

    public static boolean validDeckRating(String rating) {
        switch (rating.toUpperCase()) {
        case "E":
        case "M":
        case "H":
            return true;
        default:
            return false;
        }
    }

    public static String getChoiceOfNewDeckRating() {
        System.out.println("Please rate this new Chapter!");
        System.out.println("You have the options of: Easy(E), Medium(M) or Hard(H)");
        System.out.println("Would your choice be E, M or H?");
        Ui ratingUi = new Ui();
        String userChoice = ratingUi.readCommand();
        while (!validDeckRating(userChoice)) {
            userChoice = ratingUi.readCommand();
        }
        return userChoice.toUpperCase();
    }

    public String readCommand() {
        String userCommand = in.nextLine();
        while (userCommand.trim().isEmpty()) {
            userCommand = in.nextLine();
        }
        return userCommand;
    }

    public void showWelcome() {
        out.println("Welcome to Kaji!\n");
    }

    public void showLevel(Access access) {
        out.println(access.getLevel());
    }

    public void printLine() {
        out.println(LINE);
    }

    public void showToUser(String message) {
        out.println(message);
    }

    public void showCardRevision(Card c) {
        out.println(c.getQuestion() + MESSAGE_SHOW_ANSWER_PROMPT);
        getAnswerInput(c);
    }

    public void getAnswerInput(Card c) {
        String input = in.nextLine();
        while (!input.trim().equalsIgnoreCase("s")) {
            out.println("You have entered an invalid input, please try again.");

            input = in.nextLine();
        }
        out.println(c.getAnswer());
    }

    public String getInput(String prompt) {
        out.println(prompt);
        return in.nextLine();
    }

    public void showExit() {
        out.println("Exiting the program...");
    }

    public void showHelpList() {
        out.println("Here is a list of commands available:" + "\n");
        out.println("1. " + ListCommand.MESSAGE_USAGE);
        out.println("2. " + ReviseCommand.MESSAGE_USAGE);
        out.println("3. " + HelpCommand.MESSAGE_USAGE);
        out.println("4. " + AddCommand.MESSAGE_USAGE);
        out.println("5. " + ExitCommand.MESSAGE_USAGE);
        out.println("6. " + EditCommand.MESSAGE_USAGE);
        out.println("7. " + RemoveCommand.MESSAGE_USAGE);
        out.println("8. " + GoCommand.MESSAGE_USAGE);
        out.println("9. " + BackCommand.MESSAGE_USAGE);
        out.println("10. " + ListDueCommand.MESSAGE_USAGE);
        out.println("11. " + RateCommand.MESSAGE_USAGE);
        out.println("12. " + ShowRateCommand.MESSAGE_USAGE);
        out.println("13. " + RescheduleCommand.MESSAGE_USAGE);
    }

    public void showError(String error) {
        out.println(error);
    }

    public void printDueChapters(ArrayList<DueChapter> dueChapters) {
        for (DueChapter dueChapter : dueChapters) {
            showToUser("\t-" + dueChapter.toString());
        }
    }

    public void printDueByTodayMessage(int listSize, String commandType) {
        if (listSize == 0) {
            showToUser("You have no tasks due today!");
            if (commandType.equals("due")) {
                showToUser("Please use the \"preview\" command to view upcoming tasks or check back again tomorrow!");
            }
            return;
        }
        System.out.print("The chapter");
        if (listSize > 1) {
            System.out.print("s");
        }
        System.out.print(" you have due by today ");
        if (listSize > 1) {
            showToUser("are:");
        } else {
            showToUser("is:");
        }
    }

    public void printDueByIncrementMessage(int listSize, String incrementedDueBy) {
        if (listSize == 0) {
            showToUser("You have no tasks due on " + incrementedDueBy + "!");
            return;
        }
        System.out.print("The chapter");
        if (listSize > 1) {
            System.out.print("s");
        }
        System.out.print(" you have due by " + incrementedDueBy + " ");
        if (listSize > 1) {
            showToUser("are:");
        } else {
            showToUser("is:");
        }

    }
}
