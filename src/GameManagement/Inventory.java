package GameManagement;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private static HashMap<String, Room> rooms;
    private static HashMap<Integer, IntriguingClue> clues;
    private static HashMap<Integer, DecorationObject> decorations;

    public Inventory() {
        this.rooms = new HashMap<>();
        this.clues = new HashMap<>();
        this.decorations = new HashMap<>();
    }

    public static Room findRoom(int roomId) {
        Room room = null;
        for (Room r : rooms.values()) {
            if (r.getId() == roomId) {
                room = r;
                break;
            }
        }
        return room;
    }

    public static IntriguingClue findClue(int itemId) {
        IntriguingClue clue = null;
        for (IntriguingClue c : clues.values()) {
            if (c.getId() == itemId) {
                clue = c;
                break;
            }
        }
        return clue;
    }

    public static DecorationObject findDecoration(int itemId) {
        DecorationObject decorationObject = null;
        for (DecorationObject d : decorations.values()) {
            if (d.getId() == itemId) {
                decorationObject = d;
                break;
            }
        }
        return decorationObject;
    }

    public void addRoom(Room room) throws IllegalArgumentException {
        if (rooms.containsKey(room.name)) {
            throw new IllegalArgumentException("Room with the same name already exists.");
        }
        rooms.put(room.name, room);
    }

    public void addClue(IntriguingClue clue) throws IllegalArgumentException {
        if (clues.values().stream().anyMatch(existingClue -> existingClue.getName().equalsIgnoreCase(clue.getName()))) {
            throw new IllegalArgumentException("Clue with the same name already exists.");
        }
        clues.put(clue.getId(), clue);
    }

    public void addDecoration(DecorationObject decorationObject) throws IllegalArgumentException {
        if (decorations.values().stream().anyMatch(existingDecorationObject -> existingDecorationObject.getName().equalsIgnoreCase(decorationObject.getName()))) {
            throw new IllegalArgumentException("Decoration with the same name already exists.");
        }
        decorations.put(decorationObject.getId(), decorationObject);
    }

    public void removeClue(int clueId) {
        clues.remove(clueId);
    }

    public void removeDecoration(int decorationId) {
        decorations.remove(decorationId);
    }

    public ArrayList<Room> getAllRooms() {
        return new ArrayList<>(rooms.values());
    }

    public ArrayList<IntriguingClue> getAllClues() {
        return new ArrayList<>(clues.values());
    }

    public ArrayList<DecorationObject> getAllDecorations() {
        return new ArrayList<>(decorations.values());
    }

    public double getTotalInventoryValue() {
        double total = 0;
        for (Room room : rooms.values()) {
            total += room.getTotalValue();
        }
        return total;
    }
}
