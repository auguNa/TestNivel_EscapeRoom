package GameManagement;

import java.util.ArrayList;

public class Room {
    protected static int counter = 1;
    protected final int id;
    protected String name;
    protected Difficulty difficulty;
    protected ArrayList<IntriguingClue> clues;
    protected ArrayList<DecorationObject> decorationObjects;

    public Room(String name, Difficulty difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.id = counter++;
        this.clues = new ArrayList<>();
        this.decorationObjects = new ArrayList<>();
    }

    public void addClue(IntriguingClue clue) {
        clues.add(clue);
    }

    public void addDecoration(DecorationObject decorationObject) {
        decorationObjects.add(decorationObject);
    }

    public void removeClue(int clueId) {
        clues.removeIf(clue -> clue.getId() == (clueId));
    }

    public void removeDecoration(int decorationId) {
        decorationObjects.removeIf(decorationObject -> decorationObject.getId() == (decorationId));
    }

    public double getTotalValue() {
        double total = 0;
        for (IntriguingClue clue : clues) {
            total += clue.getPriceWithTax();
        }
        for (DecorationObject decorationObject : decorationObjects) {
            total += decorationObject.getPriceWithTax();
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return "Room ID=" + id +
                ", name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", clues=" + clues +
                ", decorations=" + decorationObjects +
                ", Total Value: " + getTotalValue();
    }
}
