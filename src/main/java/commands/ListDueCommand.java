package commands;

import access.Access;

import manager.chapter.DueChapter;

import scheduler.Scheduler;
import storage.Storage;
import ui.Ui;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListDueCommand extends Command {
    public static final String COMMAND_WORD = "due";
    public ArrayList<DueChapter> allChapters;
    public ArrayList<DueChapter> dueChapters;

    private void loadAllChapters(Storage storage, Ui ui) {
        try {
            allChapters = storage.loadAllDueChapters();
        } catch (FileNotFoundException e) {
            ui.showToUser(Ui.UNABLE_TO_LOAD_EMPTY_DATABASE);
        }
    }

    private void setDueChapters() {
        for (DueChapter chapter : allChapters) {
            LocalDate deadline = chapter.getChapter().getDueBy();
            if (Scheduler.isDeadlineDue(deadline)) {
                dueChapters.add(chapter);
            }
        }
    }

    @Override
    public void execute(Ui ui, Access access, Storage storage) {
        dueChapters = new ArrayList<>();
        loadAllChapters(storage, ui);
        setDueChapters();
        ui.printDueByTodayMessage(dueChapters.size(), COMMAND_WORD);
        ui.printDueChapters(dueChapters);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

