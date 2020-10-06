package ui;

import manager.card.Card;
import manager.chapter.Chapter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

import static commands.ReviseCommand.MESSAGE_NO_CARDS_DUE;
import static commands.ReviseCommand.MESSAGE_NO_CARDS_IN_CHAPTER;
import static commands.ReviseCommand.MESSAGE_SHOW_ANSWER_PROMPT;
import static commands.ReviseCommand.MESSAGE_SUCCESS;

public class Ui {
    private final Scanner in;
    private final PrintStream out;

    public Ui() {
        this(System.in, System.out);
    }

    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public String readCommand() {
        String userCommand = in.nextLine();
        while (userCommand.trim().isEmpty()) {
            userCommand = in.nextLine();
        }
        return userCommand;
    }

    public void showWelcome() {
        out.println("Welcome to Kaji!");
    }

    public void showCardAdded(Card card, int cardCount) {
        out.println("Got it. I've added this card:");
        out.println(card);
        if (cardCount == 1) {
            out.println("Now you have " + cardCount + " card in the list.");
            return;
        }
        out.println("Now you have " + cardCount + " cards in the list.");
    }

    public void showCardList(ArrayList<Card> cards, int cardCount) {
        if (cardCount == 0) {
            out.println("There are no cards in your list.");
            return;
        }
        out.println("Here are the cards in your list:");
        for (Card c : cards) {
            out.println((cards.indexOf(c) + 1) + "." + c);
        }
    }

    public void showRevisionContent(ArrayList<Card> cards, int cardCount, Chapter toRevise) {
        if (cardCount == 0) {
            out.println(String.format(MESSAGE_NO_CARDS_IN_CHAPTER, toRevise));
            return;
        }
        out.println("The revision for " + toRevise + " will start now:");
        boolean isEqualsDate = false;
        for (Card c : cards) {
            if (c.getDate().equals(LocalDate.now())) {
                isEqualsDate = true;
                out.println(c.getQuestion() + MESSAGE_SHOW_ANSWER_PROMPT);
                getAnswerInput(c);
            }
        }
        if (!isEqualsDate) {
            out.println(String.format(MESSAGE_NO_CARDS_DUE, toRevise));
        }
        out.println(String.format(MESSAGE_SUCCESS, toRevise));
    }

    public void getAnswerInput(Card c) {
        String input = in.nextLine();
        while (!input.equalsIgnoreCase("s")) {
            out.println("You have entered an invalid input, please try again.");
            input = in.nextLine();
        }
        out.println(c.getAnswer());
    }

    public void showExit() {
        out.println("Exiting the program...");
    }
}
