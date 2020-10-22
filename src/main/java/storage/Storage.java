package storage;

import access.Access;
import exception.ExclusionFileException;
import exception.InvalidFileFormatException;
import manager.card.Card;
import manager.history.History;
import manager.chapter.CardList;
import manager.chapter.Chapter;
import manager.chapter.DueChapter;
import parser.Parser;
import manager.module.Module;
import scheduler.Scheduler;
import ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    public static final String DELIMITER = " \\| ";
    public static final String QUESTION_PREFIX = "[Q]";
    public static final String ANSWER_PREFIX = "[A]";
    public static final String PREVIOUS_INTERVAL_PREFIX = "[P]";
    public static final String MESSAGE_CREATED = "Successfully created new %1$s %2$s\n";
    public static final String MESSAGE_EXISTS = "%1$s %2$s already exists\n";
    public static final String MESSAGE_MODULE_CHAPTER = "Module: %1$s ; Chapter: %2$s";

    public static final String FILE = "file";
    public static final String DIR = "directory";

    protected String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    //create the folder --> 'data/admin'
    public void createAdmin(Ui ui) {
        File f = new File(filePath);
        ui.showToUser("Filepath: " + filePath);

        boolean dataDirExists = f.getParentFile().exists();
        boolean dataDirCreated = false;
        if (!dataDirExists) {
            dataDirCreated = f.getParentFile().mkdir();
        } else {
            ui.showToUser(String.format(MESSAGE_EXISTS, DIR.substring(0,1).toUpperCase(),
                    f.getParentFile().getName()));
        }
        if (dataDirCreated) {
            ui.showToUser(String.format(MESSAGE_CREATED, DIR, f.getParentFile().getName()));
        }
        createHistoryDir();

        boolean adminDirExists = f.exists();
        boolean adminDirCreated = false;
        if (!adminDirExists) {
            adminDirCreated = f.mkdir();
        } else {
            ui.showToUser(String.format(MESSAGE_EXISTS, DIR.substring(0,1).toUpperCase(), f));
        }
        if (adminDirCreated) {
            ui.showToUser(String.format(MESSAGE_CREATED, DIR, f));
        }
    }

    public String createModule(String moduleName) {
        File f = new File(filePath + "/" + moduleName);
        boolean moduleDirExists = f.exists();
        boolean moduleDirCreated = false;
        String result = "";
        if (!moduleDirExists) {
            moduleDirCreated = f.mkdir();
        } else {
            result = String.format(MESSAGE_EXISTS, DIR.substring(0,1).toUpperCase(), f);
        }
        if (moduleDirCreated) {
            result = String.format(MESSAGE_CREATED, DIR, f);
        }
        return result;
    }

    public String createChapter(String chapterName, String moduleName) throws IOException {
        String result = "";

        File f = new File(filePath + "/" + moduleName + "/" + chapterName + ".txt");
        boolean chapterFileExists = f.exists();
        boolean chapterFileCreated = false;
        if (!chapterFileExists) {
            chapterFileCreated = f.createNewFile();
        } else {
            result = String.format(MESSAGE_EXISTS, FILE.substring(0,1).toUpperCase(), f);
        }
        if (chapterFileCreated) {
            result = String.format(MESSAGE_CREATED, FILE, f);
        }
        return result;
    }

    public ArrayList<Module> loadModule(Ui ui) throws FileNotFoundException {
        File f = new File(filePath);
        boolean dirExists = f.exists();
        if (!dirExists) {
            throw new FileNotFoundException();
        }

        ArrayList<Module> modules = new ArrayList<>();
        String[] contents = f.list();
        ui.showToUser("List of files and directories in the specified directory:");
        for (String content : contents) {
            if (content.equals("exclusions.txt")) {
                continue;
            }
            ui.showToUser(content);
            modules.add(new Module(content));
        }
        return modules;
    }

    public ArrayList<Chapter> loadChapter(String module, Ui ui) throws FileNotFoundException {
        File f = new File(filePath + "/" + module);
        boolean dirExists = f.exists();
        if (!dirExists) {
            throw new FileNotFoundException();
        }

        ArrayList<Chapter> chapters = new ArrayList<>();
        String[] contents = f.list();
        if (contents.length == 0) {
            return chapters;
        }
        ui.showToUser("List of files and directories in the specified directory:");
        for (String content : contents) {
            if (content.equals("dues")) {
                continue;
            }
            String target = content.replace(".txt", "");
            ui.showToUser(content);
            chapters.add(new Chapter(target));
        }
        return chapters;
    }

    public String[] loadChaptersFrom(String moduleName) throws FileNotFoundException {
        File file = new File(filePath + "/" + moduleName);
        boolean moduleExists = file.exists();
        if (!moduleExists) {
            throw new FileNotFoundException();
        }
        return file.list();
    }

    private String retrieveChapterDeadline(String moduleName, String chapterName) {
        File f = new File(filePath + "/" + moduleName + "/" + "dues" + "/" + chapterName + "due" + ".txt");
        try {
            Scanner s = new Scanner(f);
            if (s.hasNext()) {
                String deadline = s.nextLine();
                s.close();
                return deadline;
            } else {
                s.close();
                return "Invalid Date";
            }
        } catch (FileNotFoundException e) {
            return "Does not exist";
        }
    }

    private boolean missingDueFileCheck(String moduleName, String chapterName) {
        File f = new File(filePath + "/" + moduleName + "/" + chapterName + ".txt");
        return f.exists();
    }

    private ArrayList<String> loadExcludedFile() throws ExclusionFileException {
        File f = new File(getFilePath() + "/exclusions.txt");
        ArrayList<String> excludedChapters = new ArrayList<>();
        try {
            if (!f.exists()) {
                if (!f.createNewFile()) {
                    throw new ExclusionFileException();
                } else {
                    return new ArrayList<String>();
                }
            }
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                //to read the card
                String entry = s.nextLine();
                excludedChapters.add(entry);
            }
            s.close();
            return excludedChapters;
        } catch (IOException e) {
            throw new ExclusionFileException();
        }
    }

    public ArrayList<DueChapter> loadAllDueChapters(Ui ui) throws FileNotFoundException, ExclusionFileException {
        //Loading in Excluded Chapters
        ArrayList<String> excludedChapters = loadExcludedFile();
        //Loading in Modules
        File f = new File(filePath);
        boolean moduleExists = f.exists();
        if (!moduleExists) {
            throw new FileNotFoundException();
        }
        String[] modules = f.list();
        ArrayList<DueChapter> dueChapters = new ArrayList<>();
        for (String module : modules) {
            if (module.equals("exclusions.txt")) {
                continue;
            }
            //Loading in Chapters for each module
            File f2 = new File(filePath + "/" + module);
            boolean chapterExists = f2.exists();
            if (!chapterExists) {
                throw new FileNotFoundException();
            }
            String[] chapters = f2.list();
            if (chapters.length == 0) {
                return dueChapters;
            }
            for (String chapter : chapters) {
                String target = chapter.replace(".txt", "");
                String entry = "Module: " + module + "; Chapter: " + target;
                if (excludedChapters.contains(entry)) {
                    continue;
                }
                String deadline = retrieveChapterDeadline(module, target);
                assert !deadline.equals(null) : "Invalid deadline retrieved";
                if (deadline.equals("Invalid Date")) {
                    ui.showToUser("\nThe chapter:");
                    ui.showToUser(String.format(MESSAGE_MODULE_CHAPTER, module, target)
                            + " has a corrupted deadline. Please revise it ASAP! It will be considered due!\n");
                    dueChapters.add(new DueChapter(module, new Chapter(target, Scheduler.parseDate(deadline))));
                } else if (deadline.equals("Does not exist")) {
                    if (missingDueFileCheck(module, target)) {
                        deadline = "Invalid Date";
                        ui.showToUser("\nThe chapter:");
                        ui.showToUser(String.format(MESSAGE_MODULE_CHAPTER, module, target)
                                + " has a corrupted deadline. Please revise it ASAP! It will be considered due!\n");
                        dueChapters.add(new DueChapter(module, new Chapter(target, Scheduler.parseDate(deadline))));
                    }
                } else {
                    dueChapters.add(new DueChapter(module, new Chapter(target, Scheduler.parseDate(deadline))));
                }
            }
        }
        return dueChapters;
    }

    public void chapterExists(String moduleName, String chapterName) throws FileNotFoundException {
        File file = new File(filePath + "/" + moduleName + "/" + chapterName + ".txt");
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
    }

    public void updateExclusionFile(ArrayList<String> excludedChapters) throws ExclusionFileException {
        try {
            FileWriter fw = new FileWriter(getFilePath() + "/exclusions.txt");
            for (String excluded : excludedChapters) {
                fw.write(excluded + "\n");
            }
            fw.close();
        } catch (IOException e) {
            throw new ExclusionFileException("Sorry, there was an error in accessing the Exclusion File");
        }
    }

    public void appendModuleToExclusionFile(String moduleName) throws FileNotFoundException, ExclusionFileException {
        ArrayList<String> excludedChapters = loadExcludedFile();
        String[] chapters = loadChaptersFrom(moduleName);
        for (String chapter : chapters) {
            if (chapter.equals("dues")) {
                continue;
            }
            chapter = chapter.replace(".txt", "");
            String entry = "Module: " + moduleName + "; Chapter: " + chapter;
            if (!excludedChapters.contains(entry)) {
                excludedChapters.add(entry);
            }
        }
        updateExclusionFile(excludedChapters);
    }

    public void appendChapterToExclusionFile(String moduleName, String chapterName) throws FileNotFoundException,
            ExclusionFileException {
        ArrayList<String> excludedChapters = loadExcludedFile();
        chapterExists(moduleName, chapterName);
        String entry = "Module: " + moduleName + "; Chapter: " + chapterName;
        if (!excludedChapters.contains(entry)) {
            excludedChapters.add(entry);
        }
        updateExclusionFile(excludedChapters);
    }

    public void removeModuleFromExclusionFile(String moduleName) throws FileNotFoundException, ExclusionFileException {
        ArrayList<String> excludedChapters = loadExcludedFile();
        String[] chapters = loadChaptersFrom(moduleName);
        for (String chapter : chapters) {
            chapter = chapter.replace(".txt", "");
            String entry = "Module: " + moduleName + "; Chapter: " + chapter;
            excludedChapters.remove(entry);
        }
        updateExclusionFile(excludedChapters);
    }

    public void removeChapterFromExclusionFile(String moduleName, String chapterName) throws FileNotFoundException,
            ExclusionFileException {
        ArrayList<String> excludedChapters = loadExcludedFile();
        chapterExists(moduleName, chapterName);
        String entry = "Module: " + moduleName + "; Chapter: " + chapterName;
        excludedChapters.remove(entry);
        updateExclusionFile(excludedChapters);
    }

    public ArrayList<Card> loadCard(String module, String chapter) throws FileNotFoundException {
        File f = new File(filePath + "/" + module + "/" + chapter + ".txt");
        boolean fileExists = f.exists();
        if (!fileExists) {
            throw new FileNotFoundException();
        }

        ArrayList<Card> cards = new ArrayList<>();
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            //to read the card
            String fileCommand = s.nextLine();
            String[] args = fileCommand.split(DELIMITER, 3);
            try {
                String question = Parser.parseQuestionInFile(args[0]);
                String answer = Parser.parseAnswerInFile(args[1]);
                String interval = Parser.parsePreIntervalInFile(args[2]);
                int preInterval = Integer.parseInt(interval);

                Card card = new Card(question, answer, preInterval);
                cards.add(card);
            } catch (InvalidFileFormatException e) {
                return null;
            }
        }
        s.close();
        return cards;
    }

    public void saveCards(CardList cards, String module, String chapter) throws IOException {
        FileWriter fw = new FileWriter(getFilePath() + "/" + module + "/" + chapter + ".txt");
        for (int i = 0; i < cards.getCardCount(); i++) {
            fw.write(cards.getCard(i).toString()
                    + " | [P] " + cards.getCard(i).getPreviousInterval() + "\n");
        }
        fw.close();
    }

    private boolean createChapterDue(String duePath, String dirPath) throws IOException {
        File due = new File(duePath);
        File dir = new File(dirPath);
        boolean isDirValid = dir.exists() && dir.isDirectory();
        if (!isDirValid) {
            return dir.mkdir() && due.createNewFile();
        } else if (!due.exists()) {
            return due.createNewFile();
        } else {
            return true;
        }
    }

    private void writeDeadlineToChapterDue(String dueBy, String chapterPath) throws IOException {
        FileWriter fw = new FileWriter(chapterPath);
        fw.write(dueBy);
        fw.close();
    }

    public void saveChapterDeadline(String dueBy, String moduleName, String chapterName) {
        try {
            String dirPath = filePath + "/" + moduleName + "/" + "dues";
            String duePath = filePath + "/" + moduleName + "/" + "dues" + "/" + chapterName + "due" + ".txt";
            if (createChapterDue(duePath, dirPath)) {
                writeDeadlineToChapterDue(dueBy, duePath);
            } else {
                System.out.println("Unable to produce ChapterDue");
            }
        } catch (IOException e) {
            System.out.println("Error in saving chapter deadline");
        }
    }

    public boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    public boolean renameChapter(String newChapterName, Access access, Chapter chapter) {
        File file = new File(getFilePath()
                + "/" + access.getModule()
                + "/" + chapter.toString() + ".txt");
        boolean success = file.renameTo(new File(getFilePath()
                + "/" + access.getModule()
                + "/" + newChapterName + ".txt"));
        return success;
    }

    public boolean renameModule(String newModuleName, Module module) {
        File file = new File(getFilePath() + "/" + module.toString());
        boolean success = file.renameTo(new File(getFilePath() + "/" + newModuleName));
        return success;
    }

    public void createHistoryDir() {
        File f = new File("data/history");
        boolean historyDirExists = f.exists();
        if (!historyDirExists) {
            f.mkdir();
        }
    }

    public void createHistory(Ui ui, String date) {
        try {
            File f = new File("data/history/" + date + ".txt");
            boolean historyFileExists = f.exists();
            boolean historyFileCreated = false;
            if (!historyFileExists) {
                historyFileCreated = f.createNewFile();
            } else {
                ui.showToUser("the file " + date + ".txt already exists in history folder\n"
                        + "It stores the revision completed in the session/in a day\n");
            }

            if (historyFileCreated) {
                ui.showToUser("Successfully created new file " + date + ".txt in history folder\n"
                        + "It stores the revision completed in the session/in a day\n");
            }
        } catch (IOException e) {
            ui.showError("Error creating the file.");
        }
    }

    public void saveHistory(ArrayList<History> histories, String date) throws IOException {
        FileWriter fw = new FileWriter("data/history/" + date + ".txt");
        for (History h : histories) {
            fw.write(h.toString());
        }
        fw.close();
    }

    public ArrayList<History> loadHistory(String date) throws FileNotFoundException {
        File f = new File("data/history/" + date + ".txt");
        boolean fileExists = f.exists();
        if (!fileExists) {
            throw new FileNotFoundException();
        }

        ArrayList<History> histories = new ArrayList<>();
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            //to read the history
            String revision = s.nextLine();
            String[] args = revision.split("\\(", 2);
            String[] name = args[0].split("/", 2);
            try {
                String moduleName = Parser.parseTaskNameInFile(name[0]);
                String chapterName = Parser.parseTaskNameInFile(name[1]);
                String percent = Parser.parsePercentInFile(args[1]);
                int percentage = Integer.parseInt(percent);

                History history = new History(moduleName, chapterName, percentage);
                histories.add(history);
            } catch (InvalidFileFormatException e) {
                return null;
            }
        }
        s.close();
        return histories;
    }
}
